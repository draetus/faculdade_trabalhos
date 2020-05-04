package com.univali.listadecompras.persistence;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.univali.listadecompras.entities.Product;

import java.util.ArrayList;

public class DAOProduct {

    public static ArrayList<Product> findAllProduct(Activity activity) {
        ArrayList<Product> products = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = DAOSQLite.getDBInstance(activity);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT name, flag " +
            " FROM product ", null);
        while(cursor.moveToNext()) {
            Product product = new Product(cursor.getString(0), cursor.getInt(1) == 1);
            products.add(product);
        }
        return products;
    }

    public static void insert(Activity activity, Product product) {
        String flag = product.getInShopList().equals(true) ? "1" : "0";
        DAOSQLite.getDBInstance(activity).execSQL("INSERT INTO product (name, flag) " +
                " values(" + "\"" + product.getName() + "\"" +
                ", " + flag + ")");
    }

    public static void update(Activity activity, Product product) {
        String flag = product.getInShopList().equals(true) ? "1" : "0";
        DAOSQLite.getDBInstance(activity).execSQL("UPDATE product " +
                " SET " +
                " name = " + "\"" + product.getName() + "\"" + ", " +
                " flag = " + flag + " " +
                " WHERE name = " + "\"" + product.getName() + "\"" );
    }

    public static void delete(Activity activity, Product product) {
        DAOSQLite.getDBInstance(activity).execSQL("DELETE FROM " +
                " product WHERE name = " + "\""+ product.getName() + "\"");
    }
}