package com.jt.display.activitys;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.github.mikephil.charting.animation.Easing;
import com.jt.display.MainActivity;
import com.jt.display.R;
import com.jt.display.adapters.TopBottomAdapter;
import com.jt.display.base.BaseDisplayActivity;
import com.jt.display.base.Constants;
import com.jt.display.base.JsonResult;
import com.jt.display.bean.OrderAmountByCustomerBean;
import com.jt.display.bean.SalesCurrentAndLastMonthBean;
import com.jt.display.bean.TopAndDownCustomerBean;
import com.jt.display.bean.lastSixMonthSaleBean;
import com.jt.display.presenter.ComPresenter;
import com.jt.display.utils.GsonUtil;
import com.jt.display.views.CLineChart;
import com.jt.display.views.SingleBarChart;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;


public class SalesActivity extends BaseDisplayActivity {
    final List<Integer> colors = Arrays.asList(
            Color.parseColor("#face7c"),
            Color.parseColor("#e03836"),
            Color.parseColor("#fa985c"),
            Color.parseColor("#fa965b"),
            Color.parseColor("#303425"),
            Color.parseColor("#f77b51"),
            Color.parseColor("#c58dfe"),
            Color.parseColor("#e06412"),
            Color.parseColor("#6ed062"),
            Color.parseColor("#1300fe")
    );


    private ComPresenter mPresenter;
    private CLineChart mSalesCurrentAndLastMonthChart;
    private SingleBarChart mLastSixMonthSalesChart;
    private CLineChart mOrderAmountChartOne;
    private CLineChart mOrderAmountChartTwo;
    private LRecyclerView mLrvTopBottom;
    private TopBottomAdapter mTopBottomAdapter;
    List<TopAndDownCustomerBean.DataBean.TopCustomerListBean> mTopCustomerList = new ArrayList<>();
    private TextView mTvOrderAmountDesc;
    private int type = 0;
    private int mTopPager = -1;//轮播10张的第几页
    private TopAndDownCustomerBean topAndDownCustomerBean;


    @Override
    public int getLayoutId() {
        return R.layout.activity_sales2;
    }

    @Override
    public void initView() {
        mSalesCurrentAndLastMonthChart = findViewById(R.id.salesCurrentAndLastMonth_chart);
        mLastSixMonthSalesChart = findViewById(R.id.lastSixMonthSales_chart);
        mOrderAmountChartOne = findViewById(R.id.orderAmount_chart_one);
        mOrderAmountChartTwo = findViewById(R.id.orderAmount_chart_two);
        mLrvTopBottom = findViewById(R.id.lrv_top_bottom);
        mTvOrderAmountDesc = findViewById(R.id.orderAmount_desc);

        mPresenter = new ComPresenter();
        mPresenter.attachView(this);

    }

    @Override
    public void initData() {

        mLrvTopBottom.setLayoutManager(new GridLayoutManager(mContext, 4));
        mTopBottomAdapter = new TopBottomAdapter(mContext);
        LRecyclerViewAdapter mLuRecyclerViewAdapter = new LRecyclerViewAdapter(mTopBottomAdapter);
        mLrvTopBottom.setAdapter(mLuRecyclerViewAdapter);
        mLrvTopBottom.setLoadMoreEnabled(false);
        mLrvTopBottom.setPullRefreshEnabled(false);

        addAnimView(mOrderAmountChartOne);
        addAnimView(mOrderAmountChartTwo);

        mPresenter.getSalesCurrentAndLastMonth();
    }


    @Override
    public void initListener() {

    }

    @Override
    protected void onPageSelected(int pager) {
        mTopPager++;
        if (mTopPager == mTopCustomerList.size()) {
            mTopPager = 0;
        }
        type = mTopPager % 2;
        startTopChart(mTopPager);
        Logger.e(type + "," + mTopPager);
    }

    @Override
    protected void loopTimesListener(long loopTimes) {
        if (loopTimes % 3 == 0) {
            mPresenter.getSalesCurrentAndLastMonth();
        }
        if (topAndDownCustomerBean == null) return;
        if (topAndDownCustomerBean.getData().getTopCustomerList().size() > 5 || topAndDownCustomerBean.getData().getDownCustomerList().size() > 5) {
            if (loopTimes % 2 == 0) {
                mLrvTopBottom.scrollToPosition(40);
            } else {
                mLrvTopBottom.scrollToPosition(0);
            }
        }
    }

    /**
     * 前缀：http://40.73.59.226:9000/jtms-order/
     * 销售主题：
     */
    @Override
    public void onSuccess(Object jsonResult, int type) {
        if (((JsonResult) jsonResult).getCode() != Constants.HTTP_SUCCESS) {
            show(((JsonResult) jsonResult).getMsg());
        }

        if (type == Constants.METHOD_ONE) {//当月每日销售额
            mPresenter.lastSixMonthSale();

            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                SalesCurrentAndLastMonthBean salesCurrentAndLastMonthBean = GsonUtil.GsonToBean(GsonUtil.GsonString(jsonResult), SalesCurrentAndLastMonthBean.class);
                initLine(salesCurrentAndLastMonthBean);
            }
        } else if (type == Constants.METHOD_TWO) {//前十和后十客户
            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                topAndDownCustomerBean = GsonUtil.GsonToBean(GsonUtil.GsonString(jsonResult), TopAndDownCustomerBean.class);
                if (topAndDownCustomerBean.getData().getTopCustomerList() != null
                        && topAndDownCustomerBean.getData().getTopCustomerList().size() > 0) {
                    initTopAndDown(topAndDownCustomerBean);
                    mTopCustomerList.clear();
                    mTopCustomerList.addAll(topAndDownCustomerBean.getData().getTopCustomerList());
                    mTopPager = -1;
                    startAnim();
                }
            }
        } else if (type == Constants.METHOD_THREE) {//Top10客户轮播
            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                OrderAmountByCustomerBean orderAmountByCustomerBean = GsonUtil.GsonToBean(GsonUtil.GsonString(jsonResult), OrderAmountByCustomerBean.class);
                initOrderAmountLine(orderAmountByCustomerBean);
            }
        } else if (type == Constants.METHOD_FOUR) {//月销售额
            mPresenter.getTopAndDownCustomerList();
            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                lastSixMonthSaleBean lastSixMonthSaleBean = GsonUtil.GsonToBean(GsonUtil.GsonString(jsonResult), lastSixMonthSaleBean.class);
                initMBar(lastSixMonthSaleBean);
            }
        }
    }

    private void initTopAndDown(TopAndDownCustomerBean topAndDownCustomerBean) {
        List<TopAndDownCustomerBean.DataBean> dataBeanList = new ArrayList<>();
        dataBeanList.add(topAndDownCustomerBean.getData());
        if (dataBeanList.size() > 0)
            mTopBottomAdapter.setDataList(dataBeanList);
    }

    @SuppressLint("SetTextI18n")
    private void startTopChart(int page) {
        mOrderAmountChartOne.clear();
        mOrderAmountChartTwo.clear();
        String customerName = mTopCustomerList.get(page).getCustomerName();
        mTvOrderAmountDesc.setText("月销售环比(" + customerName + ")");
        mPresenter.getOrderAmountByCustomerName(customerName);
    }


    //当月每日销售额
    private void initLine(SalesCurrentAndLastMonthBean salesCurrentAndLastMonthBean) {

        //线形图
        mSalesCurrentAndLastMonthChart.animateY(1000);
        mSalesCurrentAndLastMonthChart.animateX(1000);
        List<String> Xstrings = initLineXData(salesCurrentAndLastMonthBean);
        LinkedHashMap<String, List<Float>> Ystrings = initLineYData(salesCurrentAndLastMonthBean);
        mSalesCurrentAndLastMonthChart.showLineChart(Xstrings, Ystrings, colors);
        mSalesCurrentAndLastMonthChart.setDes("当月每日销售额", 200);
        mSalesCurrentAndLastMonthChart.postInvalidate();
    }

    private List<String> initLineXData(SalesCurrentAndLastMonthBean lastSixMonthSalesBean) {
        List<String> xValues = new ArrayList<>();
        for (int i = 0; i < lastSixMonthSalesBean.getData().getLastMonth().size(); i++) {

            xValues.add(lastSixMonthSalesBean.getData().getLastMonth().get(i).getOrderDay());
        }
        return xValues;
    }

    private LinkedHashMap<String, List<Float>> initLineYData(SalesCurrentAndLastMonthBean salesCurrentAndLastMonthBean) {
        LinkedHashMap<String, List<Float>> chartDataMap = new LinkedHashMap<>();
        List<Float> yValue1 = new ArrayList<>();
        List<Float> yValue2 = new ArrayList<>();
        List<SalesCurrentAndLastMonthBean.DataBean.CurrentMonthBean> currentMonth = salesCurrentAndLastMonthBean.getData().getCurrentMonth();
        List<SalesCurrentAndLastMonthBean.DataBean.LastMonthBean> lastMonth = salesCurrentAndLastMonthBean.getData().getLastMonth();

        for (SalesCurrentAndLastMonthBean.DataBean.CurrentMonthBean valueBean : currentMonth) {
            yValue1.add(Float.parseFloat(valueBean.getSalesAmount() + ""));
        }
        for (SalesCurrentAndLastMonthBean.DataBean.LastMonthBean valueAvgBean : lastMonth) {
            yValue2.add(Float.parseFloat(valueAvgBean.getSalesAmount() + ""));
        }


        chartDataMap.put("本月", yValue1);
        chartDataMap.put("上月", yValue2);

        return chartDataMap;
    }

    //月销售额
    private void initMBar(lastSixMonthSaleBean lastSixMonthSaleBean) {
        //多条柱状图
        mLastSixMonthSalesChart.animateY(1000, Easing.EasingOption.Linear);
        mLastSixMonthSalesChart.animateX(1000, Easing.EasingOption.Linear);
        mLastSixMonthSalesChart.clear();
        List<String> XData = initXData(lastSixMonthSaleBean);
        List<String> yData = initYData(lastSixMonthSaleBean);
        mLastSixMonthSalesChart.showBarChart(XData, yData, "", colors.get(0));
        mLastSixMonthSalesChart.setDes("近6个月销售额", 190);
    }

    private List<String> initYData(lastSixMonthSaleBean barJsonBean) {
        //处理数据是 记得判断每条柱状图对应的数据集合 长度是否一致
        List<String> yValue1 = new ArrayList<>();
        List<lastSixMonthSaleBean.DataBean> barJsonBeanData = barJsonBean.getData();
        for (lastSixMonthSaleBean.DataBean valueBean : barJsonBeanData) {
            yValue1.add(valueBean.getSalesAmount());
        }
        return yValue1;
    }

    private List<String> initXData(lastSixMonthSaleBean barJsonBean) {
        //处理数据是 记得判断每条柱状图对应的数据集合 长度是否一致
        List<String> xValues = new ArrayList<>();
        List<lastSixMonthSaleBean.DataBean> data = barJsonBean.getData();
        for (lastSixMonthSaleBean.DataBean valueBean : data) {
            xValues.add(valueBean.getOrderMonth());
        }
        return xValues;
    }

    //Top10客户轮播
    private void initOrderAmountLine(OrderAmountByCustomerBean orderAmountByCustomerBean) {
        //线形图
        mOrderAmountChartOne.animateY(1000);
        mOrderAmountChartOne.animateX(1000);
        List<String> Xstrings = initOrderAmountLineXData(orderAmountByCustomerBean);
        LinkedHashMap<String, List<Float>> Ystrings = initOrderAmountLineYData(orderAmountByCustomerBean);
        mOrderAmountChartOne.showLineChart(Xstrings, Ystrings, colors);
        mOrderAmountChartOne.setDes("1", -100);//去除标签
        mOrderAmountChartOne.postInvalidate();
        //线形图
        mOrderAmountChartTwo.animateY(1000);
        mOrderAmountChartTwo.animateX(1000);
        List<String> Xstrings2 = initOrderAmountLineXData(orderAmountByCustomerBean);
        LinkedHashMap<String, List<Float>> Ystrings2 = initOrderAmountLineYData(orderAmountByCustomerBean);
        mOrderAmountChartTwo.showLineChart(Xstrings2, Ystrings2, colors);
        mOrderAmountChartTwo.setDes("1", -100);//去除标签
        mOrderAmountChartTwo.postInvalidate();

    }


    private List<String> initOrderAmountLineXData(OrderAmountByCustomerBean orderAmountByCustomerBean) {
        List<String> xValues = new ArrayList<>();
        for (int i = 0; i < orderAmountByCustomerBean.getData().getLastMonth().size(); i++) {
            xValues.add(orderAmountByCustomerBean.getData().getLastMonth().get(i).getOrderDay());
        }
        return xValues;
    }

    private LinkedHashMap<String, List<Float>> initOrderAmountLineYData(OrderAmountByCustomerBean orderAmountByCustomerBean) {
        LinkedHashMap<String, List<Float>> chartDataMap = new LinkedHashMap<>();
        List<Float> yValue1 = new ArrayList<>();
        List<Float> yValue2 = new ArrayList<>();
        List<OrderAmountByCustomerBean.DataBean.CurrentMonthBean> currentMonth = orderAmountByCustomerBean.getData().getCurrentMonth();
        List<OrderAmountByCustomerBean.DataBean.LastMonthBean> lastMonth = orderAmountByCustomerBean.getData().getLastMonth();

        for (OrderAmountByCustomerBean.DataBean.CurrentMonthBean valueBean : currentMonth) {
            yValue1.add(Float.parseFloat(valueBean.getSalesAmount() + ""));
        }
        for (OrderAmountByCustomerBean.DataBean.LastMonthBean valueAvgBean : lastMonth) {
            yValue2.add(Float.parseFloat(valueAvgBean.getSalesAmount() + ""));
        }


        chartDataMap.put("本月", yValue1);
        chartDataMap.put("上月", yValue2);

        return chartDataMap;
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

}