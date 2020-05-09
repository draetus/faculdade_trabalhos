package com.example.appjavaproject;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.appjavaproject.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.univali.mobile.entities.Post;

public class ActivityExternalDataExemple extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_data_exemple);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        new ExternalPostReaderAsyncTask ().execute();
        Runnable r;
        Thread t;
    }


    class ExternalPostReaderAsyncTask extends AsyncTask<String, Integer, String> {
        @Override
        protected String doInBackground(String... strings) {
            String result = "";
            try {
                Log.d("Step", "Start download");
                String resourceURI = "https://jsonplaceholder.typicode.com/posts";
                String httpParameters = "";//?id=0
                String formatedURL = resourceURI + httpParameters;
                URL url = new URL(formatedURL);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                InputStream is = con.getInputStream();
                java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
                String response = s.hasNext() ? s.next() : "";
                Log.i("Data", response);
                result=response;
                //System.out.println(response);
            } catch (Exception e) {
                Log.e("Exception", e.getMessage());
            }

            return result;
        }

        @Override
        protected void onPostExecute(String result) {

            //deserializa objetos
            Gson gson = new GsonBuilder().create();
            ArrayList<Post> listFromJSON = (ArrayList<Post>)
            gson.fromJson(result, new TypeToken<ArrayList<Post>>() {}.getType());

            updatePostList(listFromJSON);
        }




    }

    private void updatePostList(ArrayList<Post> postList){
        LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayoutPosts);


        for (Post post: postList) {
            LinearLayout layout = new LinearLayout(this);
            layout.setPadding(0,0,0,60);
            layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            layout.setOrientation(LinearLayout.VERTICAL);//LinearLayout.HORIZONTAL


            TextView tv = new TextView(this);
            tv.setText(post.getTitle());
            tv.setTextSize(24);
            tv.setTextColor(Color.DKGRAY);
            tv.setTypeface(null, Typeface.BOLD);
            LinearLayout.LayoutParams p1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            tv.setLayoutParams(p1);
            layout.addView(tv);

            tv = new TextView(this);
            tv.setText(post.getBody());
            tv.setTextSize(18);
            p1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            tv.setLayoutParams(p1);
            layout.addView(tv);

            tv = new TextView(this);
            tv.setText("Autor id: "+post.getUserId()+ " | Post id: "+post.getId());
            tv.setTextSize(14);
            tv.setTextColor(Color.DKGRAY);
            tv.setTypeface(null, Typeface.ITALIC);
            p1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            tv.setLayoutParams(p1);
            layout.addView(tv);

            ll.addView(layout);


        }
    }
}

