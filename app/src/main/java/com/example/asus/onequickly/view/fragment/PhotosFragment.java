package com.example.asus.onequickly.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.onequickly.R;
import com.example.asus.onequickly.utils.otherutils.SpacesItemDecoration;
import com.example.asus.onequickly.view.adapter.MyPhotosAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhotosFragment extends Fragment {

    private RecyclerView photosRecycleview;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photos, container, false);

        photosRecycleview = view.findViewById(R.id.photosRecycleview);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        List<Integer> list=new ArrayList<>();

      list.add(R.mipmap.aaa);
      list.add(R.mipmap.bbb);
      list.add(R.mipmap.ccc);
      list.add(R.mipmap.ddd);
      list.add(R.mipmap.eee);
      list.add(R.mipmap.fff);
      list.add(R.mipmap.hhh);
      list.add(R.mipmap.iii);
      list.add(R.mipmap.jjj);
      list.add(R.mipmap.hhh);
      list.add(R.mipmap.gg);


        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        photosRecycleview.setLayoutManager(gridLayoutManager);

               MyPhotosAdapter photosAdapter = new MyPhotosAdapter(getActivity(),list);
               photosRecycleview.setAdapter(photosAdapter);

        //设置item之间的间隔
          SpacesItemDecoration decoration=new SpacesItemDecoration(16);
           photosRecycleview.addItemDecoration(decoration);



    }
}
