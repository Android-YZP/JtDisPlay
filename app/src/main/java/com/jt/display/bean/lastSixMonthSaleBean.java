package com.jt.display.bean;

import java.util.List;

public class lastSixMonthSaleBean {

    /**
     * code : 200
     * data : [{"orderMonth":"2020-03","salesAmount":2593288.8236,"volume":15930.39,"weight":0,"cartonNum":144307,"cusSettleAmount":39203.2836,"channelSettleAmount":2554085.54,"orderCost":0},{"orderMonth":"2020-04","salesAmount":3312173.6892,"volume":20633.71,"weight":0,"cartonNum":234712,"cusSettleAmount":-27729.2808,"channelSettleAmount":3339902.97,"orderCost":0},{"orderMonth":"2020-05","salesAmount":5206942.0587,"volume":32112.2004,"weight":0,"cartonNum":358688,"cusSettleAmount":99763.6174,"channelSettleAmount":5107178.4413,"orderCost":0},{"orderMonth":"2020-06","salesAmount":3093756.1891,"volume":19868.497,"weight":0,"cartonNum":235015,"cusSettleAmount":-76374.9786,"channelSettleAmount":3170131.1677,"orderCost":0},{"orderMonth":"2020-07","salesAmount":3082127.5203,"volume":19618.4666,"weight":132070.14,"cartonNum":235961,"cusSettleAmount":-90698.6679,"channelSettleAmount":3172826.1882,"orderCost":303584.0684},{"orderMonth":"2020-08","salesAmount":4269688.885,"volume":26584.5075,"weight":688816.25,"cartonNum":326236,"cusSettleAmount":104185.2323,"channelSettleAmount":4165503.6527,"orderCost":1172972.6742}]
     * msg : 操作成功
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * orderMonth : 2020-03
         * salesAmount : 2593288.8236
         * volume : 15930.39
         * weight : 0
         * cartonNum : 144307
         * cusSettleAmount : 39203.2836
         * channelSettleAmount : 2554085.54
         * orderCost : 0
         */

        private String orderMonth;
        private String salesAmount;
        private String volume;
        private String weight;
        private String cartonNum;
        private String cusSettleAmount;
        private String channelSettleAmount;
        private String orderCost;

        public String getOrderMonth() {
            return orderMonth;
        }

        public void setOrderMonth(String orderMonth) {
            this.orderMonth = orderMonth;
        }

        public String getSalesAmount() {
            return salesAmount;
        }

        public void setSalesAmount(String salesAmount) {
            this.salesAmount = salesAmount;
        }

        public String getVolume() {
            return volume;
        }

        public void setVolume(String volume) {
            this.volume = volume;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getCartonNum() {
            return cartonNum;
        }

        public void setCartonNum(String cartonNum) {
            this.cartonNum = cartonNum;
        }

        public String getCusSettleAmount() {
            return cusSettleAmount;
        }

        public void setCusSettleAmount(String cusSettleAmount) {
            this.cusSettleAmount = cusSettleAmount;
        }

        public String getChannelSettleAmount() {
            return channelSettleAmount;
        }

        public void setChannelSettleAmount(String channelSettleAmount) {
            this.channelSettleAmount = channelSettleAmount;
        }

        public String getOrderCost() {
            return orderCost;
        }

        public void setOrderCost(String orderCost) {
            this.orderCost = orderCost;
        }
    }
}
