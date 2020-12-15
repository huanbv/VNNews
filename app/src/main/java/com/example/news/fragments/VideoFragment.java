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
import com.example.news.adapters.AdapterNewsSourceList;
import com.example.news.databinding.FragmentVideoBinding;
import com.example.news.models.ModelNewsSourceList;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;


public class VideoFragment extends Fragment {
    private FragmentVideoBinding B;
    private AdapterNewsSourceList adapter;
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

        /*Picasso.get()
            .load("https://tinyurl.com/y3g3gbx7")
            .into(B.imvThumbnail);*/

        /*Glide.with(getContext())
            .load("https://cafefcdn.com/zoom/370_230/203337114487263232/2020/11/18/photo1605665116947-1605665117279325495695.png")
            .into(B.imvThumbnail);*/
        firebaseFirestore = FirebaseFirestore.getInstance();


        //Query
        Query query = firebaseFirestore.collection("Videos");


        // Recycle options
        FirestoreRecyclerOptions<ModelNewsSourceList> options = new FirestoreRecyclerOptions
                .Builder<ModelNewsSourceList>()
                .setQuery(query, ModelNewsSourceList.class)
                .build();

        adapter = new AdapterNewsSourceList(options,getContext());

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