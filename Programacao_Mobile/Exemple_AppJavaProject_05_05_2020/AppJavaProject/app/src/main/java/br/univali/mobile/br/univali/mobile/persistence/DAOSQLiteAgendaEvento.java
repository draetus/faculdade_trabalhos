package br.univali.mobile.br.univali.mobile.persistence;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DAOSQLiteAgendaEvento extends SQLiteOpenHelper {
    private static final String dbname= "agenda";

    public DAOSQLiteAgendaEvento(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table item (chave integer primary key autoincrement, descricao varchar(300), date datetime)");
     }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static SQLiteDatabase getDBInstance(Activity activity){
        DAOSQLiteAgendaEvento dao = new DAOSQLiteAgendaEvento(activity.getBaseContext(), DAOSQLiteAgendaEvento.dbname , null, 1);
        return dao.getWritableDatabase();
    }
}
