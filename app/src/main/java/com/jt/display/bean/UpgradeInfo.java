package com.jt.display.bean;

public class UpgradeInfo {


    /**
     * msg : success
     * code : 0
     * data : {"md5":"134792","upgradeMsg":"","upgradeUrl":"/api/jtms-logistics/apk/d68fc11d585d4a41b5f5145372e55ee3.apk","versionName":"1.0.0.2"}
     */

    private String msg;
    private int code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

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

    public static class DataBean {
        /**
         * md5 : 134792
         * upgradeMsg :
         * upgradeUrl : /api/jtms-logistics/apk/d68fc11d585d4a41b5f5145372e55ee3.apk
         * versionName : 1.0.0.2
         */

        private String md5;
        private String upgradeMsg;
        private String upgradeUrl;
        private String versionName;
        private int versionCode;

        public int getVersionCode() {
            return versionCode;
        }

        public void setVersionCode(int versionCode) {
            this.versionCode = versionCode;
        }


        public String getMd5() {
            return md5;
        }

        public void setMd5(String md5) {
            this.md5 = md5;
        }

        public String getUpgradeMsg() {
            return upgradeMsg;
        }

        public void setUpgradeMsg(String upgradeMsg) {
            this.upgradeMsg = upgradeMsg;
        }

        public String getUpgradeUrl() {
            return upgradeUrl;
        }

        public void setUpgradeUrl(String upgradeUrl) {
            this.upgradeUrl = upgradeUrl;
        }

        public String getVersionName() {
            return versionName;
        }

        public void setVersionName(String versionName) {
            this.versionName = versionName;
        }
    }
}
