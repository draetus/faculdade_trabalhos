package com.univali.xml;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.univali.entities.BreakFestMenu;
import com.univali.entities.Food;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import http.BreakFestMenuAPI;

public class MainActivity extends AppCompatActivity {

    public static List<Food> foods;
    private LinearLayout foodList;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
        setupListeners();
    }

    private void setupViews() {
        this.foodList = findViewById(R.id.foodList);
        this.calculateButton = findViewById(R.id.calculateButton);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                MainActivity.foods = new BreakFestMenuAPI().getAllPosts();
            }
        });

        thread.start();
        while (thread.isAlive()) {}
        setupFoodListView(MainActivity.foods);
    }

    private void setupListeners() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double totalPrice = 0d;
                for (Food food : MainActivity.foods) {
                    if (food.getSelected()) {
                        totalPrice += Double.parseDouble(food.getPrice().replace("$", ""));
                    }
                }
                alertDialog("Preço Total: $" + totalPrice.toString(), "CALCULADO" );
            }
        });
    }

    private void setupFoodListView(List<Food> foods) {
        foodList.removeAllViews();
        for (Food food : foods) {
            foodList.addView(setupFoodView(food));
        }
    }

    private LinearLayout setupFoodView(Food food) {
        LinearLayout layout = new LinearLayout(this);
        layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView tv = new TextView(this);
        tv.setText(food.getName());
        tv.setLayoutParams(lp);
        tv.setAllCaps(true);
        layout.addView(tv);

        TextView tv1 = new TextView(this);
        tv1.setText(food.getDescription());
        tv1.setLayoutParams(lp);
        layout.addView(tv1);

        TextView tv2 = new TextView(this);
        tv2.setText("Price: " + food.getPrice());
        tv2.setLayoutParams(lp);
        layout.addView(tv2);

        TextView tv3 = new TextView(this);
        tv3.setText("Calories: " + food.getCalories() + "\n");
        tv3.setLayoutParams(lp);
        layout.addView(tv3);

        layout.setTag(food.getId());

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Long foodId = (Long)v.getTag();
                if (MainActivity.foods.get(foodId.intValue()).getSelected()) {
                    v.setBackgroundColor(Color.parseColor("#ffffff"));
                    System.out.println("FALSE");
                    MainActivity.foods.get(foodId.intValue()).setSelected(false);
                } else {
                    v.setBackgroundColor(Color.parseColor("#00ff7f"));
                    System.out.println("TRUE");
                    MainActivity.foods.get(foodId.intValue()).setSelected(true);
                }
            }
        });

        GradientDrawable border = new GradientDrawable();
        border.setColor(0xFFFFFFFF); //white background
        border.setStroke(1, 0xFF000000); //black border with full opacity
        layout.setBackground(border);
        layout.setClickable(true);

        return layout;
    }

    private void alertDialog(String message, String title) {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setMessage(message);
        dialog.setTitle(title);
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
    }
}
