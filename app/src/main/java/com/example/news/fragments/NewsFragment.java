package com.example.news.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.news.R;
import com.example.news.adapters.AdapterSourceList;
import com.example.news.databinding.FragmentNewsBinding;
import com.example.news.models.ModelSourceList;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;


public class NewsFragment extends Fragment {
    private FragmentNewsBinding B;
    private AdapterSourceList adapter;
    private FirebaseFirestore firebaseFirestore;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        /* anh xa layout cho DataBinding */
        B = DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false);

        return B.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        firebaseFirestore = FirebaseFirestore.getInstance();


        //Query
        Query query = firebaseFirestore.collection("news");


        // Recycle options
        FirestoreRecyclerOptions<ModelSourceList> options = new FirestoreRecyclerOptions
            .Builder<ModelSourceList>()
            .setQuery(query, ModelSourceList.class)
            .build();

        adapter = new AdapterSourceList(options);

        //View holder
        B.sourcesRv.setHasFixedSize(true);
        B.sourcesRv.setLayoutManager(new LinearLayoutManager(getContext()));
        B.sourcesRv.setAdapter(adapter);


        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();

        if (adapter != null) {
            adapter.stopListening();
        }
    }

}