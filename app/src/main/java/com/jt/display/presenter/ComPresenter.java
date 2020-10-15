package com.jt.display.presenter;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.jt.display.base.BasePresenter;
import com.jt.display.base.Constants;
import com.jt.display.base.JsonResult;
import com.jt.display.bean.AppInfo;
import com.jt.display.bean.PDALoginData;
import com.jt.display.bean.User;
import com.jt.display.http.RxScheduler;
import com.jt.display.model.ComModel;
import com.jt.display.utils.GsonUtil;
import com.jt.display.utils.SharePreferenceUtils;
import com.jt.display.utils.UpdateUtil;
import com.orhanobut.logger.Logger;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

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
                        mView.onSuccess(bean, Constants.METHOD_LOGIN);
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
                        if (!isViewAttached()) {
                            return;
                        }
                        Logger.e(GsonUtil.GsonString(bean));
                        mView.onSuccess(bean, Constants.METHOD_THREE);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }
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

    public void shipmentSum(String page1, String page2) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        mLoginModel.shipmentSum(getToken(), page1, Constants.PAGER_SIZE + "", page2, Constants.PAGER_SIZE + "")
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

    public void deliverySum(String page1, String page2) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        mLoginModel.deliverySum(getToken(), page1, Constants.PAGER_SIZE + "", page2, Constants.PAGER_SIZE + "")
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


    public void getCurrentReceivePlan(int page) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        mLoginModel.getCurrentReceivePlan(getToken(), page + "", Constants.TRANSPORT_PAGER_SIZE + "")
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

    public void getCurrentDeliveryPlan(int page) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        mLoginModel.getCurrentDeliveryPlan(getToken(), page + "", Constants.TRANSPORT_PAGER_SIZE + "")
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

    public void getChannelCityOrderCostReportForm() {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        mLoginModel.getChannelCityOrderCostReportForm(getToken())
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

    public void getCustomerChannelCityOrderCostReportForm() {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        mLoginModel.getCustomerChannelCityOrderCostReportForm(getToken())
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


    public void doLogin(final User user) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        mLoginModel.doLogin(user)
                .compose(RxScheduler.<JsonResult<PDALoginData>>flowableIoMain())
                .as(mView.<JsonResult<PDALoginData>>bindAutoDispose())
                .subscribe(new Consumer<JsonResult<PDALoginData>>() {
                    @Override
                    public void accept(JsonResult<PDALoginData> bean) throws Exception {

                        mView.onSuccess(bean, Constants.METHOD_LOGIN_PDA);
                        mView.hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });

    }


    public void checkUpgrade(final AppInfo appInfo) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        mLoginModel.checkUpgrade(getToken(), appInfo)
                .compose(RxScheduler.<JsonResult>flowableIoMain())
                .as(mView.<JsonResult>bindAutoDispose())
                .subscribe(new Consumer<JsonResult>() {
                    @Override
                    public void accept(JsonResult bean) throws Exception {
                        mView.onSuccess(bean, Constants.METHOD_CHECK_UPGRADE);
                        mView.hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });
    }

    public void startUpdate(Context context, String apkUrl) {

        new UpdateUtil(context, apkUrl, "DISPLAY.apk");
    }

    public AppInfo getAppInfo(Context context) {
        return new AppInfo(context.getPackageName(), getLocalVersion(context), getMachineHardwareAddress());
    }

    private String getToken() {
        if (SharePreferenceUtils.getLoginData((Context) mView) == null) {
            return "bearer";
        } else {
            return "bearer " + SharePreferenceUtils.getLoginData((Context) mView).getData().getAccessToken();
        }
    }
    public int getLocalVersion(Context ctx) {
        int localVersion = 0;
        try {
            PackageInfo packageInfo = ctx.getApplicationContext()
                    .getPackageManager()
                    .getPackageInfo(ctx.getPackageName(), 0);
            localVersion = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return localVersion;
    }


    private String getMachineHardwareAddress() {
        Enumeration<NetworkInterface> interfaces = null;
        try {
            interfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        String hardWareAddress = null;
        NetworkInterface iF = null;
        if (interfaces == null) {
            return null;
        }
        while (interfaces.hasMoreElements()) {
            iF = interfaces.nextElement();
            try {
                hardWareAddress = bytesToString(iF.getHardwareAddress());
                if (hardWareAddress != null)
                    break;
            } catch (SocketException e) {
                e.printStackTrace();
            }
        }
        return hardWareAddress;
    }

    /***
     * byte转为String
     *
     * @param bytes
     * @return
     */
    private String bytesToString(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        StringBuilder buf = new StringBuilder();
        for (byte b : bytes) {
            buf.append(String.format("%02X:", b));
        }
        if (buf.length() > 0) {
            buf.deleteCharAt(buf.length() - 1);
        }
        return buf.toString();
    }

}
