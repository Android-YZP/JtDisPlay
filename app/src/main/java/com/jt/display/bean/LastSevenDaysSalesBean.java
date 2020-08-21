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
        private int salesAmount;
        private int volume;
        private int weight;
        private int cartonNum;
        private int cusSettleAmount;
        private int channelSettleAmount;
        private int orderCost;

        public String getOrderDay() {
            return orderDay;
        }

        public void setOrderDay(String orderDay) {
            this.orderDay = orderDay;
        }

        public int getSalesAmount() {
            return salesAmount;
        }

        public void setSalesAmount(int salesAmount) {
            this.salesAmount = salesAmount;
        }

        public int getVolume() {
            return volume;
        }

        public void setVolume(int volume) {
            this.volume = volume;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getCartonNum() {
            return cartonNum;
        }

        public void setCartonNum(int cartonNum) {
            this.cartonNum = cartonNum;
        }

        public int getCusSettleAmount() {
            return cusSettleAmount;
        }

        public void setCusSettleAmount(int cusSettleAmount) {
            this.cusSettleAmount = cusSettleAmount;
        }

        public int getChannelSettleAmount() {
            return channelSettleAmount;
        }

        public void setChannelSettleAmount(int channelSettleAmount) {
            this.channelSettleAmount = channelSettleAmount;
        }

        public int getOrderCost() {
            return orderCost;
        }

        public void setOrderCost(int orderCost) {
            this.orderCost = orderCost;
        }
    }
}
