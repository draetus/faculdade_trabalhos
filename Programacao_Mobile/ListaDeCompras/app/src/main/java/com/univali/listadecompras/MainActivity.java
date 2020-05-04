package com.univali.listadecompras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.univali.listadecompras.entities.Product;
import com.univali.listadecompras.entities.ProductList;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ProductList productList;
    LinearLayout linearLayout;
    Button addProductButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        setupListeners();
    }

    private void setupViews() {
        productList = new ProductList(this);
        // productList.cargaInicial(this);
        linearLayout = findViewById(R.id.shoppingCart);
        addProductButton = findViewById(R.id.addProduct);
        setupProductList();
    }

    private void setupListeners(){
        addProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AddProduct.class);
                intent.putExtra("productList", productList);
                startActivity(intent);
            }
        });
    }

    private void setupProductList() {
        linearLayout.removeAllViews();
        ArrayList<Product> products = productList.getProducts();
        for (Product product : products) {
            setupProductView(product);
        }
    }

    private void setupProductView(Product product) {
        LinearLayout layout = new LinearLayout(this);
        layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        TextView tv = new TextView(this);
        tv.setWidth(600);
        tv.setText(product.getName());
        tv.setLayoutParams(lp);
        layout.addView(tv);

        Button removeButton = new Button(this);
        removeButton.setText("Remover");
        removeButton.setLayoutParams(lp);
        removeButton.setTag(product);
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product product = (Product)v.getTag();
                deleteProduct(product);
            }
        });
        layout.addView(removeButton);

        CheckBox checkBox = new CheckBox(this);
        checkBox.setChecked(product.getInShopList());
        checkBox.setTag(product);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product product = (Product)v.getTag();
                if (!((CheckBox)v).isChecked()) {
                    System.out.println("REMOVEU DO CARRINHO");
                    removeFromShoppingCart(product);
                } else {
                    System.out.println("ADICIONOU AO CARRINHO");
                    addToShoppingCart(product);
                }
            }
        });
        layout.addView(checkBox);

        linearLayout.addView(layout);
    }

    private void deleteProduct(Product product) {
        productList.deleteProduct(this, product);
        setupProductList();
    }

    private void removeFromShoppingCart(Product product) {
        productList.removeFromShoppingCart(this, product);
    }

    private void addToShoppingCart(Product product) {
        productList.addToShoppingCart(this, product);
    }
}
