package com.univali.listadecompras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.univali.listadecompras.entities.Product;
import com.univali.listadecompras.entities.ProductList;

public class AddProduct extends AppCompatActivity {

    private ProductList productList;
    private TextInputEditText nameInput;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        setupViews();
        setupListeners();
    }

    private void setupViews() {
        Intent intent = getIntent();
        productList = (ProductList)intent.getSerializableExtra("productList");
        nameInput = findViewById(R.id.nameInput);
        addButton = findViewById(R.id.addButton);
        addButton.setEnabled(false);
    }

    private void setupListeners() {
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String productName = nameInput.getText().toString();
                Product product = new Product(productName, false);
                productList.createProduct(AddProduct.this, product);
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        nameInput.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (nameInput.getText() == null || nameInput.getText().toString().equals("")) {
                    addButton.setEnabled(false);
                } else {
                    addButton.setEnabled(true);
                }
                return false;
            }
        });
    }
}
