package com.jt.display.base;


public class Constants {
    public static final String WMS_URL_BASE = "http://40.73.59.226:9000";
    public static final String UPDATE_URL = "http://40.73.59.226:9102/app/upgrade";
    public static final String PDA_LOGIN_URL = "http://40.73.59.226:9102/app/user/login";
//    public static final String WMS_URL_BASE = "http://47.114.120.136:9000";
    public static final String AES_PASSWORD = "16b9c7e8695438dc";
    public static final String TENANTID = "000000";

    public static final int HTTP_RETRY_COUNT = 3;
    public static final int PAGER_SIZE = 11;
    public static final int TRANSPORT_PAGER_SIZE = 9;
//    public static final int TRANSPORT_PAGER_SIZE = 2;
    public static final String KEY_AUTO_FOCUS = "preferences_auto_focus";
    public static final String KEY_INVERT_SCAN = "preferences_invert_scan";
    public static final String HOME_PICK_UP_THE_GOODS = "PICK_UP_THE_GOODS";
    public static final String HOME_ACCEPTANCE = "ACCEPTANCE";
    public static final String HOME_PICK_GOODS = "Pickgoods";
    public static final String HOME_PICK_OUT = "HOME_PICK_OUT";
    public static final int JSON_RESULT_SUCCESS = 0;

    public static final int SCAN_CODE= 100;
    public static final int SCAN_CODE_GOODS = 101;
    public static final int SCAN_CODE_CONTAINER= 102;
    public static final int SCAN_CODE_STORAGE= 103;

    public static final int MSG_UPDATE_WAREHOUSE = 1004;


    public static final int METHOD_LOGIN_PDA= 100001;
    public static final int METHOD_LOGIN= 10000;
    public static final int METHOD_ONE= 10002;
    public static final int METHOD_TWO = 10003;
    public static final int METHOD_THREE = 10004;
    public static final int METHOD_FOUR = 10005;
    public static final int METHOD_FIVE = 10006;
    public static final int METHOD_SIX = 10007;
    public static final int METHOD_SEVEN = 10008;
    public static final int METHOD_CHECK_UPGRADE = 10009;

    public static final int HTTP_SUCCESS = 200;
    public static final int HTTP_SUCCESS_PICK_FINISH = 100;
    public static final String HTTP_ERROR = "HTTP 400 Bad Request";


}
