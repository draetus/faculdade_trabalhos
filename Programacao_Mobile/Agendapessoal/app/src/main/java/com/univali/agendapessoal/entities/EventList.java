package com.univali.agendapessoal.entities;

import android.app.Activity;

import com.univali.agendapessoal.persistence.DAOEvent;

import java.util.ArrayList;
import java.util.Date;

public class EventList {

    ArrayList<Event> events;

    public EventList(Activity activity) {
        events = new ArrayList<>();
        attList(activity);
    }

    private void attList(Activity activity) {
        this.events = DAOEvent.findAllEvents(activity);
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