package com.example.asus.onequickly.view.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.onequickly.R;

import com.example.asus.onequickly.model.bean.RegistBean;
import com.example.asus.onequickly.presenter.httppresenter.MyRegistPresenter;
import com.example.asus.onequickly.view.viewcallback.IregistView;


//BaseActivity<IViewShoudata,Mypresenter>
//注册的Activity
public class RegisterActivity extends BaseActivity<IregistView,MyRegistPresenter>implements IregistView {

//        Mypresenter mypresenter= new Mypresenter(this,this);

                 private EditText registusername_edit;
                 private EditText registpassword_edit;

  //https://www.zhaoapi.cn/quarter/register?source=android&mobile=17316250426&password=1234567

    @Override
    public MyRegistPresenter addpresenter() {
        return new MyRegistPresenter(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

          registMether(); //注册的方法
           pageUp();//上页


    }

       private void pageUp() {

         //已有账号  回退上一页
         TextView  registzhucenumber=findViewById(R.id.registzhucenumber);
         registzhucenumber.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 RegisterActivity.this.finish();
             }
         });

           //箭头返回上一页
          ImageView registimageback=findViewById(R.id.registimageback);
          registimageback.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 RegisterActivity.this.finish();
             }
         });

     }

    private void registMether() {

        registusername_edit = findViewById(R.id.registusername_edit);
        registpassword_edit = findViewById(R.id.registpassword_edit);
        Button registbutton=findViewById(R.id.registbutton);

        registbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   Toast.makeText(RegisterActivity.this,"点击事件"++,Toast.LENGTH_SHORT).show();

                //调 获取数据
                presenter.regisdata(registusername_edit.getText().toString(),registpassword_edit.getText().toString());
                if (registusername_edit.getText().toString().isEmpty() || registpassword_edit.getText().toString().isEmpty())//判断是否输入相关值
                {
                    AlertDialog dialog = new AlertDialog.Builder(RegisterActivity.this)
                            .setTitle("注册")
                            .setMessage("请输入相关值")
                            .setPositiveButton("确定",
                                    new DialogInterface.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which)
                                        {
                                            dialog.dismiss();
                                        }
                                    })
                            .create();
                    dialog.show();
                }
                else
                {
                    presenter.regisdata(registusername_edit.getText().toString(),registpassword_edit.getText().toString());
                }
            }

        });


    }

    @Override
    public void Registdata(RegistBean registBean) {
        Log.i("=========",registBean.getMsg());
        //请求到的bean   //在这里做做个判断 如果存在 就是注册过 不存在就是注册成功
        String msg = registBean.getMsg();
        if (msg.equals("天呢！用户已注册")){
            Toast.makeText(RegisterActivity.this,"天呢！用户已注册",Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
        }

        if (msg.equals("注册成功")){
            RegisterActivity.this.finish();

        }
    }
}
