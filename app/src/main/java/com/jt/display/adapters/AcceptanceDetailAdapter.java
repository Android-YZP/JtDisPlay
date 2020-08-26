package com.jt.display.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.jt.display.R;
import com.jt.display.base.ListBaseAdapter;
import com.jt.display.base.SuperViewHolder;


public class AcceptanceDetailAdapter extends ListBaseAdapter<String> {


    public AcceptanceDetailAdapter(Context context) {
        super(context);
    }


    @Override
    public int getLayoutId() {
        return R.layout.item_acceptance_detail;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindItemHolder(SuperViewHolder holder, final int position) {
//        View rootView = holder.getView(R.id.ll_root_view);
        TextView tvCode = holder.getView(R.id.tv);
//        tvCode.setText(mDataList.get(position));
    }

}
