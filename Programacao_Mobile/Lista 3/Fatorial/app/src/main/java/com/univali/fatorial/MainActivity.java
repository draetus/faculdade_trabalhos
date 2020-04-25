package com.univali.fatorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText numberInput;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
        setupListeners();
    }

    private void setupViews() {
        this.numberInput = findViewById(R.id.numberInput);
        this.calculateButton = findViewById(R.id.calculateButton);
        this.calculateButton.setEnabled(false);
    }

    private void setupListeners() {

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Long number = Long.parseLong(numberInput.getText().toString());
                Intent intent = new Intent(getBaseContext(), FatorialResult.class);
                intent.putExtra("number", number);
                startActivity(intent);
            }
        });

        numberInput.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                try {
                    Long.parseLong(numberInput.getText().toString());
                    calculateButton.setEnabled(true);
                } catch (NumberFormatException nfe) {
                    calculateButton.setEnabled(false);
                }
                return false;
            }
        });

    }
}