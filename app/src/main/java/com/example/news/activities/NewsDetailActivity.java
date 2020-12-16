package com.example.news.activities;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
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

    TextToSpeech mTTS;

    Button mSpeakBtn, mStopBtn;

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


        description = findViewById(R.id.description);
        mSpeakBtn = findViewById(R.id.mSpeakBtn);
        mStopBtn = findViewById(R.id.mStopBtn);

        mTTS = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR){
                    mTTS.setLanguage(Locale.UK);
                }else {
                    Toast.makeText(NewsDetailActivity.this, "Error",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        mSpeakBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = description.getText().toString().trim();
                if(toSpeak.equals("")){
                    Toast.makeText(NewsDetailActivity.this, "Don't have any chẩct...",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(NewsDetailActivity.this, toSpeak,
                            Toast.LENGTH_SHORT).show();
                    mTTS.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

                }
            }
        });

        mStopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mTTS.isSpeaking()){
                    mTTS.stop();
                   // mTTS.shutdown();
                }else {
                    //not speaking
                    Toast.makeText(NewsDetailActivity.this, "Not speaking", Toast.LENGTH_SHORT).show();
                }
            }
        });


        ModelNewsSourceList modelNewsSourceList = (ModelNewsSourceList)intent.getSerializableExtra("NewsDetail");

        Glide.with(getApplicationContext()).load(modelNewsSourceList.getThumbnailUrl()).into(imageView);
        name.setText(modelNewsSourceList.getName());
        description.setText(modelNewsSourceList.getDescription());
        category.setText(modelNewsSourceList.getCategory());
        date.setText(modelNewsSourceList.getDate());
        time.setText(modelNewsSourceList.getTime());

    }

    @Override
    protected void onPause() {
        if (mTTS != null || mTTS.isSpeaking()){
            //if it is speaking then stop
            mTTS.stop();
            //mTTS.shutdown();
        }
        super.onPause();
    }
}


