package com.jt.display.bean;

import java.util.List;

public class ChannelCityOrderCostReportBean {

    /**
     * code : 200
     * data : {"otherOrderCostList":[{"cityName":"北京","currentMonthOrderCost":0,"lastMonthOrderCost":81.8214},{"cityName":"天津","currentMonthOrderCost":0,"lastMonthOrderCost":87.5632},{"cityName":"唐山","currentMonthOrderCost":0,"lastMonthOrderCost":0},{"cityName":"保定","currentMonthOrderCost":0,"lastMonthOrderCost":119.1962},{"cityName":"廊坊","currentMonthOrderCost":0,"lastMonthOrderCost":0},{"cityName":"广州","currentMonthOrderCost":0,"lastMonthOrderCost":130.6177},{"cityName":"佛山","currentMonthOrderCost":0,"lastMonthOrderCost":117.9894},{"cityName":"东莞","currentMonthOrderCost":0,"lastMonthOrderCost":0},{"cityName":"上海","currentMonthOrderCost":0,"lastMonthOrderCost":30.1661},{"cityName":"苏州","currentMonthOrderCost":0,"lastMonthOrderCost":35.5683},{"cityName":"南通","currentMonthOrderCost":0,"lastMonthOrderCost":0},{"cityName":"无锡","currentMonthOrderCost":0,"lastMonthOrderCost":160.8287},{"cityName":"成都","currentMonthOrderCost":0,"lastMonthOrderCost":77.3492},{"cityName":"德阳","currentMonthOrderCost":0,"lastMonthOrderCost":38.3858},{"cityName":"武汉","currentMonthOrderCost":0,"lastMonthOrderCost":83.4173},{"cityName":"西安","currentMonthOrderCost":0,"lastMonthOrderCost":64.5986},{"cityName":"沈阳","currentMonthOrderCost":0,"lastMonthOrderCost":72.8788},{"cityName":"德州","currentMonthOrderCost":0,"lastMonthOrderCost":86.8885},{"cityName":"济南","currentMonthOrderCost":0,"lastMonthOrderCost":94},{"cityName":"涿州","currentMonthOrderCost":0,"lastMonthOrderCost":0},{"cityName":"深圳","currentMonthOrderCost":0,"lastMonthOrderCost":151.896},{"cityName":"连云港","currentMonthOrderCost":0,"lastMonthOrderCost":0},{"cityName":"杭州","currentMonthOrderCost":0,"lastMonthOrderCost":175.12},{"cityName":"镇江","currentMonthOrderCost":0,"lastMonthOrderCost":51.1979},{"cityName":"郑州","currentMonthOrderCost":0,"lastMonthOrderCost":55.5539},{"cityName":"福州","currentMonthOrderCost":0,"lastMonthOrderCost":0}],"nanTongOrderCostList":[{"cityName":"北京","currentMonthOrderCost":0,"lastMonthOrderCost":81.8214},{"cityName":"天津","currentMonthOrderCost":0,"lastMonthOrderCost":87.5632},{"cityName":"唐山","currentMonthOrderCost":0,"lastMonthOrderCost":0},{"cityName":"保定","currentMonthOrderCost":0,"lastMonthOrderCost":119.1962},{"cityName":"廊坊","currentMonthOrderCost":0,"lastMonthOrderCost":0},{"cityName":"广州","currentMonthOrderCost":0,"lastMonthOrderCost":130.6177},{"cityName":"佛山","currentMonthOrderCost":0,"lastMonthOrderCost":117.9894},{"cityName":"东莞","currentMonthOrderCost":0,"lastMonthOrderCost":0},{"cityName":"上海","currentMonthOrderCost":0,"lastMonthOrderCost":30.1661},{"cityName":"苏州","currentMonthOrderCost":0,"lastMonthOrderCost":35.5683},{"cityName":"南通","currentMonthOrderCost":0,"lastMonthOrderCost":0},{"cityName":"无锡","currentMonthOrderCost":0,"lastMonthOrderCost":160.8287},{"cityName":"成都","currentMonthOrderCost":0,"lastMonthOrderCost":77.3492},{"cityName":"德阳","currentMonthOrderCost":0,"lastMonthOrderCost":38.3858},{"cityName":"武汉","currentMonthOrderCost":0,"lastMonthOrderCost":83.4173},{"cityName":"西安","currentMonthOrderCost":0,"lastMonthOrderCost":64.5986},{"cityName":"沈阳","currentMonthOrderCost":0,"lastMonthOrderCost":72.8788},{"cityName":"德州","currentMonthOrderCost":0,"lastMonthOrderCost":86.8885},{"cityName":"济南","currentMonthOrderCost":0,"lastMonthOrderCost":94},{"cityName":"涿州","currentMonthOrderCost":0,"lastMonthOrderCost":0},{"cityName":"深圳","currentMonthOrderCost":0,"lastMonthOrderCost":151.896},{"cityName":"连云港","currentMonthOrderCost":0,"lastMonthOrderCost":0},{"cityName":"杭州","currentMonthOrderCost":0,"lastMonthOrderCost":175.12},{"cityName":"镇江","currentMonthOrderCost":0,"lastMonthOrderCost":51.1979},{"cityName":"郑州","currentMonthOrderCost":0,"lastMonthOrderCost":55.5539},{"cityName":"福州","currentMonthOrderCost":0,"lastMonthOrderCost":0}]}
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
        private List<OtherOrderCostListBean> otherOrderCostList;
        private List<NanTongOrderCostListBean> nanTongOrderCostList;

        public List<OtherOrderCostListBean> getOtherOrderCostList() {
            return otherOrderCostList;
        }

        public void setOtherOrderCostList(List<OtherOrderCostListBean> otherOrderCostList) {
            this.otherOrderCostList = otherOrderCostList;
        }

        public List<NanTongOrderCostListBean> getNanTongOrderCostList() {
            return nanTongOrderCostList;
        }

        public void setNanTongOrderCostList(List<NanTongOrderCostListBean> nanTongOrderCostList) {
            this.nanTongOrderCostList = nanTongOrderCostList;
        }

        public static class OtherOrderCostListBean {
            /**
             * cityName : 北京
             * currentMonthOrderCost : 0
             * lastMonthOrderCost : 81.8214
             */

            private String cityName;
            private String currentMonthOrderCost;
            private String lastMonthOrderCost;

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public String getCurrentMonthOrderCost() {
                return currentMonthOrderCost;
            }

            public void setCurrentMonthOrderCost(String currentMonthOrderCost) {
                this.currentMonthOrderCost = currentMonthOrderCost;
            }

            public String getLastMonthOrderCost() {
                return lastMonthOrderCost;
            }

            public void setLastMonthOrderCost(String lastMonthOrderCost) {
                this.lastMonthOrderCost = lastMonthOrderCost;
            }
        }

        public static class NanTongOrderCostListBean {
            /**
             * cityName : 北京
             * currentMonthOrderCost : 0
             * lastMonthOrderCost : 81.8214
             */

            private String cityName;
            private String currentMonthOrderCost;
            private String lastMonthOrderCost;

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public String getCurrentMonthOrderCost() {
                return currentMonthOrderCost;
            }

            public void setCurrentMonthOrderCost(String currentMonthOrderCost) {
                this.currentMonthOrderCost = currentMonthOrderCost;
            }

            public String getLastMonthOrderCost() {
                return lastMonthOrderCost;
            }

            public void setLastMonthOrderCost(String lastMonthOrderCost) {
                this.lastMonthOrderCost = lastMonthOrderCost;
            }
        }
    }
}
