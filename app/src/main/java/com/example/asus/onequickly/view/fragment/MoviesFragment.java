package com.example.asus.onequickly.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.onequickly.R;
import com.example.asus.onequickly.utils.otherutils.TabUtils;
import com.example.asus.onequickly.view.adapter.MoviesPageAdapter;


/**
 * A simple {@link Fragment} subclass.
 */



//这是视屏播放的fragment 需求是tablayout viewpage依附两fragment

public class MoviesFragment extends Fragment {


    private TabLayout tabMovies;
    private ViewPager moviesPager;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        tabMovies = view.findViewById(R.id.TabMovies);
        moviesPager = view.findViewById(R.id.MoviesPager);

        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        MoviesPageAdapter pagerAdapter = new MoviesPageAdapter(getChildFragmentManager());
        moviesPager.setAdapter(pagerAdapter);
        tabMovies.setupWithViewPager(moviesPager);



        //设置tabLayout指示器宽度
        tabMovies.post(new Runnable() {
            @Override
            public void run() {
                TabUtils.setIndicator(tabMovies,50,50);

            }
        });
    }
}
