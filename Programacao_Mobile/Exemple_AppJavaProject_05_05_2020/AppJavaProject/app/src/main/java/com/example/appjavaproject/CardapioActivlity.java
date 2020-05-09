package com.example.appjavaproject;

import android.app.AlertDialog;
import android.graphics.Typeface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import br.univali.mobile.entities.Cardapio;
import br.univali.mobile.entities.ItemCardapio;

public class CardapioActivlity extends AppCompatActivity {
    private ArrayList<ItemCardapio> itemsSelectionados= new ArrayList<ItemCardapio>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio_activlity);




        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
/*
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
        Cardapio c= new Cardapio();
        //c.cargaInicial(this);
        ArrayList<ItemCardapio> lista=c.getItemsCardapio(this);

        LinearLayout ll=findViewById(R.id.linearLayoutCardapio);
        for(ItemCardapio ic: lista) {
            LinearLayout layout = new LinearLayout(this);
            layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            layout.setOrientation(LinearLayout.HORIZONTAL);//LinearLayout.VERTICAL
            layout.setPadding(0,0,0,15);

            TextView tv = new TextView(this);
            tv.setText(ic.getNome());
            tv.setTypeface(null, Typeface.BOLD);
            tv.setTextSize(25);
            tv.setWidth(350);
            LinearLayout.LayoutParams p1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            tv.setLayoutParams(p1);

            layout.addView(tv);

            tv = new TextView(this);
            NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            String currency = format.format(ic.getPreco());
            tv.setText(currency);
            tv.setTextSize(18);

            LinearLayout.LayoutParams p2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            tv.setLayoutParams(p2);
            tv.setWidth(150);
            tv.setGravity(Gravity.RIGHT);
            layout.addView(tv);

            CheckBox cb = new CheckBox(this);

           // Button bt = new Button(this);
            //bt.setText("Remover");
            LinearLayout.LayoutParams p3 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
            cb.setLayoutParams(p3);
            tv.setWidth(450);
            cb.setTag(ic);
            cb.setGravity(Gravity.RIGHT);
            cb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("cb","Clicked");
                    ItemCardapio ics =(ItemCardapio )v.getTag();
                    CheckBox cb=(CheckBox)v;
                    if(cb.isChecked()){
                        itemsSelectionados.add(ics);
                    }else{
                        itemsSelectionados.remove(ics);
                    }
                    double total=0;
                    for(ItemCardapio ic : itemsSelectionados){
                        total+=ic.getPreco();
                    }
                    TextView totalTv = (TextView) findViewById(R.id.textViewTotalValue);
                    NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
                    String currency = format.format(total);
                    totalTv.setText(currency);
                 }
            });

            layout.addView(cb);


            // et.setHint("Atividade "+ (fieldsList.size()+1));
            // et.setId(fieldsList.size()+1);
            ll.addView(layout);

            layout = new LinearLayout(this);
            layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            layout.setOrientation(LinearLayout.HORIZONTAL);//LinearLayout.VERTICAL
            layout.setPadding(0,0,0,100);

            tv = new TextView(this);
            tv.setText(ic.getDescricao());
            tv.setTextSize(18);

            p1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
            tv.setLayoutParams(p1);
            layout.addView(tv);

            ll.addView(layout);




        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dogao, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*
        String title=item.getTitle().toString();
        Toast.makeText(getBaseContext(),title,Toast.LENGTH_SHORT).show();
        if(title.equals("Item 1")){
            //logic for Item 1
        }else if(title.equals("Item 2")){
            //logic for Item 1
        }
        return super.onOptionsItemSelected(item);
         */
        return true;
    }

}
