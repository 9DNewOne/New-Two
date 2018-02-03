package com.example.asus.onequickly.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.onequickly.R;
import com.example.asus.onequickly.utils.app.FrescoApplication;
import com.example.asus.onequickly.view.adapter.InterestingNewsAdapter;
import com.example.asus.onequickly.view.adapter.RecommendAtnRlvAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class InterestingNewsFragment extends Fragment {

    @BindView(R.id.SatinRlv)
    RecyclerView SatinRlv;
    Unbinder unbinder;
    private final Context mContext;

    public InterestingNewsFragment() {
        mContext = FrescoApplication.getContext();
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_satin, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        SatinRlv.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));new RecommendAtnRlvAdapter();

        InterestingNewsAdapter newsAdapter = new InterestingNewsAdapter();

        SatinRlv.setAdapter(newsAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
