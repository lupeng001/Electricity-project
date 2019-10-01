package bean;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class DateBeans {
    private int commodityId;
    private int amount;

    public DateBeans(int commodityId, int amount) {
        this.commodityId = commodityId;
        this.amount = amount;
    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "DateBeans{" +
                "commodityId=" + commodityId +
                ", amount=" + amount +
                '}';
    }
}
