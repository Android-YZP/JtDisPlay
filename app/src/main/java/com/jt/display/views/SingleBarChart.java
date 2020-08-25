package com.jt.display.views;

import android.content.Context;
import android.graphics.Color;
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
import com.jt.display.bean.BarJsonBean;

import java.util.ArrayList;
import java.util.List;

public class SingleBarChart extends BarChart {
    private YAxis leftAxis;             //左侧Y轴
    private YAxis rightAxis;            //右侧Y轴
    private XAxis xAxis;                //X轴
    private YAxis leftYAxis;            //左侧Y轴
    private YAxis rightYaxis;           //右侧Y轴
    private Legend legend;              //图例

    public SingleBarChart(Context context) {
        super(context);
        initBarChart(this);
    }

    public SingleBarChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        initBarChart(this);
    }

    public SingleBarChart(Context context, AttributeSet attrs, int defStyle) {
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
        //背景颜色
        barChart.setBackgroundColor(Color.parseColor("#ffffff"));
        //不显示图表网格
        barChart.setDrawGridBackground(false);
        //背景阴影
        barChart.setDrawBarShadow(false);
        barChart.setHighlightFullBarEnabled(false);
        //显示边框
        barChart.setDrawBorders(false);
        //不显示右下角类容
        Description description = new Description();
        description.setEnabled(false);
        barChart.setDescription(description);

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

        //不显示X轴网格线
        xAxis.setDrawGridLines(false);
        //右侧Y轴网格线设置为虚线
        rightAxis.enableGridDashedLine(0f, 10f, 0f);

        //保证Y轴从0开始，不然会上移一点

//        xAxis.setAxisMinimum(0f);
        //保证Y轴从0开始，不会显示不全
        leftAxis.setAxisMinimum(0f);
//        rightAxis.setAxisMinimum(0f);
//        xAxis.setAxisMaximum(5);

//        xAxis.setCenterAxisLabels(true);

        /***折线图例 标签 设置***/
        legend = barChart.getLegend();
        legend.setForm(Legend.LegendForm.LINE);
        legend.setTextSize(18f);
        legend.setTextColor(Color.BLACK);
        //显示位置
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        //是否绘制在图表里面
        legend.setDrawInside(false);


    }


    public void showBarChart(final List<BarJsonBean.StFinDateBean.VtDateValueBean> dateValueList, String name, int color) {
        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i < dateValueList.size(); i++) {
            /**
             * 此处还可传入Drawable对象 BarEntry(float x, float y, Drawable icon)
             * 即可设置柱状图顶部的 icon展示
             */
            BarEntry barEntry = new BarEntry(i, (float) dateValueList.get(i).getFValue());
            entries.add(barEntry);
        }

        // 每一个BarDataSet代表一类柱状图
        BarDataSet barDataSet = new BarDataSet(entries, name);

        BarData data = new BarData(barDataSet);
        data.setBarWidth(0.5f);
        setData(data);
        initBarDataSet(barDataSet, color);

        //X轴自定义值
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return dateValueList.get((int) Math.abs(value) % dateValueList.size()).getSYearMonth();
            }
        });
        //右侧Y轴自定义值
        rightAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return ((int) (value * 100)) + "%";
            }
        });
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

}
