package com.jt.display;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.jt.display.activitys.CarActivity;
import com.jt.display.activitys.CostActivity;
import com.jt.display.activitys.SalesActivity;
import com.jt.display.activitys.TransportActivity;
import com.jt.display.base.BaseDisplayActivity;
import com.jt.display.base.Constants;
import com.jt.display.base.JsonResult;
import com.jt.display.bean.LoginData;
import com.jt.display.presenter.ComPresenter;
import com.jt.display.utils.GsonUtil;
import com.jt.display.utils.SharePreferenceUtils;

public class MainActivity extends BaseDisplayActivity implements View.OnFocusChangeListener {

    private TextView mTvSales;
    private TextView mTvCar;
    private TextView mTvCost;
    private TextView mTvTransport;
    private ComPresenter mPresenter;

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
        mPresenter = new ComPresenter();
        mPresenter.attachView(this);
        mPresenter.login();
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

        mTvTransport.setOnFocusChangeListener(this);
        mTvSales.setOnFocusChangeListener(this);
        mTvCar.setOnFocusChangeListener(this);
        mTvCost.setOnFocusChangeListener(this);
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if (b) {
            zoomAnim(view);
        } else {
            unZoomAnim(view);
        }
    }


    @Override
    protected void onPageSelected(int pager) {

    }

    @Override
    public void onSuccess(Object jsonResult, int type) {
        if (type == Constants.METHOD_ONE) {
            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                SharePreferenceUtils.putLoginData(MainActivity.this, GsonUtil.GsonString(jsonResult));
                mPresenter.lastSevenDaysSales();
            } else {
                show(((JsonResult) jsonResult).getMsg());
            }
        }
    }

    @Override
    public void showLoading() {

    }

    @Override

    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {
        show(throwable.getMessage());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.detachView();
    }
}