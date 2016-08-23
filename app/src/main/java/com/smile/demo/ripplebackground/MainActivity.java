package com.smile.demo.ripplebackground;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.smile.ripplebackground.RippleBackground;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private Context context;

    @BindView(R.id.rb_background1)
    RippleBackground rbBackground1;
    @BindView(R.id.rb_background2)
    RippleBackground rbBackground2;
    @BindView(R.id.tv_single)
    TextView tvSingle;
    @BindView(R.id.tv_muti)
    TextView tvMuti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        context = getApplicationContext();
        rbBackground1.setVisibility(View.VISIBLE);
        rbBackground2.setVisibility(View.GONE);
        rbBackground1.startRippleAnimation();
        tvSingle.setTextColor(ContextCompat.getColor(context, R.color.colorPrimary));
        tvMuti.setTextColor(Color.WHITE);
    }

    @OnClick({R.id.iv_icon1, R.id.iv_icon2, R.id.tv_single, R.id.tv_muti})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_icon1:
                if (rbBackground1.isRippleAnimationRunning()) {
                    rbBackground1.stopRippleAnimation();
                    return;
                }
                rbBackground1.startRippleAnimation();
                break;
            case R.id.iv_icon2:
                if (rbBackground2.isRippleAnimationRunning()) {
                    rbBackground2.stopRippleAnimation();
                    return;
                }
                rbBackground2.startRippleAnimation();
                break;
            case R.id.tv_single:
                rbBackground1.setVisibility(View.VISIBLE);
                rbBackground2.setVisibility(View.GONE);
                rbBackground1.startRippleAnimation();
                tvSingle.setTextColor(ContextCompat.getColor(context, R.color.colorPrimary));
                tvMuti.setTextColor(Color.WHITE);
                break;
            case R.id.tv_muti:
                rbBackground1.setVisibility(View.GONE);
                rbBackground2.setVisibility(View.VISIBLE);
                rbBackground2.startRippleAnimation();
                tvMuti.setTextColor(ContextCompat.getColor(context, R.color.colorPrimary));
                tvSingle.setTextColor(Color.WHITE);
                break;
        }
    }
}
