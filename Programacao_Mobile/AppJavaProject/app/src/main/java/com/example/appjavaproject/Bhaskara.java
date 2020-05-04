package com.example.appjavaproject;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Bhaskara extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhaskara);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button b=(Button)findViewById(R.id.buttonCalculaBhaskara);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etX2=(EditText) findViewById(R.id.editTextX2);
                EditText etX=(EditText) findViewById(R.id.editTextX);
                EditText etCons=(EditText) findViewById(R.id.editTextConst);

                String etX2Text=etX2.getText().toString();
                String etXText= etX.getText().toString();
                String consText= etCons.getText().toString();

                if(etX2Text.isEmpty()){
                    //Toast.makeText(v.getContext(), "O campo x2 nao foi preenchido...", Toast.LENGTH_LONG).show();
                    new AlertDialog.Builder(v.getContext()).setTitle("Atenção").setMessage("O campo x2 nao foi preenchido...").setNeutralButton("Fechar", null).show();
                    return;
                }

                if(etXText.isEmpty()){
                    //Toast.makeText(v.getContext(), "O campo x nao foi preenchido...", Toast.LENGTH_LONG).show();
                    new AlertDialog.Builder(v.getContext()).setTitle("Atenção").setMessage("O campo x nao foi preenchido...").setNeutralButton("Fechar", null).show();
                    return;
                }

                if(consText.isEmpty()){
                   // Toast.makeText(v.getContext(), "O campo constante nao foi preenchido...", Toast.LENGTH_LONG).show();
                    new AlertDialog.Builder(v.getContext()).setTitle("Atenção").setMessage("O campo constante nao foi preenchido...").setNeutralButton("Fechar", null).show();
                    return;
                }

                double a= new Double(etX2Text);
                double b= new Double(etXText);
                double c= new Double(consText);
                double x1= (-b -Math.sqrt(Math.pow(b,2)+(4*a*c))/(2*a));
                double x2= (-b -Math.sqrt(Math.pow(b,2)-(4*a*c))/(2*a));

                ((EditText)findViewById(R.id.editTextXLinha)).setText(String.valueOf(String.format("%.2f",x1)));
                ((EditText)findViewById(R.id.editTextXLinha2)).setText(String.valueOf(String.format("%.2f",x2)));
            }
        });
        ((EditText)findViewById(R.id.editTextXLinha)).setEnabled(false);
        ((EditText)findViewById(R.id.editTextXLinha2)).setEnabled(false);

        b=(Button)findViewById(R.id.buttonRelatorio);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), com.example.appjavaproject.MainReportBhaskara.class);
                myIntent.putExtra("a", ((EditText)findViewById(R.id.editTextX2)).getText().toString());
                myIntent.putExtra("b", ((EditText)findViewById(R.id.editTextX)).getText().toString());
                myIntent.putExtra("c", ((EditText)findViewById(R.id.editTextConst)).getText().toString());
                myIntent.putExtra("x1", ((EditText)findViewById(R.id.editTextXLinha)).getText().toString());
                myIntent.putExtra("x2", ((EditText)findViewById(R.id.editTextXLinha2)).getText().toString());
                startActivity(myIntent);

            }
        });

        b=(Button)findViewById(R.id.buttonSaibaMais);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mundoeducacao.bol.uol.com.br/matematica/formula-bhaskara.htm"));
                startActivity(intent);


            }
        });

        b=(Button)findViewById(R.id.buttonAjuda);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), com.example.appjavaproject.ExampleActivity.class);
                startActivity(myIntent);
            }
        });

    }


    protected void onPause(){
        super.onPause();
        Log.i("Mudanca de estado", "Estado Pause iniciado.");
    }



    @Override
    protected void onStop() {
        // call the superclass method first
        super.onStop();
        Log.w("Mudanca de estado", "Estado Stop iniciado.");
    }

    protected void onResume(){
        super.onResume();
        Log.e("Mudanca de estado", "Estado Resumo iniciado.");
    }

}
