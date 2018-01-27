package com.example.asus.onequickly.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.asus.onequickly.R;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

  /*
  *  做登录操作的activity
  * */

//  /*
//   第三方需要5个jar包 在libs 里面 还需要Application里初始化
//
// */
public class SecondActivity extends AppCompatActivity {
          //API集成
    private UMAuthListener authListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

           //微信第三方登录
           Button weixinbutton=findViewById(R.id.weixinbutton);
            weixinbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  //集成推送
                    Toast.makeText(SecondActivity.this,"sdfgbsdf",Toast.LENGTH_SHORT).show();
                }

            });

          //QQ第三方登录
          Button qqlonginbtn=findViewById(R.id.qqlonginbtn);
          qqlonginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             UMShareAPI.get(SecondActivity.this).getPlatformInfo(SecondActivity.this, SHARE_MEDIA.QQ, authListener );


            }
        });

           //其他方式登录
       TextView  textviewqita=findViewById(R.id.textviewqita);
        textviewqita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(SecondActivity.this,OtherloginActivity.class));
            }
        });

          authListener = new UMAuthListener() {
                /**
                 * @desc 授权开始的回调
                 * @param platform 平台名称
                 */
                //@Override
               public void onStart(SHARE_MEDIA platform) {

               }


                /**
                 * @desc 授权成功的回调
                 * @param platform 平台名称
                 * @param action 行为序号，开发者用不上
                 * @param data 用户资料返回
                 */

                    @Override
                public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
/*
                    Toast.makeText(SecondActivity.this, "成功了", Toast.LENGTH_LONG).show();
                        Log.i("-------",data.toString());*/

                }
                /**
                 * @desc 授权失败的回调
                 * @param platform 平台名称
                 * @param action 行为序号，开发者用不上
                 * @param t 错误原因
                 */
                @Override
                public void onError(SHARE_MEDIA platform, int action, Throwable t) {
                   // Toast.makeText(SecondActivity.this, "失败：" + t.getMessage(),                                  Toast.LENGTH_LONG).show();


                }

                /**
                 * @desc 授权取消的回调
                 * @param platform 平台名称
                 * @param action 行为序号，开发者用不上
                 */
                @Override
                public void onCancel(SHARE_MEDIA platform, int action) {
                    Toast.makeText(SecondActivity.this, "取消了", Toast.LENGTH_LONG).show();
                }
            };

          //箭头图片返回上一页
        ImageView imaeviewback=findViewById(R.id.imageback);
           imaeviewback.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                    finish();
               }
           });
    }


   @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

}
