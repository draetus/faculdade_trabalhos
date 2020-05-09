package br.univali.mobile.entities;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.univali.mobile.br.univali.mobile.persistence.DAOSQLite;
import br.univali.mobile.br.univali.mobile.persistence.DAOSQLiteAgendaEvento;

public class ItemAgendaEvento {
    private String descricao;
    private Date data;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

        public static void insere(Activity activity, ItemAgendaEvento item){
            SQLiteDatabase db = DAOSQLiteAgendaEvento.getDBInstance(activity);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

            String dateString = format.format( item.getData()  );
            String[] arrayParam= new String[2];
            arrayParam[0]=item.getDescricao();
            arrayParam[1]=dateString;
            db.execSQL("insert into item (descricao, date) values(?,?)", arrayParam);
    }

    public static void limparAgenda(Activity activity){
        SQLiteDatabase db = DAOSQLiteAgendaEvento.getDBInstance(activity);

        db.execSQL("delete from item");
    }

    public static List<ItemAgendaEvento> buscaTodos(Activity activity){
        ArrayList<ItemAgendaEvento> lista= new ArrayList<ItemAgendaEvento>();
        Cursor cursor= DAOSQLiteAgendaEvento.getDBInstance(activity).rawQuery("select descricao, date from item order by date",null);
        while(cursor.moveToNext()) {
            ItemAgendaEvento item= new ItemAgendaEvento();
            String descricao=cursor.getString(0);
            String dateTxt=cursor.getString(1);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date data=null;
            try {
                data = format.parse(dateTxt);
            }catch(Exception e) {
                data= new Date();
            }

            item.setDescricao(descricao);
            item.setData(data);
            lista.add(item);
            Log.i("SQLLite", descricao);
        }
        return lista;
    }

    public static List<ItemAgendaEvento> buscaTextual(String filtro){

        return null;
    }

}
