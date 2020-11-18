package com.example.news.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news.models.ModelSourceList;
import com.example.news.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;


public class AdapterSourceList extends FirestoreRecyclerAdapter<ModelSourceList, AdapterSourceList.NewsViewHolder> {
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public AdapterSourceList(@NonNull FirestoreRecyclerOptions options) {
        super(options);
    }


    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_source_list, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull NewsViewHolder holder, int position, @NonNull ModelSourceList model) {
        holder.name.setText(model.getName());
        holder.description.setText(model.getDescription());
        holder.category.setText(model.getCategory());
    }



    public static class NewsViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView description;
        private TextView category;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            category = itemView.findViewById(R.id.category);
        }
    }

}
