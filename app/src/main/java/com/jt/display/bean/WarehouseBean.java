package com.jt.display.bean;

import java.util.List;

public class WarehouseBean {

    /**
     * code : 200
     * data : [{"id":-1,"tenantId":"000000","createAt":"","createdBy":"","modifiedAt":"","modifiedBy":"","warehouseId":4,"warehouseName":"管理员仓库","userAccount":"admin"},{"id":-1,"tenantId":"000000","createAt":"","createdBy":"","modifiedAt":"","modifiedBy":"","warehouseId":6,"warehouseName":"南通1号仓","userAccount":"admin"},{"id":-1,"tenantId":"000000","createAt":"","createdBy":"","modifiedAt":"","modifiedBy":"","warehouseId":7,"warehouseName":"南通2号仓","userAccount":"admin"},{"id":-1,"tenantId":"000000","createAt":"","createdBy":"","modifiedAt":"","modifiedBy":"","warehouseId":8,"warehouseName":"JD","userAccount":"admin"}]
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
         * id : -1
         * tenantId : 000000
         * createAt :
         * createdBy :
         * modifiedAt :
         * modifiedBy :
         * warehouseId : 4
         * warehouseName : 管理员仓库
         * userAccount : admin
         */

        private int id;
        private String tenantId;
        private String createAt;
        private String createdBy;
        private String modifiedAt;
        private String modifiedBy;
        private int warehouseId;
        private String warehouseName;
        private String userAccount;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTenantId() {
            return tenantId;
        }

        public void setTenantId(String tenantId) {
            this.tenantId = tenantId;
        }

        public String getCreateAt() {
            return createAt;
        }

        public void setCreateAt(String createAt) {
            this.createAt = createAt;
        }

        public String getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }

        public String getModifiedAt() {
            return modifiedAt;
        }

        public void setModifiedAt(String modifiedAt) {
            this.modifiedAt = modifiedAt;
        }

        public String getModifiedBy() {
            return modifiedBy;
        }

        public void setModifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
        }

        public int getWarehouseId() {
            return warehouseId;
        }

        public void setWarehouseId(int warehouseId) {
            this.warehouseId = warehouseId;
        }

        public String getWarehouseName() {
            return warehouseName;
        }

        public void setWarehouseName(String warehouseName) {
            this.warehouseName = warehouseName;
        }

        public String getUserAccount() {
            return userAccount;
        }

        public void setUserAccount(String userAccount) {
            this.userAccount = userAccount;
        }
    }
}
