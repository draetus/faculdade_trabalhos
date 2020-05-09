package com.example.appjavaproject;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.univali.mobile.entities.ItemAgendaEvento;
import okio.GzipSink;

public class AgendaEventos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_eventos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayoutAgenda);

        /*
        ItemAgendaEvento itemTeste= new ItemAgendaEvento();
        itemTeste.setDescricao("Carga inicial");
        itemTeste.setData(new Date());

        ItemAgendaEvento.insere(this,itemTeste);
        */
        List<ItemAgendaEvento> lista = ItemAgendaEvento.buscaTodos(this);
        Log.v("DB", "Items: "+String.valueOf(lista.size()));
        for (ItemAgendaEvento item : lista) {
            LinearLayout layout = new LinearLayout(this);
            layout.setPadding(0,0,0,60);
            layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            layout.setOrientation(LinearLayout.VERTICAL);//LinearLayout.HORIZONTAL


            TextView tv = new TextView(this); ;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");

            tv.setText(format.format(item.getData()));
            tv.setTextSize(16);
            tv.setTextColor(Color.DKGRAY);
            tv.setTypeface(null, Typeface.BOLD);
            LinearLayout.LayoutParams p1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            tv.setLayoutParams(p1);
            layout.addView(tv);

            tv = new TextView(this);
            tv.setText(item.getDescricao());
            tv.setTextSize(24);
            p1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            tv.setLayoutParams(p1);
            layout.addView(tv);

            ll.addView(layout);

        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_agenda_eventos, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.idMenuItemNew){
            Intent myIntent = new Intent(getBaseContext(), com.example.appjavaproject.ActivityNewEvento.class);
            startActivity(myIntent);
            return true;
        }

        if(item.getItemId()==R.id.idMenuItemLimparTodos){
            ItemAgendaEvento.limparAgenda(this);
            Intent myIntent = new Intent(getBaseContext(), com.example.appjavaproject.AgendaEventos.class);
            startActivity(myIntent);
            return true;

        }


        if(item.getItemId()==R.id.idMenuItemExport){
            List<ItemAgendaEvento> lista = ItemAgendaEvento.buscaTodos(this);
            Gson gson= new Gson();


            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, gson.toJson(lista));
            sendIntent.setType("text/plain");
            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);


            return true;
        }
        return false;
    }

}
