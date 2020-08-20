package com.jt.display.activitys;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.StyleSpan;
import com.jt.display.R;
import com.jt.display.base.BaseDisplayActivity;

public class CostActivity extends BaseDisplayActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_cost;
    }

    @Override
    public void initView() {
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