package com.example.asus.onequickly.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.asus.onequickly.R;
import com.example.asus.onequickly.model.bean.RandomFriendsBean;
import com.example.asus.onequickly.presenter.httppresenter.MyHotFineFoodPresenter;
import com.example.asus.onequickly.view.adapter.MyHotFollowFineFoodListAdapter;
import com.example.asus.onequickly.view.viewcallback.IHotFollowFineFoodView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * 美食
 */
public class HotFollowFineFoodFragment extends BaseFragment<IHotFollowFineFoodView,MyHotFineFoodPresenter> implements IHotFollowFineFoodView {


    @BindView(R.id.hotfollow_fine_food_rv)
    RecyclerView hotfollowFineFoodRv;
    Unbinder unbinder;

    public HotFollowFineFoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.hot_follow_finefoodlayout, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public MyHotFineFoodPresenter initpresenter() {
        return new MyHotFineFoodPresenter(getActivity());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //设置recyclerview 的布局样式
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        hotfollowFineFoodRv.setLayoutManager(manager);
        hotfollowFineFoodRv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        //获取来自美食的数据 并返回到下面的回调中
        presenter.getfinefoodnow();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void getfinefooddata(RandomFriendsBean bean) {
        MyHotFollowFineFoodListAdapter adapter=new MyHotFollowFineFoodListAdapter(getActivity(),bean);
        hotfollowFineFoodRv.setAdapter(adapter);
    }
}
