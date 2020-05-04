package com.example.appjavaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.univali.mobile.entities.Filme;

public class ActivityFilmList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_list);

        //set itens on list viewList
        ListView listview = (ListView) findViewById(R.id.listViewMovies);


        List<Filme> listElementsArrayList = new ArrayList<Filme>();
        String[] horarios=new String[]{"16:30","19:00","21:00"};
        listElementsArrayList.add(new Filme("It is a wonderful life", horarios,"Frank Capra, Albert Hackett, Jo Swerling, Frances Goodrich, Michael Wilson" ));

        horarios=new String[]{"13:30","15:00","17:00"};
        listElementsArrayList.add(new Filme("12 angry man", horarios,"Sidney Lumet, Reginald Rose" ));

        horarios=new String[]{"14:30","17:00","19:00"};
        listElementsArrayList.add(new Filme("North by northwest", horarios,"Alfred Hitchcock, Ernest Lehman"));

         horarios=new String[]{"16:30","18:00","20:00"};
        listElementsArrayList.add(new Filme("The lord of the rings", horarios , "Elijah Wood, Viggo Mortensen, Orlando Bloom, Ian McKellen"));

        horarios=new String[]{"17:30","20:00","21:00"};
        listElementsArrayList.add(new Filme("City light", horarios,"Charlie Chaplin, Harry Crocker" ));
        horarios=new String[]{"18:30","21:00","22:00"};

        final ArrayAdapter<Filme> adapter = new ArrayAdapter<Filme>(this, android.R.layout.simple_list_item_1, listElementsArrayList);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = parent.getItemAtPosition(position);
                Filme f = (Filme) o; //As you are using Default String Adapter
                //Toast.makeText(getBaseContext(), f.getNome(), Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(getBaseContext(), com.example.appjavaproject.MainMovieDetails.class);
                myIntent.putExtra("movie", f);
                startActivity(myIntent);

            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.spinnerCinema);
        List<String> tipos= new ArrayList<String>();
        tipos.add("Florianópolis");
        tipos.add("São José");
        tipos.add("Palhoça");
        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,tipos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterSpinner);

         spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object o=parent.getItemAtPosition(position);
                String tipo= (String) o; //As you are using Default String Adapter
                Toast.makeText(getBaseContext(), tipo, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Toast.makeText(getBaseContext(),"No change...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
