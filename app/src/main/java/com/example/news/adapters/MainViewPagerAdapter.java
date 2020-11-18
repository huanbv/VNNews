package com.example.news.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;


public class MainViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;

    public MainViewPagerAdapter(@NonNull FragmentManager fm, List<Fragment> fragmentList, int behavior) {
        super(fm, behavior);
        this.fragmentList = fragmentList;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
