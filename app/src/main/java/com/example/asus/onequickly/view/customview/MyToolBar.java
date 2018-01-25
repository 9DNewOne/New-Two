package com.example.asus.onequickly.view.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.onequickly.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by asus on 2018/1/25.
 */

public class MyToolBar extends RelativeLayout {
    SimpleDraweeView user_icon;
    TextView tool_tittle;
    ImageView user_creat;
    public MyToolBar(Context context) {
        this(context,null);
    }

    public MyToolBar(final Context context, AttributeSet attrs) {
        super(context, attrs);
        View view=View.inflate(context, R.layout.mytoolbar_layout,null);

        user_icon = view.findViewById(R.id.user_icon);

        tool_tittle = view.findViewById(R.id.tool_tittle);

        user_creat = view.findViewById(R.id.user_creat);

        //头像点击事件
        user_icon.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"想写点击事件，来cutomview包下的mytoolbar修改",Toast.LENGTH_SHORT).show();
            }
        });

        //用户创建时的点击事件
        user_creat.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"想写点击事件，来cutomview包下的mytoolbar修改",Toast.LENGTH_SHORT).show();
            }
        });


        addView(view);

    }
    //修改中间文字的方法
    public void settittle(String string){
        if(tool_tittle!=null){
        tool_tittle.setText(string);
        }
    }



    public MyToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



}
