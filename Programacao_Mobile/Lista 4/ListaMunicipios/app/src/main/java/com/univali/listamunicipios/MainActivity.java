package com.univali.listamunicipios;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextInputEditText inputName;
    Santa_Catarina santa_catarina;
    ListView cidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
        setupListeners();

        santa_catarina = new Santa_Catarina();

        ArrayAdapter<Cidade> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, santa_catarina.getCidades());
        cidades.setAdapter(arrayAdapter);
    }

    private void setupViews() {
        inputName = findViewById(R.id.inputName);
        cidades = findViewById(R.id.cidades);
    };

    private void setupListeners() {

        inputName.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                String name = inputName.getText().toString();
                List<Cidade> estados;
                if(name.equals("")) {
                    estados = santa_catarina.getCidades();
                } else {
                    estados = santa_catarina.getCidades(name);
                }
                ArrayAdapter<Cidade> arrayAdapter = new ArrayAdapter<Cidade>(getBaseContext(), android.R.layout.simple_list_item_1, estados);
                cidades.setAdapter(arrayAdapter);
                return false;
            }
        });

        cidades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cidade cidade = (Cidade) parent.getItemAtPosition(position);
                Intent intent = new Intent(getBaseContext(), Detalhes_Cidade.class);
                intent.putExtra("cidade", cidade);
                startActivity(intent);
            }
        });

    }


}
