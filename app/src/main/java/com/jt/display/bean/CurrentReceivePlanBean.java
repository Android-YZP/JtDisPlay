package com.jt.display.bean;

import java.util.List;

public class CurrentReceivePlanBean {


    /**
     * code : 200
     * data : {"currentVolumeAndWeightStorageCapacity":{"currentWeightStorageCapacity":10017.5,"currentVolumeStorageCapacity":921.5531},"sumVolume":652.596,"hasStoredVolume":0,"receiveWarePlanList":[{"id":15,"customerId":28,"customerName":"欧普智慧照明科技有限公司","warehouseType":0,"isSelfDelivery":0,"planState":0,"dispatchCarId":20,"license":"苏E3N566","mobile":"13257680820","expectReceiveTime":"2020-07-21 08:00:00","carReadyTime":"","createTime":"2020-07-21 09:26:23","updateTime":"2020-07-21 09:26:23","status":1,"cartonNum":694,"volume":42.8229,"weight":0,"channelOrderNo":""},{"id":60,"customerId":5,"customerName":"上海水星电子商务有限公司","warehouseType":0,"isSelfDelivery":0,"planState":0,"dispatchCarId":86,"license":"苏F69596","mobile":"13218285021","expectReceiveTime":"2020-07-24 09:00:00","carReadyTime":"","createTime":"2020-07-24 09:01:24","updateTime":"2020-07-24 09:01:24","status":1,"cartonNum":184,"volume":22.5314,"weight":0,"channelOrderNo":""},{"id":61,"customerId":65,"customerName":"上海罗莱LOVO家用纺织品有限公司","warehouseType":0,"isSelfDelivery":0,"planState":0,"dispatchCarId":88,"license":"赣CB7875","mobile":"18912527848","expectReceiveTime":"2020-07-24 15:00:00","carReadyTime":"","createTime":"2020-07-24 09:18:48","updateTime":"2020-07-24 09:18:48","status":1,"cartonNum":705,"volume":166.49,"weight":0,"channelOrderNo":""},{"id":62,"customerId":5,"customerName":"上海水星电子商务有限公司","warehouseType":0,"isSelfDelivery":0,"planState":0,"dispatchCarId":89,"license":"苏B9BH78","mobile":"13057005111","expectReceiveTime":"2020-07-24 09:00:00","carReadyTime":"","createTime":"2020-07-24 09:20:07","updateTime":"2020-07-24 09:20:07","status":1,"cartonNum":48,"volume":4.5587,"weight":0,"channelOrderNo":""},{"id":68,"customerId":66,"customerName":"上海罗莱家用纺织品有限公司","warehouseType":0,"isSelfDelivery":0,"planState":0,"dispatchCarId":88,"license":"18912527848|赣CB7875|88","mobile":"18912527848","expectReceiveTime":"2020-07-23 14:00:00","carReadyTime":"","createTime":"2020-07-24 11:12:10","updateTime":"2020-07-24 11:12:10","status":1,"cartonNum":11,"volume":2.73,"weight":0,"channelOrderNo":""},{"id":90,"customerId":69,"customerName":"滔搏企业发展（上海）有限公司","warehouseType":0,"isSelfDelivery":1,"planState":0,"dispatchCarId":-1,"license":"","mobile":"","expectReceiveTime":"2020-07-26 10:00:00","carReadyTime":"","createTime":"2020-07-25 09:28:36","updateTime":"2020-07-25 09:28:36","status":1,"cartonNum":-1,"volume":-1,"weight":-1,"channelOrderNo":""},{"id":91,"customerId":65,"customerName":"上海罗莱LOVO家用纺织品有限公司","warehouseType":0,"isSelfDelivery":0,"planState":0,"dispatchCarId":114,"license":"赣CB7875","mobile":"18912527848","expectReceiveTime":"2020-07-25 16:00:00","carReadyTime":"","createTime":"2020-07-25 10:42:24","updateTime":"2020-07-25 10:42:24","status":1,"cartonNum":245,"volume":51.08,"weight":0,"channelOrderNo":""},{"id":92,"customerId":66,"customerName":"上海罗莱家用纺织品有限公司","warehouseType":0,"isSelfDelivery":0,"planState":0,"dispatchCarId":114,"license":"赣CB7875","mobile":"18912527848","expectReceiveTime":"2020-07-25 13:00:00","carReadyTime":"","createTime":"2020-07-25 10:42:24","updateTime":"2020-07-25 10:42:24","status":1,"cartonNum":363,"volume":107.1,"weight":0,"channelOrderNo":""},{"id":112,"customerId":37,"customerName":"上海有侑实业有限公司","warehouseType":0,"isSelfDelivery":1,"planState":0,"dispatchCarId":-1,"license":"","mobile":"","expectReceiveTime":"2020-07-28 13:00:00","carReadyTime":"","createTime":"2020-07-27 17:01:05","updateTime":"2020-07-27 17:01:05","status":1,"cartonNum":-1,"volume":-1,"weight":-1,"channelOrderNo":""},{"id":186,"customerId":5,"customerName":"上海���星电子商务有限公司","warehouseType":0,"isSelfDelivery":0,"planState":0,"dispatchCarId":259,"license":"苏BM21K0","mobile":"18029680253","expectReceiveTime":"2020-07-31 08:00:00","carReadyTime":"","createTime":"2020-08-01 09:13:32","updateTime":"2020-08-01 09:13:32","status":1,"cartonNum":-1,"volume":-1,"weight":-1,"channelOrderNo":""}]}
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
        /**
         * currentVolumeAndWeightStorageCapacity : {"currentWeightStorageCapacity":10017.5,"currentVolumeStorageCapacity":921.5531}
         * sumVolume : 652.596
         * hasStoredVolume : 0
         * receiveWarePlanList : [{"id":15,"customerId":28,"customerName":"欧普智慧照明科技有限公司","warehouseType":0,"isSelfDelivery":0,"planState":0,"dispatchCarId":20,"license":"苏E3N566","mobile":"13257680820","expectReceiveTime":"2020-07-21 08:00:00","carReadyTime":"","createTime":"2020-07-21 09:26:23","updateTime":"2020-07-21 09:26:23","status":1,"cartonNum":694,"volume":42.8229,"weight":0,"channelOrderNo":""},{"id":60,"customerId":5,"customerName":"上海水星电子商务有限公司","warehouseType":0,"isSelfDelivery":0,"planState":0,"dispatchCarId":86,"license":"苏F69596","mobile":"13218285021","expectReceiveTime":"2020-07-24 09:00:00","carReadyTime":"","createTime":"2020-07-24 09:01:24","updateTime":"2020-07-24 09:01:24","status":1,"cartonNum":184,"volume":22.5314,"weight":0,"channelOrderNo":""},{"id":61,"customerId":65,"customerName":"上海罗莱LOVO家用纺织品有限公司","warehouseType":0,"isSelfDelivery":0,"planState":0,"dispatchCarId":88,"license":"赣CB7875","mobile":"18912527848","expectReceiveTime":"2020-07-24 15:00:00","carReadyTime":"","createTime":"2020-07-24 09:18:48","updateTime":"2020-07-24 09:18:48","status":1,"cartonNum":705,"volume":166.49,"weight":0,"channelOrderNo":""},{"id":62,"customerId":5,"customerName":"上海水星电子商务有限公司","warehouseType":0,"isSelfDelivery":0,"planState":0,"dispatchCarId":89,"license":"苏B9BH78","mobile":"13057005111","expectReceiveTime":"2020-07-24 09:00:00","carReadyTime":"","createTime":"2020-07-24 09:20:07","updateTime":"2020-07-24 09:20:07","status":1,"cartonNum":48,"volume":4.5587,"weight":0,"channelOrderNo":""},{"id":68,"customerId":66,"customerName":"上海罗莱家用纺织品有限公司","warehouseType":0,"isSelfDelivery":0,"planState":0,"dispatchCarId":88,"license":"18912527848|赣CB7875|88","mobile":"18912527848","expectReceiveTime":"2020-07-23 14:00:00","carReadyTime":"","createTime":"2020-07-24 11:12:10","updateTime":"2020-07-24 11:12:10","status":1,"cartonNum":11,"volume":2.73,"weight":0,"channelOrderNo":""},{"id":90,"customerId":69,"customerName":"滔搏企业发展（上海）有限公司","warehouseType":0,"isSelfDelivery":1,"planState":0,"dispatchCarId":-1,"license":"","mobile":"","expectReceiveTime":"2020-07-26 10:00:00","carReadyTime":"","createTime":"2020-07-25 09:28:36","updateTime":"2020-07-25 09:28:36","status":1,"cartonNum":-1,"volume":-1,"weight":-1,"channelOrderNo":""},{"id":91,"customerId":65,"customerName":"上海罗莱LOVO家用纺织品有限公司","warehouseType":0,"isSelfDelivery":0,"planState":0,"dispatchCarId":114,"license":"赣CB7875","mobile":"18912527848","expectReceiveTime":"2020-07-25 16:00:00","carReadyTime":"","createTime":"2020-07-25 10:42:24","updateTime":"2020-07-25 10:42:24","status":1,"cartonNum":245,"volume":51.08,"weight":0,"channelOrderNo":""},{"id":92,"customerId":66,"customerName":"上海罗莱家用纺织品有限公司","warehouseType":0,"isSelfDelivery":0,"planState":0,"dispatchCarId":114,"license":"赣CB7875","mobile":"18912527848","expectReceiveTime":"2020-07-25 13:00:00","carReadyTime":"","createTime":"2020-07-25 10:42:24","updateTime":"2020-07-25 10:42:24","status":1,"cartonNum":363,"volume":107.1,"weight":0,"channelOrderNo":""},{"id":112,"customerId":37,"customerName":"上海有侑实业有限公司","warehouseType":0,"isSelfDelivery":1,"planState":0,"dispatchCarId":-1,"license":"","mobile":"","expectReceiveTime":"2020-07-28 13:00:00","carReadyTime":"","createTime":"2020-07-27 17:01:05","updateTime":"2020-07-27 17:01:05","status":1,"cartonNum":-1,"volume":-1,"weight":-1,"channelOrderNo":""},{"id":186,"customerId":5,"customerName":"上海���星电子商务有限公司","warehouseType":0,"isSelfDelivery":0,"planState":0,"dispatchCarId":259,"license":"苏BM21K0","mobile":"18029680253","expectReceiveTime":"2020-07-31 08:00:00","carReadyTime":"","createTime":"2020-08-01 09:13:32","updateTime":"2020-08-01 09:13:32","status":1,"cartonNum":-1,"volume":-1,"weight":-1,"channelOrderNo":""}]
         */

        private CurrentVolumeAndWeightStorageCapacityBean currentVolumeAndWeightStorageCapacity;
        private String sumVolume;
        private String hasStoredVolume;
        private List<ReceiveWarePlanListBean> receiveWarePlanList;

        public CurrentVolumeAndWeightStorageCapacityBean getCurrentVolumeAndWeightStorageCapacity() {
            return currentVolumeAndWeightStorageCapacity;
        }

        public void setCurrentVolumeAndWeightStorageCapacity(CurrentVolumeAndWeightStorageCapacityBean currentVolumeAndWeightStorageCapacity) {
            this.currentVolumeAndWeightStorageCapacity = currentVolumeAndWeightStorageCapacity;
        }

        public String getSumVolume() {
            return sumVolume;
        }

        public void setSumVolume(String sumVolume) {
            this.sumVolume = sumVolume;
        }

        public String getHasStoredVolume() {
            return hasStoredVolume;
        }

        public void setHasStoredVolume(String hasStoredVolume) {
            this.hasStoredVolume = hasStoredVolume;
        }

        public List<ReceiveWarePlanListBean> getReceiveWarePlanList() {
            return receiveWarePlanList;
        }

        public void setReceiveWarePlanList(List<ReceiveWarePlanListBean> receiveWarePlanList) {
            this.receiveWarePlanList = receiveWarePlanList;
        }

        public static class CurrentVolumeAndWeightStorageCapacityBean {
            /**
             * currentWeightStorageCapacity : 10017.5
             * currentVolumeStorageCapacity : 921.5531
             */

            private String currentWeightStorageCapacity;
            private String currentVolumeStorageCapacity;

            public String getCurrentWeightStorageCapacity() {
                return currentWeightStorageCapacity;
            }

            public void setCurrentWeightStorageCapacity(String currentWeightStorageCapacity) {
                this.currentWeightStorageCapacity = currentWeightStorageCapacity;
            }

            public String getCurrentVolumeStorageCapacity() {
                return currentVolumeStorageCapacity;
            }

            public void setCurrentVolumeStorageCapacity(String currentVolumeStorageCapacity) {
                this.currentVolumeStorageCapacity = currentVolumeStorageCapacity;
            }
        }

        public static class ReceiveWarePlanListBean {
            /**
             * id : 15
             * customerId : 28
             * customerName : 欧普智慧照明科技有限公司
             * warehouseType : 0
             * isSelfDelivery : 0
             * planState : 0
             * dispatchCarId : 20
             * license : 苏E3N566
             * mobile : 13257680820
             * expectReceiveTime : 2020-07-21 08:00:00
             * carReadyTime : 
             * createTime : 2020-07-21 09:26:23
             * updateTime : 2020-07-21 09:26:23
             * status : 1
             * cartonNum : 694
             * volume : 42.8229
             * weight : 0
             * channelOrderNo : 
             */

            private String id;
            private String customerId;
            private String customerName;
            private String warehouseType;
            private String isSelfDelivery;
            private String planState;
            private String dispatchCarId;
            private String license;
            private String mobile;
            private String expectReceiveTime;
            private String carReadyTime;
            private String createTime;
            private String updateTime;
            private String status;
            private String cartonNum;
            private String volume;
            private String weight;
            private String channelOrderNo;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCustomerId() {
                return customerId;
            }

            public void setCustomerId(String customerId) {
                this.customerId = customerId;
            }

            public String getCustomerName() {
                return customerName;
            }

            public void setCustomerName(String customerName) {
                this.customerName = customerName;
            }

            public String getWarehouseType() {
                return warehouseType;
            }

            public void setWarehouseType(String warehouseType) {
                this.warehouseType = warehouseType;
            }

            public String getIsSelfDelivery() {
                return isSelfDelivery;
            }

            public void setIsSelfDelivery(String isSelfDelivery) {
                this.isSelfDelivery = isSelfDelivery;
            }

            public String getPlanState() {
                return planState;
            }

            public void setPlanState(String planState) {
                this.planState = planState;
            }

            public String getDispatchCarId() {
                return dispatchCarId;
            }

            public void setDispatchCarId(String dispatchCarId) {
                this.dispatchCarId = dispatchCarId;
            }

            public String getLicense() {
                return license;
            }

            public void setLicense(String license) {
                this.license = license;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getExpectReceiveTime() {
                return expectReceiveTime;
            }

            public void setExpectReceiveTime(String expectReceiveTime) {
                this.expectReceiveTime = expectReceiveTime;
            }

            public String getCarReadyTime() {
                return carReadyTime;
            }

            public void setCarReadyTime(String carReadyTime) {
                this.carReadyTime = carReadyTime;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getCartonNum() {
                return cartonNum;
            }

            public void setCartonNum(String cartonNum) {
                this.cartonNum = cartonNum;
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

            public String getChannelOrderNo() {
                return channelOrderNo;
            }

            public void setChannelOrderNo(String channelOrderNo) {
                this.channelOrderNo = channelOrderNo;
            }
        }
    }
}
