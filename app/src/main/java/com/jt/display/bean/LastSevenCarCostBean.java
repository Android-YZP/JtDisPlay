package com.jt.display.bean;

import java.util.List;

public class LastSevenCarCostBean {

    /**
     * code : 200
     * data : [{"dispatchCarDay":"2020-08-15","transChargeSum":0},{"dispatchCarDay":"2020-08-16","transChargeSum":0},{"dispatchCarDay":"2020-08-17","transChargeSum":1000},{"dispatchCarDay":"2020-08-18","transChargeSum":0},{"dispatchCarDay":"2020-08-19","transChargeSum":200},{"dispatchCarDay":"2020-08-20","transChargeSum":0},{"dispatchCarDay":"2020-08-21","transChargeSum":0}]
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
         * dispatchCarDay : 2020-08-15
         * transChargeSum : 0
         */

        private String dispatchCarDay;
        private String transChargeSum;

        public String getDispatchCarDay() {
            return dispatchCarDay;
        }

        public void setDispatchCarDay(String dispatchCarDay) {
            this.dispatchCarDay = dispatchCarDay;
        }

        public String getTransChargeSum() {
            return transChargeSum;
        }

        public void setTransChargeSum(String transChargeSum) {
            this.transChargeSum = transChargeSum;
        }
    }
}
