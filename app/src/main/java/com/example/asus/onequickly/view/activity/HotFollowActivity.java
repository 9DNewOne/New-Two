package com.example.asus.onequickly.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    @BindView(R.id.my_hotfollow_back)
    TextView myHotfollowBack;
    @BindView(R.id.myfollow_hotet)
    EditText myfollowHotet;
    @BindView(R.id.my_follow_hot_Search)
    ImageView myFollowHotSearch;
    //TabLayout标签
    private String[] titles = new String[]{"新闻", "爆笑", "励志", "美食", "网红", "颜值"};
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_follow);
        ButterKnife.bind(this);
        //设置充满
        hotFollowTab.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < titles.length; i++) {
            hotFollowTab.addTab(hotFollowTab.newTab().setText(titles[i]));
        }
        //点击返回键 返回上一层
        myHotfollowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //搜索
        myFollowHotSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HotFollowActivity.this,"正在查找...",Toast.LENGTH_SHORT).show();
            }
        });
        //忽略edittext回车键
        myfollowHotet.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /**
             * @param v
             * @param actionId 针对软键盘,若是实体键盘actionId=0
             * @param event 针对实体键盘,若是软键盘event=null
             * @return 返回true表示自己处理Enter事件,当imeOptions="actionSearch"时返回false此方法会被调用两次
             */
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH|| event.getKeyCode() == KeyEvent.ACTION_DOWN) {
                    Toast.makeText(HotFollowActivity.this,"正在查找...",Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });

        //


        //六个fragment
        fragments.add(new HotFollowNewsFragment());
        fragments.add(new HotFollowFunneyFragment());
        fragments.add(new HotFollowEncouragementFragment());
        fragments.add(new HotFollowFineFoodFragment());
        fragments.add(new HotFollowNetRedFragment());
        fragments.add(new HotFollowGoodFaceFragment());

        MyHotFollowAdapter adapter = new MyHotFollowAdapter(getSupportFragmentManager(), titles, fragments);
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
