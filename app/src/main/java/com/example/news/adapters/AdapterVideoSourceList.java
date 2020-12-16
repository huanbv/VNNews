package com.example.news.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news.R;
import com.example.news.activities.NewsDetailActivity;
import com.example.news.models.ModelVideoSourceList;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;


public class AdapterVideoSourceList extends FirestoreRecyclerAdapter<ModelVideoSourceList, AdapterVideoSourceList.VideoViewHolder> {
    Context context;

    public AdapterVideoSourceList(@NonNull FirestoreRecyclerOptions options, Context context) {
        super(options);
        this.context = context;

    }


    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_source_list, parent, false);
        return new VideoViewHolder(view);
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onBindViewHolder(@NonNull VideoViewHolder holder, int position, @NonNull ModelVideoSourceList model) {

        /* Xuat thong tin tu Firestore hiẻn thi len RecycleView tai News Layout */
        holder.name.setText(model.getName());
        holder.description.setText((model.getDescription()));
//        holder.videoView.setVideoURI(Uri.parse(model.getVideolUrl()));

        holder.webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        String frameVideo = String.format("<html><body><br><iframe width=\"320\" height=\"200\" src=\"https://www.youtube.com/embed/%s\" frameborder=\"0\" allowfullscreen></iframe></body></html>",
                model.getVideoUrl().split("\\?v=")[1]);
        WebSettings webSettings = holder.webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        holder.webView.loadData(frameVideo, "text/html", "utf-8");


        /* Khi nhan vao tin tuc se chuyen qua Layout chi tiet cua tin tuc do */
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, NewsDetailActivity.class);
                intent.putExtra("VideoDetail",model);
                context.startActivity(intent);
            }
        });
    }


    public static class VideoViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView description;
        private WebView webView;
//        private VideoView videoView;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);

//            videoView = itemView.findViewById(R.id.videoUrl);
            webView = itemView.findViewById(R.id.videoView);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
        }
    }
}
