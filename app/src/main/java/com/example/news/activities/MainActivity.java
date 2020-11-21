package com.example.news.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.news.fragments.ExploreFragment;
import com.example.news.adapters.MainViewPagerAdapter;
import com.example.news.databinding.ActivityMainBinding;
import com.example.news.R;
import com.example.news.fragments.NewsFragment;
import com.example.news.fragments.NotificationsFragment;
import com.example.news.fragments.SettingsFragment;
import com.example.news.fragments.VideoFragment;
import com.example.news.models.ModelNewsSourceList;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public ArrayList<ModelNewsSourceList> fillerList;
    private ActivityMainBinding B;
    private List<Integer> bottomNavIdsList;
    private List<Fragment> fragmentsList;
    private MainViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* anh xa de lien ket layout voi doi tuong DataBinding */
        B = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);


        init(); /* khoi tao cac danh sach */


        /* khoi tao ViewPager */
        B.viewPager.setAdapter(adapter);
        B.viewPager.setOffscreenPageLimit(4);


        /* gan su kien cho cac View */
        assignEvents();


        /* chon item duoc hien thi mac dinh */
        B.bottomNav.setSelectedItemId(bottomNavIdsList.get(0));
    }


    private void assignEvents() {
        B.bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                /* cuon ViewPager den fragment da duoc chon tuong ung trong BottomNavView */
                B.viewPager.setCurrentItem(bottomNavIdsList.indexOf(item.getItemId()), true);

                /* cap nhat tieu de cho action bar */
                ActionBar actionBar = getSupportActionBar();
                actionBar.setTitle(item.getTitle());

                return true;
            }
        });

        B.viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                /* cap nhat bottomNav item da duoc chon khi ViewPager thay doi fragment */
                B.bottomNav.setSelectedItemId(bottomNavIdsList.get(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void init() {
        /* khoi tao danh sach cac menu id */
        bottomNavIdsList = new ArrayList<>();
        bottomNavIdsList.add(R.id.main_act_news_menu);
        bottomNavIdsList.add(R.id.main_act_video_menu);
        bottomNavIdsList.add(R.id.main_act_explore_menu);
        bottomNavIdsList.add(R.id.main_act_notis_menu);
        bottomNavIdsList.add(R.id.main_act_settings_menu);

        /* khoi tao danh sach cac fragment se hien thi trong ViewPager */
        fragmentsList = new ArrayList<>();
        fragmentsList.add(new NewsFragment());
        fragmentsList.add(new VideoFragment());
        fragmentsList.add(new ExploreFragment());
        fragmentsList.add(new NotificationsFragment());
        fragmentsList.add(new SettingsFragment());

        /* khoi tao adapter cho ViewPager */
        adapter = new MainViewPagerAdapter(getSupportFragmentManager(), fragmentsList, 0);
    }

}