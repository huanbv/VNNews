package com.example.news.activities;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.news.R;
import com.example.news.adapters.AdapterVideoItem;
import com.example.news.models.VideoItemModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class VideoItemActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterVideoItem adapter;
    private ArrayList<VideoItemModel> videoItems = new ArrayList<>();
    private ProgressBar progressBar;
    private SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerView);
        refreshLayout = findViewById(R.id.swipeLayout);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterVideoItem(videoItems, this);
        recyclerView.setAdapter(adapter);

        loadItems();
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadItems();
            }
        });

    }

    private void loadItems() {
        Content content = new Content();
        content.execute();
    }

    private class Content extends AsyncTask<Void,Void,Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
            progressBar.startAnimation(AnimationUtils.loadAnimation(VideoItemActivity.this, android.R.anim.fade_in));
            videoItems.clear();
            adapter.notifyDataSetChanged();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressBar.setVisibility(View.GONE);
            progressBar.startAnimation(AnimationUtils.loadAnimation(VideoItemActivity.this, android.R.anim.fade_out));
            adapter.notifyDataSetChanged();
            refreshLayout.setRefreshing(false);
        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                String url = "https://www.youtube.com/c/vtv24/videos";

                Document doc = Jsoup.connect(url).get();

                Elements data = doc.select("div.item");
                int size = data.size();
                Log.d("doc", "doc: "+doc);
                Log.d("data", "data: "+data);
                Log.d("size", ""+size);
                for (int i = 0; i < size; i++) {

                    String videoUrl = data.select("div.media")
                            .eq(i)
                            .attr("data-mp4");
                    videoUrl = "http:" + videoUrl;

                    String previewUrl = data.select("div.media")
                            .select("img")
                            .eq(i)
                            .attr("src");


                    videoItems.add(new VideoItemModel(videoUrl, previewUrl));
                    Log.d("items", "videoUrl: " + videoUrl + " . previewUrl: " + previewUrl);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }
    }
}

