package com.example.asus.onequickly.view.fragment;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.onequickly.R;
import com.example.asus.onequickly.model.bean.MoviesBean;
import com.example.asus.onequickly.presenter.httppresenter.MyMoviesHotPresenter;
import com.example.asus.onequickly.utils.otherutils.SpacesItemDecoration;
import com.example.asus.onequickly.view.adapter.MyMoviesHotAdapter;
import com.example.asus.onequickly.view.viewcallback.IMoviesHotView;

import static android.content.Context.MODE_PRIVATE;
/**
 * A simple {@link Fragment} subclass.
 */

public class MoviesHotFragment extends BaseFragment<IMoviesHotView,MyMoviesHotPresenter> implements IMoviesHotView {

    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private RecyclerView moviesHotrecycleview01;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies_hot, container, false);
         //xrecycleview瀑布流
         moviesHotrecycleview01 = view.findViewById(R.id.moviesHotrecycleview01);
         return view;
    }
    @Override
    public MyMoviesHotPresenter initpresenter() {
        return new MyMoviesHotPresenter(getActivity());
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        SharedPreferences sp = getActivity().getSharedPreferences("login",MODE_PRIVATE);

          int uid1 = sp.getInt("uid", 11864);
          presenter.movieshot(uid1+"","10");


    }



    @Override
    public void MoviesHotdata(MoviesBean moviesBean) {

           staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
           moviesHotrecycleview01.setLayoutManager(staggeredGridLayoutManager);

            Log.i("=======",moviesBean.getMsg());


          //添加到适配器
            MyMoviesHotAdapter myAdapter = new MyMoviesHotAdapter(getActivity(),moviesBean);
            moviesHotrecycleview01.setAdapter(myAdapter);


            //设置item之间的间隔
            SpacesItemDecoration decoration=new SpacesItemDecoration(16);
            moviesHotrecycleview01.addItemDecoration(decoration);

    }
}
