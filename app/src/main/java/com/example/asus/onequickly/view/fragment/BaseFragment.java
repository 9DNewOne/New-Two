package com.example.asus.onequickly.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.asus.onequickly.presenter.httppresenter.BasePresenter;


/**
 * Created by asus on 2017/12/29.
 */

public abstract class BaseFragment<V,P extends BasePresenter<V>> extends Fragment {
    public Context context;
    public P presenter;
    public abstract P initpresenter();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context=getActivity();
        presenter=initpresenter();
        if(presenter!=null){
            presenter.attachview((V) this);
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if(presenter!=null){
            presenter.dettach();
        }
    }
}
