package com.example.asus.onequickly.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.example.asus.onequickly.view.fragment.MoviesHotFragment;
import com.example.asus.onequickly.view.fragment.MoviesNearbyFragment;

/**
 * Created by gq on 2018/1/29.
 */

public class MoviesPageAdapter extends FragmentPagerAdapter {
    private static int Hot = 0;     //热门
    private static int nearby = 1;  //附近
    private String[] mTitles = new String[]{"热门", "附近"};
    public MoviesPageAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        if (position == Hot) {
            return new MoviesHotFragment();
        } else if (position == nearby) {
            return new MoviesNearbyFragment();
        }
        return new MoviesHotFragment();
    }
    @Override
    public int getCount() {
        return mTitles.length;
    }
    //用来设置tab的标题
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
