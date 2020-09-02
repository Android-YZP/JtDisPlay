package com.jt.display.activitys;

import android.annotation.SuppressLint;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.jt.display.R;
import com.jt.display.adapters.CurrentDeliveryPlanAdapter;
import com.jt.display.adapters.CurrentReceivePlanAdapter;
import com.jt.display.adapters.DirectDeliveryAdapter;
import com.jt.display.base.BaseDisplayActivity;
import com.jt.display.base.Constants;
import com.jt.display.base.JsonResult;
import com.jt.display.bean.CurrentDeliveryPlanBean;
import com.jt.display.bean.CurrentReceivePlanBean;
import com.jt.display.bean.SalesCurrentAndLastMonthBean;
import com.jt.display.bean.TopAndDownCustomerBean;
import com.jt.display.presenter.ComPresenter;
import com.jt.display.utils.GsonUtil;
import com.orhanobut.logger.Logger;

import java.util.List;

public class TransportActivity extends BaseDisplayActivity {

    private ComPresenter mPresenter;
    private LRecyclerView mLrvCurrentReceivePlan;
    private LRecyclerView mLrvCurrentDeliveryPlan;
    private CurrentDeliveryPlanAdapter mCurrentDeliveryPlanAdapter;
    private TextView mTvHasStoredVolume;
    private TextView mTvSumVolume;
    private TextView mTvDeliveryHasStoredVolume;
    private TextView mTvDeliverySumVolume;
    private TextView mTvWarehouseNum;
    private CurrentReceivePlanAdapter mCurrentReceivePlanAdapter;

    private int mReceivePlanPage = 1;
    private int mDeliveryPlanPage = 1;

    @Override
    public int getLayoutId() {
        return R.layout.activity_transport;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    @Override
    public void initView() {
        mPresenter = new ComPresenter();
        mPresenter.attachView(this);

        mLrvCurrentReceivePlan = findViewById(R.id.lrv_CurrentReceivePlan);
        mLrvCurrentDeliveryPlan = findViewById(R.id.lrv_CurrentDeliveryPlan);

        mTvWarehouseNum = findViewById(R.id.tv_warehouse_num);

        mTvSumVolume = findViewById(R.id.tv_sumVolume);
        mTvHasStoredVolume = findViewById(R.id.tv_hasStoredVolume);

        mTvDeliverySumVolume = findViewById(R.id.tv_DeliverySumVolume);
        mTvDeliveryHasStoredVolume = findViewById(R.id.tv_DeliveryHasStoredVolume);
    }

    @Override
    public void initData() {
        mPresenter.getCurrentReceivePlan(mReceivePlanPage);
        mPresenter.getCurrentDeliveryPlan(mDeliveryPlanPage);
//        mPresenter.getChannelCityOrderCostReportForm();
//        mPresenter.getCustomerChannelCityOrderCostReportForm();

        LinearLayoutManager directDeliveryManager = new LinearLayoutManager(mContext);
        mLrvCurrentDeliveryPlan.setLayoutManager(directDeliveryManager);
        mCurrentDeliveryPlanAdapter = new CurrentDeliveryPlanAdapter(mContext);
        LRecyclerViewAdapter mLuDirectDeliveryAdapter = new LRecyclerViewAdapter(mCurrentDeliveryPlanAdapter);
        mLrvCurrentDeliveryPlan.setAdapter(mLuDirectDeliveryAdapter);
        mLrvCurrentDeliveryPlan.setLoadMoreEnabled(false);
        mLrvCurrentDeliveryPlan.setPullRefreshEnabled(false);

        LinearLayoutManager directReceiveManager = new LinearLayoutManager(mContext);
        mLrvCurrentReceivePlan.setLayoutManager(directReceiveManager);
        mCurrentReceivePlanAdapter = new CurrentReceivePlanAdapter(mContext);
        LRecyclerViewAdapter mLuDirectReceiveAdapter = new LRecyclerViewAdapter(mCurrentReceivePlanAdapter);
        mLrvCurrentReceivePlan.setAdapter(mLuDirectReceiveAdapter);
        mLrvCurrentReceivePlan.setLoadMoreEnabled(false);
        mLrvCurrentReceivePlan.setPullRefreshEnabled(false);
    }

    @Override
    public void initListener() {

    }

    @Override
    protected void onPageSelected(int pager) {

    }

    @Override
    public void onSuccess(Object jsonResult, int type) {
        if (type == Constants.METHOD_ONE) {//当月每日销售额
            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                CurrentReceivePlanBean currentReceivePlanBean = GsonUtil.GsonToBean(GsonUtil.GsonString(jsonResult), CurrentReceivePlanBean.class);
                initCurrentReceivePlan(currentReceivePlanBean);
            }

        } else if (type == Constants.METHOD_TWO) {//前十和后十客户
            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                CurrentDeliveryPlanBean currentDeliveryPlanBean = GsonUtil.GsonToBean(GsonUtil.GsonString(jsonResult), CurrentDeliveryPlanBean.class);
                initCurrentDeliveryPlan(currentDeliveryPlanBean);

            }
        }
    }

    @SuppressLint("SetTextI18n")
    private void initCurrentDeliveryPlan(CurrentDeliveryPlanBean currentDeliveryPlanBean) {
        mCurrentDeliveryPlanAdapter.setDataList(currentDeliveryPlanBean.getData().getDeliveryPlanList());
        mTvDeliverySumVolume.setText("计划出货体积\n" + currentDeliveryPlanBean.getData().getDeliveryOrderVolume() + " m³");
        mTvDeliveryHasStoredVolume.setText("已出货体积\n" + currentDeliveryPlanBean.getData().getDeliveryVolume() + " m³");
        mTvWarehouseNum.setText("实时库容\n" + currentDeliveryPlanBean.getData().getCurrentVolumeAndWeightStorageCapacity().
                getCurrentVolumeStorageCapacity() + " m³ \n" + currentDeliveryPlanBean.getData().getCurrentVolumeAndWeightStorageCapacity().
                getCurrentWeightStorageCapacity() + " Kg");
    }

    @SuppressLint("SetTextI18n")
    private void initCurrentReceivePlan(CurrentReceivePlanBean currentReceivePlanBean) {
        mCurrentReceivePlanAdapter.setDataList(currentReceivePlanBean.getData().getReceiveWarePlanList());
        mTvSumVolume.setText("计划出货体积\n" + currentReceivePlanBean.getData().getSumVolume() + " m³");
        mTvHasStoredVolume.setText("已出货体积\n" + currentReceivePlanBean.getData().getHasStoredVolume() + " m³");
        mTvWarehouseNum.setText("实时库容\n" + currentReceivePlanBean.getData().getCurrentVolumeAndWeightStorageCapacity().
                getCurrentVolumeStorageCapacity() + " m³ \n" + currentReceivePlanBean.getData().getCurrentVolumeAndWeightStorageCapacity().
                getCurrentWeightStorageCapacity() + " Kg");
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
        Logger.e(throwable.getMessage() + "");
    }
}