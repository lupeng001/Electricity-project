package bean;

import java.util.List;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class SouSuoBean {

    /**
     * result : [{"commodityId":188,"commodityName":"赫登尔（herder）双肩包男时尚旅行背包学生书包电脑包大容量潮流男包0902A","masterPic":"http://172.17.8.100/images/small/commodity/xbsd/sjb/5/1.jpg","price":169,"saleNum":0},{"commodityId":185,"commodityName":"Texwood 休闲双肩包男款背包男时尚潮流男士旅行包书包潮 Z77J0011-67","masterPic":"http://172.17.8.100/images/small/commodity/xbsd/sjb/2/1.jpg","price":199,"saleNum":0},{"commodityId":171,"commodityName":"HOTBOOM2018男士双肩包休闲背包潮流学生书包多功能笔记本商务14英寸电脑包5606 时尚灰","masterPic":"http://172.17.8.100/images/small/commodity/xbsd/dnb/2/1.jpg","price":109,"saleNum":0},{"commodityId":187,"commodityName":"DiDe迪德双肩包男士背包休闲大容量防水复古电脑包多功能时尚学生潮流书包 DQ860","masterPic":"http://172.17.8.100/images/small/commodity/xbsd/sjb/4/1.jpg","price":89,"saleNum":0},{"commodityId":184,"commodityName":"瑞士军刀双肩包男士背包新款大容量休闲商务旅行电脑包学生书包 USb充电包","masterPic":"http://172.17.8.100/images/small/commodity/xbsd/sjb/1/1.jpg","price":99,"saleNum":0},{"commodityId":170,"commodityName":"爱登堡电脑包背包男士双肩包14/15.6英寸防泼水大容量商务通勤旅行休闲学生笔记本书包 黑色643001-01","masterPic":"http://172.17.8.100/images/small/commodity/xbsd/dnb/1/1.jpg","price":99,"saleNum":0},{"commodityId":186,"commodityName":"SWISSGEAR双肩包 防水多功能笔记本电脑包14.6英寸/15.6英寸商务背包男学生书包休闲 SA-9393III","masterPic":"http://172.17.8.100/images/small/commodity/xbsd/sjb/3/1.jpg","price":99,"saleNum":0},{"commodityId":172,"commodityName":"艾奔AspenSpor新款大容量男士双肩包学生书包防盗电脑包充电旅行背包 黑色_标准版","masterPic":"http://172.17.8.100/images/small/commodity/xbsd/dnb/3/1.jpg","price":89,"saleNum":0}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commodityId : 188
         * commodityName : 赫登尔（herder）双肩包男时尚旅行背包学生书包电脑包大容量潮流男包0902A
         * masterPic : http://172.17.8.100/images/small/commodity/xbsd/sjb/5/1.jpg
         * price : 169
         * saleNum : 0
         */

        private int commodityId;
        private String commodityName;
        private String masterPic;
        private int price;
        private int saleNum;

        public int getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(int commodityId) {
            this.commodityId = commodityId;
        }

        public String getCommodityName() {
            return commodityName;
        }

        public void setCommodityName(String commodityName) {
            this.commodityName = commodityName;
        }

        public String getMasterPic() {
            return masterPic;
        }

        public void setMasterPic(String masterPic) {
            this.masterPic = masterPic;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getSaleNum() {
            return saleNum;
        }

        public void setSaleNum(int saleNum) {
            this.saleNum = saleNum;
        }
    }
}
