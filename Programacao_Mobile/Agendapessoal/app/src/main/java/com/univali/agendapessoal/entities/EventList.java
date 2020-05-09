package com.univali.agendapessoal.entities;

import android.app.Activity;

import com.univali.agendapessoal.persistence.DAOEvent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class EventList implements Serializable {

    ArrayList<Event> events;

    public EventList(Activity activity) {
        events = new ArrayList<>();
        attList(activity);
    }

    private void attList(Activity activity) {
        this.events = DAOEvent.findAllEvents(activity);

        int n = events.size();
        Event temp = null;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (events.get(j - 1).getDate().compareTo(events.get(j).getDate()) > 0) {
                    //swap elements
                    temp = events.get(j - 1);
                    events.set(j - 1, events.get(j));
                    events.set(j, temp);
                }
            }
        }
    }

    public void cargaInicial(Activity activity) {
        attList(activity);
        if (events.size() < 1) {
            DAOEvent.insert(activity, new Event("Aula-1", "Aula na UNIVALI", new Date()));
            DAOEvent.insert(activity, new Event("Aula-2", "Aula na UFSC", new Date()));
            DAOEvent.insert(activity, new Event("Aula-3", "Aula na UNISUL", new Date()));
            DAOEvent.insert(activity, new Event("Aula-4", "Aula na UDESC", new Date()));
            attList(activity);
        }
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void removeEvent(Activity activity, Event event) {
        DAOEvent.delete(activity, event);
        attList(activity);
    }

    public void insertEvent(Activity activity, Event event) {
        DAOEvent.insert(activity, event);
        attList(activity);
    }
}