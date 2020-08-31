package com.jt.display.bean;

import java.util.List;

public class OrderAmountByCustomerBean {

    /**
     * code : 200
     * data : {"currentMonth":[{"orderDay":"2020-08-01","salesAmount":55006.4365,"volume":406.9961,"weight":0,"cartonNum":9132,"cusSettleAmount":0,"channelSettleAmount":55006.4365,"orderCost":30039.54},{"orderDay":"2020-08-02","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-08-03","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-08-04","salesAmount":47954.9795,"volume":328.8467,"weight":0,"cartonNum":5817,"cusSettleAmount":0,"channelSettleAmount":47954.9795,"orderCost":18590.226},{"orderDay":"2020-08-05","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-08-06","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-08-07","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-08-08","salesAmount":97309.7315,"volume":523.6532,"weight":0,"cartonNum":13237,"cusSettleAmount":0,"channelSettleAmount":97309.7315,"orderCost":32842.7925},{"orderDay":"2020-08-09","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-08-10","salesAmount":48157.2522,"volume":494.6426,"weight":0,"cartonNum":11227,"cusSettleAmount":0,"channelSettleAmount":48157.2522,"orderCost":26110.3557},{"orderDay":"2020-08-11","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-08-12","salesAmount":57437.6243,"volume":380.0575,"weight":0,"cartonNum":6523,"cusSettleAmount":0,"channelSettleAmount":57437.6243,"orderCost":32801.546},{"orderDay":"2020-08-13","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-08-14","salesAmount":58439.2436,"volume":381.1406,"weight":0,"cartonNum":8418,"cusSettleAmount":0,"channelSettleAmount":58439.2436,"orderCost":18325.294},{"orderDay":"2020-08-15","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-08-16","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-08-17","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-08-18","salesAmount":41318.9646,"volume":296.653,"weight":0,"cartonNum":5374,"cusSettleAmount":0,"channelSettleAmount":41318.9646,"orderCost":14437.78},{"orderDay":"2020-08-19","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-08-20","salesAmount":27925.4896,"volume":193.3013,"weight":0,"cartonNum":3856,"cusSettleAmount":0,"channelSettleAmount":27925.4896,"orderCost":9001.5818},{"orderDay":"2020-08-21","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-08-22","salesAmount":71665.7611,"volume":373.1103,"weight":0,"cartonNum":9123,"cusSettleAmount":0,"channelSettleAmount":71665.7611,"orderCost":8549.145},{"orderDay":"2020-08-23","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-08-24","salesAmount":110137.651,"volume":675.9303,"weight":0,"cartonNum":14908,"cusSettleAmount":0,"channelSettleAmount":110137.651,"orderCost":57281.2},{"orderDay":"2020-08-25","salesAmount":76472.7219,"volume":413.1009,"weight":0,"cartonNum":9712,"cusSettleAmount":0,"channelSettleAmount":76472.7219,"orderCost":58011.8095},{"orderDay":"2020-08-26","salesAmount":27379.6534,"volume":368.2935,"weight":0,"cartonNum":7909,"cusSettleAmount":0,"channelSettleAmount":27379.6534,"orderCost":6235},{"orderDay":"2020-08-27","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-08-28","salesAmount":51624.7657,"volume":331.0866,"weight":0,"cartonNum":7828,"cusSettleAmount":0,"channelSettleAmount":51624.7657,"orderCost":0},{"orderDay":"2020-08-29","salesAmount":49867.8692,"volume":308.5869,"weight":0,"cartonNum":6745,"cusSettleAmount":0,"channelSettleAmount":49867.8692,"orderCost":0},{"orderDay":"2020-08-30","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-08-31","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0}],"lastMonth":[{"orderDay":"2020-07-01","salesAmount":277352.8586,"volume":1796.4134,"weight":0,"cartonNum":26982,"cusSettleAmount":-35330.9976,"channelSettleAmount":312683.8562,"orderCost":0},{"orderDay":"2020-07-02","salesAmount":54046.2137,"volume":398.1891,"weight":0,"cartonNum":8523,"cusSettleAmount":-10832.5191,"channelSettleAmount":64878.7328,"orderCost":0},{"orderDay":"2020-07-03","salesAmount":35054.834,"volume":381.896,"weight":0,"cartonNum":8071,"cusSettleAmount":1590.9509,"channelSettleAmount":33463.8831,"orderCost":0},{"orderDay":"2020-07-04","salesAmount":59771.9324,"volume":406.154,"weight":0,"cartonNum":6066,"cusSettleAmount":-7327.8135,"channelSettleAmount":67099.7459,"orderCost":0},{"orderDay":"2020-07-05","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-07-06","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-07-07","salesAmount":90245.5659,"volume":578.177,"weight":0,"cartonNum":7498,"cusSettleAmount":-7582.1757,"channelSettleAmount":97827.7416,"orderCost":0},{"orderDay":"2020-07-08","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-07-09","salesAmount":11471.7702,"volume":90.4676,"weight":0,"cartonNum":1446,"cusSettleAmount":-1688.0311,"channelSettleAmount":13159.8013,"orderCost":0},{"orderDay":"2020-07-10","salesAmount":192214.3435,"volume":1164.3464,"weight":0,"cartonNum":18256,"cusSettleAmount":-12015.8381,"channelSettleAmount":204230.1816,"orderCost":0},{"orderDay":"2020-07-11","salesAmount":38323.3703,"volume":359.7043,"weight":0,"cartonNum":8806,"cusSettleAmount":-7021.2835,"channelSettleAmount":45344.6538,"orderCost":0},{"orderDay":"2020-07-12","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-07-13","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-07-14","salesAmount":45684.9148,"volume":317.0619,"weight":0,"cartonNum":4492,"cusSettleAmount":-6816.5513,"channelSettleAmount":52501.4661,"orderCost":0},{"orderDay":"2020-07-15","salesAmount":1076.99,"volume":8.7475,"weight":0,"cartonNum":110,"cusSettleAmount":-196.6437,"channelSettleAmount":1273.6337,"orderCost":0},{"orderDay":"2020-07-16","salesAmount":39426.0852,"volume":216.6856,"weight":0,"cartonNum":5100,"cusSettleAmount":-5477.5098,"channelSettleAmount":44903.595,"orderCost":0},{"orderDay":"2020-07-17","salesAmount":208870.5484,"volume":1508.8444,"weight":0,"cartonNum":22648,"cusSettleAmount":-37648.1031,"channelSettleAmount":246518.6515,"orderCost":0},{"orderDay":"2020-07-18","salesAmount":2042.6884,"volume":13.9566,"weight":0,"cartonNum":279,"cusSettleAmount":-193.1542,"channelSettleAmount":2235.8426,"orderCost":0},{"orderDay":"2020-07-19","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-07-20","salesAmount":56505.5107,"volume":375.1601,"weight":0,"cartonNum":5353,"cusSettleAmount":0,"channelSettleAmount":56505.5107,"orderCost":13484.12},{"orderDay":"2020-07-21","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-07-22","salesAmount":27619.8041,"volume":161.0048,"weight":0,"cartonNum":3107,"cusSettleAmount":0,"channelSettleAmount":27619.8041,"orderCost":2360.88},{"orderDay":"2020-07-23","salesAmount":63527.8409,"volume":408.8509,"weight":0,"cartonNum":9219,"cusSettleAmount":0,"channelSettleAmount":63527.8409,"orderCost":6438.88},{"orderDay":"2020-07-24","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-07-25","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-07-26","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-07-27","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-07-28","salesAmount":24081.4548,"volume":146.5162,"weight":0,"cartonNum":2606,"cusSettleAmount":0,"channelSettleAmount":24081.4548,"orderCost":7300},{"orderDay":"2020-07-29","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-07-30","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0},{"orderDay":"2020-07-31","salesAmount":54580.2413,"volume":314.8748,"weight":0,"cartonNum":6879,"cusSettleAmount":0,"channelSettleAmount":54580.2413,"orderCost":30857.5002}]}
     * msg : 操作成功
     */

    private int code;
    private DataBean data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        private List<CurrentMonthBean> currentMonth;
        private List<LastMonthBean> lastMonth;

        public List<CurrentMonthBean> getCurrentMonth() {
            return currentMonth;
        }

        public void setCurrentMonth(List<CurrentMonthBean> currentMonth) {
            this.currentMonth = currentMonth;
        }

        public List<LastMonthBean> getLastMonth() {
            return lastMonth;
        }

        public void setLastMonth(List<LastMonthBean> lastMonth) {
            this.lastMonth = lastMonth;
        }

        public static class CurrentMonthBean {
            /**
             * orderDay : 2020-08-01
             * salesAmount : 55006.4365
             * volume : 406.9961
             * weight : 0
             * cartonNum : 9132
             * cusSettleAmount : 0
             * channelSettleAmount : 55006.4365
             * orderCost : 30039.54
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

        public static class LastMonthBean {
            /**
             * orderDay : 2020-07-01
             * salesAmount : 277352.8586
             * volume : 1796.4134
             * weight : 0
             * cartonNum : 26982
             * cusSettleAmount : -35330.9976
             * channelSettleAmount : 312683.8562
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
}
