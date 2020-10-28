package com.jt.display.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.jt.display.MainActivity;
import com.jt.display.R;
import com.jt.display.adapters.CurrentDeliveryPlanAdapter;
import com.jt.display.adapters.WaybillCityAdapter;
import com.jt.display.adapters.WaybillCusAdapter;
import com.jt.display.base.BaseDisplayActivity;
import com.jt.display.base.Constants;
import com.jt.display.base.JsonResult;
import com.jt.display.bean.DeliveryBean;
import com.jt.display.bean.ShipmentBean;
import com.jt.display.bean.WaybillAgingCityBean;
import com.jt.display.bean.WaybillAgingCusBean;
import com.jt.display.presenter.ComPresenter;
import com.jt.display.utils.GsonUtil;
import com.jt.display.utils.SharePreferenceUtils;
import com.orhanobut.logger.Logger;

import java.util.List;

public class WaybilActivity extends BaseDisplayActivity {
    private ComPresenter mPresenter;

    private int mCusPage = 1;
    private int mCityPage = 1;
    private LRecyclerView mLrvWaybillCus;
    private LRecyclerView mLrvWaybillCity;
    private WaybillCusAdapter mWaybillCusAdapter;
    private WaybillCityAdapter mWaybillCityAdapter;

    @Override
    public void onBackPressed() {
        startActivity(new Intent(mContext, MainActivity.class));
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 500);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_waybil;
    }

    @Override
    public void initView() {
        mPresenter = new ComPresenter();
        mPresenter.attachView(this);
        mPresenter.waybillAgingCus(mCusPage);
        mPresenter.waybillAgingCity(mCityPage);

        mLrvWaybillCus = findViewById(R.id.lrv_Waybill_cus);
        mLrvWaybillCity = findViewById(R.id.lrv_Waybill_city);
    }

    @Override
    public void initData() {
        LinearLayoutManager directDeliveryManager = new LinearLayoutManager(mContext);
        mLrvWaybillCus.setLayoutManager(directDeliveryManager);
        mWaybillCusAdapter = new WaybillCusAdapter(mContext);
        LRecyclerViewAdapter mLuDirectDeliveryAdapter = new LRecyclerViewAdapter(mWaybillCusAdapter);
        mLrvWaybillCus.setAdapter(mLuDirectDeliveryAdapter);
        mLrvWaybillCus.setLoadMoreEnabled(false);
        mLrvWaybillCus.setPullRefreshEnabled(false);

        LinearLayoutManager directDeliveryManager1 = new LinearLayoutManager(mContext);
        mLrvWaybillCity.setLayoutManager(directDeliveryManager1);
        mWaybillCityAdapter = new WaybillCityAdapter(mContext);
        LRecyclerViewAdapter mLuDirectDeliveryAdapter1 = new LRecyclerViewAdapter(mWaybillCityAdapter);
        mLrvWaybillCity.setAdapter(mLuDirectDeliveryAdapter1);
        mLrvWaybillCity.setLoadMoreEnabled(false);
        mLrvWaybillCity.setPullRefreshEnabled(false);
    }

    @Override
    protected void onPageSelected(int pager) {

    }

    @Override
    protected void loopTimesListener(long loopTimes) {

    }

    @Override
    protected void animStart(int mAnimPager) {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void onSuccess(Object jsonResult, int type) {

        if (type == Constants.METHOD_ONE) {//waybillAgingCus
            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                WaybillAgingCusBean waybillAgingCusBean = GsonUtil.GsonToBean(GsonUtil.GsonString(jsonResult), WaybillAgingCusBean.class);
                List<WaybillAgingCusBean.DataBean.RecordsBean> records = waybillAgingCusBean.getData().getRecords();
                mWaybillCusAdapter.getDataList().addAll(records);
                mWaybillCusAdapter.notifyDataSetChanged();
            }
        } else if (type == Constants.METHOD_TWO) {//
            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                WaybillAgingCityBean waybillAgingCityBean = GsonUtil.GsonToBean(GsonUtil.GsonString(jsonResult), WaybillAgingCityBean.class);
                List<WaybillAgingCityBean.DataBean.RecordsBean> recordsBeans = waybillAgingCityBean.getData().getRecords();
                mWaybillCityAdapter.getDataList().addAll(recordsBeans);
                mWaybillCityAdapter.notifyDataSetChanged();
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

    }
}