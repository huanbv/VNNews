package com.example.news.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.news.R;
import com.example.news.activities.NewsDetailActivity;
import com.example.news.models.ModelNewsSourceList;
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

    @Override
    protected void onBindViewHolder(@NonNull VideoViewHolder holder, int position, @NonNull ModelVideoSourceList model) {


        /* Xuat thong tin tu Firestore hiẻn thi len RecycleView tai News Layout */
        holder.name.setText(model.getName());
        holder.description.setText((model.getDescription()));
//        holder.videoUrl.getContext()).VideoView(model.getVideolUrl()).into(holder.videoUrl);
//        Glide.with(holder.videoUrl.getContext()).load(model.getVideolUrl()).into(holder.videoUrl);

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
//        private VideoView videoUrl;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);

//            videoUrl = (VideoView) videoUrl.findViewById(R.id.videoUrl);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
        }
    }
}
