package com.example.asus.onequickly.view.fragment;


import android.content.SharedPreferences;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.asus.onequickly.R;
import com.example.asus.onequickly.model.bean.MoviesBean;
import com.example.asus.onequickly.model.bean.MoviesNearbyBean;

import com.example.asus.onequickly.presenter.httppresenter.MyMoviesNearbyPresenter;
import com.example.asus.onequickly.utils.otherutils.SpacesItemDecoration;

import com.example.asus.onequickly.view.adapter.MyMoviesNearbyAdapter;

import com.example.asus.onequickly.view.viewcallback.IMoviesNearbyView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */

public class MoviesNearbyFragment extends BaseFragment<IMoviesNearbyView,MyMoviesNearbyPresenter> implements IMoviesNearbyView  {

    private XRecyclerView moviesNearbyXrecycleview01;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private String token1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies_nearby, container, false);


        moviesNearbyXrecycleview01 = view.findViewById(R.id.moviesNearbyXrecycleview01);

        return  view;
    }
    @Override
    public MyMoviesNearbyPresenter initpresenter() {
        return new MyMoviesNearbyPresenter(getActivity());
    }
   @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
          //获取数据
        //获取网络数据然后列表展示到热门 瀑布流
        //瀑布流管理器
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        moviesNearbyXrecycleview01.setLayoutManager(staggeredGridLayoutManager);



        SharedPreferences sp = getActivity().getSharedPreferences("login", MODE_PRIVATE);


       token1 = sp.getString("token", "FE04C41704BE82CECA90454EA16CFBF1");
                                                      //FE04C41704BE82CECA90454EA16CFBF1

               presenter.moviesnearby("10", token1);

    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.moviesnearby("10",token1);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.dettach();
    }

    @Override
    public void MoviesNearbydata(MoviesNearbyBean moviesNearbyBean) {
          //得到数据


     //   Toast.makeText(getActivity(),"附近的视屏"+moviesNearbyBean,Toast.LENGTH_SHORT).show();



        if (moviesNearbyBean!=null)
        {
            MyMoviesNearbyAdapter moviesNearbyAdapter = new MyMoviesNearbyAdapter(getActivity(), moviesNearbyBean);
            moviesNearbyXrecycleview01.setAdapter(moviesNearbyAdapter);



             //设置item之间的间隔
            SpacesItemDecoration decoration=new SpacesItemDecoration(16);
            moviesNearbyXrecycleview01.addItemDecoration(decoration);


        }



    }
}
