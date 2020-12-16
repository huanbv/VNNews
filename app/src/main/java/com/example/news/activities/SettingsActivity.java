package com.example.news.activities;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    public void onClick(View v) {

    }

    public void onClickToVideoItemList(View view) {
        Toast.makeText(SettingsActivity.this, "Chuyển hướng thành công", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), VideoItemActivity.class));
    }
}
