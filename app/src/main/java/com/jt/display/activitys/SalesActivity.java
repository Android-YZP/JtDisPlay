package com.jt.display.activitys;


import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import com.github.mikephil.charting.animation.Easing;
import com.jt.display.R;
import com.jt.display.base.BaseDisplayActivity;
import com.jt.display.bean.BarJsonBean;
import com.jt.display.bean.lineChartBean;
import com.jt.display.utils.GsonUtil;
import com.jt.display.views.CLineChart;
import com.jt.display.views.CustomPieChart;
import com.jt.display.views.HBarChart;
import com.jt.display.views.ManyBarChart;
import com.jt.display.views.PieChartView;
import com.jt.display.views.SingleBarChart;
import com.orhanobut.logger.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SalesActivity extends BaseDisplayActivity {


    private CustomPieChart customPieChart;
    private CustomPieChart mPie;
    private CLineChart mLineChart;
    private SingleBarChart mSingleBarChart;
    private ManyBarChart mManyBarChart;
    private List<lineChartBean.GRID0Bean.ResultBean.ClientAccumulativeRateBean> clientAccumulativeRate;
    private List<lineChartBean.GRID0Bean.ResultBean.CompositeIndexShenzhenBean> compositeIndexShenzhen;
    private List<lineChartBean.GRID0Bean.ResultBean.ClientAccumulativeRateBean> clientAccumulativeRate2;
    private List<lineChartBean.GRID0Bean.ResultBean.CompositeIndexShenzhenBean> compositeIndexShenzhen2;
    private List<Integer> colors;
    private List<BarJsonBean.StFinDateBean.VtDateValueBean> dateValueList;
    private BarJsonBean barJsonBean;
    private HBarChart mHorizontalBarChart;

    @Override
    public int getLayoutId() {
        return R.layout.activity_sales;
    }

    @Override
    public void initView() {
        customPieChart = findViewById(R.id.pie);
        mLineChart = (CLineChart) findViewById(R.id.line_chart);
        mSingleBarChart = (SingleBarChart) findViewById(R.id.single_bar_chart);
        mManyBarChart = (ManyBarChart) findViewById(R.id.many_bar_chart);
        mHorizontalBarChart = findViewById(R.id.h_bar_chart);
        initHorizontalBarChart();
    }

    @Override
    public void initData() {
        String json = getJson(SalesActivity.this, "test.json").trim();
        lineChartBean lineChartBean1 = GsonUtil.GsonToBean(json, lineChartBean.class);
        clientAccumulativeRate = lineChartBean1.getGRID0().getResult().getClientAccumulativeRate();
        compositeIndexShenzhen = lineChartBean1.getGRID0().getResult().getCompositeIndexShenzhen();

        String json2 = getJson(SalesActivity.this, "test2.json").trim();
        lineChartBean lineChartBean2 = GsonUtil.GsonToBean(json2, lineChartBean.class);
        clientAccumulativeRate2 = lineChartBean2.getGRID0().getResult().getClientAccumulativeRate();
        compositeIndexShenzhen2 = lineChartBean2.getGRID0().getResult().getCompositeIndexShenzhen();


        colors = Arrays.asList(
                getResources().getColor(R.color.them_colors), getResources().getColor(R.color.bt_focus)
        );
        String json1 = getJson(SalesActivity.this, "bar_test.json").trim();
        barJsonBean = GsonUtil.GsonToBean(json1, BarJsonBean.class);
        dateValueList = barJsonBean.getStFinDate().getVtDateValue();
        Collections.reverse(dateValueList);//将集合 逆序排列，转换成需要的顺序

//        mLineChart.showLineChart(clientAccumulativeRate, "我的收益", getResources().getColor(R.color.white));
//        mLineChart.addLine(compositeIndexShenzhen, "上证指数", getResources().getColor(R.color.text_color));

        initPie();
        initSBar();
        initMBar();


    }

    private void initMBar() {
        //多条柱状图
        mManyBarChart.animateY(1000, Easing.EasingOption.Linear);
        mManyBarChart.animateX(1000, Easing.EasingOption.Linear);

        mManyBarChart.clear();
        mManyBarChart.showBarChart(mManyBarChart.initXData(barJsonBean), mManyBarChart.initYData(barJsonBean));

    }

    private void initSBar() {
        //单条柱状图
        mSingleBarChart.animateY(1000, Easing.EasingOption.Linear);
        mSingleBarChart.animateX(1000, Easing.EasingOption.Linear);

        mSingleBarChart.clear();
        mSingleBarChart.showBarChart(dateValueList, "净资产收益率（%）", getResources().getColor(R.color.them_colors));

    }

    private void initPie() {
        //饼状图
        customPieChart.animateY(1000, Easing.EasingOption.EaseInOutQuad);
        customPieChart.showPieChart(customPieChart.getPieChartData());
    }

    private void initLine() {
        Logger.e("initLine");
        //线形图
        mLineChart.animateY(1000);
        mLineChart.animateX(1000);
//        mLineChart.showLineChart(clientAccumulativeRate2, "我的收益", getResources().getColor(R.color.them_colors));
//        mLineChart.addLine(compositeIndexShenzhen2, "上证指数", getResources().getColor(R.color.black));
    }


    private void initHorizontalBarChart() {
        mHorizontalBarChart.loadData();
    }


    @Override
    public void initListener() {

        addView(customPieChart);
        addView(mLineChart);
        addView(mSingleBarChart);
        addView(mManyBarChart);


        //饼状图
        PieChartView pieChartView = (PieChartView) findViewById(R.id.pie_chart);
        List<PieChartView.PieceDataHolder> pieceDataHolders = new ArrayList<>();
        pieceDataHolders.add(new PieChartView.PieceDataHolder(100, 0xFF77CCAA, "今天，１"));
        pieceDataHolders.add(new PieChartView.PieceDataHolder(1000, 0xFF11AA33, "明天，２"));
        pieceDataHolders.add(new PieChartView.PieceDataHolder(1200, Color.GRAY, "就是风，３"));
        pieceDataHolders.add(new PieChartView.PieceDataHolder(1200, Color.GRAY, "就是风，３"));
        pieceDataHolders.add(new PieChartView.PieceDataHolder(1200, Color.GRAY, "就是风，３"));
        pieceDataHolders.add(new PieChartView.PieceDataHolder(1200, Color.GRAY, "就是风，３"));
        pieceDataHolders.add(new PieChartView.PieceDataHolder(1200, Color.GRAY, "就是风，３"));
        pieceDataHolders.add(new PieChartView.PieceDataHolder(5000, Color.YELLOW, "呵呵，４"));
        pieceDataHolders.add(new PieChartView.PieceDataHolder(10000, Color.RED, "小京，５"));
        pieceDataHolders.add(new PieChartView.PieceDataHolder(13000, Color.BLUE, "花花，６"));
        pieChartView.setData(pieceDataHolders);

    }

    @Override
    protected void onPageSelected(int pager) {
        Logger.e(pager + "");
        if (pager == 1) {
            initPie();
        } else if (pager == 2) {
            initLine();
        } else if (pager == 3) {
            initSBar();
        } else if (pager == 0) {
            initMBar();
        }
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


    /**
     * 得到json文件中的内容
     *
     * @param context
     * @param fileName
     * @return
     */
    public static String getJson(Context context, String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        //获得assets资源管理器
        AssetManager assetManager = context.getAssets();
        //使用IO流读取json文件内容
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName), "utf-8"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

}