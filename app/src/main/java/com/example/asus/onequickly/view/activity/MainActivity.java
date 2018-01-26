package com.example.asus.onequickly.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.asus.onequickly.R;
import com.example.asus.onequickly.view.customview.MyToolBar;
import com.example.asus.onequickly.view.fragment.MoviesFragment;
import com.example.asus.onequickly.view.fragment.PhotosFragment;
import com.example.asus.onequickly.view.fragment.Recommendfragment;
import com.example.asus.onequickly.view.fragment.SatinFragment;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_tool_bar)
    MyToolBar mainToolBar;
    @BindView(R.id.view_navigation)
    NavigationView mViewNavigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        MyToolBar main_tool_bar=findViewById(R.id.main_tool_bar);
        //设置标题的方法
        main_tool_bar.setTittle("推荐");

             BottomTabBar bottomTabBar=findViewById(R.id.mbottombar);

             bottomTabBar.init(getSupportFragmentManager())
                     .setImgSize(40, 40)
                     .setFontSize(10)
                     .setTabPadding(6, 6, 10)
                     .setChangeColor(Color.RED, Color.DKGRAY)

                     .addTabItem("推荐", R.mipmap.tuijian_select,Recommendfragment.class)
                     .addTabItem("段子", R.mipmap.duanzi_default,SatinFragment.class)
                     .addTabItem("视频", R.mipmap.video_defaults,MoviesFragment.class)
                     .addTabItem("趣图", R.mipmap.qutuu,PhotosFragment.class)
                     .isShowDivider(false)
                     .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener(){
                         @Override
                         public void onTabChange(int position, String name) {
                         }
                     });



        //////////////////////////////////////NavigationView导航菜单////////////////////////////////////////////////
        mViewNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                item.setChecked(false);

                switch (item.getItemId()) {
                    case R.id.action_concern:
                        Toast.makeText(MainActivity.this, "我的关心", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_collect:
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
        mainToolBar.setOnLeftButtonClickListener(new MyToolBar.OnLeftButtonClickListener() {
            @Override
            public void onClick() {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });

    }
}
