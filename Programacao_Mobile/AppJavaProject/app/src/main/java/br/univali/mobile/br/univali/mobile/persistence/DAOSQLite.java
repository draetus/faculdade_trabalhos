package br.univali.mobile.br.univali.mobile.persistence;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;



public class DAOSQLite extends SQLiteOpenHelper {
    private static final String dbname= "restaurante";
    public DAOSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table menu_item (chave integer primary key autoincrement, nome_prato varchar(70), descricao varchar (500),preco real)");
     }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static SQLiteDatabase getDBInstance(Activity activity){
        DAOSQLite  dao = new DAOSQLite(activity.getBaseContext(), DAOSQLite.dbname , null, 1);
        return dao.getWritableDatabase();
    }
}
