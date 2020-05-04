package com.univali.listadecompras.entities;

import android.app.Activity;

import com.univali.listadecompras.persistence.DAOProduct;
import com.univali.listadecompras.persistence.DAOSQLite;

import java.io.Serializable;
import java.util.ArrayList;

public class ProductList implements Serializable {

    ArrayList<Product> products;

    public ProductList(Activity activity) {
        products = new ArrayList<>();
        attList(activity);
    }

    private void attList(Activity activity) {
        this.products = DAOProduct.findAllProduct(activity);
    }

    public void cargaInicial(Activity activity) {
        attList(activity);
        if (products.size() < 1) {
            DAOProduct.insert(activity, new Product("Alface", false));
            DAOProduct.insert(activity, new Product("Cenoura", false));
            DAOProduct.insert(activity, new Product("Abacate", false));
            DAOProduct.insert(activity, new Product("Abacaxi", false));
            DAOProduct.insert(activity, new Product("Laranja", false));
            DAOProduct.insert(activity, new Product("Tomate", false));
            DAOProduct.insert(activity, new Product("Repolho", false));
            DAOProduct.insert(activity, new Product("Cebola", false));
            DAOProduct.insert(activity, new Product("Maçã", false));
            attList(activity);
        }
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addToShoppingCart(Activity activity, Product product){
        product.setInShopList(true);
        DAOProduct.update(activity, product);
        attList(activity);
    }

    public void removeFromShoppingCart(Activity activity, Product product) {
        product.setInShopList(false);
        DAOProduct.update(activity, product);
        attList(activity);
    }

    public void createProduct(Activity activity, Product product) {
        DAOProduct.insert(activity, product);
        attList(activity);
    }

    public void deleteProduct(Activity activity, Product product) {
        DAOProduct.delete(activity, product);
        attList(activity);
    }
}
