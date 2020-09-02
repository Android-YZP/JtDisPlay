package com.jt.display.activitys;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.GridLayoutManager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.jt.display.R;
import com.jt.display.adapters.LanTongCostAdapter;
import com.jt.display.adapters.OtherCostAdapter;
import com.jt.display.adapters.TopCostAdapter;
import com.jt.display.base.BaseDisplayActivity;
import com.jt.display.base.Constants;
import com.jt.display.base.JsonResult;
import com.jt.display.bean.ChannelCityOrderCostReportBean;
import com.jt.display.bean.CurrentDeliveryPlanBean;
import com.jt.display.bean.CurrentReceivePlanBean;
import com.jt.display.bean.CustomerChannelCityOrderCostReportBean;
import com.jt.display.presenter.ComPresenter;
import com.jt.display.utils.GsonUtil;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

public class CostActivity extends BaseDisplayActivity {
    private LRecyclerViewAdapter mLuRecyclerViewAdapter;
    private LRecyclerView mLrvLanTong;
    private LRecyclerView mLrvOther;
    private LRecyclerView mLrvTop;
    List<String> mData = new ArrayList<>();
    private ComPresenter mPresenter;
    private LanTongCostAdapter mLanTongCostAdapter;
    private OtherCostAdapter mOtherCostAdapter;
    private List<ChannelCityOrderCostReportBean.DataBean.NanTongOrderCostListBean> nanTongOrderCostList;
    private List<ChannelCityOrderCostReportBean.DataBean.OtherOrderCostListBean> otherOrderCostList;

    @Override
    public int getLayoutId() {
        return R.layout.activity_cost;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
        handler.removeCallbacks(runnable);
        handler.removeCallbacks(loopRunnable);
    }

    @Override
    public void initView() {
        mLrvLanTong = findViewById(R.id.lrv_lantong);
        mLrvOther = findViewById(R.id.lrv_other);
        mLrvTop = findViewById(R.id.lrv_top);
        mPresenter = new ComPresenter();
        mPresenter.attachView(this);
    }

    @Override
    public void initData() {

        mPresenter.getChannelCityOrderCostReportForm();
//        mPresenter.getCustomerChannelCityOrderCostReportForm();

        mLrvLanTong.setLayoutManager(new GridLayoutManager(mContext, 3));
        mLanTongCostAdapter = new LanTongCostAdapter(mContext);
        mLuRecyclerViewAdapter = new LRecyclerViewAdapter(mLanTongCostAdapter);
        mLrvLanTong.setAdapter(mLuRecyclerViewAdapter);
        mLrvLanTong.setLoadMoreEnabled(false);
        mLrvLanTong.setPullRefreshEnabled(false);


        mLrvOther.setLayoutManager(new GridLayoutManager(mContext, 3));
        mOtherCostAdapter = new OtherCostAdapter(mContext);
        mLuRecyclerViewAdapter = new LRecyclerViewAdapter(mOtherCostAdapter);
        mLrvOther.setAdapter(mLuRecyclerViewAdapter);
        mLrvOther.setLoadMoreEnabled(false);
        mLrvOther.setPullRefreshEnabled(false);


        mLrvTop.setLayoutManager(new GridLayoutManager(mContext, 11));
        TopCostAdapter topCostAdapter = new TopCostAdapter(mContext);
        mLuRecyclerViewAdapter = new LRecyclerViewAdapter(topCostAdapter);
        mLrvTop.setAdapter(mLuRecyclerViewAdapter);
        mLrvTop.setLoadMoreEnabled(false);
        mLrvTop.setPullRefreshEnabled(false);
        topCostAdapter.setDataList(mData);

    }

    @Override
    public void initListener() {
    }

    @Override
    protected void onPageSelected(int pager) {
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 14; i++) {
                mLanTongCostAdapter.getDataList().remove(0);
                mOtherCostAdapter.getDataList().remove(0);
                if (mLanTongCostAdapter.getDataList().size() == 0) {
                    mLanTongCostAdapter.setDataList(nanTongOrderCostList);
                    mOtherCostAdapter.setDataList(otherOrderCostList);
                    handler.postDelayed(runnable, mDelayTime);
                    return;
                }
            }
            mLanTongCostAdapter.notifyDataSetChanged();
            mOtherCostAdapter.notifyDataSetChanged();
            handler.postDelayed(runnable, mDelayTime);
        }
    };

    Runnable loopRunnable = new Runnable() {
        @Override
        public void run() {
            handler.removeCallbacks(runnable);
            mPresenter.getChannelCityOrderCostReportForm();
            handler.postDelayed(loopRunnable, mDelayTime * 6);
        }
    };

    @Override
    public void onSuccess(Object jsonResult, int type) {
        if (type == Constants.METHOD_THREE) {
            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                ChannelCityOrderCostReportBean channelCityOrderCostReportBean = GsonUtil.GsonToBean(GsonUtil.GsonString(jsonResult), ChannelCityOrderCostReportBean.class);
                initChannelCityOrderCostReport(channelCityOrderCostReportBean);
            }

        } else if (type == Constants.METHOD_FOUR) {
            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                CustomerChannelCityOrderCostReportBean customerChannelCityOrderCostReportBean = GsonUtil.GsonToBean(GsonUtil.GsonString(jsonResult), CustomerChannelCityOrderCostReportBean.class);
                initCustomerChannelCityOrderCostReport(customerChannelCityOrderCostReportBean);

            }
        }
    }

    private void initCustomerChannelCityOrderCostReport(CustomerChannelCityOrderCostReportBean customerChannelCityOrderCostReportBean) {

    }

    private void initChannelCityOrderCostReport(ChannelCityOrderCostReportBean channelCityOrderCostReportBean) {
        nanTongOrderCostList = channelCityOrderCostReportBean.getData().getNanTongOrderCostList();
        otherOrderCostList = channelCityOrderCostReportBean.getData().getOtherOrderCostList();

        mLanTongCostAdapter.setDataList(nanTongOrderCostList);
        mOtherCostAdapter.setDataList(otherOrderCostList);

        handler.postDelayed(runnable, mDelayTime);
        handler.removeCallbacks(loopRunnable);
        handler.postDelayed(loopRunnable, mDelayTime * 6);
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