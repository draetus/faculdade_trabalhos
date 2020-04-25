package com.univali.toastnotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.sql.Time;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.button = findViewById(R.id.button);
        this.constraintLayout = findViewById(R.id.layout);
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToastNotification();
            }
        });
    }

    private void sendToastNotification() {
        String message = chooseMessage();
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private String chooseMessage() {
        Date dt = new Date();
        int hours = dt.getHours();

        if (hours <= 6) {
            constraintLayout.setBackgroundColor(Color.parseColor("#191970"));
            return "Boa noite";
        } else if (hours <= 12) {
            constraintLayout.setBackgroundColor(Color.parseColor("#ffff00"));
            return "Bom dia";
        } else if (hours <= 18) {
            constraintLayout.setBackgroundColor(Color.parseColor("#006400"));
            return "Boa tarde";
        } else {
            constraintLayout.setBackgroundColor(Color.parseColor("#191970"));
            return "Boa noite";
        }
    }
}
