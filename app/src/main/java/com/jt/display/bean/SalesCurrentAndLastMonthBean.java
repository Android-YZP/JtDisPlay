package com.jt.display.bean;

import java.util.List;

public class SalesCurrentAndLastMonthBean {


    /**
     * code : 200
     * data : {"currentMonth":[{"orderDay":"2020-08-01","salesAmount":312210.1488,"volume":1990.4143,"weight":73908.15,"cartonNum":27403,"cusSettleAmount":3942,"channelSettleAmount":308268.1488,"orderCost":137894.5875},{"orderDay":"2020-08-02","salesAmount":63988.3,"volume":410.0845,"weight":0,"cartonNum":2135,"cusSettleAmount":0,"channelSettleAmount":63988.3,"orderCost":26507.4549},{"orderDay":"2020-08-03","salesAmount":23728.5395,"volume":178.9715,"weight":0,"cartonNum":1345,"cusSettleAmount":0,"channelSettleAmount":23728.5395,"orderCost":4764.7247},{"orderDay":"2020-08-04","salesAmount":111476.7937,"volume":643.3948,"weight":18956.3,"cartonNum":9366,"cusSettleAmount":1250.8,"channelSettleAmount":110225.9937,"orderCost":29247.1186},{"orderDay":"2020-08-05","salesAmount":222314.2441,"volume":1439.0233,"weight":76572.28,"cartonNum":14294,"cusSettleAmount":7538.8,"channelSettleAmount":214775.4441,"orderCost":76499.9919},{"orderDay":"2020-08-06","salesAmount":73956.9973,"volume":470.9451,"weight":0,"cartonNum":2915,"cusSettleAmount":0,"channelSettleAmount":73956.9973,"orderCost":12405.2842},{"orderDay":"2020-08-07","salesAmount":64459.9296,"volume":426.7307,"weight":3360.34,"cartonNum":3107,"cusSettleAmount":4434.8885,"channelSettleAmount":60025.0411,"orderCost":14018.2743},{"orderDay":"2020-08-08","salesAmount":310006.7205,"volume":1870.4147,"weight":77842.69,"cartonNum":35434,"cusSettleAmount":12712.563,"channelSettleAmount":297294.1575,"orderCost":103274.5309},{"orderDay":"2020-08-09","salesAmount":31931.77,"volume":191.55,"weight":0,"cartonNum":1031,"cusSettleAmount":0,"channelSettleAmount":31931.77,"orderCost":13020.0211},{"orderDay":"2020-08-10","salesAmount":95181.8677,"volume":784.7939,"weight":570,"cartonNum":12988,"cusSettleAmount":721,"channelSettleAmount":94460.8677,"orderCost":49534.9499},{"orderDay":"2020-08-11","salesAmount":54460.659,"volume":288.474,"weight":16917,"cartonNum":2341,"cusSettleAmount":0,"channelSettleAmount":54460.659,"orderCost":1972.722},{"orderDay":"2020-08-12","salesAmount":295931.4077,"volume":1777.6261,"weight":11362,"cartonNum":17718,"cusSettleAmount":4946.6,"channelSettleAmount":290984.8077,"orderCost":130713.3814},{"orderDay":"2020-08-13","salesAmount":49427.6147,"volume":297.718,"weight":0,"cartonNum":1680,"cusSettleAmount":343.6,"channelSettleAmount":49084.0147,"orderCost":9262.5909},{"orderDay":"2020-08-14","salesAmount":193195.462,"volume":1315.3542,"weight":38657.65,"cartonNum":18519,"cusSettleAmount":3630.0912,"channelSettleAmount":189565.3708,"orderCost":68486.7975},{"orderDay":"2020-08-15","salesAmount":37115.568,"volume":210.506,"weight":6020,"cartonNum":1368,"cusSettleAmount":7693.5,"channelSettleAmount":29422.068,"orderCost":1258.1026},{"orderDay":"2020-08-16","salesAmount":46184.612,"volume":248.335,"weight":0,"cartonNum":1273,"cusSettleAmount":0,"channelSettleAmount":46184.612,"orderCost":0},{"orderDay":"2020-08-17","salesAmount":25229.8888,"volume":147.6477,"weight":0,"cartonNum":1013,"cusSettleAmount":1.496,"channelSettleAmount":25228.3928,"orderCost":3399.7491},{"orderDay":"2020-08-18","salesAmount":112514.8945,"volume":729.0567,"weight":17871,"cartonNum":8484,"cusSettleAmount":0,"channelSettleAmount":112514.8945,"orderCost":19082.574},{"orderDay":"2020-08-19","salesAmount":211324.0933,"volume":1181.7793,"weight":5505,"cartonNum":8344,"cusSettleAmount":22001.4398,"channelSettleAmount":189322.6535,"orderCost":1872.0001},{"orderDay":"2020-08-20","salesAmount":191995.2653,"volume":1220.3372,"weight":50028.99,"cartonNum":14156,"cusSettleAmount":1587.042,"channelSettleAmount":190408.2233,"orderCost":84407.6106},{"orderDay":"2020-08-21","salesAmount":107305.6776,"volume":589.3333,"weight":11496,"cartonNum":6787,"cusSettleAmount":4908.6888,"channelSettleAmount":102396.9888,"orderCost":41664.4219},{"orderDay":"2020-08-22","salesAmount":259553.987,"volume":1445.6575,"weight":0,"cartonNum":20772,"cusSettleAmount":0,"channelSettleAmount":259553.987,"orderCost":73623.1171},{"orderDay":"2020-08-23","salesAmount":61913.5,"volume":454.55,"weight":0,"cartonNum":3601,"cusSettleAmount":0,"channelSettleAmount":61913.5,"orderCost":15061.5259},{"orderDay":"2020-08-24","salesAmount":208874.7832,"volume":1470.9983,"weight":41079.28,"cartonNum":28507,"cusSettleAmount":13826.4763,"channelSettleAmount":195048.3069,"orderCost":96386.5956},{"orderDay":"2020-08-25","salesAmount":259579.3215,"volume":1506.0744,"weight":72418.86,"cartonNum":22241,"cusSettleAmount":0,"channelSettleAmount":259579.3215,"orderCost":130756.3651},{"orderDay":"2020-08-26","salesAmount":195555.9791,"volume":1277.0462,"weight":23215.3,"cartonNum":13173,"cusSettleAmount":1194.5486,"channelSettleAmount":194361.4305,"orderCost":26791.5756},{"orderDay":"2020-08-27","salesAmount":82729.2464,"volume":497.6277,"weight":16575.42,"cartonNum":4606,"cusSettleAmount":5994.578,"channelSettleAmount":76734.6684,"orderCost":1066.6068},{"orderDay":"2020-08-28","salesAmount":302105.6312,"volume":1872.2063,"weight":60129.54,"cartonNum":21855,"cusSettleAmount":5835.1201,"channelSettleAmount":296270.5111,"orderCost":0},{"orderDay":"2020-08-29","salesAmount":231596.1355,"volume":1447.5524,"weight":66330.45,"cartonNum":18898,"cusSettleAmount":1622,"channelSettleAmount":229974.1355,"orderCost":0},{"orderDay":"2020-08-30","salesAmount":33839.847,"volume":200.3044,"weight":0,"cartonNum":882,"cusSettleAmount":0,"channelSettleAmount":33839.847,"orderCost":0},{"orderDay":"2020-08-31","salesAmount":0,"volume":0,"weight":0,"cartonNum":0,"cusSettleAmount":0,"channelSettleAmount":0,"orderCost":0}],"lastMonth":[{"orderDay":"2020-07-01","salesAmount":350883.6331,"volume":2232.5513,"weight":0,"cartonNum":30251,"cusSettleAmount":-33653.3976,"channelSettleAmount":384537.0307,"orderCost":0},{"orderDay":"2020-07-02","salesAmount":109981.094,"volume":753.5427,"weight":0,"cartonNum":10765,"cusSettleAmount":-10639.8791,"channelSettleAmount":120620.9731,"orderCost":0},{"orderDay":"2020-07-03","salesAmount":82007.8135,"volume":644.2078,"weight":0,"cartonNum":10563,"cusSettleAmount":3657.2509,"channelSettleAmount":78350.5626,"orderCost":0},{"orderDay":"2020-07-04","salesAmount":118413.7864,"volume":739.486,"weight":0,"cartonNum":8195,"cusSettleAmount":-6503.6135,"channelSettleAmount":124917.3999,"orderCost":0},{"orderDay":"2020-07-05","salesAmount":34618.48,"volume":202.68,"weight":0,"cartonNum":1365,"cusSettleAmount":-94.6,"channelSettleAmount":34713.08,"orderCost":0},{"orderDay":"2020-07-06","salesAmount":33683.5503,"volume":202.589,"weight":0,"cartonNum":2039,"cusSettleAmount":1114.2655,"channelSettleAmount":32569.2848,"orderCost":0},{"orderDay":"2020-07-07","salesAmount":130577.1759,"volume":828.9681,"weight":0,"cartonNum":9445,"cusSettleAmount":-7012.8157,"channelSettleAmount":137589.9916,"orderCost":0},{"orderDay":"2020-07-08","salesAmount":84601.0782,"volume":550.7424,"weight":0,"cartonNum":2780,"cusSettleAmount":0,"channelSettleAmount":84601.0782,"orderCost":0},{"orderDay":"2020-07-09","salesAmount":59473.5922,"volume":360.4147,"weight":0,"cartonNum":4087,"cusSettleAmount":-148.4611,"channelSettleAmount":59622.0533,"orderCost":0},{"orderDay":"2020-07-10","salesAmount":233207.8162,"volume":1393.6335,"weight":0,"cartonNum":20407,"cusSettleAmount":-12063.3381,"channelSettleAmount":245271.1543,"orderCost":0},{"orderDay":"2020-07-11","salesAmount":86889.2388,"volume":662.3793,"weight":0,"cartonNum":11136,"cusSettleAmount":-5788.1835,"channelSettleAmount":92677.4223,"orderCost":0},{"orderDay":"2020-07-12","salesAmount":10569.84,"volume":64.96,"weight":0,"cartonNum":454,"cusSettleAmount":0,"channelSettleAmount":10569.84,"orderCost":0},{"orderDay":"2020-07-13","salesAmount":48846.2944,"volume":303.7501,"weight":0,"cartonNum":2273,"cusSettleAmount":154.345,"channelSettleAmount":48691.9494,"orderCost":0},{"orderDay":"2020-07-14","salesAmount":75298.0711,"volume":488.783,"weight":0,"cartonNum":6343,"cusSettleAmount":-4112.9513,"channelSettleAmount":79411.0224,"orderCost":0},{"orderDay":"2020-07-15","salesAmount":76388.1927,"volume":482.8506,"weight":0,"cartonNum":3458,"cusSettleAmount":-196.6437,"channelSettleAmount":76584.8364,"orderCost":0},{"orderDay":"2020-07-16","salesAmount":127677.0605,"volume":730.1767,"weight":0,"cartonNum":8732,"cusSettleAmount":-2877.9351,"channelSettleAmount":130554.9956,"orderCost":0},{"orderDay":"2020-07-17","salesAmount":247352.7194,"volume":1737.8858,"weight":0,"cartonNum":24332,"cusSettleAmount":-36594.8031,"channelSettleAmount":283947.5225,"orderCost":0},{"orderDay":"2020-07-18","salesAmount":38784.2744,"volume":249.1166,"weight":0,"cartonNum":1818,"cusSettleAmount":-225.0942,"channelSettleAmount":39009.3686,"orderCost":0},{"orderDay":"2020-07-19","salesAmount":14719.06,"volume":94.76,"weight":0,"cartonNum":467,"cusSettleAmount":0,"channelSettleAmount":14719.06,"orderCost":0},{"orderDay":"2020-07-20","salesAmount":140530.8982,"volume":872.5681,"weight":31935.53,"cartonNum":10688,"cusSettleAmount":360,"channelSettleAmount":140170.8982,"orderCost":22727.155},{"orderDay":"2020-07-21","salesAmount":99895.8609,"volume":677.2609,"weight":13009.5,"cartonNum":5606,"cusSettleAmount":0,"channelSettleAmount":99895.8609,"orderCost":22379.2386},{"orderDay":"2020-07-22","salesAmount":72398.1118,"volume":415.4905,"weight":0,"cartonNum":5462,"cusSettleAmount":2950.28,"channelSettleAmount":69447.8318,"orderCost":11941.15},{"orderDay":"2020-07-23","salesAmount":150328.0673,"volume":953.3099,"weight":0,"cartonNum":15534,"cusSettleAmount":8699.5754,"channelSettleAmount":141628.4919,"orderCost":21241.3146},{"orderDay":"2020-07-24","salesAmount":155466.4547,"volume":945.4829,"weight":46186.22,"cartonNum":10432,"cusSettleAmount":349.1,"channelSettleAmount":155117.3547,"orderCost":30143.2575},{"orderDay":"2020-07-25","salesAmount":46743.1273,"volume":300.1045,"weight":0,"cartonNum":1943,"cusSettleAmount":166.6,"channelSettleAmount":46576.5273,"orderCost":2785.58},{"orderDay":"2020-07-26","salesAmount":37071.09,"volume":186.94,"weight":0,"cartonNum":1434,"cusSettleAmount":2538,"channelSettleAmount":34533.09,"orderCost":12072.9921},{"orderDay":"2020-07-27","salesAmount":56250.711,"volume":371.61,"weight":0,"cartonNum":1861,"cusSettleAmount":0,"channelSettleAmount":56250.711,"orderCost":27519.0009},{"orderDay":"2020-07-28","salesAmount":104637.681,"volume":644.156,"weight":35504.39,"cartonNum":7461,"cusSettleAmount":1993,"channelSettleAmount":102644.681,"orderCost":41901.3822},{"orderDay":"2020-07-29","salesAmount":68773.1174,"volume":413.1663,"weight":0,"cartonNum":2934,"cusSettleAmount":2291.3514,"channelSettleAmount":66481.766,"orderCost":25437.6045},{"orderDay":"2020-07-30","salesAmount":51217.6429,"volume":288.5027,"weight":5434.5,"cartonNum":3056,"cusSettleAmount":3523.2919,"channelSettleAmount":47694.351,"orderCost":24639.4153},{"orderDay":"2020-07-31","salesAmount":134841.9867,"volume":826.3972,"weight":0,"cartonNum":10640,"cusSettleAmount":1415.988,"channelSettleAmount":133425.9987,"orderCost":60795.9777}]}
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
        private List<CurrentMonthBean> currentMonth;
        private List<LastMonthBean> lastMonth;

        public List<CurrentMonthBean> getCurrentMonth() {
            return currentMonth;
        }

        public void setCurrentMonth(List<CurrentMonthBean> currentMonth) {
            this.currentMonth = currentMonth;
        }

        public List<LastMonthBean> getLastMonth() {
            return lastMonth;
        }

        public void setLastMonth(List<LastMonthBean> lastMonth) {
            this.lastMonth = lastMonth;
        }

        public static class CurrentMonthBean {
            /**
             * orderDay : 2020-08-01
             * salesAmount : 312210.1488
             * volume : 1990.4143
             * weight : 73908.15
             * cartonNum : 27403
             * cusSettleAmount : 3942
             * channelSettleAmount : 308268.1488
             * orderCost : 137894.5875
             */

            private String orderDay;
            private String salesAmount;
            private String volume;
            private String weight;
            private String cartonNum;
            private String cusSettleAmount;
            private String channelSettleAmount;
            private String orderCost;

            public String getOrderDay() {
                return orderDay;
            }

            public void setOrderDay(String orderDay) {
                this.orderDay = orderDay;
            }

            public String getSalesAmount() {
                return salesAmount;
            }

            public void setSalesAmount(String salesAmount) {
                this.salesAmount = salesAmount;
            }

            public String getVolume() {
                return volume;
            }

            public void setVolume(String volume) {
                this.volume = volume;
            }

            public String getWeight() {
                return weight;
            }

            public void setWeight(String weight) {
                this.weight = weight;
            }

            public String getCartonNum() {
                return cartonNum;
            }

            public void setCartonNum(String cartonNum) {
                this.cartonNum = cartonNum;
            }

            public String getCusSettleAmount() {
                return cusSettleAmount;
            }

            public void setCusSettleAmount(String cusSettleAmount) {
                this.cusSettleAmount = cusSettleAmount;
            }

            public String getChannelSettleAmount() {
                return channelSettleAmount;
            }

            public void setChannelSettleAmount(String channelSettleAmount) {
                this.channelSettleAmount = channelSettleAmount;
            }

            public String getOrderCost() {
                return orderCost;
            }

            public void setOrderCost(String orderCost) {
                this.orderCost = orderCost;
            }
        }

        public static class LastMonthBean {
            /**
             * orderDay : 2020-07-01
             * salesAmount : 350883.6331
             * volume : 2232.5513
             * weight : 0
             * cartonNum : 30251
             * cusSettleAmount : -33653.3976
             * channelSettleAmount : 384537.0307
             * orderCost : 0
             */

            private String orderDay;
            private String salesAmount;
            private String volume;
            private String weight;
            private String cartonNum;
            private String cusSettleAmount;
            private String channelSettleAmount;
            private String orderCost;

            public String getOrderDay() {
                return orderDay;
            }

            public void setOrderDay(String orderDay) {
                this.orderDay = orderDay;
            }

            public String getSalesAmount() {
                return salesAmount;
            }

            public void setSalesAmount(String salesAmount) {
                this.salesAmount = salesAmount;
            }

            public String getVolume() {
                return volume;
            }

            public void setVolume(String volume) {
                this.volume = volume;
            }

            public String getWeight() {
                return weight;
            }

            public void setWeight(String weight) {
                this.weight = weight;
            }

            public String getCartonNum() {
                return cartonNum;
            }

            public void setCartonNum(String cartonNum) {
                this.cartonNum = cartonNum;
            }

            public String getCusSettleAmount() {
                return cusSettleAmount;
            }

            public void setCusSettleAmount(String cusSettleAmount) {
                this.cusSettleAmount = cusSettleAmount;
            }

            public String getChannelSettleAmount() {
                return channelSettleAmount;
            }

            public void setChannelSettleAmount(String channelSettleAmount) {
                this.channelSettleAmount = channelSettleAmount;
            }

            public String getOrderCost() {
                return orderCost;
            }

            public void setOrderCost(String orderCost) {
                this.orderCost = orderCost;
            }
        }
    }
}
