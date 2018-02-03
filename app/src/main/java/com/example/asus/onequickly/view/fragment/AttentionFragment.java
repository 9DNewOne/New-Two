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
import com.example.asus.onequickly.presenter.httppresenter.AttentionPresenter;
import com.example.asus.onequickly.utils.app.FrescoApplication;
import com.example.asus.onequickly.view.adapter.RecommendAtnRlvAdapter;
import com.example.asus.onequickly.view.adapter.RecommendHotRlvAdapter;
import com.example.asus.onequickly.view.viewcallback.AttentionView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * 关注
 */
public class AttentionFragment extends BaseFragment<AttentionView, AttentionPresenter> implements AttentionView {

    Unbinder unbinder;
    @BindView(R.id.attention_rlv)
    RecyclerView attentionRlv;
    private final Context mContext;
    private RecommendAtnRlvAdapter adapter;

    public AttentionFragment() {

        mContext = FrescoApplication.getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attention, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public AttentionPresenter initpresenter() {
        return new AttentionPresenter();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        attentionRlv.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        adapter = new RecommendAtnRlvAdapter();

        presenter.gainNetRequest();

        presenter.gainNetProduction("", "1", "0");

        adapter.setOnItemClickListener(new RecommendAtnRlvAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(context, "你点击了" + position + "", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void showBannerList(BannerBean bannerBean) {

        if (bannerBean != null) {
            adapter.getBannerData(bannerBean.getData());
            attentionRlv.setAdapter(adapter);

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

    @Override
    public void showProductionList(ProductionBean productions) {
        if (productions != null) {

            adapter.getProductionList(productions.getData());

            attentionRlv.setAdapter(adapter);


        }
    }
}
