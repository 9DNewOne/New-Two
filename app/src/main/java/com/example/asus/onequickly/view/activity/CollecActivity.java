package com.example.asus.onequickly.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.onequickly.R;

import butterknife.BindView;
import butterknife.ButterKnife;

//收藏activity
public class CollecActivity extends AppCompatActivity {

    @BindView(R.id.my_Collec_back)
    TextView myCollecBack;
    @BindView(R.id.my_Collec_hotdel)
    TextView myCollecHotdel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collec);
        ButterKnife.bind(this);
        //点击“返回”后
        myCollecBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        myCollecHotdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CollecActivity.this,"点击了删除",Toast.LENGTH_SHORT).show();
            }
        });





    }
}
