package com.example.asus.onequickly.view.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;


import android.content.DialogInterface;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.onequickly.R;
import com.example.asus.onequickly.model.bean.LoginBean;
import com.example.asus.onequickly.model.bean.RegistBean;
import com.example.asus.onequickly.presenter.httppresenter.MyLogPresenter;
import com.example.asus.onequickly.view.viewcallback.IlogView;


public class OtherloginActivity extends BaseActivity<IlogView,MyLogPresenter>implements IlogView {

//         Myloginpresenter myloginpresenter=new Myloginpresenter(this,this);
    public static boolean bIsGuestLogin = false;//是否游客登录，这个变量用于其他界面数据的处理
    private EditText mUserName = null;
    private EditText mPassword = null;
    private Button loginbutton;
    ProgressDialog m_Dialog;

    @Override
    public MyLogPresenter addpresenter() {
        return new MyLogPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otherlogin);
        mUserName= findViewById(R.id.username_edit);
        mPassword=findViewById(R.id.password_edit);
        loginbutton = findViewById(R.id.loginbutton);

        registButton(); //注册
        backfinish();//回退
        youkelogin(); //游客登录
        feikong();//输入框的非空判断


    }

    private void feikong() {




        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //记录游客登录
                bIsGuestLogin = false;

                 if (mUserName.getText().toString().isEmpty() || mPassword.getText().toString().isEmpty())//判断是否输入相关值
                {


                    AlertDialog dialog = new AlertDialog.Builder(OtherloginActivity.this)
                            .setTitle("登录")
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

                    presenter.login(mUserName.getText().toString(),mPassword.getText().toString(),"");

                }

            }
        });

    }


    private void youkelogin() {
       //游客登录
        TextView textView3=findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bIsGuestLogin = true;
                Intent intent = new Intent();
                intent.setClass(OtherloginActivity.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(OtherloginActivity.this, "您现在是以游客身份登录，登录成功", Toast.LENGTH_SHORT).show();
                OtherloginActivity.this.finish();

            }
        });

    }


    private void backfinish() {
         //回退
        ImageView otherimageback=findViewById(R.id.otherimageback);
        otherimageback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void registButton() {
         //去注册
        TextView zhucenumber=findViewById(R.id.zhucenumber);
        zhucenumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OtherloginActivity.this,RegisterActivity.class));

            }
        });

    }

    @Override
    public void Logindata(LoginBean loginBean) {
        String msg = loginBean.getMsg();

        if (msg.equals("登录成功"))
        {
            Toast.makeText(OtherloginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
        }else{

            Toast.makeText(OtherloginActivity.this,"登录失败",Toast.LENGTH_SHORT).show();

        }

    }
}
