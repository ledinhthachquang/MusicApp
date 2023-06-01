// MainViewPagerAdapter
package com.example.appnhac.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class MainViewPagerAdapter extends FragmentStateAdapter {
    private ArrayList<Fragment> arrayFragment = new ArrayList<>();
    private ArrayList<String> arrayTitle = new ArrayList<>();

    public MainViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return arrayFragment.get(position);
    }

    @Override
    public int getItemCount() {
        return arrayFragment.size();
    }

    public void addFragment(Fragment fragment, String title) {
        arrayFragment.add(fragment);
        arrayTitle.add(title);
    }


    public CharSequence getPageTitle(int position) {
        return arrayTitle.get(position);
    }
}
