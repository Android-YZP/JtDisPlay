package com.jt.display.bean;

import java.util.List;

public class CurrentDeliveryPlanBean {

    /**
     * code : 200
     * data : {"currentVolumeAndWeightStorageCapacity":{"currentWeightStorageCapacity":4855.2,"currentVolumeStorageCapacity":582.0281},"deliveryPlanList":[{"id":628,"dispatchCarId":976,"license":"苏111111","mobile":"11111111111","planState":0,"deliveryType":1,"carReadyTime":"","start":"南通市通州区张芝山镇香樟路66号","end":"武汉百货B家居日用仓2号库","warehouseType":0,"createTime":"2020-09-02 09:47:55","updateTime":"2020-09-02 09:47:55","status":1,"cartonNum":172,"volume":52.2225,"weight":422.2,"channelOrderNo":"","flag":-1},{"id":629,"dispatchCarId":977,"license":"赣C7N777","mobile":"13507057379","planState":0,"deliveryType":1,"carReadyTime":"","start":"南通市通州区张芝山镇香樟路66号","end":"广州百货B家居日用仓5号库","warehouseType":0,"createTime":"2020-09-02 09:51:19","updateTime":"2020-09-02 09:51:19","status":1,"cartonNum":635,"volume":129.2941,"weight":534.1,"channelOrderNo":"","flag":-1}],"deliveryOrderVolume":132.4511,"deliveryVolume":33980.2377}
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
         * currentVolumeAndWeightStorageCapacity : {"currentWeightStorageCapacity":4855.2,"currentVolumeStorageCapacity":582.0281}
         * deliveryPlanList : [{"id":628,"dispatchCarId":976,"license":"苏111111","mobile":"11111111111","planState":0,"deliveryType":1,"carReadyTime":"","start":"南通市通州区张芝山镇香樟路66号","end":"武汉百货B家居日用仓2号库","warehouseType":0,"createTime":"2020-09-02 09:47:55","updateTime":"2020-09-02 09:47:55","status":1,"cartonNum":172,"volume":52.2225,"weight":422.2,"channelOrderNo":"","flag":-1},{"id":629,"dispatchCarId":977,"license":"赣C7N777","mobile":"13507057379","planState":0,"deliveryType":1,"carReadyTime":"","start":"南通市通州区张芝山镇香樟路66号","end":"广州百货B家居日用仓5号库","warehouseType":0,"createTime":"2020-09-02 09:51:19","updateTime":"2020-09-02 09:51:19","status":1,"cartonNum":635,"volume":129.2941,"weight":534.1,"channelOrderNo":"","flag":-1}]
         * deliveryOrderVolume : 132.4511
         * deliveryVolume : 33980.2377
         */

        private CurrentVolumeAndWeightStorageCapacityBean currentVolumeAndWeightStorageCapacity;
        private String deliveryOrderVolume;
        private String deliveryVolume;
        private List<DeliveryPlanListBean> deliveryPlanList;
        private int total;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public CurrentVolumeAndWeightStorageCapacityBean getCurrentVolumeAndWeightStorageCapacity() {
            return currentVolumeAndWeightStorageCapacity;
        }

        public void setCurrentVolumeAndWeightStorageCapacity(CurrentVolumeAndWeightStorageCapacityBean currentVolumeAndWeightStorageCapacity) {
            this.currentVolumeAndWeightStorageCapacity = currentVolumeAndWeightStorageCapacity;
        }

        public String getDeliveryOrderVolume() {
            return deliveryOrderVolume;
        }

        public void setDeliveryOrderVolume(String deliveryOrderVolume) {
            this.deliveryOrderVolume = deliveryOrderVolume;
        }

        public String getDeliveryVolume() {
            return deliveryVolume;
        }

        public void setDeliveryVolume(String deliveryVolume) {
            this.deliveryVolume = deliveryVolume;
        }

        public List<DeliveryPlanListBean> getDeliveryPlanList() {
            return deliveryPlanList;
        }

        public void setDeliveryPlanList(List<DeliveryPlanListBean> deliveryPlanList) {
            this.deliveryPlanList = deliveryPlanList;
        }

        public static class CurrentVolumeAndWeightStorageCapacityBean {
            /**
             * currentWeightStorageCapacity : 4855.2
             * currentVolumeStorageCapacity : 582.0281
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

        public static class DeliveryPlanListBean {
            /**
             * id : 628
             * dispatchCarId : 976
             * license : 苏111111
             * mobile : 11111111111
             * planState : 0
             * deliveryType : 1
             * carReadyTime : 
             * start : 南通市通州区张芝山镇香樟路66号
             * end : 武汉百货B家居日用仓2号库
             * warehouseType : 0
             * createTime : 2020-09-02 09:47:55
             * updateTime : 2020-09-02 09:47:55
             * status : 1
             * cartonNum : 172
             * volume : 52.2225
             * weight : 422.2
             * channelOrderNo : 
             * flag : -1
             */

            private String id;
            private String dispatchCarId;
            private String license;
            private String mobile;
            private String planState;
            private String deliveryType;
            private String carReadyTime;
            private String start;
            private String end;
            private String warehouseType;
            private String createTime;
            private String updateTime;
            private String status;
            private String cartonNum;
            private String volume;
            private String weight;
            private String channelOrderNo;
            private String flag;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
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

            public String getPlanState() {
                return planState;
            }

            public void setPlanState(String planState) {
                this.planState = planState;
            }

            public String getDeliveryType() {
                return deliveryType;
            }

            public void setDeliveryType(String deliveryType) {
                this.deliveryType = deliveryType;
            }

            public String getCarReadyTime() {
                return carReadyTime;
            }

            public void setCarReadyTime(String carReadyTime) {
                this.carReadyTime = carReadyTime;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getEnd() {
                return end;
            }

            public void setEnd(String end) {
                this.end = end;
            }

            public String getWarehouseType() {
                return warehouseType;
            }

            public void setWarehouseType(String warehouseType) {
                this.warehouseType = warehouseType;
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

            public String getFlag() {
                return flag;
            }

            public void setFlag(String flag) {
                this.flag = flag;
            }
        }
    }
}
