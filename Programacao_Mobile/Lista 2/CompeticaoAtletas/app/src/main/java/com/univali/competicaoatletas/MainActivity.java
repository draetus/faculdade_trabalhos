package com.univali.competicaoatletas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView titleText;
    private TextView athletesText;
    private TextInputEditText inputTime;
    private TextInputEditText inputName;
    private Button addButton;
    private Button calculateButton;
    private ListView athletesList;

    private List<Atleta> atletas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleText = findViewById(R.id.titleText);
        athletesText = findViewById(R.id.athletesText);
        inputTime = findViewById(R.id.inputTime);
        inputName = findViewById(R.id.inputName);

        addButton = findViewById(R.id.addButton);
        calculateButton = findViewById(R.id.addButton);
        addButton.setEnabled(false);
        calculateButton.setEnabled(false);

        athletesList = findViewById(R.id.athletesList);
    }

    public void add(View view) {
        String name = inputName.getText().toString();
        Double time = Double.parseDouble(inputTime.getText().toString());

        Atleta atleta = new Atleta(name, time);
        atletas.add(atleta);

        inputName.clearComposingText();
        inputTime.clearComposingText();
    }

    public void calculate(View view) {

    }



    @Override
    public boolean onKeyUp (int keyCode, KeyEvent event) {
        if (inputName.getText().toString().equals(""))
        {
            calculateButton.setEnabled(false);
            addButton.setEnabled(false);
            return super.onKeyUp(keyCode, event);
        }
        try {
            Double.parseDouble(inputTime.getText().toString());
            calculateButton.setEnabled(true);
            addButton.setEnabled(true);
        } catch (Exception ex) {
            calculateButton.setEnabled(false);
            addButton.setEnabled(false);
            return super.onKeyUp(keyCode, event);
        }
        return super.onKeyUp(keyCode, event);
    }
}
