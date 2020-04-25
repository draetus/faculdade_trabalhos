package com.univali.sobrescrevermetodos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.button = findViewById(R.id.button);
        System.out.println("ON CREATE");
    }

    @Override
    protected void onResume() {
        System.out.println("ON RESUME");
        super.onResume();
    }

    @Override
    protected void onStart() {
        System.out.println("ON START");
        super.onStart();
    }

    @Override
    protected void onStop() {
        System.out.println("ON STOP");
        super.onStop();
    }

    @Override
    protected void onPause() {
        System.out.println("ON PAUSE");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        System.out.println("ON RESTART");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        System.out.println("ON DESTROY");
        super.onDestroy();
    }
}
