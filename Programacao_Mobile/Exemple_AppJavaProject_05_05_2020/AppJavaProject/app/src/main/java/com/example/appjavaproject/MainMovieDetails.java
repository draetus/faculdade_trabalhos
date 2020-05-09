package com.example.appjavaproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.TextView;

import br.univali.mobile.entities.Filme;

import static android.os.FileUtils.copy;

public class MainMovieDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_movie_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Filme f = (Filme)getIntent().getSerializableExtra("movie");

        ((TextView)findViewById(R.id.textViewMovieTitleValue)).setText(f.getNome());
        String horariostxt="";
        for(byte i=0; i< f.getHorarios().length;i++){
            horariostxt+= f.getHorarios()[i];
            if(i<f.getHorarios().length-1){
                horariostxt+=", ";
            }
        }
        ((TextView)findViewById(R.id.textViewCastValue)).setText(f.getElenco());
        ((TextView)findViewById(R.id.textViewTimeValue)).setText(horariostxt);

    }




}
