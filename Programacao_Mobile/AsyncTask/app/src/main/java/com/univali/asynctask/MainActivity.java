package com.univali.asynctask;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import entities.Post;
import http.TypiCodeAPIPosts;

public class MainActivity extends AppCompatActivity {

    private LinearLayout postList;
    public static List<Post> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();

    }

    private void setupViews() {
        this.postList = findViewById(R.id.postList);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                MainActivity.posts = new TypiCodeAPIPosts().getAllPosts();
            }
        });

        thread.start();
        while (thread.isAlive()) {}
        setupPostsView(MainActivity.posts);
    }

    private void setupPostsView(List<Post> posts) {
        postList.removeAllViews();
        for (Post post : posts) {
            postList.addView(setupPostView(post));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private LinearLayout setupPostView(Post post) {
            LinearLayout layout = new LinearLayout(this);
            layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            layout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView tv = new TextView(this);
        tv.setText(post.getTitle());
        tv.setLayoutParams(lp);
        tv.setAllCaps(true);
        layout.addView(tv);

        TextView tv1 = new TextView(this);
        tv1.setText(post.getBody());
        tv1.setLayoutParams(lp);
        layout.addView(tv1);

        layout.setTag(post.getId());

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Long postId = (Long)v.getTag();
                Intent intent = new Intent(getBaseContext(), Comments.class);
                intent.putExtra("postId", postId);
                startActivity(intent);
            }
        });


        GradientDrawable border = new GradientDrawable();
        border.setColor(0xFFFFFFFF); //white background
        border.setStroke(1, 0xFF000000); //black border with full opacity
        layout.setBackground(border);
        layout.setClickable(true);

        return layout;

    }
}