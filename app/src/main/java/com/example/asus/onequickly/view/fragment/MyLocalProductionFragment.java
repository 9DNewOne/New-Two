package com.example.asus.onequickly.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.onequickly.R;
import com.example.asus.onequickly.view.adapter.MyProductionAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * 本地作品
 */
public class MyLocalProductionFragment extends Fragment {


    Unbinder unbinder;
    @BindView(R.id.my_local_production_rv)
    RecyclerView myLocalProductionRv;

    public MyLocalProductionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.my_localproduction_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 3);
        myLocalProductionRv.setLayoutManager(manager);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //myLocalProductionRv
        List<String> list=new ArrayList<>();
        list.add("https://www.zhaoapi.cn//images//15160825477571516082546650.png");
        list.add("https://www.zhaoapi.cn//images//15169660139571516966011147.png");
        list.add("http://imgsrc.baidu.com/forum/pic/item/267f9e2f070828383e511184b899a9014d08f1c6.jpg");
        list.add("http://img1.touxiang.cn/uploads/20130427/27-065400_562.jpg");
        list.add("http://img1.imgtn.bdimg.com/it/u=1871941004,4015046403&fm=27&gp=0.jpg");
        list.add("http://m.3fantizi.com/Article/pic/201414121159431.jpg");


        MyProductionAdapter adapter=new MyProductionAdapter(getActivity(),list);
        myLocalProductionRv.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
