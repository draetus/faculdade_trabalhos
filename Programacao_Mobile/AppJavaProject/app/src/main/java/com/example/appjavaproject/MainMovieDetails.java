package com.example.appjavaproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import br.univali.mobile.entities.Filme;

import static android.os.FileUtils.copy;
import static com.squareup.picasso.Picasso.*;

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
