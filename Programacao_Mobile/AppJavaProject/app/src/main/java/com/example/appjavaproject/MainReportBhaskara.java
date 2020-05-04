package com.example.appjavaproject;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;

public class MainReportBhaskara extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_report_bhaskara);


        String a = getIntent().getStringExtra("a");
        String b = getIntent().getStringExtra("b");
        String c = getIntent().getStringExtra("c");
        String x1 = getIntent().getStringExtra("x1");
        String x2 = getIntent().getStringExtra("x2");

        ((EditText)findViewById(R.id.a)).setText(a);
        ((EditText)findViewById(R.id.b)).setText(b);
        ((EditText)findViewById(R.id.c)).setText(c);

        ((EditText)findViewById(R.id.x1)).setText(x1);
        ((EditText)findViewById(R.id.x2)).setText(x2);


    }

}
