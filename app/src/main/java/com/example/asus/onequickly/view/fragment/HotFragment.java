package com.example.asus.onequickly.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.asus.onequickly.R;
import com.example.asus.onequickly.utils.app.FrescoApplication;



import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 热门
 */
public class HotFragment extends Fragment{

    private static final String TAG = "HotFragment";

    @BindView(R.id.hot_rlv)
    RecyclerView hotRlv;
    Unbinder unbinder;

    private Context context;
//    private HotRlvAdapter rlvAdapter;

    public HotFragment() {
        context = FrescoApplication.getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_hot, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

//    @Override
//    public HotPresenter initPresenter() {
//        return new HotPresenter();
//    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


//        presenter.gainNetRequest();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * 获取数据
     *
     * @param icons 轮播图的数据
     */
//    @Override
//    public void showBannerList(List<String> icons) {
//        Log.e(TAG, "showBannerList: " + icons.size());
////        rlvAdapter.getData(icons);
//        rlvAdapter = new HotRlvAdapter(icons);
//
//        hotRlv.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
//
//        hotRlv.setAdapter(rlvAdapter);
//
//    }
//
//    @Override
//    public void showToast(int e) {
//
//        Toast.makeText(context, "" + e, Toast.LENGTH_SHORT).show();
//    }
}
