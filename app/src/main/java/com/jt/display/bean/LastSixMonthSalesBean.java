package com.jt.display.bean;

import java.util.List;

public class LastSixMonthSalesBean {

    /**
     * code : 200
     * data : [{"orderMonth":"2020-03","salesAmount":2593288.8236,"volume":15930.39,"weight":0,"cartonNum":144307,"cusSettleAmount":39203.2836,"channelSettleAmount":2554085.54,"orderCost":0},{"orderMonth":"2020-04","salesAmount":3229207.5756,"volume":20077.4,"weight":0,"cartonNum":227190,"cusSettleAmount":-18693.7844,"channelSettleAmount":3247901.36,"orderCost":0},{"orderMonth":"2020-05","salesAmount":5206942.0587,"volume":32112.2004,"weight":0,"cartonNum":358688,"cusSettleAmount":99763.6174,"channelSettleAmount":5107178.4413,"orderCost":0},{"orderMonth":"2020-06","salesAmount":2742872.556,"volume":17635.9457,"weight":0,"cartonNum":204764,"cusSettleAmount":-42721.581,"channelSettleAmount":2785594.137,"orderCost":0},{"orderMonth":"2020-07","salesAmount":3082156.3203,"volume":19618.6586,"weight":132070.14,"cartonNum":235962,"cusSettleAmount":-90698.6679,"channelSettleAmount":3172854.9882,"orderCost":331947.5734},{"orderMonth":"2020-08","salesAmount":1648096.3279,"volume":10422.4709,"weight":279488.76,"cartonNum":129749,"cusSettleAmount":35522.6515,"channelSettleAmount":1612573.6764,"orderCost":428277.5034}]
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
        private double salesAmount;
        private double volume;
        private int weight;
        private int cartonNum;
        private double cusSettleAmount;
        private double channelSettleAmount;
        private int orderCost;

        public String getOrderMonth() {
            return orderMonth;
        }

        public void setOrderMonth(String orderMonth) {
            this.orderMonth = orderMonth;
        }

        public double getSalesAmount() {
            return salesAmount;
        }

        public void setSalesAmount(double salesAmount) {
            this.salesAmount = salesAmount;
        }

        public double getVolume() {
            return volume;
        }

        public void setVolume(double volume) {
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

        public double getCusSettleAmount() {
            return cusSettleAmount;
        }

        public void setCusSettleAmount(double cusSettleAmount) {
            this.cusSettleAmount = cusSettleAmount;
        }

        public double getChannelSettleAmount() {
            return channelSettleAmount;
        }

        public void setChannelSettleAmount(double channelSettleAmount) {
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
