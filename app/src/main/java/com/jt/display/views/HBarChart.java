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

import java.util.ArrayList;
import java.util.List;

public class HBarChart extends HorizontalBarChart {
    public HBarChart(Context context) {
        super(context);
        setXAxis();
        setYAxis();
    }

    public HBarChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        setXAxis();
        setYAxis();
    }

    public HBarChart(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setXAxis();
        setYAxis();
    }

    //设置标题
    public void setDes() {
        Description description = new Description();
        description.setText("违章车辆的违章次数占比分布图统计");
        description.setTextSize(20f);
        description.setTextColor(Color.BLACK);
        description.setPosition(0, 40);
        setDescription(description);
    }

    //设置y轴
    private void setYAxis() {
        //两边的y轴都要设置y轴的最小值才能在柱状图上面显示数值
        //不然是看不到效果的
        YAxis tepAxis = getAxisLeft();
        tepAxis.setAxisMaximum(80f);
        tepAxis.setAxisMinimum(0f);
        tepAxis.setEnabled(false);

        YAxis yAxis = getAxisRight();
        yAxis.setTextSize(12f);
        yAxis.setAxisMinimum(0f);
        yAxis.setAxisMaximum(80f);
        //自定义样式
        yAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return (int) value + "%";
            }
        });
    }


    //设置x轴
    private void setXAxis() {
        XAxis xAxis = getXAxis();
        xAxis.setTextSize(16);
        xAxis.setAxisMaximum(1.3f);
        //把最小值设置为负数能够为下方留出点空白距离
        xAxis.setAxisMinimum(-0.5f);

        xAxis.setCenterAxisLabels(true);
        xAxis.setDrawGridLines(false);
        //将x轴显示在左侧
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setLabelCount(0);
        //自定义样式
        final String ss[] = {"5条以上违章", "3-5条违章", "1-2条违章"};
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return ss[(int) value];
            }
        });
        //设置x轴的偏移量
        xAxis.setXOffset(15f);
    }


    //加载数据
    public void loadData() {
        //不绘制图例
        getLegend().setEnabled(false);
        //自动对齐
        setFitBars(true);
        setExtraOffsets(20, 50, 30, 30);
        //将文本绘制在柱块上还是柱块里面
        setDrawValueAboveBar(true);

        List<IBarDataSet> dataSets = new ArrayList<>();


        for (int i = 0; i < 4; i++) {
            //从下往上绘制
            final List<BarEntry> entries = new ArrayList<BarEntry>();
            float da[] = {60.51f};

            for (int j = 0; j < da.length; j++) {
                entries.add(new BarEntry(j, da[j]));
            }

            BarDataSet barDataSet = new BarDataSet(entries, "");
            barDataSet.setValueTextSize(16f);//柱块上的字体大小
            barDataSet.setValueTextColor(Color.RED);//柱块上的字体颜色
            barDataSet.setValueTypeface(Typeface.DEFAULT_BOLD);//加粗
            //自自定义样式
            barDataSet.setValueFormatter(new IValueFormatter() {
                @Override
                public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                    return String.format("%.2f", value) + "%";//保留两位小数
                }
            });
            //依次设置每次柱块的颜色
            barDataSet.setColors(getResources().getColor(R.color.background), getResources().getColor(R.color.bt_focus), getResources().getColor(R.color.text_color));

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

    }

}
