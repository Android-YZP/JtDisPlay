package com.jt.display.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.TextView;

import com.jt.display.R;
import com.jt.display.base.ListBaseAdapter;
import com.jt.display.base.SuperViewHolder;
import com.jt.display.bean.TopAndDownCustomerBean;
import com.jt.display.utils.GsonUtil;
import com.orhanobut.logger.Logger;


public class TopBottomAdapter extends ListBaseAdapter<TopAndDownCustomerBean.DataBean> {

    public TopBottomAdapter(Context context) {
        super(context);
    }


    @Override
    public int getLayoutId() {
        return R.layout.item_top_bottom;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindItemHolder(SuperViewHolder holder, final int position) {
        int p = position + 4;
        TopAndDownCustomerBean.DataBean dataBean = mDataList.get(0);
        TextView tvCode = holder.getView(R.id.tv);
        if (position % 4 == 0) {
            tvCode.setText(dataBean.getTopCustomerList().get((p / 4 - 1)).getCustomerName());
        } else if (position % 4 == 1) {
            tvCode.setText(dataBean.getTopCustomerList().get((p / 4 - 1)).getSumAmount());
        } else if (position % 4 == 2) {
            tvCode.setText(dataBean.getDownCustomerList().get((p / 4 - 1)).getCustomerName());
        } else if (position % 4 == 3) {
            tvCode.setText(dataBean.getDownCustomerList().get((p / 4 - 1)).getSumAmount());
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size() > 0 ? 40 : 0;
    }
}
