package bean;

import java.util.List;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class MoneyBean {

    /**
     * result : {"balance":99999999,"detailList":[]}
     * message : 查询成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

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

    public static class ResultBean {
        /**
         * balance : 99999999
         * detailList : []
         */

        private int balance;
        private List<DatailList> detailList;

        public ResultBean(int balance, List<DatailList> detailList) {
            this.balance = balance;
            this.detailList = detailList;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public List<DatailList> getDetailList() {
            return detailList;
        }

        public void setDetailList(List<DatailList> detailList) {
            this.detailList = detailList;
        }
    }
    public static class DatailList {
        /**
         * balance : 99999999
         * detailList : []
         */

       private String amount;
       private long createTime;

        public DatailList(String amount, long createTime) {
            this.amount = amount;
            this.createTime = createTime;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

    }
}
