package com.univali.dadoscovid.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.univali.dadoscovid.R;
import com.univali.dadoscovid.entities.Municipio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.List;

public class JSONReader {

    public static List<Municipio> parseMunicipios(String json) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(json));
            Gson gson = new Gson();
            Type municipiosListType = new TypeToken<List<Municipio>>(){}.getType();

            List<Municipio> municipios = gson.fromJson(bufferedReader, municipiosListType);

            return municipios;
        } catch (Exception ex) {
            System.out.println("DEU RUIM");
            System.out.println("DEU RUIM");
            System.out.println("DEU RUIM");
            System.out.println("DEU RUIM");
            System.out.println("DEU RUIM");
            System.out.println("DEU RUIM");
            System.out.println("DEU RUIM");
            System.out.println("DEU RUIM");
            System.err.println(ex.getMessage());
            return null;
        }
    }
}
