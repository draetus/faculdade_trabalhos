package com.univali.listadecompras.persistence;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DAOSQLite extends SQLiteOpenHelper {
    private static final String dbname= "productList";

public DAOSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version){
    super(context, name, factory, version);
}

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("TA CRIANDO");
        db.execSQL("CREATE TABLE product (id integer primary key autoincrement, name varchar(100), flag integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static SQLiteDatabase getDBInstance(Activity activity){
        DAOSQLite dao = new DAOSQLite(activity.getBaseContext(), DAOSQLite.dbname , null, 1);
        SQLiteDatabase sqLiteDatabase = dao.getWritableDatabase();
        return sqLiteDatabase;
    }
}
