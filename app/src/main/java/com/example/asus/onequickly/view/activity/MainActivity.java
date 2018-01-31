package com.example.asus.onequickly.view.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.asus.onequickly.R;
import com.example.asus.onequickly.model.bean.UserInfoBean;
import com.example.asus.onequickly.view.customview.MyToolBar;
import com.example.asus.onequickly.view.fragment.MoviesFragment;
import com.example.asus.onequickly.view.fragment.PhotosFragment;
import com.example.asus.onequickly.view.fragment.Recommendfragment;
import com.example.asus.onequickly.view.fragment.SatinFragment;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.view_navigation)
    NavigationView mViewNavigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    //提供全局的intent
    Intent it;
    @BindView(R.id.main_tool_bar)
    MyToolBar mainToolBar;
    @BindView(R.id.mbottombar)
    BottomTabBar mBottomBar;


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainToolBar.setTittle(getString(R.string.BottomRecommend));
        //点击头像选择登录     跳转activity 选择登录方式
        View headerView = mViewNavigationView.getHeaderView(0);
        ImageView imageViewBtn = headerView.findViewById(R.id.TouXiang01);
        imageViewBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("CommitPrefEdits")
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));

//                //判断是否登录
//                if (sp.getBoolean("Islogin", false)) {
//
//                    sp.edit().putBoolean("Islogin",true);
//                } else {
//                    Log.e("Login", "onNavigationItemSelected: " + token + "////" + uid);
//                    presenter.getNetUserInfo(token, uid + "");
//                }
            }
        });
        ////////////////////////////////////////底部导航//////////////////////////////
        mBottomBar.init(getSupportFragmentManager())
                .setImgSize(40, 40)
                .setFontSize(10)
                .setTabPadding(6, 6, 10)
                .setChangeColor(Color.BLUE, Color.DKGRAY)
                .addTabItem(getString(R.string.BottomRecommend), R.mipmap.tuijian_select, Recommendfragment.class)
                .addTabItem(getString(R.string.crosstalk), R.mipmap.duanzi_default, SatinFragment.class)
                .addTabItem(getString(R.string.video), R.mipmap.video_defaults, MoviesFragment.class)
                .addTabItem(getString(R.string.funny_pictures), R.mipmap.qutuu, PhotosFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {
                        switch (position) {
                            //设置标题的方法
                            case 0:
                                mainToolBar.setTittle(getString(R.string.BottomRecommend));
                                break;
                            case 1:
                                mainToolBar.setTittle(getString(R.string.crosstalk));
                                break;
                            case 2:
                                mainToolBar.setTittle(getString(R.string.video));
                                break;
                            case 3:
                                mainToolBar.setTittle(getString(R.string.funny_pictures));
                                break;
                        }
                    }
                });

        //////////////////////////////////////NavigationView导航菜单////////////////////////////////////////////////
        mViewNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                item.setChecked(false);

                switch (item.getItemId()) {
                    case R.id.action_concern:
                        startActivity(new Intent(MainActivity.this, MyFollowActivity.class));
                        break;
                    case R.id.action_collect://我的收藏
                        Toast.makeText(MainActivity.this, "我的收藏", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_Search:
                        Toast.makeText(MainActivity.this, "搜索好友", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_inform:
                        Toast.makeText(MainActivity.this, "消息通知", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.ic_menu_night:
                        Toast.makeText(MainActivity.this, "夜间模式", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.ic_menu_my_works:
                        Toast.makeText(MainActivity.this, "我的作品", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.ic_menu_set:
                        Toast.makeText(MainActivity.this, "设置", Toast.LENGTH_SHORT).show();
                        break;

                }

                //关闭侧拉
                mDrawerLayout.closeDrawers();
                return false;
            }
        });

        /////////////////////////////////打开DrawerLayout//////////////////////////////////////////////////
        mainToolBar.setOnLeftButtonClickListener(new MyToolBar.OnLeftButtonClickListener() {
            @Override
            public void onClick() {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });

    }

}
