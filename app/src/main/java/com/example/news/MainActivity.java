package com.example.news;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class MainActivity extends AppCompatActivity {


    private EditText searchEt;
    private ImageButton filterBtn;
    private RecyclerView sourcesRv;
    private FirebaseFirestore firebaseFirestore;

    private FirestoreRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init ui views
        //searchEt = findViewById(R.id.searchEt);
        //filterBtn = findViewById(R.id.filterBtn);
        firebaseFirestore = FirebaseFirestore.getInstance();
        sourcesRv = findViewById(R.id.sourcesRv);

        //Query
        Query query = firebaseFirestore.collection("news");

        // Recycle options
        FirestoreRecyclerOptions<ModelSourceList> options = new FirestoreRecyclerOptions
                .Builder<ModelSourceList>()
                .setQuery(query, ModelSourceList.class)
                .build();

        adapter = new FirestoreRecyclerAdapter<ModelSourceList, NewsViewHolder>(options) {
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
        };

        //View holder
        sourcesRv.setHasFixedSize(true);
        sourcesRv.setLayoutManager(new LinearLayoutManager(this));
        sourcesRv.setAdapter(adapter);
        adapter.startListening();

    }

    private class NewsViewHolder extends RecyclerView.ViewHolder{

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

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        if(adapter != null) {
            adapter.stopListening();
        }
    }
}