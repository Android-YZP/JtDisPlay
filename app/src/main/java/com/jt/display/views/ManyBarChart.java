package com.jt.display.views;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.ColorRes;
import android.util.AttributeSet;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.jt.display.R;
import com.jt.display.bean.BarJsonBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class ManyBarChart extends BarChart {

    private XAxis xAxis;                //X轴
    private Legend legend;              //图例
    private YAxis leftAxis;             //左侧Y轴
    private YAxis rightAxis;            //右侧Y轴

    public ManyBarChart(Context context) {
        super(context);
        initBarChart(this);
    }

    public ManyBarChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        initBarChart(this);
    }

    public ManyBarChart(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initBarChart(this);
    }


    /**
     * 圆柱图
     */
    /**
     * 初始化BarChart图表
     */
    private void initBarChart(BarChart barChart) {
        /***图表设置***/
        setNoDataText("正在加载中....");
        //背景颜色
        barChart.setBackgroundColor(Color.parseColor("#0f1e3d"));
        //不显示图表网格
        barChart.setDrawGridBackground(false);
        //背景阴影
        barChart.setDrawBarShadow(false);
        barChart.setHighlightFullBarEnabled(false);
        //显示边框
        barChart.setDrawBorders(false);
        //不显示右下角类容
        setExtraOffsets(0, 30, 0, 0);
        //设置动画效果
        barChart.animateY(1000, Easing.EasingOption.Linear);
        barChart.animateX(1000, Easing.EasingOption.Linear);

        barChart.setAutoScaleMinMaxEnabled(true);
        //禁止所有事件
        barChart.setTouchEnabled(false);
        /***XY轴的设置***/
        //X轴设置显示位置在底部
        xAxis = barChart.getXAxis();
        leftAxis = barChart.getAxisLeft();
        rightAxis = barChart.getAxisRight();

        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);

        //不显示X轴 Y轴线条
        xAxis.setDrawAxisLine(false);
        leftAxis.setDrawAxisLine(true);
        rightAxis.setDrawAxisLine(false);
        //不显示左侧Y轴
        leftAxis.setEnabled(true);
        rightAxis.setEnabled(false);
        xAxis.setTextColor(Color.parseColor("#8FC7CC"));
        leftAxis.setTextColor(Color.parseColor("#8FC7CC"));
        leftAxis.setAxisLineColor(Color.TRANSPARENT);
        //不显示X轴网格线
        xAxis.setDrawGridLines(false);
        //右侧Y轴网格线设置为虚线
        leftAxis.enableGridDashedLine(10f, 10f, 0f);

        //保证Y轴从0开始，不然会上移一点

        xAxis.setAxisMinimum(-0.2f);
        //保证Y轴从0开始，不会显示不全
        leftAxis.setAxisMinimum(0f);
        rightAxis.setAxisMinimum(0f);
        xAxis.setCenterAxisLabels(true);


        /***折线图例 标签 设置***/
        legend = barChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setTextSize(10f);
        legend.setTextColor(Color.WHITE);
        //显示位置
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        //是否绘制在图表里面
        legend.setDrawInside(false);


    }

    //设置标题
    public void setDes(String desc,int Xposition) {
        Description description = new Description();
        description.setText(desc);
        description.setPosition(Xposition, 60);
        description.setTextSize(13f);
        description.setTextColor(Color.parseColor("#ffffff"));
        description.setEnabled(true);
        setDescription(description);
    }

    /**
     * @param xValues   X轴的值
     * @param dataLists LinkedHashMap<String, List<Float>>
     *                  key对应柱状图名字  List<Float> 对应每类柱状图的Y值
     */
    public void showBarChart(final List<String> xValues, LinkedHashMap<String, List<Float>> dataLists) {

        List<Integer> colors = Arrays.asList(
                getResources().getColor(R.color.them_colors),
                getResources().getColor(R.color.bt_focus),
                getResources().getColor(R.color.bt_focus),
                getResources().getColor(R.color.bt_focus)
        );

        List<IBarDataSet> dataSets = new ArrayList<>();
        int currentPosition = 0;//用于柱状图颜色集合的index

        for (LinkedHashMap.Entry<String, List<Float>> entry : dataLists.entrySet()) {
            String name = entry.getKey();
            List<Float> yValueList = entry.getValue();

            List<BarEntry> entries = new ArrayList<>();

            for (int i = 0; i < yValueList.size(); i++) {
                entries.add(new BarEntry(i, yValueList.get(i)));
            }
            // 每一个BarDataSet代表一类柱状图
            BarDataSet barDataSet = new BarDataSet(entries, name);
            initBarDataSet(barDataSet, colors.get(currentPosition));
            dataSets.add(barDataSet);
            xAxis.setAxisMaximum((float) yValueList.size() + 0.2f);

            currentPosition++;
        }

        //X轴自定义值
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return value == -1 ? "" : xValues.get((int) Math.abs(value) % xValues.size());
            }
        });

        //右侧Y轴自定义值
        rightAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return (int) (value) + "%";
            }
        });
        xAxis.setTextSize(8f);
        leftAxis.setTextSize(8f);
        BarData data = new BarData(dataSets);
        /**
         * float groupSpace = 0.3f;   //柱状图组之间的间距
         * float barSpace =  0.05f;  //每条柱状图之间的间距  一组两个柱状图
         * float barWidth = 0.3f;    //每条柱状图的宽度     一组两个柱状图
         * (barWidth + barSpace) * barAmount + groupSpace = (0.3 + 0.05) * 2 + 0.3 = 1.00
         * 3个数值 加起来 必须等于 1 即100% 按照百分比来计算 组间距 柱状图间距 柱状图宽度
         */
        int barAmount = dataLists.size(); //需要显示柱状图的类别 数量
        //设置组间距占比30% 每条柱状图宽度占比 70% /barAmount  柱状图间距占比 0%
        float groupSpace = 0.1f; //柱状图组之间的间距
        float barSpace = 0f;
        float barWidth = (1f - groupSpace - barSpace) / barAmount;
        //设置柱状图宽度
        data.setBarWidth(barWidth);
        //(起始点、柱状图组间距、柱状图之间间距)
        data.groupBars(0f, groupSpace, barSpace);
        setData(data);

    }

    /**
     * 柱状图始化设置 一个BarDataSet 代表一列柱状图
     *
     * @param barDataSet 柱状图
     * @param color      柱状图颜色
     */
    private void initBarDataSet(BarDataSet barDataSet, int color) {
        barDataSet.setColor(color);
        barDataSet.setFormLineWidth(1f);
        barDataSet.setFormSize(15.f);
        //不显示柱状图顶部值
        barDataSet.setDrawValues(false);

//        barDataSet.setValueTextSize(10f);
//        barDataSet.setValueTextColor(color);

    }

    public LinkedHashMap<String, List<Float>> initYData(BarJsonBean barJsonBean) {
        //处理数据是 记得判断每条柱状图对应的数据集合 长度是否一致
        LinkedHashMap<String, List<Float>> chartDataMap = new LinkedHashMap<>();
        List<Float> yValue1 = new ArrayList<>();
        List<Float> yValue2 = new ArrayList<>();

        List<BarJsonBean.StFinDateBean.VtDateValueBean> valueList = barJsonBean.getStFinDate().getVtDateValue();
        List<BarJsonBean.StFinDateBean.VtDateValueAvgBean> avgValueList = barJsonBean.getStFinDate().getVtDateValueAvg();
        Collections.reverse(valueList);

        for (BarJsonBean.StFinDateBean.VtDateValueBean valueBean : valueList) {
            yValue1.add((float) valueBean.getFValue());
        }
        for (BarJsonBean.StFinDateBean.VtDateValueAvgBean valueAvgBean : avgValueList) {
            yValue2.add((float) valueAvgBean.getFValue());
        }

        chartDataMap.put("净资产收益率（%）", yValue1);
        chartDataMap.put("行业平均值（%）", yValue2);
        return chartDataMap;
    }

    public List<String> initXData(BarJsonBean barJsonBean) {
        //处理数据是 记得判断每条柱状图对应的数据集合 长度是否一致
        LinkedHashMap<String, List<Float>> chartDataMap = new LinkedHashMap<>();
        List<String> xValues = new ArrayList<>();

        List<BarJsonBean.StFinDateBean.VtDateValueBean> valueList = barJsonBean.getStFinDate().getVtDateValue();
        Collections.reverse(valueList);
        for (BarJsonBean.StFinDateBean.VtDateValueBean valueBean : valueList) {
            xValues.add(valueBean.getSYearMonth());
        }
        return xValues;
    }


}
