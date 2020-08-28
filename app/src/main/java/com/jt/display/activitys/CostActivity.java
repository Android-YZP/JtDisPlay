package com.jt.display.activitys;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.GridLayoutManager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.StyleSpan;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.jt.display.R;
import com.jt.display.adapters.LanTongCostAdapter;
import com.jt.display.adapters.OtherCostAdapter;
import com.jt.display.adapters.TopCostAdapter;
import com.jt.display.base.BaseDisplayActivity;

import java.util.ArrayList;
import java.util.List;

public class CostActivity extends BaseDisplayActivity {
    private LRecyclerViewAdapter mLuRecyclerViewAdapter;
    private LRecyclerView mLrvLanTong;
    private LRecyclerView mLrvOther;
    private LRecyclerView mLrvTop;
    List<String> mData = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_cost;
    }

    @Override
    public void initView() {
        mLrvLanTong = findViewById(R.id.lrv_lantong);
        mLrvOther = findViewById(R.id.lrv_other);
        mLrvTop = findViewById(R.id.lrv_top);
    }

    @Override
    public void initData() {
        Spannable string = new SpannableString("修改背景色、粗体、字体大小");
        // 背景色
        string.setSpan(new BackgroundColorSpan(Color.RED), 2, 5, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        // 粗体
        string.setSpan(new StyleSpan(Typeface.BOLD), 6, 8, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        // 字体大小
        string.setSpan(new AbsoluteSizeSpan(50), 11, 13, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        for (int i = 0; i < 102; i++) {
            mData.add("11");
        }

        mLrvLanTong.setLayoutManager(new GridLayoutManager(mContext, 3));
        LanTongCostAdapter lanTongCostAdapter = new LanTongCostAdapter(mContext);
        mLuRecyclerViewAdapter = new LRecyclerViewAdapter(lanTongCostAdapter);
        mLrvLanTong.setAdapter(mLuRecyclerViewAdapter);
        mLrvLanTong.setLoadMoreEnabled(false);
        mLrvLanTong.setPullRefreshEnabled(false);
        lanTongCostAdapter.setDataList(mData);


        mLrvOther.setLayoutManager(new GridLayoutManager(mContext, 3));
        OtherCostAdapter otherCostAdapter = new OtherCostAdapter(mContext);
        mLuRecyclerViewAdapter = new LRecyclerViewAdapter(otherCostAdapter);
        mLrvOther.setAdapter(mLuRecyclerViewAdapter);
        mLrvOther.setLoadMoreEnabled(false);
        mLrvOther.setPullRefreshEnabled(false);
        otherCostAdapter.setDataList(mData);


        mLrvTop.setLayoutManager(new GridLayoutManager(mContext, 11));
        TopCostAdapter topCostAdapter = new TopCostAdapter(mContext);
        mLuRecyclerViewAdapter = new LRecyclerViewAdapter(topCostAdapter);
        mLrvTop.setAdapter(mLuRecyclerViewAdapter);
        mLrvTop.setLoadMoreEnabled(false);
        mLrvTop.setPullRefreshEnabled(false);
        topCostAdapter.setDataList(mData);


    }

    @Override
    public void initListener() {

    }

    @Override
    protected void onPageSelected(int pager) {

    }

    @Override
    public void onSuccess(Object jsonResult, int type) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}