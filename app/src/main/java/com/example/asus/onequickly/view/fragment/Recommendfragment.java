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
import com.example.asus.onequickly.view.adapter.RecommendPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Recommendfragment extends Fragment {

    private ViewPager mRecommendVP;
    private TabLayout mTab;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommendfragment, container, false);

        mTab = view.findViewById(R.id.Tab);
        mRecommendVP = view.findViewById(R.id.RecommendPager);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        RecommendPagerAdapter pagerAdapter = new RecommendPagerAdapter(getChildFragmentManager());
        mRecommendVP.setAdapter(pagerAdapter);
        mTab.setupWithViewPager(mRecommendVP);

        //设置tabLayout指示器宽度
        mTab.post(new Runnable() {
            @Override
            public void run() {
                TabUtils.setIndicator(mTab,50,50);

            }
        });


    }
}
