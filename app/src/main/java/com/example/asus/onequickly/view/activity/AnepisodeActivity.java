package com.example.asus.onequickly.view.activity;


import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.onequickly.R;
import com.example.asus.onequickly.model.bean.PublishBean;
import com.example.asus.onequickly.presenter.httppresenter.MyPublishpresenter;
import com.example.asus.onequickly.view.viewcallback.IPublishView;

//发表段子activity
public class AnepisodeActivity extends BaseActivity<IPublishView,MyPublishpresenter>  implements IPublishView{

    private Button publishbtn;
    private EditText duanzi;
    private TextView publishquxiao;
    @Override
    public MyPublishpresenter addpresenter() {
        return new MyPublishpresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anepisode);

        duanzi = findViewById(R.id.duanzi);
          publishbtn = findViewById(R.id.publishbtn);
        publishquxiao = findViewById(R.id.publishquxiao);

        publishquxiao.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                   finish();
              }
          });

          publishbtn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                  if (duanzi.getText().toString().equals(""))
                   {
                       Toast.makeText(AnepisodeActivity.this,"请输入要发表的内容",Toast.LENGTH_SHORT).show();

                   }else
                   {
                        SharedPreferences sp =getSharedPreferences("login",MODE_PRIVATE);
                        int uid = sp.getInt("uid", 11864);
                        String token = sp.getString("token", "FE04C41704BE82CECA90454EA16CFBF1");

                       //拼接口 需要是三个值
                     //4305&token=FE04C41704BE82CECA90454EA16CFBF1&content=的分v你发的
                     presenter.getpublishdata(uid+"",token,duanzi.getText().toString());

                    }


               }
           });


    }

    @Override
    public void publishdata(PublishBean publishBean) {

        String msg = publishBean.getMsg();
          if (msg.equals("发布成功"))
          {
              Toast.makeText(AnepisodeActivity.this,"发布成功",Toast.LENGTH_SHORT).show();
          }else
          {
              Toast.makeText(AnepisodeActivity.this,"重新发布",Toast.LENGTH_SHORT).show();
          }

    }
}
