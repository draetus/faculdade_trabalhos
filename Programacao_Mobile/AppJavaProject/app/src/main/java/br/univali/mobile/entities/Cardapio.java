package br.univali.mobile.entities;

import android.app.Activity;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;

import br.univali.mobile.br.univali.mobile.persistence.DAOSQLite;

public class Cardapio {

    public Cardapio(){

    }

    public ArrayList<ItemCardapio> getItemsCardapio(Activity activity){

        ArrayList<ItemCardapio> lista= new ArrayList<ItemCardapio>();
        Cursor cursor= DAOSQLite.getDBInstance(activity).rawQuery("select nome_prato, descricao, preco from menu_item ",null);
        while(cursor.moveToNext()) {
            String nome=cursor.getString(0);
            String descricao=cursor.getString(1);
            double preco=cursor.getFloat(2);
            ItemCardapio ic= new ItemCardapio();
            ic.setNome(nome);
            ic.setDescricao(descricao);
            ic.setPreco(preco);
            ic.setPreco(preco);
            lista.add(ic);
            Log.i("SQLLite", nome);
        }
        return lista;
    }

    public void cargaInicial(Activity activity){
        DAOSQLite.getDBInstance(activity).execSQL("delete from menu_item");
        if(this.getItemsCardapio(activity).size()==0) {
            DAOSQLite.getDBInstance(activity).execSQL("insert into menu_item (nome_prato, descricao, preco) values('X-BURGER', 'Pão, Hambúrguer, presunto, maionese e queijo',13)");
            DAOSQLite.getDBInstance(activity).execSQL("insert into menu_item (nome_prato, descricao, preco) values('X-SALADA', 'Pão, Hambúrguer, alface, tomate, milho, ervilha, batata-palha, presunto, maionese e queijo',20)");
            DAOSQLite.getDBInstance(activity).execSQL("insert into menu_item (nome_prato, descricao, preco) values('X-EGG', 'Pão, Hambúrguer, ovo, alface, tomate, milho, ervilha, batata-palha, presunto, maionese e queijo',22)");
            DAOSQLite.getDBInstance(activity).execSQL("insert into menu_item (nome_prato, descricao, preco) values('X-ALCATRA', 'Pão, alcatra, alface, tomate, milho, ervilha, batata-palha, presunto, maionese e queijo',25)");
            DAOSQLite.getDBInstance(activity).execSQL("insert into menu_item (nome_prato, descricao, preco) values('X-MIGNON', 'Pão, Filé Mignon, presunto, queijo, tomate, alface, milho, ervilha, maionese e batata palha',28)");
            DAOSQLite.getDBInstance(activity).execSQL("insert into menu_item (nome_prato, descricao, preco) values('X-TUDO', 'Pão, Hambúrguer, frango, calabresa, coração, ovo, bacon, alface, tomate, milho, ervilha, batata-palha, presunto, maionese e queijo',33)");




        }
    }
}
