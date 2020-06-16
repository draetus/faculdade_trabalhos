package com.univali.asynctask;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import entities.Comment;
import http.TypiCodeAPIComments;

public class Comments extends AppCompatActivity {

    private LinearLayout commentsList;
    public static List<Comment> comments;
    public static Long postId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        setupViews();
    }

    private void setupViews() {
        commentsList = findViewById(R.id.commentsList);

        Intent intent = getIntent();
        Comments.postId = intent.getLongExtra("postId", 1);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Comments.comments = new TypiCodeAPIComments().getAllComments(Comments.postId);
            }
        });

        thread.start();
        while (thread.isAlive()) {}
        setupCommentsView(Comments.comments);
    }

    private void setupCommentsView(List<Comment> comments) {
        commentsList.removeAllViews();
        for (Comment comment : comments) {
            commentsList.addView(setupCommentInfoView(comment));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private LinearLayout setupCommentInfoView(Comment comment) {
        LinearLayout layout = new LinearLayout(this);
        layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView tv = new TextView(this);
        tv.setText(comment.getName());
        tv.setLayoutParams(lp);
        tv.setAllCaps(true);
        layout.addView(tv);

        TextView tv1 = new TextView(this);
        tv1.setText(comment.getEmail());
        tv1.setLayoutParams(lp);
        tv1.setAllCaps(true);
        layout.addView(tv1);

        TextView tv2 = new TextView(this);
        tv2.setText(comment.getBody());
        tv2.setLayoutParams(lp);
        tv2.setAllCaps(true);
        layout.addView(tv2);

        GradientDrawable border = new GradientDrawable();
        border.setColor(0xFFFFFFFF); //white background
        border.setStroke(1, 0xFF000000); //black border with full opacity
        layout.setBackground(border);

        return layout;

    }
}
