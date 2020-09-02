package com.jt.display.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.jt.display.R;
import com.jt.display.base.ListBaseAdapter;
import com.jt.display.base.SuperViewHolder;
import com.jt.display.bean.CurrentDeliveryPlanBean;
import com.jt.display.bean.CurrentDeliveryPlanBean.DataBean.DeliveryPlanListBean;
import com.jt.display.bean.CurrentReceivePlanBean;
import com.jt.display.bean.CurrentReceivePlanBean.DataBean.ReceiveWarePlanListBean;
import com.jt.display.bean.DeliveryBean.DataBean.DirectDeliveryBean.DirectDeliveryCarListBean;


public class CurrentDeliveryPlanAdapter extends ListBaseAdapter<DeliveryPlanListBean> {


    public CurrentDeliveryPlanAdapter(Context context) {
        super(context);
    }


    @Override
    public int getLayoutId() {
        return R.layout.item_current_delivery;
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

//        float charge = Float.parseFloat(mDataList.get(position).getTransCharge()) +
//                Float.parseFloat(mDataList.get(position).getLoadCarCharge()) +
//                Float.parseFloat(mDataList.get(position).getOtherCharge());

        tvDriver.setVisibility(View.GONE);
        tvLicence.setText(mDataList.get(position).getLicense());
        tvVolume.setText(mDataList.get(position).getVolume());
        tvCost.setText(mDataList.get(position).getCartonNum());
        tvSCost.setText(TextUtils.isEmpty(mDataList.get(position).getCarReadyTime()) ? "无" :
                mDataList.get(position).getCarReadyTime());

    }

}
