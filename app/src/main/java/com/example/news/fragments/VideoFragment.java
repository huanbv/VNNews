package com.example.news.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.news.R;
import com.example.news.adapters.AdapterVideoSourceList;
import com.example.news.databinding.FragmentVideoBinding;
import com.example.news.models.ModelVideoSourceList;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class VideoFragment extends Fragment {
    private FragmentVideoBinding B;
    private AdapterVideoSourceList adapter;
    private FirebaseFirestore firebaseFirestore;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        /* anh xa layout cho DataBinding */
        B = DataBindingUtil.inflate(inflater, R.layout.fragment_video, container, false);
        return B.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        firebaseFirestore = FirebaseFirestore.getInstance();


        //Query
        Query query = firebaseFirestore.collection("video");


        // Recycle options
        FirestoreRecyclerOptions<ModelVideoSourceList> options = new FirestoreRecyclerOptions
                .Builder<ModelVideoSourceList>()
                .setQuery(query, ModelVideoSourceList.class)
                .build();

        adapter = new AdapterVideoSourceList(options,getContext());

        //View holder
        B.videoSourcesRv.setHasFixedSize(true);
        B.videoSourcesRv.setLayoutManager(new LinearLayoutManager(getContext()));
        B.videoSourcesRv.setAdapter(adapter);

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