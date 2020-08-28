package com.jt.display.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.TextView;

import com.jt.display.R;
import com.jt.display.base.ListBaseAdapter;
import com.jt.display.base.SuperViewHolder;


public class TopCostAdapter extends ListBaseAdapter<String> {


    public TopCostAdapter(Context context) {
        super(context);
    }


    @Override
    public int getLayoutId() {
        return R.layout.item_acceptance_detail;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindItemHolder(SuperViewHolder holder, final int position) {
        TextView tvCode = holder.getView(R.id.tv);

        if (position == 0) {
            tvCode.setText("");
        } else if (position <= 10) {
            tvCode.setText("客户" + (position - 1));
        } else if (position % 11 == 0) {
            tvCode.setText("城市" + (position / 11 - 1));
        } else if (position % 11 == 1) {
            tvCode.setText("本月" + (position / 11 - 1));
        }


//        tvCode.setText(mDataList.get(position));
    }

}
