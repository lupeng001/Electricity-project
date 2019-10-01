package bean;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class TouxiangBean {

    /**
     * message : 上传成功
     * status : 0000
     */
    private String headPath;
    private String message;
    private String status;

    public TouxiangBean(String headPath) {
        this.headPath = headPath;
    }

    public String getHeadPath() {
        return headPath;
    }

    public void setHeadPath(String headPath) {
        this.headPath = headPath;
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
}
