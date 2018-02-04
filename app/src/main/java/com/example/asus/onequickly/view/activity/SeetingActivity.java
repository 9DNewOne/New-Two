package com.example.asus.onequickly.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.asus.onequickly.R;

public class SeetingActivity extends AppCompatActivity {

    private Button exitlong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeting);
        exitlong = findViewById(R.id.exitlong);
        ImageView imageView=findViewById(R.id.imageView);
          imageView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  finish();
              }
          });


        exitlong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences("login",MODE_PRIVATE);

                sp.edit().clear().commit();//清除数据必须要提交:提交以后，文件仍存在，只是文件中的数据被清除了
                Toast.makeText(SeetingActivity.this,"请重新登录",Toast.LENGTH_SHORT).show();




                //3、销毁所有的Activity
                //this.removeAll();
                //4、重新进入首页面
                goToActivity(OtherloginActivity.class,null);

            }
        });

    }

    //启动新的Activity
    public void goToActivity(Class Activity,Bundle bundle){
        Intent intent = new Intent(this,Activity);
        if (bundle!=null&&bundle.size()!=0){
            intent.putExtra("data",bundle);
        }

        startActivity(intent);
    }
}
