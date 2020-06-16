package com.univali.agendapessoal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.EventLogTags;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.univali.agendapessoal.entities.Event;
import com.univali.agendapessoal.entities.EventList;

public class MainActivity extends AppCompatActivity {

    private EventList eventList;
    private LinearLayout eventListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
    }

    private void setupViews() {
        this.eventList = new EventList(this);
        this.eventList.cargaInicial(this);
        eventListView = findViewById(R.id.eventList);
        setupEventListView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addEvent:
                Intent intent = new Intent(getBaseContext(), addEvent.class);
                intent.putExtra("eventList", eventList);
                startActivity(intent);
                break;
            case R.id.clearList:
                for (Event event : eventList.getEvents()) {
                    removeEvent(event);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setupEventListView() {
        eventListView.removeAllViews();
        for (Event event: eventList.getEvents()) {
            eventListView.addView(setupEventView(event));
        }
    }

    public LinearLayout setupEventView(Event event) {
        LinearLayout layout = new LinearLayout(this);
        layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        layout.addView(setupEventTextView(event));

        final Button removeButton = new Button(this);
        removeButton.setText("Remover");
        removeButton.setLayoutParams(lp);
        removeButton.setTag(event);
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Event event = (Event)v.getTag();
                removeEvent(event);
            }
        });
        layout.addView(removeButton);

        return layout;
    }

    public LinearLayout setupEventTextView(Event event) {
        LinearLayout layout = new LinearLayout(this);
        layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
        layout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView tv = new TextView(this);
        tv.setWidth(600);
        tv.setText(event.getName());
        tv.setLayoutParams(lp);
        layout.addView(tv);

        TextView tv1 = new TextView(this);
        tv1.setWidth(600);
        tv1.setText(event.getDescription());
        tv1.setLayoutParams(lp);
        layout.addView(tv1);

        return layout;
    }

    public void removeEvent(Event event) {
        this.eventList.removeEvent(this, event);
        setupEventListView();
    }
}
