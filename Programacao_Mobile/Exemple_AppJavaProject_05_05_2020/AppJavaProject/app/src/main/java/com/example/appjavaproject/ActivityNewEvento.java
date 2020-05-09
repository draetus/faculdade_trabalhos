package com.example.appjavaproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

import br.univali.mobile.entities.ItemAgendaEvento;

public class ActivityNewEvento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_evento);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button bt= (Button)findViewById(R.id.buttonNovoEvento);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etDescricao=(EditText)findViewById(R.id.editTextEventoDescricao);
                EditText etDate=(EditText)findViewById(R.id.editTextEventoDate);
                EditText etHorario=(EditText)findViewById(R.id.editTextEventoTime);

                String descricao=etDescricao.getText().toString();
                String date=etDate.getText().toString();
                String time=etHorario.getText().toString();
                ItemAgendaEvento item= new ItemAgendaEvento();
                item.setDescricao(descricao);
                String[] dateParts=date.split("/");
                String[] timeParts=time.split(":");
                Date dt=new Date(new Integer(dateParts[2])-1900,new Integer(dateParts[1])-1,new Integer(dateParts[0]));
                dt.setHours(new Integer(timeParts[0]));
                dt.setMinutes(new Integer(timeParts[1]));
                item.setData(dt);
                ItemAgendaEvento.insere((Activity) v.getContext(), item);

                Intent myIntent = new Intent(getBaseContext(), com.example.appjavaproject.AgendaEventos.class);
                startActivity(myIntent);
            }
        });

    }

}
