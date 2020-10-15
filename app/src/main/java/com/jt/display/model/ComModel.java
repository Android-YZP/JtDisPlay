package com.jt.display.model;

import android.text.format.Time;

import com.jt.display.base.Constants;
import com.jt.display.base.JsonResult;
import com.jt.display.bean.AppInfo;
import com.jt.display.http.Authorization;
import com.jt.display.http.RetrofitClient;
import com.jt.display.utils.CryptUtil;

import java.util.Random;

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
        return RetrofitClient.getInstance().getApi().shipmentSum("http://47.114.120.136:9102/vsp/shipmentSum",
                Authorization.getInstance().getAuthorization(),
                token, page1, pageSize1, page2, pageSize2);
    }

    public Flowable<JsonResult> deliverySum(String token, String page1, String pageSize1, String page2, String pageSize2) {
        return RetrofitClient.getInstance().getApi().deliverySum("http://47.114.120.136:9102/vsp/deliverySum",
                Authorization.getInstance().getAuthorization(),
                token, page1, pageSize1, page2, pageSize2);
    }

    public Flowable<JsonResult> getCurrentReceivePlan(String token, String currentPage, String pageSize) {
        return RetrofitClient.getInstance().getApi().getCurrentReceivePlan(Authorization.getInstance().getAuthorization(),
                token, currentPage, pageSize);
    }

    public Flowable<JsonResult> getCurrentDeliveryPlan(String token, String currentPage, String pageSize) {
        return RetrofitClient.getInstance().getApi().getCurrentDeliveryPlan(Authorization.getInstance().getAuthorization(),
                token, currentPage, pageSize);
    }

    public Flowable<JsonResult> getChannelCityOrderCostReportForm(String token) {
        return RetrofitClient.getInstance().getApi().getChannelCityOrderCostReportForm(Authorization.getInstance().getAuthorization(),
                token);
    }

    public Flowable<JsonResult> getCustomerChannelCityOrderCostReportForm(String token) {
        return RetrofitClient.getInstance().getApi().getCustomerChannelCityOrderCostReportForm(Authorization.getInstance().getAuthorization(),
                token);
    }
    public  String TOKEN = "a7db4f7859784f4982b218f73d1a7706";
    public Flowable<JsonResult> checkUpgrade(String token, AppInfo appInfo) {
        return RetrofitClient.getInstance().getApi().checkUpgrade(Constants.UPDATE_URL,
                Authorization.getInstance().getAuthorization(), TOKEN, appInfo);
    }


    String AUTH_SECRET_KEY = "OmOCClU3mnDIlXBs0heiLEYyDNVhB9AIu6eniwJgu6g=";
    public String getAuthorization(){

        //passwordDigest = md5(SHA1(nonce+createTimestamp+secretKey))
        //PasswordDigest="cccccccccccccccccc",Nonce="6FQHGU7M01ZMIA5G",Created="2017-01-01T15:00:00+08:00"
        String nonce = getRandomString(16);
        String created = getRFC3339Time();
        String passwordDigest = CryptUtil.encryptToMD5(CryptUtil.encryptToSHA(AUTH_SECRET_KEY).toUpperCase());
        return String.format("PasswordDigest=\"%s\",Nonce=\"%s\",Created=\"%s\"",passwordDigest,nonce,created);
    }


    private String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    private String getRFC3339Time(){
        Time time = new Time();
        time.setToNow();
        return time.format3339(false);
    }
}
