package com.jt.display.bean;

import java.util.List;

public class ShipmentBean {

    /**
     * code : 200
     * data : {"hzShipment":{"hzShipmentCarList":[{"loadCarCharge":200,"forwarderNo":21,"dispatchType":2,"transportStatus":1,"mobile":"19826343326","start":"南通市通州区张芝山镇香樟路66号","remark":"","updateTime":"2020-09-01T09:29:58","linkMan":"唐陆伟","license":"苏BB1529","transCharge":700,"otherCharge":0,"carCode":"D20083059272","transType":1,"createTime":"2020-08-30T17:34:33","planTime":1.598909662E12,"shipType":2,"clockStatus":0,"end":"无锡市惠山区惠澄大道","id":917,"hasDiff":0,"status":1},{"loadCarCharge":200,"forwarderNo":21,"dispatchType":2,"transportStatus":1,"mobile":"13225872680","start":"南通市通州区张芝山镇香樟路66号","remark":"","updateTime":"2020-09-01T09:30:06","linkMan":"冯新涛","license":"皖S1A852","transCharge":700,"otherCharge":0,"carCode":"D20083059053","transType":1,"createTime":"2020-08-30T17:32:22","planTime":1.598909534E12,"shipType":2,"clockStatus":0,"end":"无锡市惠山区惠澄大道","id":916,"hasDiff":0,"status":1},{"loadCarCharge":205.2,"forwarderNo":21,"dispatchType":2,"transportStatus":1,"mobile":"18621800638","start":"南通市通州区张芝山镇香樟路66号","remark":"","updateTime":"2020-09-01T09:30:09","linkMan":"武杰","license":"苏NDV116","transCharge":700,"otherCharge":0,"carCode":"D20083058966","transType":1,"createTime":"2020-08-30T17:24:17","planTime":1.598909039E12,"shipType":2,"clockStatus":0,"end":"无锡市惠山区惠澄大道","id":915,"hasDiff":0,"status":1}],"totalCountShipmentHZ":3,"hzShipmentVolum":0,"hzShipmentPlanVolum":104.2368},"mdcShipment":{"mdcShipmentPlanVolum":128.9116,"mdcShipmentVolum":45.8126,"totalCountShipmentMDC":4,"mdcShipmentCarList":[{"loadCarCharge":0,"dispatchType":2,"transportStatus":2,"mobile":"18994910581","start":"南通市通州区张芝山镇香樟路66号","remark":"","updateTime":"2020-09-01T09:33:27","linkMan":"吴丽华","license":"苏BQ0885","transCharge":0,"otherCharge":0,"carCode":"D20083028088","transType":1,"createTime":"2020-08-30T12:18:33","planTime":1.598933906E12,"shipType":1,"clockStatus":0,"end":"德州百货B家居日用仓3号库","id":897,"hasDiff":0,"status":1},{"loadCarCharge":79.8,"dispatchType":2,"transportStatus":1,"mobile":"13057005111","start":"南通市通州区张芝山镇香樟路66号","remark":"","updateTime":"2020-09-01T09:33:33","linkMan":"梁高峰","license":"苏B9BH78","transCharge":800,"otherCharge":0,"carCode":"D20082921732","transType":1,"createTime":"2020-08-29T17:59:24","planTime":1.598911105E12,"shipType":1,"clockStatus":0,"end":"南京百货B家居日用仓2号库","id":894,"hasDiff":0,"status":1},{"loadCarCharge":171,"dispatchType":2,"transportStatus":2,"mobile":"13218285021","start":"南通市通州区张芝山镇香樟路66号","remark":"","updateTime":"2020-09-01T09:30:45","linkMan":"彭贵金","license":"苏F69596","transCharge":900,"otherCharge":0,"carCode":"D20083028098","transType":1,"createTime":"2020-08-30T14:28:19","planTime":1.598898492E12,"shipType":1,"clockStatus":0,"end":"上海百货B家居日用仓4号库","id":911,"hasDiff":0,"status":1},{"loadCarCharge":267.9,"dispatchType":2,"transportStatus":2,"mobile":"11111111111","start":"南通市通州区张芝山镇香樟路66号","remark":"","updateTime":"2020-09-01T09:30:51","linkMan":"张华","license":"苏FG7255","transCharge":1500,"otherCharge":0,"carCode":"D20083024950","transType":1,"createTime":"2020-08-30T14:25:49","planTime":1.598898345E12,"shipType":1,"clockStatus":0,"end":"上海商超B牛奶水饮仓6号库","id":910,"hasDiff":0,"status":1}]},"shipmentPlanVolum":233.1484,"shipmentVolum":45.8126}
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
        /**
         * hzShipment : {"hzShipmentCarList":[{"loadCarCharge":200,"forwarderNo":21,"dispatchType":2,"transportStatus":1,"mobile":"19826343326","start":"南通市通州区张芝山镇香樟路66号","remark":"","updateTime":"2020-09-01T09:29:58","linkMan":"唐陆伟","license":"苏BB1529","transCharge":700,"otherCharge":0,"carCode":"D20083059272","transType":1,"createTime":"2020-08-30T17:34:33","planTime":1.598909662E12,"shipType":2,"clockStatus":0,"end":"无锡市惠山区惠澄大道","id":917,"hasDiff":0,"status":1},{"loadCarCharge":200,"forwarderNo":21,"dispatchType":2,"transportStatus":1,"mobile":"13225872680","start":"南通市通州区张芝山镇香樟路66号","remark":"","updateTime":"2020-09-01T09:30:06","linkMan":"冯新涛","license":"皖S1A852","transCharge":700,"otherCharge":0,"carCode":"D20083059053","transType":1,"createTime":"2020-08-30T17:32:22","planTime":1.598909534E12,"shipType":2,"clockStatus":0,"end":"无锡市惠山区惠澄大道","id":916,"hasDiff":0,"status":1},{"loadCarCharge":205.2,"forwarderNo":21,"dispatchType":2,"transportStatus":1,"mobile":"18621800638","start":"南通市通州区张芝山镇香樟路66号","remark":"","updateTime":"2020-09-01T09:30:09","linkMan":"武杰","license":"苏NDV116","transCharge":700,"otherCharge":0,"carCode":"D20083058966","transType":1,"createTime":"2020-08-30T17:24:17","planTime":1.598909039E12,"shipType":2,"clockStatus":0,"end":"无锡市惠山区惠澄大道","id":915,"hasDiff":0,"status":1}],"totalCountShipmentHZ":3,"hzShipmentVolum":0,"hzShipmentPlanVolum":104.2368}
         * mdcShipment : {"mdcShipmentPlanVolum":128.9116,"mdcShipmentVolum":45.8126,"totalCountShipmentMDC":4,"mdcShipmentCarList":[{"loadCarCharge":0,"dispatchType":2,"transportStatus":2,"mobile":"18994910581","start":"南通市通州区张芝山镇香樟路66号","remark":"","updateTime":"2020-09-01T09:33:27","linkMan":"吴丽华","license":"苏BQ0885","transCharge":0,"otherCharge":0,"carCode":"D20083028088","transType":1,"createTime":"2020-08-30T12:18:33","planTime":1.598933906E12,"shipType":1,"clockStatus":0,"end":"德州百货B家居日用仓3号库","id":897,"hasDiff":0,"status":1},{"loadCarCharge":79.8,"dispatchType":2,"transportStatus":1,"mobile":"13057005111","start":"南通市通州区张芝山镇香樟路66号","remark":"","updateTime":"2020-09-01T09:33:33","linkMan":"梁高峰","license":"苏B9BH78","transCharge":800,"otherCharge":0,"carCode":"D20082921732","transType":1,"createTime":"2020-08-29T17:59:24","planTime":1.598911105E12,"shipType":1,"clockStatus":0,"end":"南京百货B家居日用仓2号库","id":894,"hasDiff":0,"status":1},{"loadCarCharge":171,"dispatchType":2,"transportStatus":2,"mobile":"13218285021","start":"南通市通州区张芝山镇香樟路66号","remark":"","updateTime":"2020-09-01T09:30:45","linkMan":"彭贵金","license":"苏F69596","transCharge":900,"otherCharge":0,"carCode":"D20083028098","transType":1,"createTime":"2020-08-30T14:28:19","planTime":1.598898492E12,"shipType":1,"clockStatus":0,"end":"上海百货B家居日用仓4号库","id":911,"hasDiff":0,"status":1},{"loadCarCharge":267.9,"dispatchType":2,"transportStatus":2,"mobile":"11111111111","start":"南通市通州区张芝山镇香樟路66号","remark":"","updateTime":"2020-09-01T09:30:51","linkMan":"张华","license":"苏FG7255","transCharge":1500,"otherCharge":0,"carCode":"D20083024950","transType":1,"createTime":"2020-08-30T14:25:49","planTime":1.598898345E12,"shipType":1,"clockStatus":0,"end":"上海商超B牛奶水饮仓6号库","id":910,"hasDiff":0,"status":1}]}
         * shipmentPlanVolum : 233.1484
         * shipmentVolum : 45.8126
         */

        private HzShipmentBean hzShipment;
        private MdcShipmentBean mdcShipment;
        private String shipmentPlanVolum;
        private String shipmentVolum;

        public HzShipmentBean getHzShipment() {
            return hzShipment;
        }

        public void setHzShipment(HzShipmentBean hzShipment) {
            this.hzShipment = hzShipment;
        }

        public MdcShipmentBean getMdcShipment() {
            return mdcShipment;
        }

        public void setMdcShipment(MdcShipmentBean mdcShipment) {
            this.mdcShipment = mdcShipment;
        }

        public String getShipmentPlanVolum() {
            return shipmentPlanVolum;
        }

        public void setShipmentPlanVolum(String shipmentPlanVolum) {
            this.shipmentPlanVolum = shipmentPlanVolum;
        }

        public String getShipmentVolum() {
            return shipmentVolum;
        }

        public void setShipmentVolum(String shipmentVolum) {
            this.shipmentVolum = shipmentVolum;
        }

        public static class HzShipmentBean {
            /**
             * hzShipmentCarList : [{"loadCarCharge":200,"forwarderNo":21,"dispatchType":2,"transportStatus":1,"mobile":"19826343326","start":"南通市通州区张芝山镇香樟路66号","remark":"","updateTime":"2020-09-01T09:29:58","linkMan":"唐陆伟","license":"苏BB1529","transCharge":700,"otherCharge":0,"carCode":"D20083059272","transType":1,"createTime":"2020-08-30T17:34:33","planTime":1.598909662E12,"shipType":2,"clockStatus":0,"end":"无锡市惠山区惠澄大道","id":917,"hasDiff":0,"status":1},{"loadCarCharge":200,"forwarderNo":21,"dispatchType":2,"transportStatus":1,"mobile":"13225872680","start":"南通市通州区张芝山镇香樟路66号","remark":"","updateTime":"2020-09-01T09:30:06","linkMan":"冯新涛","license":"皖S1A852","transCharge":700,"otherCharge":0,"carCode":"D20083059053","transType":1,"createTime":"2020-08-30T17:32:22","planTime":1.598909534E12,"shipType":2,"clockStatus":0,"end":"无锡市惠山区惠澄大道","id":916,"hasDiff":0,"status":1},{"loadCarCharge":205.2,"forwarderNo":21,"dispatchType":2,"transportStatus":1,"mobile":"18621800638","start":"南通市通州区张芝山镇香樟路66号","remark":"","updateTime":"2020-09-01T09:30:09","linkMan":"武杰","license":"苏NDV116","transCharge":700,"otherCharge":0,"carCode":"D20083058966","transType":1,"createTime":"2020-08-30T17:24:17","planTime":1.598909039E12,"shipType":2,"clockStatus":0,"end":"无锡市惠山区惠澄大道","id":915,"hasDiff":0,"status":1}]
             * totalCountShipmentHZ : 3
             * hzShipmentVolum : 0
             * hzShipmentPlanVolum : 104.2368
             */

            private String totalCountShipmentHZ;
            private String hzShipmentVolum;
            private String hzShipmentPlanVolum;
            private List<HzShipmentCarListBean> hzShipmentCarList;

            public String getTotalCountShipmentHZ() {
                return totalCountShipmentHZ;
            }

            public void setTotalCountShipmentHZ(String totalCountShipmentHZ) {
                this.totalCountShipmentHZ = totalCountShipmentHZ;
            }

            public String getHzShipmentVolum() {
                return hzShipmentVolum;
            }

            public void setHzShipmentVolum(String hzShipmentVolum) {
                this.hzShipmentVolum = hzShipmentVolum;
            }

            public String getHzShipmentPlanVolum() {
                return hzShipmentPlanVolum;
            }

            public void setHzShipmentPlanVolum(String hzShipmentPlanVolum) {
                this.hzShipmentPlanVolum = hzShipmentPlanVolum;
            }

            public List<HzShipmentCarListBean> getHzShipmentCarList() {
                return hzShipmentCarList;
            }

            public void setHzShipmentCarList(List<HzShipmentCarListBean> hzShipmentCarList) {
                this.hzShipmentCarList = hzShipmentCarList;
            }

            public static class HzShipmentCarListBean {
                /**
                 * loadCarCharge : 200
                 * forwarderNo : 21
                 * dispatchType : 2
                 * transportStatus : 1
                 * mobile : 19826343326
                 * start : 南通市通州区张芝山镇香樟路66号
                 * remark : 
                 * updateTime : 2020-09-01T09:29:58
                 * linkMan : 唐陆伟
                 * license : 苏BB1529
                 * transCharge : 700
                 * otherCharge : 0
                 * carCode : D20083059272
                 * transType : 1
                 * createTime : 2020-08-30T17:34:33
                 * planTime : 1.598909662E12
                 * shipType : 2
                 * clockStatus : 0
                 * end : 无锡市惠山区惠澄大道
                 * id : 917
                 * hasDiff : 0
                 * status : 1
                 */

                private String loadCarCharge;
                private String forwarderNo;
                private String dispatchType;
                private String transportStatus;
                private String mobile;
                private String start;
                private String remark;
                private String updateTime;
                private String linkMan;
                private String license;
                private String transCharge;
                private String otherCharge;
                private String carCode;
                private String transType;
                private String createTime;
                private String planTime;
                private String shipType;
                private String clockStatus;
                private String end;
                private String id;
                private String hasDiff;
                private String status;
                private String volume;
                private String cost;

                public String getCost() {
                    return cost;
                }

                public void setCost(String cost) {
                    this.cost = cost;
                }
                public String getVolume() {
                    return volume;
                }

                public void setVolume(String volume) {
                    this.volume = volume;
                }

                public String getLoadCarCharge() {
                    return loadCarCharge;
                }

                public void setLoadCarCharge(String loadCarCharge) {
                    this.loadCarCharge = loadCarCharge;
                }

                public String getForwarderNo() {
                    return forwarderNo;
                }

                public void setForwarderNo(String forwarderNo) {
                    this.forwarderNo = forwarderNo;
                }

                public String getDispatchType() {
                    return dispatchType;
                }

                public void setDispatchType(String dispatchType) {
                    this.dispatchType = dispatchType;
                }

                public String getTransportStatus() {
                    return transportStatus;
                }

                public void setTransportStatus(String transportStatus) {
                    this.transportStatus = transportStatus;
                }

                public String getMobile() {
                    return mobile;
                }

                public void setMobile(String mobile) {
                    this.mobile = mobile;
                }

                public String getStart() {
                    return start;
                }

                public void setStart(String start) {
                    this.start = start;
                }

                public String getRemark() {
                    return remark;
                }

                public void setRemark(String remark) {
                    this.remark = remark;
                }

                public String getUpdateTime() {
                    return updateTime;
                }

                public void setUpdateTime(String updateTime) {
                    this.updateTime = updateTime;
                }

                public String getLinkMan() {
                    return linkMan;
                }

                public void setLinkMan(String linkMan) {
                    this.linkMan = linkMan;
                }

                public String getLicense() {
                    return license;
                }

                public void setLicense(String license) {
                    this.license = license;
                }

                public String getTransCharge() {
                    return transCharge;
                }

                public void setTransCharge(String transCharge) {
                    this.transCharge = transCharge;
                }

                public String getOtherCharge() {
                    return otherCharge;
                }

                public void setOtherCharge(String otherCharge) {
                    this.otherCharge = otherCharge;
                }

                public String getCarCode() {
                    return carCode;
                }

                public void setCarCode(String carCode) {
                    this.carCode = carCode;
                }

                public String getTransType() {
                    return transType;
                }

                public void setTransType(String transType) {
                    this.transType = transType;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public String getPlanTime() {
                    return planTime;
                }

                public void setPlanTime(String planTime) {
                    this.planTime = planTime;
                }

                public String getShipType() {
                    return shipType;
                }

                public void setShipType(String shipType) {
                    this.shipType = shipType;
                }

                public String getClockStatus() {
                    return clockStatus;
                }

                public void setClockStatus(String clockStatus) {
                    this.clockStatus = clockStatus;
                }

                public String getEnd() {
                    return end;
                }

                public void setEnd(String end) {
                    this.end = end;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getHasDiff() {
                    return hasDiff;
                }

                public void setHasDiff(String hasDiff) {
                    this.hasDiff = hasDiff;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }
            }
        }

        public static class MdcShipmentBean {
            /**
             * mdcShipmentPlanVolum : 128.9116
             * mdcShipmentVolum : 45.8126
             * totalCountShipmentMDC : 4
             * mdcShipmentCarList : [{"loadCarCharge":0,"dispatchType":2,"transportStatus":2,"mobile":"18994910581","start":"南通市通州区张芝山镇香樟路66号","remark":"","updateTime":"2020-09-01T09:33:27","linkMan":"吴丽华","license":"苏BQ0885","transCharge":0,"otherCharge":0,"carCode":"D20083028088","transType":1,"createTime":"2020-08-30T12:18:33","planTime":1.598933906E12,"shipType":1,"clockStatus":0,"end":"德州百货B家居日用仓3号库","id":897,"hasDiff":0,"status":1},{"loadCarCharge":79.8,"dispatchType":2,"transportStatus":1,"mobile":"13057005111","start":"南通市通州区张芝山镇香樟路66号","remark":"","updateTime":"2020-09-01T09:33:33","linkMan":"梁高峰","license":"苏B9BH78","transCharge":800,"otherCharge":0,"carCode":"D20082921732","transType":1,"createTime":"2020-08-29T17:59:24","planTime":1.598911105E12,"shipType":1,"clockStatus":0,"end":"南京百货B家居日用仓2号库","id":894,"hasDiff":0,"status":1},{"loadCarCharge":171,"dispatchType":2,"transportStatus":2,"mobile":"13218285021","start":"南通市通州区张芝山镇香樟路66号","remark":"","updateTime":"2020-09-01T09:30:45","linkMan":"彭贵金","license":"苏F69596","transCharge":900,"otherCharge":0,"carCode":"D20083028098","transType":1,"createTime":"2020-08-30T14:28:19","planTime":1.598898492E12,"shipType":1,"clockStatus":0,"end":"上海百货B家居日用仓4号库","id":911,"hasDiff":0,"status":1},{"loadCarCharge":267.9,"dispatchType":2,"transportStatus":2,"mobile":"11111111111","start":"南通市通州区张芝山镇香樟路66号","remark":"","updateTime":"2020-09-01T09:30:51","linkMan":"张华","license":"苏FG7255","transCharge":1500,"otherCharge":0,"carCode":"D20083024950","transType":1,"createTime":"2020-08-30T14:25:49","planTime":1.598898345E12,"shipType":1,"clockStatus":0,"end":"上海商超B牛奶水饮仓6号库","id":910,"hasDiff":0,"status":1}]
             */

            private String mdcShipmentPlanVolum;
            private String mdcShipmentVolum;
            private String totalCountShipmentMDC;
            private List<MdcShipmentCarListBean> mdcShipmentCarList;

            public String getMdcShipmentPlanVolum() {
                return mdcShipmentPlanVolum;
            }

            public void setMdcShipmentPlanVolum(String mdcShipmentPlanVolum) {
                this.mdcShipmentPlanVolum = mdcShipmentPlanVolum;
            }

            public String getMdcShipmentVolum() {
                return mdcShipmentVolum;
            }

            public void setMdcShipmentVolum(String mdcShipmentVolum) {
                this.mdcShipmentVolum = mdcShipmentVolum;
            }

            public String getTotalCountShipmentMDC() {
                return totalCountShipmentMDC;
            }

            public void setTotalCountShipmentMDC(String totalCountShipmentMDC) {
                this.totalCountShipmentMDC = totalCountShipmentMDC;
            }

            public List<MdcShipmentCarListBean> getMdcShipmentCarList() {
                return mdcShipmentCarList;
            }

            public void setMdcShipmentCarList(List<MdcShipmentCarListBean> mdcShipmentCarList) {
                this.mdcShipmentCarList = mdcShipmentCarList;
            }

            public static class MdcShipmentCarListBean {
                /**
                 * loadCarCharge : 0
                 * dispatchType : 2
                 * transportStatus : 2
                 * mobile : 18994910581
                 * start : 南通市通州区张芝山镇香樟路66号
                 * remark : 
                 * updateTime : 2020-09-01T09:33:27
                 * linkMan : 吴丽华
                 * license : 苏BQ0885
                 * transCharge : 0
                 * otherCharge : 0
                 * carCode : D20083028088
                 * transType : 1
                 * createTime : 2020-08-30T12:18:33
                 * planTime : 1.598933906E12
                 * shipType : 1
                 * clockStatus : 0
                 * end : 德州百货B家居日用仓3号库
                 * id : 897
                 * hasDiff : 0
                 * status : 1
                 */

                private String loadCarCharge;
                private String dispatchType;
                private String transportStatus;
                private String mobile;
                private String start;
                private String remark;
                private String updateTime;
                private String linkMan;
                private String license;
                private String transCharge;
                private String otherCharge;
                private String carCode;
                private String transType;
                private String createTime;
                private String planTime;
                private String shipType;
                private String clockStatus;
                private String end;
                private String id;
                private String hasDiff;
                private String status;
                private String volume;
                private String cost;

                public String getCost() {
                    return cost;
                }

                public void setCost(String cost) {
                    this.cost = cost;
                }
                public String getVolume() {
                    return volume;
                }

                public void setVolume(String volume) {
                    this.volume = volume;
                }

                public String getLoadCarCharge() {
                    return loadCarCharge;
                }

                public void setLoadCarCharge(String loadCarCharge) {
                    this.loadCarCharge = loadCarCharge;
                }

                public String getDispatchType() {
                    return dispatchType;
                }

                public void setDispatchType(String dispatchType) {
                    this.dispatchType = dispatchType;
                }

                public String getTransportStatus() {
                    return transportStatus;
                }

                public void setTransportStatus(String transportStatus) {
                    this.transportStatus = transportStatus;
                }

                public String getMobile() {
                    return mobile;
                }

                public void setMobile(String mobile) {
                    this.mobile = mobile;
                }

                public String getStart() {
                    return start;
                }

                public void setStart(String start) {
                    this.start = start;
                }

                public String getRemark() {
                    return remark;
                }

                public void setRemark(String remark) {
                    this.remark = remark;
                }

                public String getUpdateTime() {
                    return updateTime;
                }

                public void setUpdateTime(String updateTime) {
                    this.updateTime = updateTime;
                }

                public String getLinkMan() {
                    return linkMan;
                }

                public void setLinkMan(String linkMan) {
                    this.linkMan = linkMan;
                }

                public String getLicense() {
                    return license;
                }

                public void setLicense(String license) {
                    this.license = license;
                }

                public String getTransCharge() {
                    return transCharge;
                }

                public void setTransCharge(String transCharge) {
                    this.transCharge = transCharge;
                }

                public String getOtherCharge() {
                    return otherCharge;
                }

                public void setOtherCharge(String otherCharge) {
                    this.otherCharge = otherCharge;
                }

                public String getCarCode() {
                    return carCode;
                }

                public void setCarCode(String carCode) {
                    this.carCode = carCode;
                }

                public String getTransType() {
                    return transType;
                }

                public void setTransType(String transType) {
                    this.transType = transType;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public String getPlanTime() {
                    return planTime;
                }

                public void setPlanTime(String planTime) {
                    this.planTime = planTime;
                }

                public String getShipType() {
                    return shipType;
                }

                public void setShipType(String shipType) {
                    this.shipType = shipType;
                }

                public String getClockStatus() {
                    return clockStatus;
                }

                public void setClockStatus(String clockStatus) {
                    this.clockStatus = clockStatus;
                }

                public String getEnd() {
                    return end;
                }

                public void setEnd(String end) {
                    this.end = end;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getHasDiff() {
                    return hasDiff;
                }

                public void setHasDiff(String hasDiff) {
                    this.hasDiff = hasDiff;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }
            }
        }
    }
}
