package com.jt.display.activitys;

import android.support.v7.widget.LinearLayoutManager;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.jt.display.R;
import com.jt.display.adapters.AcceptanceDetailAdapter;
import com.jt.display.base.BaseDisplayActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

public class CarActivity extends BaseDisplayActivity {
    private LRecyclerViewAdapter mLuRecyclerViewAdapter;
    private LRecyclerView mLuRecyclerView;
    int page = 3333;
    List<String> mData = new ArrayList<>();
    Runnable carRunnable = new Runnable() {
        @Override
        public void run() {
            acceptanceDetailAdapter.getDataList().clear();
            page = page + 1111;
            acceptanceDetailAdapter.getDataList().add(page+ "");
            acceptanceDetailAdapter.getDataList().add(page+ "");
            acceptanceDetailAdapter.getDataList().add(page+ "");
            acceptanceDetailAdapter.getDataList().add(page+ "");
            acceptanceDetailAdapter.getDataList().add(page+ "");
            acceptanceDetailAdapter.getDataList().add(page+ "");
            acceptanceDetailAdapter.getDataList().add(page+ "");
            acceptanceDetailAdapter.getDataList().add(page+ "");
            acceptanceDetailAdapter.getDataList().add(page+ "");
            acceptanceDetailAdapter.getDataList().add(page+ "");
            acceptanceDetailAdapter.getDataList().add(page+ "");

            acceptanceDetailAdapter.notifyDataSetChanged();

            handler.postDelayed(carRunnable, 5000);
        }
    };
    private AcceptanceDetailAdapter acceptanceDetailAdapter;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(carRunnable);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_car;
    }

    @Override
    public void initView() {
        mLuRecyclerView = findViewById(R.id.lrv_acceptance);
    }

    @Override
    public void initData() {

        mData.add("11");
        mData.add("11");
        mData.add("11");
        mData.add("11");
        mData.add("11");
        mData.add("11");
        mData.add("11");
        mData.add("11");
        mData.add("11");
        mData.add("11");
        mData.add("11");
        mData.add("11");

        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(mContext);
        mLuRecyclerView.setLayoutManager(gridLayoutManager);
//        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
//        divider.setDrawable(ContextCompat.getDrawable(this,R.drawable.custom_divider));
//        mLuRecyclerView.addItemDecoration(divider);

        acceptanceDetailAdapter = new AcceptanceDetailAdapter(mContext);
        mLuRecyclerViewAdapter = new LRecyclerViewAdapter(acceptanceDetailAdapter);
        mLuRecyclerView.setAdapter(mLuRecyclerViewAdapter);
        mLuRecyclerView.setLoadMoreEnabled(false);
        mLuRecyclerView.setPullRefreshEnabled(false);
        acceptanceDetailAdapter.setDataList(mData);

        handler.postDelayed(carRunnable, 5000);
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