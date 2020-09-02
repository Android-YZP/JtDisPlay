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

    public Flowable<JsonResult> customerSalesSort(String token, String type) {
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

    //销售主题
    public Flowable<JsonResult> getSalesCurrentAndLastMonth(String token) {
        return RetrofitClient.getInstance().getApi().getSalesCurrentAndLastMonth(Authorization.getInstance().getAuthorization(),
                token);
    }

    public Flowable<JsonResult> getTopAndDownCustomerList(String token) {
        return RetrofitClient.getInstance().getApi().getTopAndDownCustomerList(Authorization.getInstance().getAuthorization(),
                token);
    }

    public Flowable<JsonResult> getOrderAmountByCustomerName(String token, String customerName) {
        return RetrofitClient.getInstance().getApi().getOrderAmountByCustomerName(Authorization.getInstance().getAuthorization(),
                token, customerName);
    }

    public Flowable<JsonResult> lastSixMonthSale(String token) {
        return RetrofitClient.getInstance().getApi().lastSixMonthSale(Authorization.getInstance().getAuthorization(),
                token);
    }

    public Flowable<JsonResult> shipmentSum(String token, String page1, String pageSize1, String page2, String pageSize2) {
        return RetrofitClient.getInstance().getApi().shipmentSum("http://40.73.59.226:9102/vsp/shipmentSum",
                Authorization.getInstance().getAuthorization(),
                token, page1, pageSize1, page2, pageSize2);
    }

    public Flowable<JsonResult> deliverySum(String token, String page1, String pageSize1, String page2, String pageSize2) {
        return RetrofitClient.getInstance().getApi().deliverySum("http://40.73.59.226:9102/vsp/deliverySum",
                Authorization.getInstance().getAuthorization(),
                token, page1, pageSize1, page2, pageSize2);
    }

    public Flowable<JsonResult> getCurrentReceivePlan(String token,String currentPage,String pageSize) {
        return RetrofitClient.getInstance().getApi().getCurrentReceivePlan(Authorization.getInstance().getAuthorization(),
                token,currentPage,pageSize);
    }

    public Flowable<JsonResult> getCurrentDeliveryPlan(String token,String currentPage,String pageSize) {
        return RetrofitClient.getInstance().getApi().getCurrentDeliveryPlan(Authorization.getInstance().getAuthorization(),
                token,currentPage,pageSize);
    }

    public Flowable<JsonResult> getChannelCityOrderCostReportForm(String token) {
        return RetrofitClient.getInstance().getApi().getChannelCityOrderCostReportForm(Authorization.getInstance().getAuthorization(),
                token);
    }

    public Flowable<JsonResult> getCustomerChannelCityOrderCostReportForm(String token) {
        return RetrofitClient.getInstance().getApi().getCustomerChannelCityOrderCostReportForm(Authorization.getInstance().getAuthorization(),
                token);
    }

}
