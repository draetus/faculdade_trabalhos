package com.univali.dadoscovid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.univali.dadoscovid.entities.Municipio;
import com.univali.dadoscovid.json.JSONReader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputStream is = getResources().openRawResource(R.raw.dados);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (Exception e) {
            System.out.println();
        } finally {
            try {
                is.close();
            } catch (Exception e) {
                System.out.println();
            }
        }
        String jsonString = writer.toString();

        System.out.println("lol");

        List<Municipio> municipios = JSONReader.parseMunicipios(jsonString);
    }
}
