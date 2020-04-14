package com.univali.listamunicipios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Detalhes_Cidade extends AppCompatActivity {

    TextView nameTitle;
    TextView popTitle;
    TextView areaTitle;
    TextView densTitle;
    TextView nameContent;
    TextView popContent;
    TextView areaContent;
    TextView densContent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes__cidade);

        setupViews();

        Intent intent = getIntent();
        Cidade cidade = (Cidade)intent.getSerializableExtra("cidade");
        setupInfo(cidade);
    }

    private void setupViews() {
        nameTitle = findViewById(R.id.nameTitle);
        popTitle = findViewById(R.id.popTitle);
        areaTitle = findViewById(R.id.areaTitle);
        densTitle = findViewById(R.id.denstitle);
        nameContent = findViewById(R.id.nameContent);
        popContent = findViewById(R.id.popContent);
        areaContent = findViewById(R.id.areaContent);
        densContent = findViewById(R.id.densContent);
    };

    public void setupInfo(Cidade cidade) {
        nameContent.setText(cidade.getNome());

        if (cidade.getPopulacao() != null)
            popContent.setText(cidade.getPopulacao().toString());

        if (cidade.getArea() != null)
            areaContent.setText(cidade.getArea().toString());

        if (cidade.getDensidadePopulacional() != null)
            densContent.setText(cidade.getDensidadePopulacional().toString());
    }
}
