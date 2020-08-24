package com.jt.display.bean;

import java.util.List;

public class LastSevenDaysSalesBean {

    /**
     * code : 200
     * data : [{"orderDay":"2020-08-15","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-08-16","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-08-17","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-08-18","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-08-19","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-08-20","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-08-21","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0}]
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
         * orderDay : 2020-08-15
         * salesAmount : 0
         * volume : 0
         * weight : 0
         * cartonNum : 0
         * cusSettleAmount : 0
         * channelSettleAmount : 0
         * orderCost : 0
         */

        private String orderDay;
        private String salesAmount;
        private String volume;
        private String weight;
        private String cartonNum;
        private String cusSettleAmount;
        private String channelSettleAmount;
        private String orderCost;

        public String getOrderDay() {
            return orderDay;
        }

        public void setOrderDay(String orderDay) {
            this.orderDay = orderDay;
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
