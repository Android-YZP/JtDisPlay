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
import com.jt.display.bean.CurrentDateLoadAndUnloadVolumeBean;
import com.jt.display.bean.CurrentReceiveDeliveryBean;
import com.jt.display.bean.CustomerSalesSortBean;
import com.jt.display.bean.LastSevenCarCostBean;
import com.jt.display.bean.LastSevenDaysSalesBean;
import com.jt.display.bean.LastSixMonthSalesBean;
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
        if (type == Constants.METHOD_ONE) {//登录
            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                SharePreferenceUtils.putLoginData(MainActivity.this, GsonUtil.GsonString(jsonResult));
//                mPresenter.lastSevenDaysSales();
//                mPresenter.lastSixMonthSales();
//                mPresenter.customerSalesSort("1");
//                mPresenter.lastSevenCarCost();
                mPresenter.currentReceiveDelivery();
//                mPresenter.currentDateLoadAndUnloadVolume();


            } else {
                show(((JsonResult) jsonResult).getMsg());
            }
        } else if (type == Constants.METHOD_TWO) {//近七日销量
            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                LastSevenDaysSalesBean lastSevenDaysSalesBean = GsonUtil.GsonToBean(GsonUtil.GsonString(jsonResult), LastSevenDaysSalesBean.class);

            } else {
                show(((JsonResult) jsonResult).getMsg());
            }
        } else if (type == Constants.METHOD_THREE) {//近六个月销量
            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                LastSixMonthSalesBean lastSixMonthSalesBean = GsonUtil.GsonToBean(GsonUtil.GsonString(jsonResult), LastSixMonthSalesBean.class);

            } else {
                show(((JsonResult) jsonResult).getMsg());
            }
        } else if (type == Constants.METHOD_FOUR) {//客户销量排名
            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                CustomerSalesSortBean customerSalesSortBean = GsonUtil.GsonToBean(GsonUtil.GsonString(jsonResult), CustomerSalesSortBean.class);

            } else {
                show(((JsonResult) jsonResult).getMsg());
            }
        } else if (type == Constants.METHOD_FIVE) {//近七日车辆成本
            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                LastSevenCarCostBean lastSevenCarCostBean = GsonUtil.GsonToBean(GsonUtil.GsonString(jsonResult), LastSevenCarCostBean.class);


            } else {
                show(((JsonResult) jsonResult).getMsg());
            }
        } else if (type == Constants.METHOD_SIX) {//当日收发货
            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                CurrentReceiveDeliveryBean currentReceiveDeliveryBean = GsonUtil.GsonToBean(GsonUtil.GsonString(jsonResult), CurrentReceiveDeliveryBean.class);


            } else {
                show(((JsonResult) jsonResult).getMsg());
            }
        } else if (type == Constants.METHOD_SEVEN) {//当日装卸方数
            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                CurrentDateLoadAndUnloadVolumeBean currentDateLoadAndUnloadVolumeBean =
                        GsonUtil.GsonToBean(GsonUtil.GsonString(jsonResult), CurrentDateLoadAndUnloadVolumeBean.class);

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