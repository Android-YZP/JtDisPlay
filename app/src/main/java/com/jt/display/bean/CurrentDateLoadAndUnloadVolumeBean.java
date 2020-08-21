package com.jt.display.bean;

import java.util.List;

public class CurrentDateLoadAndUnloadVolumeBean {

    /**
     * code : 200
     * data : [{"currentDate":"2020-08-21","takeWareLoadAndUnloadVolume":0.06,"tcLoadAndUnloadVolume":0,"jdLoadAndUnloadVolume":0}]
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
         * takeWareLoadAndUnloadVolume : 0.06
         * tcLoadAndUnloadVolume : 0
         * jdLoadAndUnloadVolume : 0
         */

        private String currentDate;
        private double takeWareLoadAndUnloadVolume;
        private int tcLoadAndUnloadVolume;
        private int jdLoadAndUnloadVolume;

        public String getCurrentDate() {
            return currentDate;
        }

        public void setCurrentDate(String currentDate) {
            this.currentDate = currentDate;
        }

        public double getTakeWareLoadAndUnloadVolume() {
            return takeWareLoadAndUnloadVolume;
        }

        public void setTakeWareLoadAndUnloadVolume(double takeWareLoadAndUnloadVolume) {
            this.takeWareLoadAndUnloadVolume = takeWareLoadAndUnloadVolume;
        }

        public int getTcLoadAndUnloadVolume() {
            return tcLoadAndUnloadVolume;
        }

        public void setTcLoadAndUnloadVolume(int tcLoadAndUnloadVolume) {
            this.tcLoadAndUnloadVolume = tcLoadAndUnloadVolume;
        }

        public int getJdLoadAndUnloadVolume() {
            return jdLoadAndUnloadVolume;
        }

        public void setJdLoadAndUnloadVolume(int jdLoadAndUnloadVolume) {
            this.jdLoadAndUnloadVolume = jdLoadAndUnloadVolume;
        }
    }
}
