package com.example.asus.onequickly.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.asus.onequickly.R;
import com.example.asus.onequickly.view.adapter.MyHotFollowAdapter;
import com.example.asus.onequickly.view.fragment.HotFollowEncouragementFragment;
import com.example.asus.onequickly.view.fragment.HotFollowFineFoodFragment;
import com.example.asus.onequickly.view.fragment.HotFollowFunneyFragment;
import com.example.asus.onequickly.view.fragment.HotFollowGoodFaceFragment;
import com.example.asus.onequickly.view.fragment.HotFollowNetRedFragment;
import com.example.asus.onequickly.view.fragment.HotFollowNewsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

//热门关注
public class HotFollowActivity extends AppCompatActivity {

    @BindView(R.id.hot_follow_tab)
    TabLayout hotFollowTab;
    @BindView(R.id.hot_follow_vp)
    ViewPager hotFollowVp;
    //TabLayout标签
    private String[] titles=new String[]{"新闻","爆笑","励志","美食","网红","颜值"};
    private List<Fragment> fragments=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_follow);
        ButterKnife.bind(this);
        //设置充满
        hotFollowTab.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i <titles.length ; i++) {
            hotFollowTab.addTab(hotFollowTab.newTab().setText(titles[i]));
        }
        //六个fragment
        fragments.add(new HotFollowNewsFragment());
        fragments.add(new HotFollowFunneyFragment());
        fragments.add(new HotFollowEncouragementFragment());
        fragments.add(new HotFollowFineFoodFragment());
        fragments.add(new HotFollowNetRedFragment());
        fragments.add(new HotFollowGoodFaceFragment());

        MyHotFollowAdapter adapter=new MyHotFollowAdapter(getSupportFragmentManager(),titles,fragments);
        hotFollowVp.setAdapter(adapter);
        hotFollowTab.setupWithViewPager(hotFollowVp);

        //设置TabLayout点击事件
        hotFollowTab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                hotFollowVp.setCurrentItem(tab.getPosition());
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
