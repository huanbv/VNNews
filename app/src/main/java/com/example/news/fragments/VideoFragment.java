package com.example.news.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.news.R;
import com.example.news.databinding.FragmentVideoBinding;
import com.squareup.picasso.Picasso;


public class VideoFragment extends Fragment {
    private FragmentVideoBinding B;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        B = DataBindingUtil.inflate(inflater, R.layout.fragment_video, container, false);
        return B.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*Picasso.get()
            .load("https://tinyurl.com/y3g3gbx7")
            .into(B.imvThumbnail);*/

        Glide.with(getContext())
            .load("https://cafefcdn.com/zoom/370_230/203337114487263232/2020/11/18/photo1605665116947-1605665117279325495695.png")
            .into(B.imvThumbnail);
    }

}