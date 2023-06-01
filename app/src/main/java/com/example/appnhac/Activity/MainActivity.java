// MainActivity
package com.example.appnhac.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.appnhac.Adapter.MainViewPagerAdapter;
import com.example.appnhac.Fragment.Fragment_Home;
import com.example.appnhac.Fragment.Fragment_search;
import com.example.appnhac.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        init();
    }

    private void setupViews() {
        tabLayout = findViewById(R.id.myTabLayout);
        viewPager = findViewById(R.id.myViewPager);
    }

    private void init() {
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(this);
        mainViewPagerAdapter.addFragment(new Fragment_Home(), "Trang Chu");
        mainViewPagerAdapter.addFragment(new Fragment_search(), "Tim kiem");
        viewPager.setAdapter(mainViewPagerAdapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setIcon(position == 0 ? R.drawable.icontrangchu : R.drawable.icontimkiem))
                .attach();
    }
}
