package com.example.asus.onequickly.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.asus.onequickly.view.fragment.AttentionFragment;
import com.example.asus.onequickly.view.fragment.HotFragment;


/**
 *
 * Created by asus on 2018/1/24.
 */

public class RecommendPagerAdapter extends FragmentPagerAdapter {
    private static int Hot = 0;
    private static int ATTENTION = 1;

    private String[] mTitles = new String[]{"热门", "关注"};

    public RecommendPagerAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        if (position == Hot) {

            return new HotFragment();
        } else if (position == ATTENTION) {
            return new AttentionFragment();
        }

        return new HotFragment();

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
