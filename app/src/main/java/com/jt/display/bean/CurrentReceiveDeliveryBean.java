package com.jt.display.bean;

import java.util.List;

public class CurrentReceiveDeliveryBean {

    /**
     * code : 200
     * data : [{"currentDate":"2020-08-21","receiveVolume":0,"receiveWeight":0,"deliveryVolume":0,"deliveryWeight":0,"currentVolumeStorageCapacity":0,"currentWeightStorageCapacity":0}]
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
         * currentDate : 2020-08-21
         * receiveVolume : 0
         * receiveWeight : 0
         * deliveryVolume : 0
         * deliveryWeight : 0
         * currentVolumeStorageCapacity : 0
         * currentWeightStorageCapacity : 0
         */

        private String currentDate;
        private String receiveVolume;
        private String receiveWeight;
        private String deliveryVolume;
        private String deliveryWeight;
        private String currentVolumeStorageCapacity;
        private String currentWeightStorageCapacity;

        public String getCurrentDate() {
            return currentDate;
        }

        public void setCurrentDate(String currentDate) {
            this.currentDate = currentDate;
        }

        public String getReceiveVolume() {
            return receiveVolume;
        }

        public void setReceiveVolume(String receiveVolume) {
            this.receiveVolume = receiveVolume;
        }

        public String getReceiveWeight() {
            return receiveWeight;
        }

        public void setReceiveWeight(String receiveWeight) {
            this.receiveWeight = receiveWeight;
        }

        public String getDeliveryVolume() {
            return deliveryVolume;
        }

        public void setDeliveryVolume(String deliveryVolume) {
            this.deliveryVolume = deliveryVolume;
        }

        public String getDeliveryWeight() {
            return deliveryWeight;
        }

        public void setDeliveryWeight(String deliveryWeight) {
            this.deliveryWeight = deliveryWeight;
        }

        public String getCurrentVolumeStorageCapacity() {
            return currentVolumeStorageCapacity;
        }

        public void setCurrentVolumeStorageCapacity(String currentVolumeStorageCapacity) {
            this.currentVolumeStorageCapacity = currentVolumeStorageCapacity;
        }

        public String getCurrentWeightStorageCapacity() {
            return currentWeightStorageCapacity;
        }

        public void setCurrentWeightStorageCapacity(String currentWeightStorageCapacity) {
            this.currentWeightStorageCapacity = currentWeightStorageCapacity;
        }
    }
}
