package com.jt.display;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.google.gson.Gson;
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
import com.jt.display.bean.UpgradeInfo;
import com.jt.display.bean.User;
import com.jt.display.presenter.ComPresenter;
import com.jt.display.utils.GsonUtil;
import com.jt.display.utils.SharePreferenceUtils;
import com.jt.display.utils.UpdateUtil;
import com.jt.display.views.CLineChart;
import com.jt.display.views.HBarChart;
import com.jt.display.views.ManyBarChart;
import com.jt.display.views.PieChartView;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends BaseDisplayActivity implements View.OnFocusChangeListener, EasyPermissions.PermissionCallbacks {

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
//        fbf506   ac9e0e      3d9c06   346207     10f5c3
//        1b9979   109bf0     196595   3f0af2   a80d02
    final List<Integer> colors = Arrays.asList(
            Color.parseColor("#10f5c3"),
            Color.parseColor("#c58dfe"),
            Color.parseColor("#fa985c"),
            Color.parseColor("#3f0af2"),
            Color.parseColor("#fa965b"),
            Color.parseColor("#f77b51"),
            Color.parseColor("#fb4751"),
            Color.parseColor("#e06412"),
            Color.parseColor("#6ed062"),
            Color.parseColor("#5afe01"),
            Color.parseColor("#ffffff")
    );

    private TextView mTvWeek;
    private TextView mTvMonth;
    private TextView mTvQuarterly;
    private TextView mTvloding;
    private TextView mTvTodaySales;
    private TextView mTvTodayReceiving;
    private TextView mTvTodayShipment;
    private TextView mTvTodayInventory;
    private boolean isLoading = true;


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
        mPresenter.customerSalesSort(type + "");//1周2月3季度

        addAnimView(mCustomerSalesSortChartWeek);
        addAnimView(mCustomerSalesSortChartMonth);
        addAnimView(mCustomerSalesSortChartQuarterly);
        startAnim();
        requestPermission();
    }

    @Override
    public void initListener() {
        mTvSales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(mContext, SalesActivity.class));
            }
        });
        mTvCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(mContext, CarActivity.class));
            }
        });
        mTvTransport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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
        mSecretCode = 0;
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
        mAnimDataLoading = true;
        isLoading = true;

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

    @Override
    protected void loopTimesListener(long loopTimes) {
        if (loopTimes % 6 == 0 && isLoading) {//检测轮播是否被卡住
            mPresenter.customerSalesSort(type + "");//1周2月3季度
        }

        if (loopTimes % 180 == 0) {//30分钟刷新
            mPresenter.login();
        }

    }

    @Override
    protected void animStart(int mAnimPager) {

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSuccess(Object jsonResult, int type) {
        if (((JsonResult) jsonResult).getCode() != Constants.HTTP_SUCCESS) {
            show(((JsonResult) jsonResult).getMsg());
        }

        if (type == Constants.METHOD_LOGIN) {//登录
            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                SharePreferenceUtils.putLoginData(MainActivity.this, GsonUtil.GsonString(jsonResult));
                mPresenter.lastSevenDaysSales();

            }
        } else if (type == Constants.METHOD_TWO) {//近七日销量
            mPresenter.lastSixMonthSales();

            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                LastSevenDaysSalesBean lastSevenDaysSalesBean = GsonUtil.GsonToBean(GsonUtil.GsonString(jsonResult), LastSevenDaysSalesBean.class);
                mTvTodaySales.setText("今日销售额\n" + lastSevenDaysSalesBean.getData().get(6).getSalesAmount());
                initMBar(lastSevenDaysSalesBean);
            }
        } else if (type == Constants.METHOD_THREE) {//近六个月销量
            mPresenter.lastSevenCarCost();
            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                LastSixMonthSalesBean lastSixMonthSalesBean = GsonUtil.GsonToBean(GsonUtil.GsonString(jsonResult), LastSixMonthSalesBean.class);
                initLine(lastSixMonthSalesBean);
            }
        } else if (type == Constants.METHOD_FOUR) {//客户销量排名
            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                CustomerSalesSortBean customerSalesSortBean = GsonUtil.GsonToBean(GsonUtil.GsonString(jsonResult), CustomerSalesSortBean.class);
                initPieChart(customerSalesSortBean);
                mTvloding.setVisibility(View.GONE);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mAnimDataLoading = false;
                    }
                }, mDelayTime - 4000);
                isLoading = false;
            }

        } else if (type == Constants.METHOD_FIVE) {//近七日车辆成本
            mPresenter.currentReceiveDelivery();

            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                LastSevenCarCostBean lastSevenCarCostBean = GsonUtil.GsonToBean(GsonUtil.GsonString(jsonResult), LastSevenCarCostBean.class);
                initCarLineChart(lastSevenCarCostBean);

            }
        } else if (type == Constants.METHOD_SIX) {//当日收发货
            mPresenter.currentDateLoadAndUnloadVolume();

            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                CurrentReceiveDeliveryBean bean = GsonUtil.GsonToBean(GsonUtil.GsonString(jsonResult), CurrentReceiveDeliveryBean.class);
                initReceiveBar(bean);
                mTvTodayReceiving.setText("今日收货\n" + bean.getData().get(0).getReceiveVolume() + " m³\n" +
                        bean.getData().get(0).getReceiveVolume() + " Kg");
                mTvTodayShipment.setText("今日发货\n" + bean.getData().get(0).getDeliveryVolume() + " m³\n" +
                        bean.getData().get(0).getDeliveryWeight() + " Kg");
                mTvTodayInventory.setText("今日库存\n" + bean.getData().get(0).getCurrentVolumeStorageCapacity() + " m³\n" +
                        bean.getData().get(0).getCurrentWeightStorageCapacity() + " Kg");
            }
        } else if (type == Constants.METHOD_SEVEN) {//当日装卸方数
            mPresenter.doLogin(new User("admin", "!@jingtong1920"));

            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                CurrentDateLoadAndUnloadVolumeBean currentDateLoadAndUnloadVolumeBean =
                        GsonUtil.GsonToBean(GsonUtil.GsonString(jsonResult), CurrentDateLoadAndUnloadVolumeBean.class);
                initLoadAndUnloadVolumeChart(currentDateLoadAndUnloadVolumeBean);
            }
        } else if (type == Constants.METHOD_CHECK_UPGRADE) {//升级
            UpgradeInfo upgradeInfo = new Gson().fromJson(new Gson().toJson(jsonResult), UpgradeInfo.class);
            mPresenter.startUpdate(MainActivity.this, Constants.WMS_URL_BASE +
                    (upgradeInfo.getData().getUpgradeUrl() + "").replace("api/jtms-logistics/", ""));

        } else if (type == Constants.METHOD_LOGIN_PDA) {//PDA登录
            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                mPresenter.checkUpgrade(mPresenter.getAppInfo(MainActivity.this));//版本升级
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
        mLastSevenDaysChart.showBarChart(XData, YData, colors);
        mLastSevenDaysChart.setDes("近七日销量", 150);

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
        mLastSixMonthSalesChart.showLineChart(Xstrings, Ystrings, colors);
        mLastSixMonthSalesChart.setDes("近六个月销量", 180);
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
            mCustomerSalesSortChartMonth.setVisibility(View.GONE);
            mCustomerSalesSortChartQuarterly.setVisibility(View.GONE);
            mCustomerSalesSortChartWeek.setVisibility(View.VISIBLE);

            mCustomerSalesSortChartWeek.setPieChartCircleRadius(60);
            mCustomerSalesSortChartWeek.setTextSize(6f);
            mCustomerSalesSortChartWeek.setData(getPieChartData(customerSalesSortBean));
        } else if (type == 2) {
            mCustomerSalesSortChartWeek.setVisibility(View.GONE);
            mCustomerSalesSortChartQuarterly.setVisibility(View.GONE);
            mCustomerSalesSortChartMonth.setVisibility(View.VISIBLE);

            mCustomerSalesSortChartMonth.setPieChartCircleRadius(60);
            mCustomerSalesSortChartMonth.setTextSize(6f);
            mCustomerSalesSortChartMonth.setData(getPieChartData(customerSalesSortBean));
        } else if (type == 3) {
            mCustomerSalesSortChartWeek.setVisibility(View.GONE);
            mCustomerSalesSortChartMonth.setVisibility(View.GONE);
            mCustomerSalesSortChartQuarterly.setVisibility(View.VISIBLE);

            mCustomerSalesSortChartQuarterly.setPieChartCircleRadius(60);
            mCustomerSalesSortChartQuarterly.setTextSize(6f);
            mCustomerSalesSortChartQuarterly.setData(getPieChartData(customerSalesSortBean));

        }
    }


    public List<PieChartView.PieceDataHolder> getPieChartData(CustomerSalesSortBean customerSalesSortBean) {
        int currentPosition = 0;
        List<CustomerSalesSortBean.DataBean> dataBeanList = customerSalesSortBean.getData();
        List<PieChartView.PieceDataHolder> pieceDataHolders = new ArrayList<>();
        for (CustomerSalesSortBean.DataBean data : dataBeanList) {
            pieceDataHolders.add(new PieChartView.PieceDataHolder(Float.parseFloat(data.getChannelSettleAmount()),
                    colors.get(currentPosition % 11), data.getCustomerName()));
            currentPosition++;
        }
        return pieceDataHolders;
    }

    private void initCarLineChart(LastSevenCarCostBean lastSevenCarCostBean) {
        mLastSevenCarCostChart.animateY(1000);
        mLastSevenCarCostChart.animateX(1000);
        List<String> Xstrings = initCarLineXData(lastSevenCarCostBean);
        LinkedHashMap<String, List<Float>> Ystrings = initCarLineYData(lastSevenCarCostBean);
        mLastSevenCarCostChart.showLineChart(Xstrings, Ystrings, colors);
        mLastSevenCarCostChart.setDes("近七日车辆成本", 200);
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
        mCurrentReceiveDeliveryChart.animateY(1000);
        mCurrentReceiveDeliveryChart.animateX(1000);
        List<String> Xstrings = initReceiveBarXData(bean);

        LinkedHashMap<String, List<String>> Ystring = initReceiveBarYData(bean);
        mCurrentReceiveDeliveryChart.loadData(colors, Xstrings, Ystring, 2f);
        mCurrentReceiveDeliveryChart.setDes("当日收发货", 150);
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
        mCurrentDateLoadAndUnloadVolumeChart.animateY(1000);
        mCurrentDateLoadAndUnloadVolumeChart.animateX(1000);
        List<String> Xstrings = initLoadAndUnloadVolumeBarXData(currentDateLoadAndUnloadVolumeBean);
        LinkedHashMap<String, List<String>> Ystring = initLoadAndUnloadVolumeBarYData(currentDateLoadAndUnloadVolumeBean);
        mCurrentDateLoadAndUnloadVolumeChart.loadData(colors, Xstrings, Ystring, 1f);
        mCurrentDateLoadAndUnloadVolumeChart.setDes("当日装卸方数", 180);
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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.detachView();
    }


    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();
        int action = event.getAction();
        return handleKeyEvent(action, keyCode) || super.dispatchKeyEvent(event);
    }

    private boolean handleKeyEvent(int action, int keyCode) {
        if (action != KeyEvent.ACTION_DOWN)
            return false;
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_UP:
                mSecretCode = mSecretCode + 3;
                mPresenter.doLogin(new User("admin", "!@jingtong1920"));
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                mSecretCode = mSecretCode + 5;
                if (mSecretCode == 17 && mTvTransport.hasFocus()) {
                    show("进入成本主题");
                    finish();
                    startActivity(new Intent(mContext, CostActivity.class));
                }
                break;
            default:
                break;
        }
        return false;
    }


    String[] permissions = {Manifest.permission.CAMERA
            , Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.BLUETOOTH_ADMIN,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION};

    @AfterPermissionGranted(500)
    private void requestPermission() {
        if (EasyPermissions.hasPermissions(this, permissions)) {
        } else {
            EasyPermissions.requestPermissions(this, "请授予应用相关权限", 500, permissions);
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        Toast.makeText(this, "没有相关权限!", Toast.LENGTH_SHORT).show();
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            if (requestCode == 500) {
                new AppSettingsDialog.Builder(this).setTitle("权限申请").setRationale("请授予应用相关权限").build().show();
            } else {
                new AppSettingsDialog.Builder(this).build().show();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        try {
            EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}