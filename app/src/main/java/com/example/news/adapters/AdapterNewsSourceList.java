package com.example.news.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.news.activities.NewsDetailActivity;
import com.example.news.models.ModelNewsSourceList;
import com.example.news.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;


public class AdapterNewsSourceList extends FirestoreRecyclerAdapter<ModelNewsSourceList, AdapterNewsSourceList.NewsViewHolder> {
    Context context;

    public AdapterNewsSourceList(@NonNull FirestoreRecyclerOptions options, Context context) {
        super(options);
        this.context = context;

    }


    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_source_list, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull NewsViewHolder holder, int position, @NonNull ModelNewsSourceList model) {


        /* Xuat thong tin tu Firestore hiẻn thi len RecycleView tai News Layout */
        holder.name.setText(model.getName());
        Glide.with(holder.itemView.getContext()).load(model.getThumbnailUrl()).into(holder.thumbnailUrl);

        /* Khi nhan vao tin tuc se chuyen qua Layout chi tiet cua tin tuc do */
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, NewsDetailActivity.class);
                intent.putExtra("NewsDetail",model);
                context.startActivity(intent);
            }
        });
    }


    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private ImageView thumbnailUrl;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            thumbnailUrl = itemView.findViewById(R.id.thumbnailUrl);
            name = itemView.findViewById(R.id.name);
        }
    }
}
