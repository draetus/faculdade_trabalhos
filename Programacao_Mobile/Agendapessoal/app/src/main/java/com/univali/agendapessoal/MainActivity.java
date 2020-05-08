package com.univali.agendapessoal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.univali.agendapessoal.entities.EventList;

public class MainActivity extends AppCompatActivity {

    private EventList eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
        for (int i=0; i<eventList.getEvents().size(); i++) {
            System.out.print(eventList.getEvents().get(i).getId() + " - ");
            System.out.print(eventList.getEvents().get(i).getName() + " - ");
            System.out.print(eventList.getEvents().get(i).getDescription() + " - ");
            System.out.print(eventList.getEvents().get(i). getDate());
            System.out.println();
        }
    }

    private void setupViews() {
        this.eventList = new EventList(this);
        this.eventList.cargaInicial(this);
    }
}
