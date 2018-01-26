package com.example.asus.onequickly.view.activity;



import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.asus.onequickly.R;
import com.example.asus.onequickly.model.bean.LoginBean;
import com.example.asus.onequickly.model.bean.RegistBean;
import com.example.asus.onequickly.presenter.localpresenter.Mypresenter;
import com.example.asus.onequickly.view.viewcallback.IViewShoudata;


//BaseActivity<IViewShoudata,Mypresenter>
//注册的Activity
public class RegisterActivity extends Activity  implements IViewShoudata {

        Mypresenter mypresenter= new Mypresenter(this,this);

                 private EditText registusername_edit;
                 private EditText registpassword_edit;

  //https://www.zhaoapi.cn/quarter/register?source=android&mobile=17316250426&password=1234567

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        registusername_edit = findViewById(R.id.registusername_edit);
        registpassword_edit = findViewById(R.id.registpassword_edit);
        Button registbutton=findViewById(R.id.registbutton);

        registbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //   Toast.makeText(RegisterActivity.this,"点击事件"++,Toast.LENGTH_SHORT).show();

                //调 获取数据
                mypresenter.aishasha(registusername_edit.getText().toString(),registpassword_edit.getText().toString());

            }
        });

        ImageView registimageback=findViewById(R.id.registimageback);
        registimageback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void IviewShooudata(RegistBean registBean) {

        Log.i("=========",registBean.getMsg());


             //请求到的bean   //在这里做做个判断 如果存在 就是注册过 不存在就是注册成功
        String msg = registBean.getMsg();
     if (msg.equals("天呢！用户已注册")){
         Toast.makeText(RegisterActivity.this,"天呢！用户已注册",Toast.LENGTH_SHORT).show();

     }else{
         Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();

          if (msg.equals("注册成功")){
              RegisterActivity.this.finish();

          }

     }

    }

    @Override
    public void IvewShouLogindata(LoginBean loginBean) {

    }
}
