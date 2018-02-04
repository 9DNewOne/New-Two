package com.example.asus.onequickly.view.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.asus.onequickly.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreamaActivity extends AppCompatActivity {

    @BindView(R.id.btn_cancel)
    Button btnCancel;
    @BindView(R.id.btn_video)
    Button btnVideo;
    @BindView(R.id.btn_anepisode)
    Button btnAnepisode;


    final static int CAMERA_RESULT = 0;//声明一个常量，代表结果码
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creama);
        ButterKnife.bind(this);

        initClick();
    }

    private void initClick() {
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//实例化Intent对象,使用MediaStore的ACTION_IMAGE_CAPTURE常量调用系统相机
                startActivityForResult(intent, CAMERA_RESULT);//开启相机，传入上面的Intent对象
            }
        });

        btnAnepisode.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreamaActivity.this,AnepisodeActivity.class));
            }
        });

    }

    /**
     * 用onActivityResult()接收传回的图像，当用户拍完照片，或者取消后，系统都会调用这个函数
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, intent);
        if(resultCode==RESULT_OK){
            Bundle extras=intent.getExtras();//从Intent中获取附加值
            Bitmap bitmap=(Bitmap) extras.get("data");//从附加值中获取返回的图像
           // imageView.setImageBitmap(bitmap);//显示图像
        }
    }
}
