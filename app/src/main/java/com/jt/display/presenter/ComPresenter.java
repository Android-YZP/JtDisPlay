package com.jt.display.presenter;

import android.content.Context;

import com.jt.display.base.BasePresenter;
import com.jt.display.base.Constants;
import com.jt.display.base.JsonResult;
import com.jt.display.http.RxScheduler;
import com.jt.display.model.ComModel;
import com.jt.display.utils.GsonUtil;
import com.jt.display.utils.SharePreferenceUtils;
import com.orhanobut.logger.Logger;

import io.reactivex.functions.Consumer;

public class ComPresenter extends BasePresenter {
    private ComModel mLoginModel;

    public ComPresenter() {
        this.mLoginModel = new ComModel();
    }

    public void login() {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        mLoginModel.login()
                .compose(RxScheduler.<JsonResult>flowableIoMain())
                .as(mView.<JsonResult>bindAutoDispose())
                .subscribe(new Consumer<JsonResult>() {
                    @Override
                    public void accept(JsonResult bean) throws Exception {
                        Logger.e(GsonUtil.GsonString(bean));
                        mView.onSuccess(bean, Constants.METHOD_ONE);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });

    }

    public void lastSevenDaysSales() {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        mLoginModel.lastSevenDaysSales(getToken())
                .compose(RxScheduler.<JsonResult>flowableIoMain())
                .as(mView.<JsonResult>bindAutoDispose())
                .subscribe(new Consumer<JsonResult>() {
                    @Override
                    public void accept(JsonResult bean) throws Exception {
                        Logger.e(GsonUtil.GsonString(bean));
                        mView.onSuccess(bean, Constants.METHOD_TWO);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });

    }

    public void lastSixMonthSales() {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        mLoginModel.lastSixMonthSales(getToken())
                .compose(RxScheduler.<JsonResult>flowableIoMain())
                .as(mView.<JsonResult>bindAutoDispose())
                .subscribe(new Consumer<JsonResult>() {
                    @Override
                    public void accept(JsonResult bean) throws Exception {
                        Logger.e(GsonUtil.GsonString(bean));
                        mView.onSuccess(bean, Constants.METHOD_THREE);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });

    }

    public void customerSalesSort(String type) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        mLoginModel.customerSalesSort(getToken(), type)
                .compose(RxScheduler.<JsonResult>flowableIoMain())
                .as(mView.<JsonResult>bindAutoDispose())
                .subscribe(new Consumer<JsonResult>() {
                    @Override
                    public void accept(JsonResult bean) throws Exception {
                        Logger.e(GsonUtil.GsonString(bean));
                        mView.onSuccess(bean, Constants.METHOD_FOUR);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });

    }

    public void lastSevenCarCost() {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        mLoginModel.lastSevenCarCost(getToken())
                .compose(RxScheduler.<JsonResult>flowableIoMain())
                .as(mView.<JsonResult>bindAutoDispose())
                .subscribe(new Consumer<JsonResult>() {
                    @Override
                    public void accept(JsonResult bean) throws Exception {
                        Logger.e(GsonUtil.GsonString(bean));
                        mView.onSuccess(bean, Constants.METHOD_FIVE);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });

    }

    public void currentReceiveDelivery() {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        mLoginModel.currentReceiveDelivery(getToken())
                .compose(RxScheduler.<JsonResult>flowableIoMain())
                .as(mView.<JsonResult>bindAutoDispose())
                .subscribe(new Consumer<JsonResult>() {
                    @Override
                    public void accept(JsonResult bean) throws Exception {
                        Logger.e(GsonUtil.GsonString(bean));
                        mView.onSuccess(bean, Constants.METHOD_SIX);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });

    }

    public void currentDateLoadAndUnloadVolume() {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        mLoginModel.currentDateLoadAndUnloadVolume(getToken())
                .compose(RxScheduler.<JsonResult>flowableIoMain())
                .as(mView.<JsonResult>bindAutoDispose())
                .subscribe(new Consumer<JsonResult>() {
                    @Override
                    public void accept(JsonResult bean) throws Exception {
                        Logger.e(GsonUtil.GsonString(bean));
                        mView.onSuccess(bean, Constants.METHOD_SEVEN);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });

    }

    public void getSalesCurrentAndLastMonth() {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        mLoginModel.getSalesCurrentAndLastMonth(getToken())
                .compose(RxScheduler.<JsonResult>flowableIoMain())
                .as(mView.<JsonResult>bindAutoDispose())
                .subscribe(new Consumer<JsonResult>() {
                    @Override
                    public void accept(JsonResult bean) throws Exception {
                        Logger.e(GsonUtil.GsonString(bean));
                        mView.onSuccess(bean, Constants.METHOD_ONE);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });

    }

    public void getTopAndDownCustomerList() {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        mLoginModel.getTopAndDownCustomerList(getToken())
                .compose(RxScheduler.<JsonResult>flowableIoMain())
                .as(mView.<JsonResult>bindAutoDispose())
                .subscribe(new Consumer<JsonResult>() {
                    @Override
                    public void accept(JsonResult bean) throws Exception {
                        Logger.e(GsonUtil.GsonString(bean));
                        mView.onSuccess(bean, Constants.METHOD_TWO);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });

    }

    public void getOrderAmountByCustomerName(String customerName) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        mLoginModel.getOrderAmountByCustomerName(getToken(), customerName)
                .compose(RxScheduler.<JsonResult>flowableIoMain())
                .as(mView.<JsonResult>bindAutoDispose())
                .subscribe(new Consumer<JsonResult>() {
                    @Override
                    public void accept(JsonResult bean) throws Exception {
                        Logger.e(GsonUtil.GsonString(bean));
                        mView.onSuccess(bean, Constants.METHOD_THREE);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });

    }

    public void lastSixMonthSale() {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        mLoginModel.lastSixMonthSale(getToken())
                .compose(RxScheduler.<JsonResult>flowableIoMain())
                .as(mView.<JsonResult>bindAutoDispose())
                .subscribe(new Consumer<JsonResult>() {
                    @Override
                    public void accept(JsonResult bean) throws Exception {
                        Logger.e(GsonUtil.GsonString(bean));
                        mView.onSuccess(bean, Constants.METHOD_FOUR);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });

    }

    private String getToken() {
        return "bearer " + SharePreferenceUtils.getLoginData((Context) mView).getData().getAccessToken();

    }

}
