package com.example.asus.onequickly.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.asus.onequickly.R;
import com.example.asus.onequickly.view.customview.MyToolBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        MyToolBar main_tool_bar=findViewById(R.id.main_tool_bar);
        //设置标题的方法
        main_tool_bar.settittle("推荐");

    }
}
