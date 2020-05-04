package com.example.appjavaproject;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //set itens on list view
        ListView listview = (ListView) findViewById(R.id.listViewComponent1);
        List<String> ListElementsArrayList = new ArrayList<String>();

        ListElementsArrayList.add("Bora Bora, French Polynesia");
        ListElementsArrayList.add("Flamenco Beach, Puerto Rico");
        ListElementsArrayList.add("Tortuga Bay, Galapagos");
        ListElementsArrayList.add("Freights Bay, Barbados");
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (MainActivity.this, android.R.layout.simple_list_item_1, ListElementsArrayList);

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = parent.getItemAtPosition(position);
                String str = (String)o; //As you are using Default String Adapter
                Toast.makeText(getBaseContext(),str,Toast.LENGTH_SHORT).show();
            }
        });

        ImageView iv = (ImageView) findViewById(R.id.imageView);
        iv.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                String str = "The image view as been clicked";
                Toast.makeText(getBaseContext(),str,Toast.LENGTH_SHORT).show();
            }
        });

        //add elements on layout
        LinearLayout ll= (LinearLayout)findViewById(R.id.linearHorizonzalLayout);
        for (int i=0;i<ListElementsArrayList.size();i++){
            TextView t= new TextView(ll.getContext());
            t.setText(ListElementsArrayList.get(i));
            t.setOnClickListener(new View.OnClickListener() {
                //@Override
                public void onClick(View v) {
                    String str = ((TextView)v).getText().toString();
                    Toast.makeText(getBaseContext(),str,Toast.LENGTH_SHORT).show();
                }
            });

            ll.addView(t);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String title=item.getTitle().toString();
        Toast.makeText(getBaseContext(),title,Toast.LENGTH_SHORT).show();
        if(title.equals("Item 1")){
            //logic for Item 1
        }else if(title.equals("Item 2")){
            //logic for Item 1
        }
        return super.onOptionsItemSelected(item);
    }


}
