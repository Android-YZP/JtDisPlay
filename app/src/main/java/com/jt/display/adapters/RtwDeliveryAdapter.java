package com.jt.display.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.TextView;

import com.jt.display.R;
import com.jt.display.base.ListBaseAdapter;
import com.jt.display.base.SuperViewHolder;
import com.jt.display.bean.DeliveryBean;
import com.jt.display.bean.DeliveryBean.DataBean.DirectDeliveryBean.DirectDeliveryCarListBean;
import com.jt.display.bean.DeliveryBean.DataBean.RtwDeliveryBean.RtwDeliveryCarListBean;


public class RtwDeliveryAdapter extends ListBaseAdapter<RtwDeliveryCarListBean> {


    public RtwDeliveryAdapter(Context context) {
        super(context);
    }


    @Override
    public int getLayoutId() {
        return R.layout.item_direct_delivery;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindItemHolder(SuperViewHolder holder, final int position) {
        TextView tvCode = holder.getView(R.id.tv);
        TextView tvLicence = holder.getView(R.id.tv_licence);
        TextView tvDriver = holder.getView(R.id.tv_driver);
        TextView tvVolume = holder.getView(R.id.tv_volume);
        TextView tvCost = holder.getView(R.id.tv_cost);
        TextView tvSCost = holder.getView(R.id.tv_s_cost);


        float charge = Float.parseFloat(mDataList.get(position).getTransCharge()) +
                Float.parseFloat(mDataList.get(position).getLoadCarCharge()) +
                Float.parseFloat(mDataList.get(position).getOtherCharge());

        tvLicence.setText(mDataList.get(position).getLicense());
        tvDriver.setText(mDataList.get(position).getLinkMan());
        tvVolume.setText(mDataList.get(position).getVolume());
        tvCost.setText(charge + "");
        tvSCost.setText(mDataList.get(position).getCost()+ "");
    }

}
