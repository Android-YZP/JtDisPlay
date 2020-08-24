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
        private int receiveVolume;
        private int receiveWeight;
        private int deliveryVolume;
        private int deliveryWeight;
        private int currentVolumeStorageCapacity;
        private int currentWeightStorageCapacity;

        public String getCurrentDate() {
            return currentDate;
        }

        public void setCurrentDate(String currentDate) {
            this.currentDate = currentDate;
        }

        public int getReceiveVolume() {
            return receiveVolume;
        }

        public void setReceiveVolume(int receiveVolume) {
            this.receiveVolume = receiveVolume;
        }

        public int getReceiveWeight() {
            return receiveWeight;
        }

        public void setReceiveWeight(int receiveWeight) {
            this.receiveWeight = receiveWeight;
        }

        public int getDeliveryVolume() {
            return deliveryVolume;
        }

        public void setDeliveryVolume(int deliveryVolume) {
            this.deliveryVolume = deliveryVolume;
        }

        public int getDeliveryWeight() {
            return deliveryWeight;
        }

        public void setDeliveryWeight(int deliveryWeight) {
            this.deliveryWeight = deliveryWeight;
        }

        public int getCurrentVolumeStorageCapacity() {
            return currentVolumeStorageCapacity;
        }

        public void setCurrentVolumeStorageCapacity(int currentVolumeStorageCapacity) {
            this.currentVolumeStorageCapacity = currentVolumeStorageCapacity;
        }

        public int getCurrentWeightStorageCapacity() {
            return currentWeightStorageCapacity;
        }

        public void setCurrentWeightStorageCapacity(int currentWeightStorageCapacity) {
            this.currentWeightStorageCapacity = currentWeightStorageCapacity;
        }
    }
}
