package com.jt.display.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jt.display.R;
import com.jt.display.base.ListBaseAdapter;
import com.jt.display.base.SuperViewHolder;
import com.jt.display.bean.CustomerChannelCityOrderCostReportBean;


public class TopCostAdapter extends ListBaseAdapter<CustomerChannelCityOrderCostReportBean.DataBean> {


    public TopCostAdapter(Context context) {
        super(context);
    }


    @Override
    public int getLayoutId() {
        return R.layout.item_top10_cost;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindItemHolder(SuperViewHolder holder, int position) {
        TextView tvCurrent = holder.getView(R.id.tv_current);
        TextView tvArrow = holder.getView(R.id.tv_arrow);
        TextView tvLast = holder.getView(R.id.tv_last);
        tvCurrent.setSelected(true);
//        position = position ;

        if (position == 0) {
            tvCurrent.setText("");
            tvArrow.setText("");
            tvLast.setText("");
        } else if (position <= 5 && position > 0) {
            tvCurrent.setText(mDataList.get(0).getCustomerList().get(position - 1));
            tvArrow.setText("");
            tvLast.setText("");
        } else if (position % 6 == 0) {
            tvCurrent.setText(mDataList.get(0).getChannelList().get(position / 6 - 1));
            tvArrow.setText("");
            tvLast.setText("");
        } else if (position % 6 == 1) {
            float lastMonthOrderCost = Float.parseFloat(mDataList.get(0).getCustomerCityOrderCostList().get(0).
                    getCustomerCityOrderCostList().get(position / 6 - 1).getLastMonthOrderCost());
            float currentMonthOrderCost = Float.parseFloat(mDataList.get(0).getCustomerCityOrderCostList().get(0).
                    getCustomerCityOrderCostList().get(position / 6 - 1).getCurrentMonthOrderCost());
            parseData(tvCurrent, tvArrow, tvLast, lastMonthOrderCost, currentMonthOrderCost);

        } else if (position % 6 == 2) {
            float lastMonthOrderCost = Float.parseFloat(mDataList.get(0).getCustomerCityOrderCostList().get(1).
                    getCustomerCityOrderCostList().get(position / 6 - 1).getLastMonthOrderCost());
            float currentMonthOrderCost = Float.parseFloat(mDataList.get(0).getCustomerCityOrderCostList().get(1).
                    getCustomerCityOrderCostList().get(position / 6 - 1).getCurrentMonthOrderCost());
            parseData(tvCurrent, tvArrow, tvLast, lastMonthOrderCost, currentMonthOrderCost);

        } else if (position % 6 == 3) {
            float lastMonthOrderCost = Float.parseFloat(mDataList.get(0).getCustomerCityOrderCostList().get(2).
                    getCustomerCityOrderCostList().get(position / 6 - 1).getLastMonthOrderCost());
            float currentMonthOrderCost = Float.parseFloat(mDataList.get(0).getCustomerCityOrderCostList().get(2).
                    getCustomerCityOrderCostList().get(position / 6 - 1).getCurrentMonthOrderCost());
            parseData(tvCurrent, tvArrow, tvLast, lastMonthOrderCost, currentMonthOrderCost);

        } else if (position % 6 == 4) {
            float lastMonthOrderCost = Float.parseFloat(mDataList.get(0).getCustomerCityOrderCostList().get(3).
                    getCustomerCityOrderCostList().get(position / 6 - 1).getLastMonthOrderCost());
            float currentMonthOrderCost = Float.parseFloat(mDataList.get(0).getCustomerCityOrderCostList().get(3).
                    getCustomerCityOrderCostList().get(position / 6 - 1).getCurrentMonthOrderCost());
            parseData(tvCurrent, tvArrow, tvLast, lastMonthOrderCost, currentMonthOrderCost);

        } else if (position % 6 == 5) {
            float lastMonthOrderCost = Float.parseFloat(mDataList.get(0).getCustomerCityOrderCostList().get(4).
                    getCustomerCityOrderCostList().get(position / 6 - 1).getLastMonthOrderCost());
            float currentMonthOrderCost = Float.parseFloat(mDataList.get(0).getCustomerCityOrderCostList().get(4).
                    getCustomerCityOrderCostList().get(position / 6 - 1).getCurrentMonthOrderCost());
            parseData(tvCurrent, tvArrow, tvLast, lastMonthOrderCost, currentMonthOrderCost);

        } else {
            tvCurrent.setText("");
            tvArrow.setText("");
            tvLast.setText("");
        }
    }

    @SuppressLint("SetTextI18n")
    private void parseData(TextView tvCurrent, TextView tvArrow, TextView tvLast, float lastMonthOrderCost, float currentMonthOrderCost) {
        if (currentMonthOrderCost - lastMonthOrderCost > 0) {//增长
            tvCurrent.setText(currentMonthOrderCost == 0f ? "0" : (int)currentMonthOrderCost + "");
            tvArrow.setText("⬆");
            tvArrow.setTextColor(Color.GREEN);
            tvLast.setText((int)lastMonthOrderCost - (int)currentMonthOrderCost + "");
        } else if (currentMonthOrderCost - lastMonthOrderCost < 0) {//减少
            tvCurrent.setText(currentMonthOrderCost == 0f ? "0" : (int)currentMonthOrderCost + "");
            tvArrow.setText("⬇");
            tvArrow.setTextColor(Color.RED);
            tvLast.setText((int)lastMonthOrderCost - (int)currentMonthOrderCost + "");
        } else if (currentMonthOrderCost - lastMonthOrderCost == 0) {//持平
            tvCurrent.setText(currentMonthOrderCost == 0f ? "0" : (int)currentMonthOrderCost + "");
            tvArrow.setText("-");
            tvArrow.setTextColor(Color.GRAY);
            tvLast.setText("");
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size() > 0 ? (mDataList.get(0).getChannelList().size() + 1) * 6 : 0;
    }
}
