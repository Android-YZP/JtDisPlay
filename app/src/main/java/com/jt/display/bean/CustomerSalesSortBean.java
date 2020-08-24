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
        private String sumVolume;
        private String sumWeight;
        private String sumAmount;
        private String cusSettleAmount;
        private String channelSettleAmount;
        private String orderCost;
        private String orderNum;
        private String acceptNum;

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getSumVolume() {
            return sumVolume;
        }

        public void setSumVolume(String sumVolume) {
            this.sumVolume = sumVolume;
        }

        public String getSumWeight() {
            return sumWeight;
        }

        public void setSumWeight(String sumWeight) {
            this.sumWeight = sumWeight;
        }

        public String getSumAmount() {
            return sumAmount;
        }

        public void setSumAmount(String sumAmount) {
            this.sumAmount = sumAmount;
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

        public String getOrderNum() {
            return orderNum;
        }

        public void setOrderNum(String orderNum) {
            this.orderNum = orderNum;
        }

        public String getAcceptNum() {
            return acceptNum;
        }

        public void setAcceptNum(String acceptNum) {
            this.acceptNum = acceptNum;
        }
    }
}
