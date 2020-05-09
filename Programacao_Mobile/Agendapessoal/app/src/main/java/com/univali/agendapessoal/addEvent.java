package com.univali.agendapessoal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.univali.agendapessoal.entities.Event;
import com.univali.agendapessoal.entities.EventList;

import java.util.Date;

public class addEvent extends AppCompatActivity {

    private TextInputEditText inputName;
    private TextInputEditText inputDescription;
    private CalendarView dateInput;
    private EventList eventList;
    private Button addButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        setupViews();
        setupListeners();
    }

    public void setupViews() {
        Intent intent = getIntent();
        this.eventList = (EventList)intent.getSerializableExtra("eventList");
        this.inputName = findViewById(R.id.nameInput);
        this.inputDescription = findViewById(R.id.descriptionInput);
        this.dateInput = findViewById(R.id.dateInput);
        this.addButton = findViewById(R.id.addButton);
        this.addButton.setEnabled(false);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupListeners() {
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eventName = inputName.getText().toString();
                String eventDescription = inputDescription.getText().toString();
                Date eventDate = new Date(dateInput.getDate());
                Event event = new Event(eventName, eventDescription, eventDate);
                eventList.insertEvent(addEvent.this, event);
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        inputName.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (inputName.getText() == null || inputName.getText().toString().equals("")
                   || inputDescription.getText() == null || inputDescription.getText().toString().equals("")) {
                    addButton.setEnabled(false);
                } else {
                    addButton.setEnabled(true);
                }
                return false;
            }
        });

        inputDescription.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (inputName.getText() == null || inputName.getText().toString().equals("")
                        || inputDescription.getText() == null || inputDescription.getText().toString().equals("")) {
                    addButton.setEnabled(false);
                } else {
                    addButton.setEnabled(true);
                }
                return false;
            }
        });
    }
}