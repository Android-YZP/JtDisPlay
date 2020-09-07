package com.jt.display.activitys;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.GridLayoutManager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.jt.display.MainActivity;
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
import com.jt.display.utils.SharePreferenceUtils;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

public class CostActivity extends BaseDisplayActivity {
    private LRecyclerViewAdapter mLuRecyclerViewAdapter;
    private LRecyclerView mLrvLanTong;
    private LRecyclerView mLrvOther;
    private LRecyclerView mLrvTop;
    private ComPresenter mPresenter;
    private LanTongCostAdapter mLanTongCostAdapter;
    private OtherCostAdapter mOtherCostAdapter;
    private List<ChannelCityOrderCostReportBean.DataBean.NanTongOrderCostListBean> nanTongOrderCostList;
    private List<ChannelCityOrderCostReportBean.DataBean.OtherOrderCostListBean> otherOrderCostList;
    private TopCostAdapter mTopCostAdapter;
    private CustomerChannelCityOrderCostReportBean mCostReportBean;

    private int mTop10Page = 0;
    private boolean isTopFive = true;
    private boolean isLoading = true;

    @Override
    public int getLayoutId() {
        return R.layout.activity_cost;
    }

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
    public void initView() {
        mLrvLanTong = findViewById(R.id.lrv_lantong);
        mLrvOther = findViewById(R.id.lrv_other);
        mLrvTop = findViewById(R.id.lrv_top);
        mPresenter = new ComPresenter();
        mPresenter.attachView(this);
    }

    @Override
    public void initData() {

        isLoading = true;
        mPresenter.getChannelCityOrderCostReportForm();


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

        mLrvTop.setLayoutManager(new GridLayoutManager(mContext, 6));
        mTopCostAdapter = new TopCostAdapter(mContext);
        mLuRecyclerViewAdapter = new LRecyclerViewAdapter(mTopCostAdapter);
        mLrvTop.setAdapter(mLuRecyclerViewAdapter);
        mLrvTop.setLoadMoreEnabled(false);
        mLrvTop.setPullRefreshEnabled(false);
    }

    @Override
    public void initListener() {
    }

    @Override
    protected void onPageSelected(int pager) {
    }

    @Override
    protected void loopTimesListener(long loopTimes) {
        if (loopTimes% 720 == 0){//10000*6*60*4   2小时刷新token
            mPresenter.login();
        }

        if (!isLoading) {//是否在加载中
            mTop10Page++;
            mTopCostAdapter.setDataList(changeCostReportData(mCostReportBean));

            for (int i = 0; i < 14; i++) {
                mLanTongCostAdapter.getDataList().remove(0);
                mOtherCostAdapter.getDataList().remove(0);
                if (mLanTongCostAdapter.getDataList().size() == 0) {
                    mLanTongCostAdapter.setDataList(nanTongOrderCostList);
                    mOtherCostAdapter.setDataList(otherOrderCostList);
                    return;
                }
            }
            mLanTongCostAdapter.notifyDataSetChanged();
            mOtherCostAdapter.notifyDataSetChanged();
        }

        if (loopTimes % 16 == 0) {//每循环16次加载一次数据
            isLoading = true;
            mPresenter.getChannelCityOrderCostReportForm();
        }
    }

    @Override
    protected void animStart(int mAnimPager) {

    }


    @Override
    public void onSuccess(Object jsonResult, int type) {

        if (type == Constants.METHOD_LOGIN) {//登录
            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                SharePreferenceUtils.putLoginData(mContext, GsonUtil.GsonString(jsonResult));
            }
        }

        if (type == Constants.METHOD_THREE) {
            mPresenter.getCustomerChannelCityOrderCostReportForm();

            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                ChannelCityOrderCostReportBean channelCityOrderCostReportBean = GsonUtil.GsonToBean(GsonUtil.GsonString(jsonResult), ChannelCityOrderCostReportBean.class);
                initChannelCityOrderCostReport(channelCityOrderCostReportBean);
            }

        } else if (type == Constants.METHOD_FOUR) {
            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                mCostReportBean = GsonUtil.GsonToBean(GsonUtil.GsonString(jsonResult), CustomerChannelCityOrderCostReportBean.class);
                initCustomerChannelCityOrderCostReport(mCostReportBean);
                isLoading = false;
            }
        }
    }

    private void initCustomerChannelCityOrderCostReport(CustomerChannelCityOrderCostReportBean customerChannelCityOrderCostReportBean) {
        List<CustomerChannelCityOrderCostReportBean.DataBean> mCustomerChannelCityOrderCostReportBeanList = new ArrayList<>();
        mCustomerChannelCityOrderCostReportBeanList.add(customerChannelCityOrderCostReportBean.getData());
        if (mCustomerChannelCityOrderCostReportBeanList.size() > 0) {
            mTopCostAdapter.setDataList(mCustomerChannelCityOrderCostReportBeanList);
        }
    }


    private List<CustomerChannelCityOrderCostReportBean.DataBean> changeCostReportData(CustomerChannelCityOrderCostReportBean customerChannelCityOrderCostReportBean) {

        List<CustomerChannelCityOrderCostReportBean.DataBean> mCustomerChannelCityOrderCostReportBeanList = new ArrayList<>();
        CustomerChannelCityOrderCostReportBean data = GsonUtil.GsonToBean(GsonUtil.GsonString(customerChannelCityOrderCostReportBean), CustomerChannelCityOrderCostReportBean.class);

        if ((10 * mTop10Page) > customerChannelCityOrderCostReportBean.getData().getChannelList().size()) {
            mTop10Page = 0;
            isTopFive = !isTopFive;
        }

        if (!isTopFive) {
            for (int i = 0; i < 5; i++) {
                data.getData().getCustomerCityOrderCostList().remove(0);
                data.getData().getCustomerList().remove(0);
            }
        }

        for (int i = 0; i < ((10 * mTop10Page) > customerChannelCityOrderCostReportBean.getData().getChannelList().size() ? 0 : (10 * mTop10Page)); i++) {
            data.getData().getChannelList().remove(0);
            for (int j = 0; j < data.getData().getCustomerCityOrderCostList().size(); j++) {
                data.getData().getCustomerCityOrderCostList().get(j).getCustomerCityOrderCostList().remove(0);
            }
        }
        mCustomerChannelCityOrderCostReportBeanList.add(data.getData());
        return mCustomerChannelCityOrderCostReportBeanList;
    }


    private void initChannelCityOrderCostReport(ChannelCityOrderCostReportBean channelCityOrderCostReportBean) {
        nanTongOrderCostList = channelCityOrderCostReportBean.getData().getNanTongOrderCostList();
        otherOrderCostList = channelCityOrderCostReportBean.getData().getOtherOrderCostList();

        mLanTongCostAdapter.setDataList(nanTongOrderCostList);
        mOtherCostAdapter.setDataList(otherOrderCostList);
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