package com.univali.imc_calculus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.SQLOutput;
import java.text.ParseException;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private EditText heightInput;
    private EditText weightInput;
    private Button calculateButton;
    private Boolean heightValid;
    private Boolean weightValida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.result = findViewById(R.id.result);
        this.heightInput = findViewById(R.id.height);
        this.weightInput = findViewById(R.id.weight);
        this.calculateButton = findViewById(R.id.calculateButton);

    }

    public void calcular(View v) {

        TextView result = findViewById(R.id.result);
        System.out.println("ENTROU AQUI");

        Double height = Double.parseDouble(heightInput.getText().toString());
        Double weight = Double.parseDouble(weightInput.getText().toString());
        Double imc = weight / (height+height);

        result.setText(imc.toString());
        if (imc<20) {
            result.setTextColor(Color.parseColor("#800080"));
        } else if(imc>25) {
            result.setTextColor(Color.parseColor("#FF0000"));
        } else {
            result.setTextColor(Color.parseColor("#0000FF"));
        }

    }

    @Override
    public boolean onKeyUp (int keyCode, KeyEvent event) {
        try {
            Double.parseDouble(heightInput.getText().toString());
            Double.parseDouble(weightInput.getText().toString());
            calculateButton.setEnabled(true);
        } catch (Exception ex) {
            return super.onKeyUp(keyCode, event);
        }
        return super.onKeyUp(keyCode, event);
    }

}
