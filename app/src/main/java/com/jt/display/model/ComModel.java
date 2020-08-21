package com.jt.display.model;

import com.jt.display.base.JsonResult;
import com.jt.display.http.Authorization;
import com.jt.display.http.RetrofitClient;

import io.reactivex.Flowable;

public class ComModel {

    public Flowable<JsonResult> login() {
        return RetrofitClient.getInstance().getApi().login(Authorization.getInstance().getAuthorization(),
                "password", "000000", "admin", "!@jingtong1920");
    }

    public Flowable<JsonResult> lastSevenDaysSales(String token) {
        return RetrofitClient.getInstance().getApi().lastSevenDaysSales(Authorization.getInstance().getAuthorization(),
                token);
    }

    public Flowable<JsonResult> lastSixMonthSales(String token) {
        return RetrofitClient.getInstance().getApi().lastSixMonthSales(Authorization.getInstance().getAuthorization(),
                token);
    }

    public Flowable<JsonResult> customerSalesSort(String type,String token) {
        return RetrofitClient.getInstance().getApi().customerSalesSort(Authorization.getInstance().getAuthorization(),
                token, type);
    }

    public Flowable<JsonResult> lastSevenCarCost(String token) {
        return RetrofitClient.getInstance().getApi().lastSevenCarCost(Authorization.getInstance().getAuthorization(),
                token);
    }

    public Flowable<JsonResult> currentReceiveDelivery(String token) {
        return RetrofitClient.getInstance().getApi().currentReceiveDelivery(Authorization.getInstance().getAuthorization(),
                token);
    }

    public Flowable<JsonResult> currentDateLoadAndUnloadVolume(String token) {
        return RetrofitClient.getInstance().getApi().currentDateLoadAndUnloadVolume(Authorization.getInstance().getAuthorization(),
                token);
    }


}
