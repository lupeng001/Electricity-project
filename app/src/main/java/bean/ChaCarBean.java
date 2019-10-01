package bean;

import java.util.List;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class ChaCarBean {
    /**
     * result : [{"categoryName":"女鞋","shoppingCartList":[{"commodityId":27,"commodityName":"休闲马衔扣保暖绒里棉鞋懒人鞋毛毛鞋平底女雪地靴女短靴子豆豆鞋女鞋","count":1,"pic":"http://172.17.8.100/images/small/commodity/nx/ddx/3/1.jpg","price":139},{"commodityId":32,"commodityName":"唐狮女鞋冬季女鞋休闲鞋子女士女鞋百搭帆布鞋女士休闲鞋子女款板鞋休闲女鞋帆布鞋","count":2,"pic":"http://172.17.8.100/images/small/commodity/nx/fbx/1/1.jpg","price":88},{"commodityId":29,"commodityName":"秋冬新款平底毛毛豆豆鞋加绒单鞋一脚蹬懒人鞋休闲","count":1,"pic":"http://172.17.8.100/images/small/commodity/nx/ddx/5/1.jpg","price":278}]},{"categoryName":"美妆护肤","shoppingCartList":[{"commodityId":17,"commodityName":"化妆镜","count":7,"pic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/7/1.jpg","price":31},{"commodityId":6,"commodityName":"轻柔系自然裸妆假睫毛","count":4,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/4/1.jpg","price":39},{"commodityId":15,"commodityName":"玻儿精灵美妆蛋一个","count":1,"pic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/5/1.jpg","price":6},{"commodityId":11,"commodityName":"盒装葫芦粉扑美妆蛋化妆海绵","count":1,"pic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/1/1.jpg","price":9},{"commodityId":13,"commodityName":"贝览得美妆蛋","count":2,"pic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/3/1.jpg","price":44}]}]
     * message : 查詢成功
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
         * categoryName : 女鞋
         * shoppingCartList : [{"commodityId":27,"commodityName":"休闲马衔扣保暖绒里棉鞋懒人鞋毛毛鞋平底女雪地靴女短靴子豆豆鞋女鞋","count":1,"pic":"http://172.17.8.100/images/small/commodity/nx/ddx/3/1.jpg","price":139},{"commodityId":32,"commodityName":"唐狮女鞋冬季女鞋休闲鞋子女士女鞋百搭帆布鞋女士休闲鞋子女款板鞋休闲女鞋帆布鞋","count":2,"pic":"http://172.17.8.100/images/small/commodity/nx/fbx/1/1.jpg","price":88},{"commodityId":29,"commodityName":"秋冬新款平底毛毛豆豆鞋加绒单鞋一脚蹬懒人鞋休闲","count":1,"pic":"http://172.17.8.100/images/small/commodity/nx/ddx/5/1.jpg","price":278}]
         */
        private boolean isCheck=false;
        private String categoryName;
        private List<ShoppingCartListBean> shoppingCartList;

        public ResultBean(boolean isCheck) {
            this.isCheck = isCheck;
        }

        public boolean isCheck() {
            return isCheck;
        }

        public void setCheck(boolean check) {
            isCheck = check;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public List<ShoppingCartListBean> getShoppingCartList() {
            return shoppingCartList;
        }

        public void setShoppingCartList(List<ShoppingCartListBean> shoppingCartList) {
            this.shoppingCartList = shoppingCartList;
        }

        public static class ShoppingCartListBean {
            /**
             * commodityId : 27
             * commodityName : 休闲马衔扣保暖绒里棉鞋懒人鞋毛毛鞋平底女雪地靴女短靴子豆豆鞋女鞋
             * count : 1
             * pic : http://172.17.8.100/images/small/commodity/nx/ddx/3/1.jpg
             * price : 139
             */
            private boolean isChecked = false;
            private int commodityId;
            private String commodityName;
            private int count;
            private String pic;
            private int price;

            public boolean isChecked() {
                return isChecked;
            }

            public void setChecked(boolean checked) {
                isChecked = checked;
            }

            public ShoppingCartListBean(boolean isChecked) {
                this.isChecked = isChecked;
            }

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

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }
        }
    }
    /**
     * result : [{"commodityId":5,"commodityName":"双头两用修容笔","count":3,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/3/1.jpg","price":39},{"commodityId":6,"commodityName":"轻柔系自然裸妆假睫毛","count":4,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/4/1.jpg","price":39},{"commodityId":3,"commodityName":"Lara style女神的魔盒全套彩妆","count":4,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/1/1.jpg","price":3499},{"commodityId":7,"commodityName":"蓝色之恋","count":4,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/5/1.jpg","price":29},{"commodityId":8,"commodityName":"Lara style蜜颊润泽腮红","count":4,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/6/1.jpg","price":19}]
     * message : 查询成功
     * status : 0000
     */

}