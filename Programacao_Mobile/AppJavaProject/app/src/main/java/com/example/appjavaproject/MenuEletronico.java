package com.example.appjavaproject;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuEletronico extends AppCompatActivity {

    private ArrayList<EditText> fields= new ArrayList<EditText>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_eletronico);

        ArrayList<String> str= new ArrayList<String>();
        str.add("Bacon");
        str.add("Salcinha dupla");
        str.add("Batata");
        str.add("Queijo");
        str.add("Calabresa");
        str.add("Mostarda");
        str.add("Ketchup");
        str.add("Maionse");
        str.add("Tomate");
        str.add("Cebola");
        str.add("Milho");
        str.add("Ervilha");
        str.add("Frango");

        LinearLayout ll=(LinearLayout)findViewById(R.id.linearlayoutTimeEntry);

        int i=0;
        for(String s: str) {
            i++;
            LinearLayout layout = new LinearLayout(this);
            layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            layout.setOrientation(LinearLayout.HORIZONTAL);//LinearLayout.VERTICAL

            TextView tv = new TextView(this);
            tv.setText(String.valueOf(i));
            LinearLayout.LayoutParams p1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            tv.setLayoutParams(p1);
            layout.addView(tv);

            EditText et = new EditText(this);
            et.setText(s);
            et.setWidth(600);
            LinearLayout.LayoutParams p2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            et.setLayoutParams(p2);
            layout.addView(et);
            fields.add(et);

            Button bt = new Button(this);
            bt.setText("Remover");
            LinearLayout.LayoutParams p3 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            bt.setLayoutParams(p3);
            bt.setTag(new Integer(i));
            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int index=(Integer)v.getTag();
                    fields.get(index-1).setText("");
                    new AlertDialog.Builder(v.getContext()).setTitle("Atenção").setMessage("Registro no indice "+ index+" apagado.").setNeutralButton("Fechar", null).show();

                }
            });
            layout.addView(bt);
            // et.setHint("Atividade "+ (fieldsList.size()+1));
            // et.setId(fieldsList.size()+1);


            ll.addView(layout);
        }

        Button bt =(Button)findViewById(R.id.button_registrar);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(EditText dt: fields){
                    Log.i("dados", dt.getText().toString());
                }
                new AlertDialog.Builder(v.getContext()).setTitle("Atenção").setMessage("Pedido realizado!").setNeutralButton("Fechar", null).show();

            }
        });
    }

}
