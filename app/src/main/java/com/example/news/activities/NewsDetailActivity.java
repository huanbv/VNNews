package com.example.news.activities;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.news.R;
import com.example.news.models.ModelNewsSourceList;

import java.util.Locale;

public class NewsDetailActivity extends AppCompatActivity {
    Intent intent;
    ImageView imageView;
    TextView name;
    TextView description;
    TextView category;
    TextView date;
    TextView time;

    TextToSpeech textToSpeech_On;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_detail);
        intent = getIntent();
        imageView = findViewById(R.id.thumbnailUrl);
        name = findViewById(R.id.name);
        description = findViewById(R.id.description);
        category = findViewById(R.id.category);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);


        ModelNewsSourceList modelNewsSourceList = (ModelNewsSourceList)intent.getSerializableExtra("NewsDetail");

        Glide.with(getApplicationContext()).load(modelNewsSourceList.getThumbnailUrl()).into(imageView);
        name.setText(modelNewsSourceList.getName());
        description.setText(modelNewsSourceList.getDescription());
        category.setText(modelNewsSourceList.getCategory());
        date.setText(modelNewsSourceList.getDate());
        time.setText(modelNewsSourceList.getTime());

    }
}


