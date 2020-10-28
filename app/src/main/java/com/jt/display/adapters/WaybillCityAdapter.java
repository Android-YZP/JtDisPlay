package com.jt.display.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.jt.display.R;
import com.jt.display.base.ListBaseAdapter;
import com.jt.display.base.SuperViewHolder;
import com.jt.display.bean.CurrentDeliveryPlanBean.DataBean.DeliveryPlanListBean;
import com.jt.display.bean.WaybillAgingCityBean;


public class WaybillCityAdapter extends ListBaseAdapter<WaybillAgingCityBean.DataBean.RecordsBean> {


    public WaybillCityAdapter(Context context) {
        super(context);
    }


    @Override
    public int getLayoutId() {
        return R.layout.item_waybill_city;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindItemHolder(SuperViewHolder holder, final int position) {
//        View rootView = holder.getView(R.id.ll_root_view);
        TextView tvLicence = holder.getView(R.id.tv_licence);
        TextView tvDriver = holder.getView(R.id.tv_driver);
        TextView tvVolume = holder.getView(R.id.tv_volume);
        TextView tvCost = holder.getView(R.id.tv_cost);
        TextView tvSCost = holder.getView(R.id.tv_s_cost);
        TextView tvSDaBiao = holder.getView(R.id.tv_s_dabiao);

        tvLicence.setText(mDataList.get(position).getCityName());
        tvDriver.setText(mDataList.get(position).getAllNum() + "");
        tvVolume.setText(mDataList.get(position).getErroNum() + "");
        tvCost.setText(mDataList.get(position).getTimeOutNum() + "");
        tvSCost.setText(mDataList.get(position).getNormalNum() + "");

        float i = (float) mDataList.get(position).getNormalNum()*100 / (float) mDataList.get(position).getAllNum();
        tvSDaBiao.setText(String.format("%.2f", i)+"%");

    }

}
