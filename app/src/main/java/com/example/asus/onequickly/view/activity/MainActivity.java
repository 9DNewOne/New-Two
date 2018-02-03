package com.example.asus.onequickly.view.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.asus.onequickly.R;
import com.example.asus.onequickly.model.bean.ThreeBean;
import com.example.asus.onequickly.view.customview.MyToolBar;
import com.example.asus.onequickly.view.fragment.InterestingNewsFragment;
import com.example.asus.onequickly.view.fragment.MoviesFragment;
import com.example.asus.onequickly.view.fragment.PhotosFragment;
import com.example.asus.onequickly.view.fragment.Recommendfragment;
import com.hjm.bottomtabbar.BottomTabBar;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayer;

public class MainActivity extends AppCompatActivity {
    private long lastTime;
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
    private ImageView imageViewBtn;
    private TextView id_username;
    private TextView id_link;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        EventBus.getDefault().register(this);

        mainToolBar.setTittle(getString(R.string.BottomRecommend));

        //点击头像选择登录//////跳转activity 选择登录方式
        View headerView = mViewNavigationView.getHeaderView(0);
        id_username = headerView.findViewById(R.id.id_username);
        id_link = headerView.findViewById(R.id.id_link);
        imageViewBtn = headerView.findViewById(R.id.TouXiang01);
        imageViewBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("CommitPrefEdits")
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });

        //////底部导航//////
        mBottomBar.init(getSupportFragmentManager())
                .setImgSize(40, 40)
                .setFontSize(10)
                .setTabPadding(6, 6, 10)
                .setChangeColor(Color.BLUE, Color.DKGRAY)
                .addTabItem(getString(R.string.BottomRecommend), R.mipmap.tuijian_select, Recommendfragment.class)
                .addTabItem(getString(R.string.crosstalk), R.mipmap.duanzi_default, InterestingNewsFragment.class)
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

        /////NavigationView导航菜单/////
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
                        startActivity(new Intent(MainActivity.this, SearchUserActivity.class));
                        break;
                    case R.id.action_inform:
                        Toast.makeText(MainActivity.this, "消息通知", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.ic_menu_night:
                        Toast.makeText(MainActivity.this, "夜间模式", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.ic_menu_my_works:
                        startActivity(new Intent(MainActivity.this, MyproductionActivity.class));
                        break;
                    case R.id.ic_menu_set:

                        startActivity(new Intent(MainActivity.this,SeetingActivity.class));


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

    @Subscribe
    public void three(ThreeBean b){
        Glide.with(this).load(b.getIconurl()).into(imageViewBtn);
        id_username.setText(b.getName());
        id_link.setText(b.getGrander());
        mainToolBar.setUser_icon(b.getIconurl());

    }

    @Override  //双击退出
    public void onBackPressed(){
        if (JZVideoPlayer.backPress()) {
            return;
        }
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastTime < 2 * 1000) {
            super.onBackPressed();
        } else {
            Toast.makeText(this, "请再按一次", Toast.LENGTH_SHORT).show();
            lastTime = currentTime;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
         EventBus.getDefault().unregister(this);
      }

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }

}
