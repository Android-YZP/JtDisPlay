package com.jt.display.bean;

import java.util.List;

public class CustomerSalesSortBean {


    /**
     * code : 200
     * data : [{"customerName":"上海水星电子商务有限公司","sumVolume":0,"sumWeight":0,"sumAmount":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0,"orderNum":0,"acceptNum":0},{"customerName":"扬州纬弗斯体育用品有限公司","sumVolume":0,"sumWeight":0,"sumAmount":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0,"orderNum":0,"acceptNum":0},{"customerName":"江苏东成电器有限公司","sumVolume":0,"sumWeight":0,"sumAmount":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0,"orderNum":0,"acceptNum":0},{"customerName":"安睡宝（上海）电子商务有限公司","sumVolume":0,"sumWeight":0,"sumAmount":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0,"orderNum":0,"acceptNum":0},{"customerName":"宁波居美风尚家纺有限公司","sumVolume":0,"sumWeight":0,"sumAmount":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0,"orderNum":0,"acceptNum":0},{"customerName":"上海珏致信息科技有限公司","sumVolume":0,"sumWeight":0,"sumAmount":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0,"orderNum":0,"acceptNum":0},{"customerName":"海门罗迪纺织品有限公司","sumVolume":0,"sumWeight":0,"sumAmount":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0,"orderNum":0,"acceptNum":0},{"customerName":"宁波美作贸易有限公司","sumVolume":0,"sumWeight":0,"sumAmount":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0,"orderNum":0,"acceptNum":0},{"customerName":"杭州浩逸网络科技有限公司","sumVolume":0,"sumWeight":0,"sumAmount":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0,"orderNum":0,"acceptNum":0},{"customerName":"杭州锅道电子商务有限公司","sumVolume":0,"sumWeight":0,"sumAmount":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0,"orderNum":0,"acceptNum":0}]
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
         * customerName : 上海水星电子商务有限公司
         * sumVolume : 0
         * sumWeight : 0
         * sumAmount : 0
         * cusSettleAmount : 0
         * channelSettleAmount : 0
         * orderCost : 0
         * orderNum : 0
         * acceptNum : 0
         */

        private String customerName;
        private int sumVolume;
        private int sumWeight;
        private int sumAmount;
        private int cusSettleAmount;
        private int channelSettleAmount;
        private int orderCost;
        private int orderNum;
        private int acceptNum;

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public int getSumVolume() {
            return sumVolume;
        }

        public void setSumVolume(int sumVolume) {
            this.sumVolume = sumVolume;
        }

        public int getSumWeight() {
            return sumWeight;
        }

        public void setSumWeight(int sumWeight) {
            this.sumWeight = sumWeight;
        }

        public int getSumAmount() {
            return sumAmount;
        }

        public void setSumAmount(int sumAmount) {
            this.sumAmount = sumAmount;
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

        public int getOrderNum() {
            return orderNum;
        }

        public void setOrderNum(int orderNum) {
            this.orderNum = orderNum;
        }

        public int getAcceptNum() {
            return acceptNum;
        }

        public void setAcceptNum(int acceptNum) {
            this.acceptNum = acceptNum;
        }
    }
}
