package com.jt.display.views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.jt.display.R;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class HBarChart extends HorizontalBarChart {
    public HBarChart(Context context) {
        super(context);
        setYAxis();
    }

    public HBarChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        setYAxis();
    }

    public HBarChart(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setYAxis();
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

    //设置y轴
    private void setYAxis() {
        setBackgroundColor(Color.parseColor("#0f1e3d"));
        //两边的y轴都要设置y轴的最小值才能在柱状图上面显示数值
        //不然是看不到效果的
        setNoDataText("正在加载中....");
        YAxis tepAxis = getAxisLeft();
//        tepAxis.setAxisMaximum(80f);
        tepAxis.setAxisMinimum(0f);
        tepAxis.setEnabled(false);

        YAxis yAxis = getAxisRight();
        yAxis.setTextColor(Color.parseColor("#8FC7CC"));
        yAxis.setTextSize(8f);
        yAxis.setAxisMinimum(0f);
        yAxis.enableGridDashedLine(10f, 10f, 0f);
//        yAxis.setAxisMaximum(80f);
        setAutoScaleMinMaxEnabled(true);
        //自定义样式
        yAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return value + "";
            }
        });
    }


    //设置x轴
    private void setXAxis(final List<String> xstrings) {
        XAxis xAxis = getXAxis();
        xAxis.setTextSize(10f);
        xAxis.setAxisMaximum(2f);
        //把最小值设置为负数能够为下方留出点空白距离
        xAxis.setAxisMinimum(-0.5f);

        xAxis.setCenterAxisLabels(true);
        xAxis.setDrawGridLines(false);
        //将x轴显示在左侧
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setLabelCount(0);
        //自定义样式
        xAxis.setAxisLineColor(Color.GRAY);


        xAxis.setTextColor(Color.parseColor("#8FC7CC"));

        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return value == 0f ? xstrings.get((int) value) : "";
            }
        });
        //设置x轴的偏移量
        xAxis.setXOffset(15f);
    }


    //加载数据
    public void loadData(List<Integer> colors, List<String> xstrings, LinkedHashMap<String, List<String>> ystring) {
        setXAxis(xstrings);
        //不绘制图例
        Legend legend = getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setTextSize(7f);
        legend.setTextColor(Color.WHITE);
        //显示位置
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);

        //是否绘制在图表里面
        legend.setDrawInside(false);
        //自动对齐
        setFitBars(true);
        setExtraOffsets(0, 30, 0, 0);
        //将文本绘制在柱块上还是柱块里面
        setDrawValueAboveBar(true);

        List<IBarDataSet> dataSets = new ArrayList<>();
        int currentPosition = 0;//用于柱状图颜色集合的index

        for (LinkedHashMap.Entry<String, List<String>> entry : ystring.entrySet()) {
            String name = entry.getKey();
            List<String> yValueList = entry.getValue();


            final List<BarEntry> entries = new ArrayList<BarEntry>();

            for (int j = 0; j < yValueList.size(); j++) {
                entries.add(new BarEntry(j, Float.parseFloat(yValueList.get(j))));
            }

            BarDataSet barDataSet = new BarDataSet(entries, name);
            barDataSet.setValueTextSize(16f);//柱块上的字体大小
            barDataSet.setValueTextColor(Color.RED);//柱块上的字体颜色
            barDataSet.setValueTypeface(Typeface.DEFAULT_BOLD);//加粗
            //自自定义样式
            barDataSet.setValueFormatter(new IValueFormatter() {
                @Override
                public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                    return "";//保留两位小数
                }
            });
            //依次设置每次柱块的颜色
            barDataSet.setColors(colors.get(currentPosition++));
            dataSets.add(barDataSet);
        }

        BarData barData = new BarData(dataSets);
        int barAmount = 2; //需要显示柱状图的类别 数量
        float groupSpace = 0.3f; //柱状图组之间的间距
        float barWidth = (1f - groupSpace) / barAmount;
        float barSpace = 0.01f;
        barData.setBarWidth(barWidth);
        barData.groupBars(-0.5f, groupSpace, barSpace);

        setData(barData);
        invalidate();
    }

}
