package com.example.asus.onequickly.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.asus.onequickly.R;
import com.example.asus.onequickly.view.adapter.MyHotFollowAdapter;
import com.example.asus.onequickly.view.fragment.HotFollowEncouragementFragment;
import com.example.asus.onequickly.view.fragment.HotFollowFineFoodFragment;
import com.example.asus.onequickly.view.fragment.HotFollowFunneyFragment;
import com.example.asus.onequickly.view.fragment.HotFollowGoodFaceFragment;
import com.example.asus.onequickly.view.fragment.HotFollowNetRedFragment;
import com.example.asus.onequickly.view.fragment.HotFollowNewsFragment;
import com.example.asus.onequickly.view.fragment.MyLocalProductionFragment;
import com.example.asus.onequickly.view.fragment.MyUpedProductionFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyproductionActivity extends AppCompatActivity {

    @BindView(R.id.myproduction_back)
    TextView myproductionBack;
    @BindView(R.id.my_production_tab)
    TabLayout myProductionTab;
    @BindView(R.id.my_production_vp)
    ViewPager myProductionVp;

    private String[] titles = new String[]{"本地作品", "已上传"};
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myproduction);
        ButterKnife.bind(this);
        //返回按钮的点击事件
        myproductionBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //
        myProductionTab.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < titles.length; i++) {
            myProductionTab.addTab(myProductionTab.newTab().setText(titles[i]));
        }

        //两个fragment
        fragments.add(new MyLocalProductionFragment());
        fragments.add(new MyUpedProductionFragment());


        MyHotFollowAdapter adapter = new MyHotFollowAdapter(getSupportFragmentManager(), titles, fragments);
        myProductionVp.setAdapter(adapter);
        myProductionTab.setupWithViewPager(myProductionVp);

        //设置TabLayout点击事件
        myProductionTab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                myProductionVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
}
