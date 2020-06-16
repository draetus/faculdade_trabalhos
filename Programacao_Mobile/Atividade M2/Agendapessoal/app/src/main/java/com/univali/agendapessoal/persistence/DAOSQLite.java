package com.univali.agendapessoal.persistence;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DAOSQLite extends SQLiteOpenHelper {

    private static final String dbname="schedule";

    public DAOSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("TA CRIANDO");
        db.execSQL("CREATE TABLE event (id integer primary key autoincrement, name varchar(100), description varchar(300), date varchar(100) )");
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
