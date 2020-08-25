package com.jt.display.views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.jt.display.R;
import com.jt.display.bean.lineChartBean;
import com.jt.display.utils.DateUtil;
import com.jt.display.utils.GsonUtil;
import com.orhanobut.logger.Logger;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class CLineChart extends LineChart {
    private XAxis xAxis;                //X轴
    private YAxis leftYAxis;            //左侧Y轴
    private YAxis rightYaxis;           //右侧Y轴
    private Legend legend;              //图例

    public CLineChart(Context context) {
        super(context);
        initChart(this);
    }

    public CLineChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        initChart(this);
    }

    public CLineChart(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initChart(this);
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
     * 线形图
     */
    private void initChart(LineChart lineChart) {
        /***图表设置***/
        setNoDataText("正在加载中....");
        //是否展示网格线
        lineChart.setDrawGridBackground(false);
        //是否显示边界
        lineChart.setDrawBorders(false);
        //是否可以拖动
        lineChart.setDragEnabled(false);
        //是否有触摸事件
        lineChart.setTouchEnabled(true);
        lineChart.setBackgroundColor(Color.parseColor("#0f1e3d"));
        //设置XY轴动画效果
        lineChart.animateY(1000);
        lineChart.animateX(1000);
        //右下角的刻度显示


        /***XY轴的设置***/
        xAxis = lineChart.getXAxis();
        leftYAxis = lineChart.getAxisLeft();
        rightYaxis = lineChart.getAxisRight();


        xAxis.setDrawGridLines(false);
        rightYaxis.setDrawGridLines(false);
        leftYAxis.setDrawGridLines(true);
        rightYaxis.setEnabled(false);
        //设置X Y轴网格线为虚线（实体线长度、间隔距离、偏移量：通常使用 0）
        leftYAxis.enableGridDashedLine(10f, 10f, 0f);

        //X轴设置显示位置在底部
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisMinimum(-0.2f);
        xAxis.setGranularity(1f);

        //保证Y轴从0开始，不然会上移一点
        leftYAxis.setAxisMinimum(0f);

        //X,Y轴数据设置
        leftYAxis.setAxisLineColor(Color.TRANSPARENT);
        leftYAxis.setTextColor(Color.parseColor("#8FC7CC"));
        xAxis.setTextColor(Color.parseColor("#8FC7CC"));
        xAxis.setAxisLineColor(Color.TRANSPARENT);

//        //是否启用绘制零线:设置为true后才有后面的操作
//        leftYAxis.setDrawZeroLine(false);
//        //设置绘制零线宽度
//        leftYAxis.setZeroLineWidth(1.2f);
//        //绘制零线颜色
//        leftYAxis.setZeroLineColor(Color.YELLOW);


        /***折线图例 标签 设置***/
        legend = lineChart.getLegend();
        //设置显示类型，LINE CIRCLE SQUARE EMPTY 等等 多种方式，查看LegendForm 即可
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setTextSize(10f);
        legend.setTextColor(Color.WHITE);
        //显示位置 左下方
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        //是否绘制在图表里面
        legend.setDrawInside(false);
        legend.setEnabled(true);
    }


//    /**
//     * 设置线条填充背景颜色
//     *
//     * @param drawable
//     */
//    public void setChartFillDrawable(Drawable drawable) {
//        if (getData() != null && getData().getDataSetCount() > 0) {
//            LineDataSet lineDataSet = (LineDataSet) getData().getDataSetByIndex(0);
//            //避免在 initLineDataSet()方法中 设置了 lineDataSet.setDrawFilled(false); 而无法实现效果
//            lineDataSet.setDrawFilled(true);
//            lineDataSet.setFillDrawable(drawable);
//            invalidate();
//        }
//    }


    /**
     * 展示曲线
     *
     */
    public void showLineChart(final List<String> XValue, LinkedHashMap<String, List<Float>> YValue) {
        List<ILineDataSet> dataSets = new ArrayList<>();

        List<Integer> colors = Arrays.asList(
                getResources().getColor(R.color.them_colors),
                getResources().getColor(R.color.white),
                getResources().getColor(R.color.bt_focus),
                getResources().getColor(R.color.button_background)
        );
        int currentPosition = 0;
        for (LinkedHashMap.Entry<String, List<Float>> entry : YValue.entrySet()) {
            String key = entry.getKey();
            List<Float> yValueList = entry.getValue();
            List<Entry> entries = new ArrayList<>();
            for (int i = 0; i < yValueList.size(); i++) {

                /**
                 * 在此可查看 Entry构造方法，可发现 可传入数值 Entry(float x, float y)
                 * 也可传入Drawable， Entry(float x, float y, Drawable icon) 可在XY轴交点 设置Drawable图像展示
                 */
                Entry entry1 = new Entry(i, yValueList.get(i));
                entries.add(entry1);
            }
            // 每一个LineDataSet代表一条线
            LineDataSet lineDataSet = new LineDataSet(entries, key);
            initLineDataSet(lineDataSet, colors.get(currentPosition), LineDataSet.Mode.LINEAR);
            dataSets.add(lineDataSet);
            currentPosition++;
            xAxis.setAxisMaximum((float) yValueList.size() - 0.7f);
        }

        LineData lineData = new LineData(dataSets);
        setData(lineData);
        //  X轴值的定义 在 showLineChart 方法中我们会传入X轴的值，所以自定义X轴的值可以 写在该方法内
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return value == -1 ? "" : XValue.get((int) value % XValue.size()) + "";
            }
        });

        //Y轴值的自定义
        leftYAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return (value) + "";
            }
        });


    }


    /**
     * 曲线初始化设置 一个LineDataSet 代表一条曲线
     *
     * @param lineDataSet 线条
     * @param color       线条颜色
     * @param mode
     */
    private void initLineDataSet(LineDataSet lineDataSet, int color, LineDataSet.Mode mode) {
        lineDataSet.setColor(color);
        lineDataSet.setCircleColor(color);
        lineDataSet.setLineWidth(1f);
        lineDataSet.setCircleRadius(3f);
        //设置曲线值的圆点是实心还是空心
        lineDataSet.setDrawCircleHole(false);
        lineDataSet.setValueTextSize(10f);
        //设置折线图填充
        lineDataSet.setDrawFilled(false);
        lineDataSet.setFormLineWidth(1f);
        lineDataSet.setFormSize(15.f);
        //不显示点
        lineDataSet.setDrawCircles(false);
        //不显示值
        lineDataSet.setDrawValues(false);
        //线条值的更改
        lineDataSet.setValueFormatter(new IValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                DecimalFormat df = new DecimalFormat(".00");
                return df.format(value * 100) + "%";
            }
        });


        if (mode == null) {
            //设置曲线展示为圆滑曲线（如果不设置则默认折线）
            lineDataSet.setMode(LineDataSet.Mode.LINEAR);
        } else {
            lineDataSet.setMode(LineDataSet.Mode.LINEAR);
        }
    }


}
