package com.univali.pontoeletrnico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private LinearLayout jobsLayout;
    private TextView name;
    private TextView registration;
    private TextView department;
    private TextView role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
        setupListOfJobs();
    }

    private void setupViews() {
        this.jobsLayout = findViewById(R.id.jobsLayout);
        this.name = findViewById(R.id.name);
        this.department = findViewById(R.id.department);
        this.registration = findViewById(R.id.registration);
        this.role = findViewById(R.id.role);

        this.name.setText("Rafael Queiroz Gonçalves");
        this.department.setText("UNIVALI");
        this.registration.setText("2272342");
        this.role.setText("Professor");
    }

    private void setupListOfJobs() {
        Integer numJobs = calculateNumJobs();
        for (Integer i=1; i<=numJobs; i++) {
            setupJobInput(parseHoursOfDay(i));
        }
        if (numJobs > 0) {
            Button button = new Button(this);
            button.setText("Registrar");
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            button.setLayoutParams(lp);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Cadastro de atividades realizado (Sem persistência hehe)", Toast.LENGTH_SHORT).show();
                }
            });
            jobsLayout.addView(button);
        }
    }

    private void setupJobInput(String hourText) {
        LinearLayout layout = new LinearLayout(this);
        layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        TextView tv = new TextView(this);
        tv.setText(hourText);
        tv.setLayoutParams(lp);
        layout.addView(tv);

        EditText et = new EditText(this);
        et.setHint("Preencha a atividade executada");
        et.setWidth(900);
        et.setLayoutParams(lp);
        layout.addView(et);

        jobsLayout.addView(layout);
    }

    private Integer calculateNumJobs() {
        Date now = new Date();
        Integer hours = now.getHours() - 8;

        if (hours < 1) {
            return 0;
        } else if (hours < 5) {
            return hours;
        } else {
            hours--;
            if (hours > 8) {
                return 8;
            } else {
                return hours;
            }
        }
    }

    private String parseHoursOfDay(Integer hour) {
        switch (hour) {
            case 1:
                return "8:00h - 9:00h";

            case 2:
                return "9:00h - 10:00h";

            case 3:
                return "10:00h - 11:00h";

            case 4:
                return "11:00h - 12:00h";

            case 5:
                return "13:00h - 14:00h";

            case 6:
                return "14:00h - 15:00h";

            case 7:
                return "15:00h - 16:00h";

            case 8:
                return "16:00h - 17:00h";

            default:
                return null;
        }
    }
}
