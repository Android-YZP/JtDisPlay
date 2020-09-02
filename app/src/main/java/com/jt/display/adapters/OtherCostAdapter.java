package com.jt.display.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.TextView;

import com.jt.display.R;
import com.jt.display.base.ListBaseAdapter;
import com.jt.display.base.SuperViewHolder;
import com.jt.display.bean.ChannelCityOrderCostReportBean;
import com.jt.display.bean.ChannelCityOrderCostReportBean.DataBean.OtherOrderCostListBean;


public class OtherCostAdapter extends ListBaseAdapter<OtherOrderCostListBean> {


    public OtherCostAdapter(Context context) {
        super(context);
    }


    @Override
    public int getLayoutId() {
        return R.layout.item_cost;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindItemHolder(SuperViewHolder holder, int position) {
        TextView tvCity = holder.getView(R.id.tv_city);
        position = position + 3;

        if (position % 3 == 0) {
            tvCity.setText(mDataList.get((position / 3 - 1)).getCityName());
        } else if (position % 3 == 1) {
            tvCity.setText(mDataList.get((position / 3 - 1)).getCurrentMonthOrderCost());
        } else if (position % 3 == 2) {
            tvCity.setText(mDataList.get((position / 3 - 1)).getLastMonthOrderCost());
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size() > 0 ? mDataList.size() * 3 : 0;
    }
}
