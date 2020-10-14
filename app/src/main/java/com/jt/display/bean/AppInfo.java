package com.jt.display.bean;

public class AppInfo {

    private String packageName;
    private Integer versionCode;
    private String mac;

    public AppInfo() {
    }

    public AppInfo(String packageName, Integer versionCode, String mac) {
        this.packageName = packageName;
        this.versionCode = versionCode;
        this.mac = mac;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Integer getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }
}
