package com.jt.display.views;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class CustomPieChart extends PieChart {
    public CustomPieChart(Context context) {
        super(context);
    }

    public CustomPieChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomPieChart(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    public void showPieChart(List<PieEntry> pieList) {

        showPieChart(this, pieList);
    }

    /**
     * 饼庄图
     */
    public List<PieEntry> getPieChartData() {
        List<String> dataList = new ArrayList<>();
        dataList.add("京东科技");
        dataList.add("京东科技");
        dataList.add("京东科技");
        dataList.add("京东科技");
        dataList.add("京东科技");
        dataList.add("京东科技");
        dataList.add("京东科技");
        dataList.add("京东科技");
        dataList.add("京东科技");
        dataList.add("京东科技");
        List<PieEntry> mPie = new ArrayList<>();

        for (String data : dataList) {
            // 参数1为 value，参数2为 data。
            // 如 PieEntry(0.15F, "90分以上");  表示90分以上的人占比15%。
            PieEntry pieEntry = new PieEntry(50, data);
            pieEntry.setX(1f);
            mPie.add(pieEntry);
        }
        return mPie;
    }

    private void showPieChart(PieChart pieChart, List<PieEntry> pieList) {
        PieDataSet dataSet = new PieDataSet(pieList, "");

        // 设置颜色list，让不同的块显示不同颜色，下面是我觉得不错的颜色集合，比较亮
        ArrayList<Integer> colors = new ArrayList<Integer>();
        int[] MATERIAL_COLORS = {
                Color.rgb(150, 172, 255)
        };
        for (int c : MATERIAL_COLORS) {
            colors.add(c);
        }
        for (int c : ColorTemplate.VORDIPLOM_COLORS) {
            colors.add(c);
        }
        dataSet.setColors(colors);

        PieData pieData = new PieData(dataSet);

        // 设置描述，我设置了不显示，因为不好看，你也可以试试让它显示，真的不好看
        Description description = new Description();
        description.setEnabled(false);
        pieChart.setDescription(description);
        //设置半透明圆环的半径, 0为透明
        pieChart.setTransparentCircleRadius(0.5f);

        //设置初始旋转角度
        pieChart.setRotationAngle(-95);
        //数据连接线距图形片内部边界的距离，为百分数
        dataSet.setValueLinePart1OffsetPercentage(90f);
        //设置连接线的颜色
        dataSet.setValueLineColor(Color.WHITE);
        //中心园颜色
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setCenterText("车辆调度中心");
        pieChart.setCenterTextColor(Color.BLACK);
        pieChart.setCenterTextSize(7f);
        // 连接线在饼状图外面
        dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);//lable外部展示
        dataSet.setYValuePosition(PieDataSet.ValuePosition.INSIDE_SLICE);//value外部展示
        dataSet.setValueLinePart1Length(0.4f);//
        dataSet.setValueLinePart2Length(0.5f);//组成折线的两段折线长短


        // 设置饼块之间的间隔
        dataSet.setSliceSpace(0f);
        dataSet.setHighlightEnabled(true);
        // 不显示图例
        Legend l = pieChart.getLegend();
        l.setEnabled(true);
        l.setTextSize(7f);
        l.setTextColor(Color.WHITE);
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);

        // 和四周相隔一段距离,显示数据
        pieChart.setExtraOffsets(50, 20, 50, 20);
        // 设置pieChart图表是否可以手动旋转
        pieChart.setRotationEnabled(false);
        // 设置piecahrt图表点击Item高亮是否可用
        pieChart.setHighlightPerTapEnabled(true);
        // 设置pieChart图表展示动画效果，动画运行1.4秒结束
        pieChart.animateY(1000, Easing.EasingOption.EaseInOutQuad);
        //设置pieChart是否只显示饼图上百分比不显示文字
        pieChart.setDrawEntryLabels(true);
        //是否绘制PieChart内部中心文本
        pieChart.setDrawCenterText(true);

        // 绘制内容value，设置字体颜色大小
        pieData.setDrawValues(true);
        pieData.setValueFormatter(new PercentFormatter());
        pieData.setValueTextSize(8f);
        pieData.setValueTextColor(Color.BLACK);
        pieChart.setData(pieData);
        // 更新 piechart 视图
        pieChart.postInvalidate();
    }


}
