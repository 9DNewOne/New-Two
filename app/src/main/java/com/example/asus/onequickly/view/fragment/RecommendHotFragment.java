package com.example.asus.onequickly.view.fragment;

import android.content.Context;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;

import com.example.asus.onequickly.R;
import com.example.asus.onequickly.model.bean.BannerBean;
import com.example.asus.onequickly.model.bean.ProductionBean;
import com.example.asus.onequickly.presenter.httppresenter.RecommendHotPresenter;
import com.example.asus.onequickly.utils.app.FrescoApplication;
import com.example.asus.onequickly.view.adapter.RecommendHotRlvAdapter;
import com.example.asus.onequickly.view.viewcallback.HotView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 热门
 */
public class RecommendHotFragment extends BaseFragment<HotView, RecommendHotPresenter> implements HotView {

    private static final String TAG = "HotFragment";

    @BindView(R.id.hot_rlv)
    RecyclerView hotRlv;
    Unbinder unbinder;

    private Context context;
    private RecommendHotRlvAdapter rlvAdapter;

    public RecommendHotFragment() {
        context = FrescoApplication.getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_hot, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public RecommendHotPresenter initpresenter() {
        return new RecommendHotPresenter();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        hotRlv.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        rlvAdapter = new RecommendHotRlvAdapter();

        rlvAdapter.setOnItemClickListener(new RecommendHotRlvAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(context, "你点击了" + position + "", Toast.LENGTH_SHORT).show();

            }
        });
        presenter.gainNetRequest();

        presenter.gainNetProduction("","1","0");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * 获取数据
     *
     * @param bannerBean 请求数据
     */
    @Override
    public void showBannerList(BannerBean bannerBean) {

        if (bannerBean != null) {
            rlvAdapter.getBannerData(bannerBean.getData());
            hotRlv.setAdapter(rlvAdapter);
        }
    }
    /**
     * 请求失败
     *
     * @param e 错误码
     */

    @Override
    public void showToast(int e) {
        Toast.makeText(context, "" + e, Toast.LENGTH_SHORT).show();
    }

    /**
     * 获取作品列表
     *
     */
    @Override
    public void showProductionList(ProductionBean productions) {

        if (productions!=null){
            rlvAdapter.getProductionList(productions.getData());
            hotRlv.setAdapter(rlvAdapter);
        }
    }
}
