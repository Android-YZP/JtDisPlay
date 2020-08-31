package com.jt.display.bean;

import java.util.List;

public class TopAndDownCustomerBean {


    /**
     * code : 200
     * data : {"topCustomerList":[{"customerName":"欧普智慧照明科技有限公司（华南）","sumVolume":6954.8554,"sumWeight":-1,"sumAmount":1069205.6325,"cusSettleAmount":-1,"channelSettleAmount":-1,"orderCost":-1,"orderNum":423,"acceptNum":-1},{"customerName":"欧普智慧照明科技有限公司","sumVolume":5475.3995,"sumWeight":-1,"sumAmount":820698.1441,"cusSettleAmount":-1,"channelSettleAmount":-1,"orderCost":-1,"orderNum":318,"acceptNum":-1},{"customerName":"上海罗莱LOVO家用纺织品有限公司","sumVolume":1345.93,"sumWeight":-1,"sumAmount":218917.38,"cusSettleAmount":-1,"channelSettleAmount":-1,"orderCost":-1,"orderNum":157,"acceptNum":-1},{"customerName":"无锡自然家居针纺织品有限公司","sumVolume":1082.595,"sumWeight":-1,"sumAmount":197535.8,"cusSettleAmount":-1,"channelSettleAmount":-1,"orderCost":-1,"orderNum":637,"acceptNum":-1},{"customerName":"上海水星电子商务有限公司","sumVolume":1194.1324,"sumWeight":-1,"sumAmount":184868.86,"cusSettleAmount":-1,"channelSettleAmount":-1,"orderCost":-1,"orderNum":401,"acceptNum":-1},{"customerName":"上海有侑实业有限公司","sumVolume":1047.08,"sumWeight":-1,"sumAmount":158596.75,"cusSettleAmount":-1,"channelSettleAmount":-1,"orderCost":-1,"orderNum":469,"acceptNum":-1},{"customerName":"南通天然阁家用纺织品有限公司","sumVolume":881.37,"sumWeight":-1,"sumAmount":149090.85,"cusSettleAmount":-1,"channelSettleAmount":-1,"orderCost":-1,"orderNum":904,"acceptNum":-1},{"customerName":"海门罗迪纺织品有限公司","sumVolume":845.9939,"sumWeight":-1,"sumAmount":146426.1905,"cusSettleAmount":-1,"channelSettleAmount":-1,"orderCost":-1,"orderNum":819,"acceptNum":-1},{"customerName":"上海罗莱家用纺织品有限公司","sumVolume":925.07,"sumWeight":-1,"sumAmount":154267.14,"cusSettleAmount":-1,"channelSettleAmount":-1,"orderCost":-1,"orderNum":129,"acceptNum":-1},{"customerName":"南通小雨纺织品有限公司","sumVolume":802.9,"sumWeight":-1,"sumAmount":124979.3,"cusSettleAmount":-1,"channelSettleAmount":-1,"orderCost":-1,"orderNum":333,"acceptNum":-1}],"downCustomerList":[{"customerName":"宁波美作贸易有限公司","sumVolume":2.2,"sumWeight":-1,"sumAmount":255.2,"cusSettleAmount":-1,"channelSettleAmount":-1,"orderCost":-1,"orderNum":3,"acceptNum":-1},{"customerName":"南通绫帛薇布家纺有限公司","sumVolume":2.5,"sumWeight":-1,"sumAmount":452.3,"cusSettleAmount":-1,"channelSettleAmount":-1,"orderCost":-1,"orderNum":11,"acceptNum":-1},{"customerName":"无锡戴可思生物科技有限公司","sumVolume":3,"sumWeight":-1,"sumAmount":456,"cusSettleAmount":-1,"channelSettleAmount":-1,"orderCost":-1,"orderNum":1,"acceptNum":-1},{"customerName":"南通梦随礼纺织科技有限公司","sumVolume":4.048,"sumWeight":-1,"sumAmount":670.7536,"cusSettleAmount":-1,"channelSettleAmount":-1,"orderCost":-1,"orderNum":20,"acceptNum":-1},{"customerName":"江苏悦达生活科技有限公司上海万航渡路分公司","sumVolume":5.52,"sumWeight":-1,"sumAmount":1272.88,"cusSettleAmount":-1,"channelSettleAmount":-1,"orderCost":-1,"orderNum":8,"acceptNum":-1},{"customerName":"南通大也纺织品有限公司","sumVolume":9.52,"sumWeight":-1,"sumAmount":1350.82,"cusSettleAmount":-1,"channelSettleAmount":-1,"orderCost":-1,"orderNum":33,"acceptNum":-1},{"customerName":"上海宥阿尘实业有限公司","sumVolume":8.73,"sumWeight":-1,"sumAmount":1464.58,"cusSettleAmount":-1,"channelSettleAmount":-1,"orderCost":-1,"orderNum":22,"acceptNum":-1},{"customerName":"南通吉庭纺织品有限公司","sumVolume":13.83,"sumWeight":-1,"sumAmount":1724.97,"cusSettleAmount":-1,"channelSettleAmount":-1,"orderCost":-1,"orderNum":21,"acceptNum":-1},{"customerName":"南通香阁娜纺织品有限公司","sumVolume":12.58,"sumWeight":-1,"sumAmount":2009.32,"cusSettleAmount":-1,"channelSettleAmount":-1,"orderCost":-1,"orderNum":17,"acceptNum":-1},{"customerName":"南通赛沃纺织品有限公司","sumVolume":11.42,"sumWeight":-1,"sumAmount":2036.03,"cusSettleAmount":-1,"channelSettleAmount":-1,"orderCost":-1,"orderNum":34,"acceptNum":-1}]}
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
        private List<TopCustomerListBean> topCustomerList;
        private List<DownCustomerListBean> downCustomerList;

        public List<TopCustomerListBean> getTopCustomerList() {
            return topCustomerList;
        }

        public void setTopCustomerList(List<TopCustomerListBean> topCustomerList) {
            this.topCustomerList = topCustomerList;
        }

        public List<DownCustomerListBean> getDownCustomerList() {
            return downCustomerList;
        }

        public void setDownCustomerList(List<DownCustomerListBean> downCustomerList) {
            this.downCustomerList = downCustomerList;
        }

        public static class TopCustomerListBean {
            /**
             * customerName : 欧普智慧照明科技有限公司（华南）
             * sumVolume : 6954.8554
             * sumWeight : -1
             * sumAmount : 1069205.6325
             * cusSettleAmount : -1
             * channelSettleAmount : -1
             * orderCost : -1
             * orderNum : 423
             * acceptNum : -1
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

        public static class DownCustomerListBean {
            /**
             * customerName : 宁波美作贸易有限公司
             * sumVolume : 2.2
             * sumWeight : -1
             * sumAmount : 255.2
             * cusSettleAmount : -1
             * channelSettleAmount : -1
             * orderCost : -1
             * orderNum : 3
             * acceptNum : -1
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
}
