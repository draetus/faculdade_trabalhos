package com.univali.fatorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.security.spec.ECField;

public class FatorialResult extends AppCompatActivity {

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fatorial_result);

        setupViews();
    }

    private void setupViews() {
        this.result = findViewById(R.id.result);
        Intent intent = getIntent();
        Long number = (Long)intent.getSerializableExtra("number");
        try {
            Long factorial = calculateFactorial(number);
            result.setText(factorial.toString());
        } catch (ArithmeticException ex) {
            result.setText("Valor não calculável");
        }

    }

    private Long calculateFactorial(Long num){

        if(num.equals(1l) || (num.equals(0l))) {
            return 1l;
        }
        return Math.multiplyExact(calculateFactorial(num-1), num);
    }
}
