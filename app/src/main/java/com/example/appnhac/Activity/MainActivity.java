// MainActivity
package com.example.appnhac.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.example.appnhac.Adapter.MainViewPagerAdapter;
import com.example.appnhac.Fragment.Fragment_Downloads;
import com.example.appnhac.Fragment.Fragment_Home;
import com.example.appnhac.Fragment.Fragment_MyLibrary;
import com.example.appnhac.Fragment.Fragment_Tim_Kiem;
import com.example.appnhac.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        init();
    }

    private void setupViews() {
        viewPager = findViewById(R.id.myViewPager);
        tabLayout = findViewById(R.id.myTabLayout);
    }

    private void init() {
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(this);
        mainViewPagerAdapter.addFragment(new Fragment_Home(), "Home");
        mainViewPagerAdapter.addFragment(new Fragment_Tim_Kiem(), "Search");
        mainViewPagerAdapter.addFragment(new Fragment_MyLibrary(),"My Library");
        mainViewPagerAdapter.addFragment(new Fragment_Downloads(), "Downloads");
        viewPager.setAdapter(mainViewPagerAdapter);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setIcon(R.drawable.icontrangchu);
                            break;
                        case 1:
                            tab.setIcon(R.drawable.icontimkiem);
                            break;
                        case 2:
                            tab.setIcon(R.drawable.icon_library);
                            break;
                        case 3:
                            tab.setIcon(R.drawable.icon_downloads);
                            break;
                    }
                });

        tabLayoutMediator.attach();
        viewPager.setUserInputEnabled(false); // Disable swiping between pages
    }
}
