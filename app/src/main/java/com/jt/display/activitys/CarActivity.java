package com.jt.display.activitys;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.jt.display.MainActivity;
import com.jt.display.R;
import com.jt.display.adapters.DirectDeliveryAdapter;
import com.jt.display.adapters.HzShipmentAdapter;
import com.jt.display.adapters.MdcShipmentAdapter;
import com.jt.display.adapters.RtwDeliveryAdapter;
import com.jt.display.base.BaseDisplayActivity;
import com.jt.display.base.Constants;
import com.jt.display.base.JsonResult;
import com.jt.display.bean.DeliveryBean;
import com.jt.display.bean.ShipmentBean;
import com.jt.display.presenter.ComPresenter;
import com.jt.display.utils.GsonUtil;
import com.jt.display.utils.SharePreferenceUtils;

import java.util.List;

public class CarActivity extends BaseDisplayActivity {
    private LRecyclerView mLrvDirectDelivery;
    private LRecyclerView mLrvRtwDelivery;
    private LRecyclerView mLrvMdcShipment;
    private LRecyclerView mLrvHzShipment;
    private ComPresenter mPresenter;
    private DirectDeliveryAdapter mDirectDeliveryAdapter;
    private RtwDeliveryAdapter mRtwDeliveryAdapter;
    private MdcShipmentAdapter mMdcShipmentAdapter;
    private HzShipmentAdapter mHzShipmentAdapter;
    private int mHzShipmentPage = 1;
    private int mMdcShipmentPage = 1;
    private int mRtwDeliveryPage = 1;//提货回仓
    private int mDirectDeliveryPage = 1;
    private TextView mTvDeliveryPlanVolum;
    private TextView mTvDeliveryVolum;
    private TextView mTvDirectDelivery;
    private TextView mTvRtwDelivery;
    private TextView mTvShipmentPlanVolum;
    private TextView mTvShipmentVolum;
    private TextView mTvHzShipment;
    private TextView mTvMdcShipmen;

    @Override
    public void onBackPressed() {
        startActivity(new Intent(mContext, MainActivity.class));
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 500);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_car;
    }

    @Override
    public void initView() {
        mLrvDirectDelivery = findViewById(R.id.lrv_directDelivery);
        mLrvRtwDelivery = findViewById(R.id.lrv_rtwDelivery);
        mLrvMdcShipment = findViewById(R.id.lrv_mdcShipment);
        mLrvHzShipment = findViewById(R.id.lrv_hzShipment);

        mTvDeliveryPlanVolum = findViewById(R.id.tv_deliveryPlanVolum);
        mTvDeliveryVolum = findViewById(R.id.tv_deliveryVolum);
        mTvDirectDelivery = findViewById(R.id.tv_directDelivery);
        mTvRtwDelivery = findViewById(R.id.tv_rtwDelivery);

        mTvShipmentPlanVolum = findViewById(R.id.tv_shipmentPlanVolum);
        mTvShipmentVolum = findViewById(R.id.tv_shipmentVolum);
        mTvHzShipment = findViewById(R.id.tv_hzShipment);
        mTvMdcShipmen = findViewById(R.id.tv_mdcShipmen);


        mPresenter = new ComPresenter();
        mPresenter.attachView(this);
    }

    @Override
    public void initData() {
        mPresenter.deliverySum(mRtwDeliveryPage + "", +mDirectDeliveryPage + "");//提货
        mPresenter.shipmentSum(mHzShipmentPage + "", +mMdcShipmentPage + "");//出货

        LinearLayoutManager directDeliveryManager = new LinearLayoutManager(mContext);
        mLrvDirectDelivery.setLayoutManager(directDeliveryManager);
        mDirectDeliveryAdapter = new DirectDeliveryAdapter(mContext);
        LRecyclerViewAdapter mLuDirectDeliveryAdapter = new LRecyclerViewAdapter(mDirectDeliveryAdapter);
        mLrvDirectDelivery.setAdapter(mLuDirectDeliveryAdapter);
        mLrvDirectDelivery.setLoadMoreEnabled(false);
        mLrvDirectDelivery.setPullRefreshEnabled(false);

        LinearLayoutManager RtwDeliveryManager = new LinearLayoutManager(mContext);
        mLrvRtwDelivery.setLayoutManager(RtwDeliveryManager);
        mRtwDeliveryAdapter = new RtwDeliveryAdapter(mContext);
        LRecyclerViewAdapter mLuRtwDeliveryAdapter = new LRecyclerViewAdapter(mRtwDeliveryAdapter);
        mLrvRtwDelivery.setAdapter(mLuRtwDeliveryAdapter);
        mLrvRtwDelivery.setLoadMoreEnabled(false);
        mLrvRtwDelivery.setPullRefreshEnabled(false);


        LinearLayoutManager MdcShipmentManager = new LinearLayoutManager(mContext);
        mLrvMdcShipment.setLayoutManager(MdcShipmentManager);
        mMdcShipmentAdapter = new MdcShipmentAdapter(mContext);
        LRecyclerViewAdapter mLuMdcShipmentManagerAdapter = new LRecyclerViewAdapter(mMdcShipmentAdapter);
        mLrvMdcShipment.setAdapter(mLuMdcShipmentManagerAdapter);
        mLrvMdcShipment.setLoadMoreEnabled(false);
        mLrvMdcShipment.setPullRefreshEnabled(false);

        LinearLayoutManager HzShipmentManager = new LinearLayoutManager(mContext);
        mLrvHzShipment.setLayoutManager(HzShipmentManager);
        mHzShipmentAdapter = new HzShipmentAdapter(mContext);
        LRecyclerViewAdapter mLuHzShipmentManagerAdapter = new LRecyclerViewAdapter(mHzShipmentAdapter);
        mLrvHzShipment.setAdapter(mLuHzShipmentManagerAdapter);
        mLrvHzShipment.setLoadMoreEnabled(false);
        mLrvHzShipment.setPullRefreshEnabled(false);


    }


    @Override
    public void initListener() {

    }

    @Override
    protected void onPageSelected(int pager) {

    }

    @Override
    protected void loopTimesListener(long loopTimes) {
        if (loopTimes % 6 == 0) {
            mPresenter.shipmentSum(mMdcShipmentPage + "", +mHzShipmentPage + "");//出货
            mPresenter.deliverySum(mRtwDeliveryPage + "", mDirectDeliveryPage + "");//提货
        }

        if (loopTimes % 720 == 0) {//10000*6*60*4   2小时刷新token
            mPresenter.login();
        }
    }

    @Override
    protected void animStart(int mAnimPager) {

    }

    @Override
    public void onSuccess(Object jsonResult, int type) {

        if (type == Constants.METHOD_LOGIN) {//登录
            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                SharePreferenceUtils.putLoginData(mContext, GsonUtil.GsonString(jsonResult));
            }
        }

        if (type == Constants.METHOD_ONE) {//出货
            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                ShipmentBean shipmentBean = GsonUtil.GsonToBean(GsonUtil.GsonString(jsonResult), ShipmentBean.class);
                initShipment(shipmentBean);
            }
        } else if (type == Constants.METHOD_TWO) {//提货
            if (((JsonResult) jsonResult).getCode() == Constants.HTTP_SUCCESS) {
                DeliveryBean deliveryBean = GsonUtil.GsonToBean(GsonUtil.GsonString(jsonResult), DeliveryBean.class);
                initDelivery(deliveryBean);
            }
        }
    }


    @SuppressLint("SetTextI18n")
    private void initShipment(ShipmentBean shipmentBean) {

        mTvShipmentPlanVolum.setText("出货计划体积 \n" + shipmentBean.getData().getShipmentPlanVolum() + "m³");
        mTvShipmentVolum.setText("已出货体积 \n" + shipmentBean.getData().getShipmentVolum() + "m³");
        mTvHzShipment.setText(shipmentBean.getData().getHzShipment().getHzShipmentPlanVolum() + "m³    " +
                shipmentBean.getData().getHzShipment().getHzShipmentVolum() + "m³");
        mTvMdcShipmen.setText(shipmentBean.getData().getMdcShipment().getMdcShipmentPlanVolum() + "m³    " +
                shipmentBean.getData().getMdcShipment().getMdcShipmentVolum() + "m³");


        List<ShipmentBean.DataBean.HzShipmentBean.HzShipmentCarListBean> hzShipmentCarList = shipmentBean.getData().getHzShipment().getHzShipmentCarList();
        List<ShipmentBean.DataBean.MdcShipmentBean.MdcShipmentCarListBean> mdcShipmentCarList = shipmentBean.getData().getMdcShipment().getMdcShipmentCarList();

        float TotalCountShipmentHZ = Float.parseFloat(shipmentBean.getData().getHzShipment().getTotalCountShipmentHZ());
        float TotalCountShipmentMDC = Float.parseFloat(shipmentBean.getData().getMdcShipment().getTotalCountShipmentMDC());
        float TotalCountShipmentHZPage = 0;
        float TotalCountShipmentMDCPage = 0;
        if (TotalCountShipmentHZ % Constants.PAGER_SIZE == 0) {
            TotalCountShipmentHZPage = TotalCountShipmentHZ / Constants.PAGER_SIZE;
        } else {
            TotalCountShipmentHZPage = TotalCountShipmentHZ / Constants.PAGER_SIZE + 1;
        }

        if (TotalCountShipmentMDC % Constants.PAGER_SIZE == 0) {
            TotalCountShipmentMDCPage = TotalCountShipmentMDC / Constants.PAGER_SIZE;
        } else {
            TotalCountShipmentMDCPage = TotalCountShipmentMDC / Constants.PAGER_SIZE + 1;
        }


        if (hzShipmentCarList != null && hzShipmentCarList.size() > 0) {
            mHzShipmentAdapter.setDataList(hzShipmentCarList);
            mHzShipmentPage++;
            if (mHzShipmentPage > TotalCountShipmentHZPage) mHzShipmentPage = 1;
        }


        if (mdcShipmentCarList != null && mdcShipmentCarList.size() > 0) {
            mMdcShipmentAdapter.setDataList(mdcShipmentCarList);
            mMdcShipmentPage++;
            if (mMdcShipmentPage > TotalCountShipmentMDCPage) mMdcShipmentPage = 1;
        }

    }


    @SuppressLint("SetTextI18n")
    private void initDelivery(DeliveryBean deliveryBean) {

        mTvDeliveryPlanVolum.setText("提货计划体积 \n" + deliveryBean.getData().getDeliveryPlanVolum() + "m³");
        mTvDeliveryVolum.setText("已提货体积 \n" + deliveryBean.getData().getDeliveryVolum() + "m³");
        mTvDirectDelivery.setText(deliveryBean.getData().getDirectDelivery().getDirectDeliveryPlanVolum() + "m³    " +
                deliveryBean.getData().getDirectDelivery().getDirectDeliveryVolum() + "m³");
        mTvRtwDelivery.setText(deliveryBean.getData().getRtwDelivery().getRtwDeliveryPlanVolum() + "m³    " +
                deliveryBean.getData().getRtwDelivery().getRtwDeliveryVolum() + "m³");


        List<DeliveryBean.DataBean.DirectDeliveryBean.DirectDeliveryCarListBean> directDeliveryCarList = deliveryBean.getData().getDirectDelivery().getDirectDeliveryCarList();
        List<DeliveryBean.DataBean.RtwDeliveryBean.RtwDeliveryCarListBean> rtwDeliveryCarList = deliveryBean.getData().getRtwDelivery().getRtwDeliveryCarList();

        float TotalCountDirectDelivery = Float.parseFloat(deliveryBean.getData().getDirectDelivery().getTotalCountDirectDelivery());
        float TotalCountDelivery = Float.parseFloat(deliveryBean.getData().getRtwDelivery().getTotalCountDelivery());
        float TotalCountDirectDeliveryPage = 0;
        float TotalCountDeliveryMDCPage = 0;
        if (TotalCountDirectDelivery % Constants.PAGER_SIZE == 0) {
            TotalCountDirectDeliveryPage = TotalCountDirectDelivery / Constants.PAGER_SIZE;
        } else {
            TotalCountDirectDeliveryPage = TotalCountDirectDelivery / Constants.PAGER_SIZE + 1;
        }
        if (TotalCountDelivery % Constants.PAGER_SIZE == 0) {
            TotalCountDeliveryMDCPage = TotalCountDelivery / Constants.PAGER_SIZE;
        } else {
            TotalCountDeliveryMDCPage = TotalCountDelivery / Constants.PAGER_SIZE + 1;
        }


        if (directDeliveryCarList != null && directDeliveryCarList.size() > 0) {
            mDirectDeliveryAdapter.setDataList(directDeliveryCarList);
            mDirectDeliveryPage++;
            if (mDirectDeliveryPage > TotalCountDirectDeliveryPage) mDirectDeliveryPage = 1;

        }

        if (rtwDeliveryCarList != null && rtwDeliveryCarList.size() > 0) {
            mRtwDeliveryAdapter.setDataList(rtwDeliveryCarList);
            mRtwDeliveryPage++;
            if (mRtwDeliveryPage > TotalCountDeliveryMDCPage) mRtwDeliveryPage = 1;
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }
}