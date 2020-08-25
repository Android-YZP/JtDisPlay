package com.jt.display;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieEntry;
import com.jt.display.activitys.CarActivity;
import com.jt.display.activitys.CostActivity;
import com.jt.display.activitys.SalesActivity;
import com.jt.display.activitys.TransportActivity;
import com.jt.display.base.BaseDisplayActivity;
import com.jt.display.base.Constants;
import com.jt.display.base.JsonResult;
import com.jt.display.bean.BarJsonBean;
import com.jt.display.bean.CurrentDateLoadAndUnloadVolumeBean;
import com.jt.display.bean.CurrentReceiveDeliveryBean;
import com.jt.display.bean.CustomerSalesSortBean;
import com.jt.display.bean.LastSevenCarCostBean;
import com.jt.display.bean.LastSevenDaysSalesBean;
import com.jt.display.bean.LastSixMonthSalesBean;
import com.jt.display.bean.lineChartBean;
import com.jt.display.presenter.ComPresenter;
import com.jt.display.utils.GsonUtil;
import com.jt.display.utils.SharePreferenceUtils;
import com.jt.display.views.CLineChart;
import com.jt.display.views.CustomPieChart;
import com.jt.display.views.HBarChart;
import com.jt.display.views.ManyBarChart;
import com.jt.display.views.PieChartView;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class MainActivity extends BaseDisplayActivity implements View.OnFocusChangeListener {

    private TextView mTvSales;
    private TextView mTvCar;
    private TextView mTvCost;
    private TextView mTvTransport;
    private ComPresenter mPresenter;
    private ManyBarChart mLastSevenDaysChart;
    private CLineChart mLastSixMonthSalesChart;
    private PieChartView mCustomerSalesSortChartWeek;
    private PieChartView mCustomerSalesSortChartMonth;
    private PieChartView mCustomerSalesSortChartQuarterly;
    private CLineChart mLastSevenCarCostChart;
    private HBarChart mCurrentReceiveDeliveryChart;
    private HBarChart mCurrentDateLoadAndUnloadVolumeChart;
    private int type = 1;//1周2月3季度
//    <!--    face7c   fa965b  fa985c  e03836  f77b51  6ed062  303425 c58dfe e06412  1300fe-->

    final List<Integer> colors = Arrays.asList(
            Color.parseColor("#face7c"),
            Color.parseColor("#fa985c"),
            Color.parseColor("#e03836"),
            Color.parseColor("#fa965b"),
            Color.parseColor("#303425"),
            Color.parseColor("#f77b51"),
            Color.parseColor("#c58dfe"),
            Color.parseColor("#e06412"),
            Color.parseColor("#6ed062"),
            Color.parseColor("#1300fe")
    );

    private TextView mTvWeek;
    private TextView mTvMonth;
    private TextView mTvQuarterly;
    private TextView mTvloding;
    private TextView mTvTodaySales;
    private TextView mTvTodayReceiving;
    private TextView mTvTodayShipment;
    private TextView mTvTodayInventory;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mTvTodaySales = findViewById(R.id.tv_today_sale);
        mTvTodayReceiving = findViewById(R.id.tv_today_receiving_goods);
        mTvTodayShipment = findViewById(R.id.tv_today_shipment);
        mTvTodayInventory = findViewById(R.id.tv_today_inventory);

        mTvSales = findViewById(R.id.tv_sales);
        mTvCar = findViewById(R.id.tv_car);
        mTvCost = findViewById(R.id.tv_cost);

        mTvWeek = findViewById(R.id.tv_week);
        mTvMonth = findViewById(R.id.tv_month);
        mTvQuarterly = findViewById(R.id.tv_quarterly);
        mTvloding = findViewById(R.id.tv_loding);

        mTvTransport = findViewById(R.id.tv_transport);
        mLastSevenDaysChart = findViewById(R.id.lastSevenDays_chart);
        mLastSixMonthSalesChart = findViewById(R.id.lastSixMonthSales_chart);

        mCustomerSalesSortChartWeek = findViewById(R.id.customerSalesSort_chart_week);
        mCustomerSalesSortChartMonth = findViewById(R.id.customerSalesSort_chart_month);
        mCustomerSalesSortChartQuarterly = findViewById(R.id.customerSalesSort_chart_quarterly);

        mLastSevenCarCostChart = findViewById(R.id.lastSevenCarCost_chart);
        mCurrentReceiveDeliveryChart = findViewById(R.id.currentReceiveDelivery_chart);
        mCurrentDateLoadAndUnloadVolumeChart = findViewById(R.id.currentDateLoadAndUnloadVolume_chart);
    }

    @Override
    public void initData() {
        mPresenter = new ComPresenter();
        mPresenter.attachView(this);
        mPresenter.login();

        addView(mCustomerSalesSortChartWeek);
        addView(mCustomerSalesSortChartMonth);
        addView(mCustomerSalesSortChartQuarterly);

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
        type = pager + 1;
        mPresenter.customerSalesSort(type + "");//1周2月3季度
        mTvWeek.setBackgroundColor(Color.TRANSPARENT);
        mTvMonth.setBackgroundColor(Color.TRANSPARENT);
        mTvQuarterly.setBackgroundColor(Color.TRANSPARENT);
        mTvWeek.setTextColor(Color.GRAY);
        mTvMonth.setTextColor(Color.GRAY);
        mTvQuarterly.setTextColor(Color.GRAY);

        if (type == 1) {
            mTvWeek.setTextColor(Color.WHITE);
            mTvWeek.setBackgroundResource(R.drawable.home_shape_left);
        } else if (type == 2) {
            mTvMonth.setTextColor(Color.WHITE);
            mTvMonth.setBackgroundResource(R.drawable.home_shape_ceter);
        } else if (type == 3) {
            mTvQuarterly.setTextColor(Color.WHITE);
            mTvQuarterly.setBackgroundResource(R.drawable.home_shape_right);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSuccess(Object jsonResult, int type) {
        if (((JsonResult) jsonResult).getCode() != Constants.HTTP_SUCCESS) {
            show(((JsonResult) jsonResult).getMsg());
        }

        if (type == Constants.METHOD_ONE) {//登录
            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                SharePreferenceUtils.putLoginData(MainActivity.this, GsonUtil.GsonString(jsonResult));
                mPresenter.lastSevenDaysSales();
                startAnim();
            }
        } else if (type == Constants.METHOD_TWO) {//近七日销量
            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                mPresenter.lastSixMonthSales();
                mPresenter.lastSevenCarCost();

                LastSevenDaysSalesBean lastSevenDaysSalesBean = GsonUtil.GsonToBean(GsonUtil.GsonString(jsonResult), LastSevenDaysSalesBean.class);
                mTvTodaySales.setText("今日销售额\n" + lastSevenDaysSalesBean.getData().get(6).getSalesAmount());
                initMBar(lastSevenDaysSalesBean);
            }
        } else if (type == Constants.METHOD_THREE) {//近六个月销量
            mPresenter.customerSalesSort(type + "");//1周2月3季度

            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                LastSixMonthSalesBean lastSixMonthSalesBean = GsonUtil.GsonToBean(GsonUtil.GsonString(jsonResult), LastSixMonthSalesBean.class);
                initLine(lastSixMonthSalesBean);
            }
        } else if (type == Constants.METHOD_FOUR) {//客户销量排名
            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                CustomerSalesSortBean customerSalesSortBean = GsonUtil.GsonToBean(GsonUtil.GsonString(jsonResult), CustomerSalesSortBean.class);
                initPieChart(customerSalesSortBean);
                mTvloding.setVisibility(View.GONE);
            }
        } else if (type == Constants.METHOD_FIVE) {//近七日车辆成本
            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                mPresenter.currentReceiveDelivery();

                LastSevenCarCostBean lastSevenCarCostBean = GsonUtil.GsonToBean(GsonUtil.GsonString(jsonResult), LastSevenCarCostBean.class);
                initCarLineChart(lastSevenCarCostBean);

            }
        } else if (type == Constants.METHOD_SIX) {//当日收发货
            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                mPresenter.currentDateLoadAndUnloadVolume();

                CurrentReceiveDeliveryBean bean = GsonUtil.GsonToBean(GsonUtil.GsonString(jsonResult), CurrentReceiveDeliveryBean.class);
                initReceiveBar(bean);
                mTvTodayReceiving.setText("今日收货\n" + bean.getData().get(0).getReceiveVolume() + "m³/" +
                        bean.getData().get(0).getReceiveVolume() + "Kg");
                mTvTodayShipment.setText("今日发货\n" + bean.getData().get(0).getDeliveryVolume() + "m³/" +
                        bean.getData().get(0).getDeliveryWeight() + "Kg");
                mTvTodayInventory.setText("今日库存\n" + bean.getData().get(0).getCurrentVolumeStorageCapacity() + "m³/" +
                        bean.getData().get(0).getCurrentWeightStorageCapacity() + "Kg");
            }
        } else if (type == Constants.METHOD_SEVEN) {//当日装卸方数
            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                CurrentDateLoadAndUnloadVolumeBean currentDateLoadAndUnloadVolumeBean =
                        GsonUtil.GsonToBean(GsonUtil.GsonString(jsonResult), CurrentDateLoadAndUnloadVolumeBean.class);
                initLoadAndUnloadVolumeChart(currentDateLoadAndUnloadVolumeBean);
            }
        }
    }


    private void initMBar(LastSevenDaysSalesBean lastSevenDaysSalesBean) {
        //多条柱状图
        mLastSevenDaysChart.animateY(1000, Easing.EasingOption.Linear);
        mLastSevenDaysChart.animateX(1000, Easing.EasingOption.Linear);
        mLastSevenDaysChart.clear();
        List<String> XData = initXData(lastSevenDaysSalesBean);
        LinkedHashMap<String, List<Float>> YData = initYData(lastSevenDaysSalesBean);
        mLastSevenDaysChart.showBarChart(XData, YData,colors);
        mLastSevenDaysChart.setDes("近七日销量", 230);

    }

    private LinkedHashMap<String, List<Float>> initYData(LastSevenDaysSalesBean barJsonBean) {
        //处理数据是 记得判断每条柱状图对应的数据集合 长度是否一致
        LinkedHashMap<String, List<Float>> chartDataMap = new LinkedHashMap<>();
        List<Float> yValue1 = new ArrayList<>();
        List<Float> yValue2 = new ArrayList<>();
        List<Float> yValue3 = new ArrayList<>();
        List<Float> yValue4 = new ArrayList<>();

        List<LastSevenDaysSalesBean.DataBean> barJsonBeanData = barJsonBean.getData();

        for (LastSevenDaysSalesBean.DataBean valueBean : barJsonBeanData) {
            yValue1.add(Float.parseFloat(valueBean.getSalesAmount()));
        }
        for (LastSevenDaysSalesBean.DataBean valueAvgBean : barJsonBeanData) {
            yValue2.add(Float.parseFloat(valueAvgBean.getVolume()));
        }
        for (LastSevenDaysSalesBean.DataBean valueAvgBean : barJsonBeanData) {
            yValue3.add(Float.parseFloat(valueAvgBean.getWeight()));
        }
        for (LastSevenDaysSalesBean.DataBean valueAvgBean : barJsonBeanData) {
            yValue4.add(Float.parseFloat(valueAvgBean.getCartonNum()));
        }

        chartDataMap.put("销售金额", yValue1);
        chartDataMap.put("体积", yValue2);
        chartDataMap.put("重量", yValue3);
        chartDataMap.put("总箱数", yValue4);
        return chartDataMap;
    }

    private List<String> initXData(LastSevenDaysSalesBean barJsonBean) {
        //处理数据是 记得判断每条柱状图对应的数据集合 长度是否一致
        List<String> xValues = new ArrayList<>();
        List<LastSevenDaysSalesBean.DataBean> barJsonBeanData = barJsonBean.getData();
        for (LastSevenDaysSalesBean.DataBean valueBean : barJsonBeanData) {
            xValues.add(valueBean.getOrderDay());
        }
        return xValues;
    }


    private void initLine(LastSixMonthSalesBean lastSixMonthSalesBean) {
        //线形图
        mLastSixMonthSalesChart.animateY(1000);
        mLastSixMonthSalesChart.animateX(1000);
        List<String> Xstrings = initLineXData(lastSixMonthSalesBean);
        LinkedHashMap<String, List<Float>> Ystrings = initLineYData(lastSixMonthSalesBean);
        mLastSixMonthSalesChart.showLineChart(Xstrings, Ystrings,colors);
        mLastSixMonthSalesChart.setDes("近六个月销量", 270);
    }

    private List<String> initLineXData(LastSixMonthSalesBean lastSixMonthSalesBean) {
        List<String> xValues = new ArrayList<>();
        for (int i = 0; i < lastSixMonthSalesBean.getData().size(); i++) {
            xValues.add(lastSixMonthSalesBean.getData().get(i).getOrderMonth());
        }
        return xValues;
    }

    private LinkedHashMap<String, List<Float>> initLineYData(LastSixMonthSalesBean lastSixMonthSalesBean) {

        LinkedHashMap<String, List<Float>> chartDataMap = new LinkedHashMap<>();
        List<Float> yValue1 = new ArrayList<>();
        List<Float> yValue2 = new ArrayList<>();
        List<Float> yValue3 = new ArrayList<>();
        List<Float> yValue4 = new ArrayList<>();

        List<LastSixMonthSalesBean.DataBean> sixMonthSalesBeanData = lastSixMonthSalesBean.getData();

        for (LastSixMonthSalesBean.DataBean valueBean : sixMonthSalesBeanData) {
            yValue1.add(Float.parseFloat(valueBean.getSalesAmount()));
        }
        for (LastSixMonthSalesBean.DataBean valueAvgBean : sixMonthSalesBeanData) {
            yValue2.add(Float.parseFloat(valueAvgBean.getVolume()));
        }
        for (LastSixMonthSalesBean.DataBean valueAvgBean : sixMonthSalesBeanData) {
            yValue3.add(Float.parseFloat(valueAvgBean.getWeight()));
        }
        for (LastSixMonthSalesBean.DataBean valueAvgBean : sixMonthSalesBeanData) {
            yValue4.add(Float.parseFloat(valueAvgBean.getCartonNum()));
        }

        chartDataMap.put("销售金额", yValue1);
        chartDataMap.put("体积", yValue2);
        chartDataMap.put("重量", yValue3);
        chartDataMap.put("总箱数", yValue4);

        return chartDataMap;
    }


    private void initPieChart(CustomerSalesSortBean customerSalesSortBean) {
        if (type == 1) {
            mCustomerSalesSortChartWeek.setPieChartCircleRadius(180);
            mCustomerSalesSortChartWeek.setTextSize(8f);
            mCustomerSalesSortChartWeek.setData(getPieChartData(customerSalesSortBean));
        } else if (type == 2) {
            mCustomerSalesSortChartMonth.setPieChartCircleRadius(180);
            mCustomerSalesSortChartMonth.setTextSize(8f);
            mCustomerSalesSortChartMonth.setData(getPieChartData(customerSalesSortBean));
        } else if (type == 3) {
            mCustomerSalesSortChartQuarterly.setPieChartCircleRadius(180);
            mCustomerSalesSortChartQuarterly.setTextSize(8f);
            mCustomerSalesSortChartQuarterly.setData(getPieChartData(customerSalesSortBean));

        }
    }


    public List<PieChartView.PieceDataHolder> getPieChartData(CustomerSalesSortBean customerSalesSortBean) {
        int currentPosition = 0;
        List<CustomerSalesSortBean.DataBean> dataBeanList = customerSalesSortBean.getData();
        List<PieChartView.PieceDataHolder> pieceDataHolders = new ArrayList<>();
        for (CustomerSalesSortBean.DataBean data : dataBeanList) {
            pieceDataHolders.add(new PieChartView.PieceDataHolder(Float.parseFloat(data.getChannelSettleAmount()),
                    colors.get(currentPosition), data.getCustomerName()));
            currentPosition++;
        }

        return pieceDataHolders;
    }

    private void initCarLineChart(LastSevenCarCostBean lastSevenCarCostBean) {
        mLastSevenCarCostChart.animateY(1000);
        mLastSevenCarCostChart.animateX(1000);
        List<String> Xstrings = initCarLineXData(lastSevenCarCostBean);
        LinkedHashMap<String, List<Float>> Ystrings = initCarLineYData(lastSevenCarCostBean);
        mLastSevenCarCostChart.showLineChart(Xstrings, Ystrings,colors);
        mLastSevenCarCostChart.setDes("近七日车辆成本", 300);
    }

    private List<String> initCarLineXData(LastSevenCarCostBean lastSevenCarCostBean) {
        List<String> xValues = new ArrayList<>();
        for (int i = 0; i < lastSevenCarCostBean.getData().size(); i++) {
            xValues.add(lastSevenCarCostBean.getData().get(i).getDispatchCarDay());
        }
        return xValues;
    }

    private LinkedHashMap<String, List<Float>> initCarLineYData(LastSevenCarCostBean lastSevenCarCostBean) {
        LinkedHashMap<String, List<Float>> chartDataMap = new LinkedHashMap<>();
        List<Float> yValue1 = new ArrayList<>();
        List<LastSevenCarCostBean.DataBean> lastSevenCarCostBeanData = lastSevenCarCostBean.getData();
        for (LastSevenCarCostBean.DataBean valueBean : lastSevenCarCostBeanData) {
            yValue1.add(Float.parseFloat(valueBean.getTransChargeSum()));
        }
        chartDataMap.put("费用", yValue1);
        return chartDataMap;
    }


    private void initReceiveBar(CurrentReceiveDeliveryBean bean) {

        List<String> Xstrings = initReceiveBarXData(bean);

        LinkedHashMap<String, List<String>> Ystring = initReceiveBarYData(bean);
        mCurrentReceiveDeliveryChart.loadData(colors, Xstrings, Ystring);
        mCurrentReceiveDeliveryChart.setDes("当日收发货", 230);
    }

    private List<String> initReceiveBarXData(CurrentReceiveDeliveryBean bean) {
        List<String> xValues = new ArrayList<>();
        for (int i = 0; i < bean.getData().size(); i++) {
            xValues.add(bean.getData().get(i).getCurrentDate());
        }
        return xValues;
    }

    private LinkedHashMap<String, List<String>> initReceiveBarYData(CurrentReceiveDeliveryBean bean) {
        LinkedHashMap<String, List<String>> chartDataMap = new LinkedHashMap<>();

        List<String> yValue1 = new ArrayList<>();
        List<String> yValue2 = new ArrayList<>();
        List<String> yValue3 = new ArrayList<>();
        List<String> yValue4 = new ArrayList<>();
        List<String> yValue5 = new ArrayList<>();
        List<String> yValue6 = new ArrayList<>();

        List<CurrentReceiveDeliveryBean.DataBean> data = bean.getData();

        for (CurrentReceiveDeliveryBean.DataBean valueBean : data) {
            yValue1.add(valueBean.getReceiveVolume());
        }
        for (CurrentReceiveDeliveryBean.DataBean valueBean : data) {
            yValue2.add(valueBean.getReceiveWeight());
        }
        for (CurrentReceiveDeliveryBean.DataBean valueBean : data) {
            yValue3.add(valueBean.getDeliveryVolume());
        }
        for (CurrentReceiveDeliveryBean.DataBean valueBean : data) {
            yValue4.add(valueBean.getDeliveryWeight());
        }
        for (CurrentReceiveDeliveryBean.DataBean valueBean : data) {
            yValue5.add(valueBean.getCurrentVolumeStorageCapacity());
        }
        for (CurrentReceiveDeliveryBean.DataBean valueBean : data) {
            yValue6.add(valueBean.getCurrentWeightStorageCapacity());
        }
        chartDataMap.put("收货体积", yValue1);
        chartDataMap.put("收货重量", yValue2);
        chartDataMap.put("发货体积", yValue3);
        chartDataMap.put("发货重量", yValue4);
        chartDataMap.put("库存体积", yValue5);
        chartDataMap.put("库存重量", yValue6);
        return chartDataMap;
    }


    private void initLoadAndUnloadVolumeChart(CurrentDateLoadAndUnloadVolumeBean currentDateLoadAndUnloadVolumeBean) {

        List<String> Xstrings = initLoadAndUnloadVolumeBarXData(currentDateLoadAndUnloadVolumeBean);
        LinkedHashMap<String, List<String>> Ystring = initLoadAndUnloadVolumeBarYData(currentDateLoadAndUnloadVolumeBean);
        mCurrentDateLoadAndUnloadVolumeChart.loadData(colors, Xstrings, Ystring);
        mCurrentDateLoadAndUnloadVolumeChart.setDes("当日装卸方数", 270);
        mCurrentDateLoadAndUnloadVolumeChart.postInvalidate();
    }


    private List<String> initLoadAndUnloadVolumeBarXData(CurrentDateLoadAndUnloadVolumeBean currentDateLoadAndUnloadVolumeBean) {
        List<String> xValues = new ArrayList<>();
        for (int i = 0; i < currentDateLoadAndUnloadVolumeBean.getData().size(); i++) {
            xValues.add(currentDateLoadAndUnloadVolumeBean.getData().get(i).getCurrentDate() + "");
        }
        return xValues;
    }

    private LinkedHashMap<String, List<String>> initLoadAndUnloadVolumeBarYData(CurrentDateLoadAndUnloadVolumeBean currentDateLoadAndUnloadVolumeBean) {
        LinkedHashMap<String, List<String>> chartDataMap = new LinkedHashMap<>();

        List<String> yValue1 = new ArrayList<>();
        List<String> yValue2 = new ArrayList<>();
        List<String> yValue3 = new ArrayList<>();

        List<CurrentDateLoadAndUnloadVolumeBean.DataBean> data = currentDateLoadAndUnloadVolumeBean.getData();

        for (CurrentDateLoadAndUnloadVolumeBean.DataBean valueBean : data) {
            yValue1.add(valueBean.getTakeWareLoadAndUnloadVolume());
        }
        for (CurrentDateLoadAndUnloadVolumeBean.DataBean valueBean : data) {
            yValue2.add(valueBean.getTcLoadAndUnloadVolume());
        }
        for (CurrentDateLoadAndUnloadVolumeBean.DataBean valueBean : data) {
            yValue3.add(valueBean.getJdLoadAndUnloadVolume());
        }


        chartDataMap.put("提货装卸体积", yValue1);
        chartDataMap.put("转运仓装卸货体积", yValue2);
        chartDataMap.put("京东仓装卸货体积", yValue3);
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
        show(throwable.getMessage());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.detachView();
    }
}