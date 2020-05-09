package com.univali.agendapessoal.persistence;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.univali.agendapessoal.entities.Event;

import java.util.ArrayList;
import java.util.Date;

public class DAOEvent {

    public static ArrayList<Event> findAllEvents(Activity activity) {
        ArrayList<Event> events = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = DAOSQLite.getDBInstance(activity);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM event ", null);
        while(cursor.moveToNext()) {
            Event event = new Event(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    new Date(cursor.getString(3)) );
            events.add(event);
        }
        return events;
    }

    public static void insert(Activity activity, Event event) {
        DAOSQLite.getDBInstance(activity).execSQL("INSERT INTO event (name, description, date)" +
                " values(" + "\"" + event.getName() + "\""
                        + ", " + "\"" + event.getDescription() + "\""
                        + ", " + "\"" + event.getDate() + "\"" + ") ");
    }

    public static void update(Activity activity, Event event) {
        DAOSQLite.getDBInstance(activity).execSQL("UPDATE event " +
                " SET " +
                " name = " + "\"" + event.getName() + "\"" + ", " +
                " description = " + "\"" + event.getDescription() + "\"" + ", " +
                " date = " + "\"" + event.getDate().toString() + "\"" +
                " WHERE id = " + "\"" + event.getId().toString() + "\"" );
    }

    public static void delete(Activity activity, Event event) {
        DAOSQLite.getDBInstance(activity).execSQL("DELETE FROM " +
                " event WHERE id = " + "\""+ event.getId().toString() + "\"");
    }
}
