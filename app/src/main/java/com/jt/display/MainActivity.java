package com.jt.display;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jt.display.activitys.CarActivity;
import com.jt.display.activitys.CostActivity;
import com.jt.display.activitys.SalesActivity;
import com.jt.display.activitys.TransportActivity;
import com.jt.display.base.BaseDisplayActivity;
import com.orhanobut.logger.Logger;

public class MainActivity extends BaseDisplayActivity {


    private TextView mTvSales;
    private TextView mTvCar;
    private TextView mTvCost;
    private TextView mTvTransport;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mTvSales = findViewById(R.id.tv_sales);
        mTvCar = findViewById(R.id.tv_car);
        mTvCost = findViewById(R.id.tv_cost);
        mTvTransport = findViewById(R.id.tv_transport);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        mTvSales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              startActivity(new Intent(mContext, SalesActivity.class));
            }
        });
        mTvCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, CarActivity.class));
            }
        });
        mTvCost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, CostActivity.class));
            }
        });
        mTvTransport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, TransportActivity.class));
            }
        });

    }

    @Override
    protected void onPageSelected(int pager) {

    }

    @Override
    public void onSuccess(Object jsonResult, int type) {

    }

    @Override
    public void showLoading() {

    }

    @Override

    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {

    }

//
//    @Override
//    public boolean dispatchKeyEvent(KeyEvent event) {
//        int keyCode = event.getKeyCode();
//        int action = event.getAction();
//        return handleKeyEvent(action, keyCode) || super.dispatchKeyEvent(event);
//    }
//
//    private boolean handleKeyEvent(int action, int keyCode) {
//        if (action != KeyEvent.ACTION_DOWN)
//            return false;
//        switch (keyCode) {
//            case KeyEvent.KEYCODE_ENTER:
//            case KeyEvent.KEYCODE_DPAD_CENTER:
//
//                break;
//            default:
//                break;
//        }
//        return false;
//    }

}