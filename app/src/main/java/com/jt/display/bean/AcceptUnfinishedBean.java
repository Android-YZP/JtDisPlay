package com.jt.display.bean;

import java.util.List;

public class AcceptUnfinishedBean {


    /**
     * code : 200
     * data : [{"receiptCode":"qeqeqe","cargoOwnerName":"阿迪达斯","warehouseName":"JD","status":"RECEIVING"}]
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
         * receiptCode : qeqeqe
         * cargoOwnerName : 阿迪达斯
         * warehouseName : JD
         * status : RECEIVING
         */

        private String receiptCode;
        private String cargoOwnerName;
        private String warehouseName;
        private String status;

        public String getReceiptCode() {
            return receiptCode;
        }

        public void setReceiptCode(String receiptCode) {
            this.receiptCode = receiptCode;
        }

        public String getCargoOwnerName() {
            return cargoOwnerName;
        }

        public void setCargoOwnerName(String cargoOwnerName) {
            this.cargoOwnerName = cargoOwnerName;
        }

        public String getWarehouseName() {
            return warehouseName;
        }

        public void setWarehouseName(String warehouseName) {
            this.warehouseName = warehouseName;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
