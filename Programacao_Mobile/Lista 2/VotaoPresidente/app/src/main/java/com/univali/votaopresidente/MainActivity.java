package com.univali.votaopresidente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    TextInputEditText candidatosInput;
    TextInputEditText votosInput;
    Button addButton;
    Button calculateButton;

    List<String> candidatos;
    List<Integer> votos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.candidatos = new ArrayList<>();
        this.votos = new ArrayList<>();

        this.candidatosInput = findViewById(R.id.candidatoInput);
        this.votosInput = findViewById(R.id.votosInput);
        this.listView = findViewById(R.id.candidatos);
        this.addButton = findViewById(R.id.adicionar);
        this.calculateButton = findViewById(R.id.calcular);

        addButton.setEnabled(false);
        calculateButton.setEnabled(false);

    }


    public void populateList(View view) {

        String candidato = this.candidatosInput.getText().toString();
        Integer voto = Integer.parseInt(this.votosInput.getText().toString());

        this.candidatos.add(candidato);
        this.votos.add(voto);

    }

    public void calculateVotes(View view) {
        List<String> orderedList = this.candidatos;
        for (int i=0; i<candidatos.size()-1; i++) {
            for (int j = 0; j < candidatos.size() - i - 1; j++) {
                if (votos.get(j) > votos.get(j + 1)) {
                    int temp = votos.get(j);
                    votos.set(j, votos.get(j + 1));
                    votos.set(j + 1, temp);

                    String temp1 = candidatos.get(j);
                    candidatos.set(j, candidatos.get(j + 1));
                    candidatos.set(j + 1, temp1);
                }
            }
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, orderedList);
        this.listView.setAdapter(arrayAdapter);
    }

    @Override
    public boolean onKeyUp (int keyCode, KeyEvent event) {
        if (candidatos.size() > 7) {
            deactivateButtons();
        }
        try {
            Integer.parseInt(votosInput.getText().toString());
            activateButtons();
        } catch (Exception ex) {
            deactivateButtons();
            return super.onKeyUp(keyCode, event);
        }
        return super.onKeyUp(keyCode, event);
    }

    private void deactivateButtons() {
        this.addButton.setEnabled(false);
        this.calculateButton.setEnabled(false);
    }

    private void activateButtons() {
        this.addButton.setEnabled(true);
        this.calculateButton.setEnabled(true);
    }
}
