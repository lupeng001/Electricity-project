package bawei.com.jmessage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class UserInfo {
    protected long userID;
    protected String userName;
    protected String nickname = "";
    protected String avatarMediaID;
    protected String birthday = "";
    protected String signature = "";
    protected String gender = "";
    protected String region = "";
    protected String address = "";
    protected String appkey = null;
    protected String notename = null;
    protected String noteText = null;
    protected int mTime;

    public UserInfo(long userID, String userName, String nickname, String avatarMediaID, String birthday, String signature, String gender, String region, String address, String appkey, String notename, String noteText, int mTime, Map<String, String> extras) {
        this.userID = userID;
        this.userName = userName;
        this.nickname = nickname;
        this.avatarMediaID = avatarMediaID;
        this.birthday = birthday;
        this.signature = signature;
        this.gender = gender;
        this.region = region;
        this.address = address;
        this.appkey = appkey;
        this.notename = notename;
        this.noteText = noteText;
        this.mTime = mTime;
        this.extras = extras;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatarMediaID() {
        return avatarMediaID;
    }

    public void setAvatarMediaID(String avatarMediaID) {
        this.avatarMediaID = avatarMediaID;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getNotename() {
        return notename;
    }

    public void setNotename(String notename) {
        this.notename = notename;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public int getmTime() {
        return mTime;
    }

    public void setmTime(int mTime) {
        this.mTime = mTime;
    }

    public Map<String, String> getExtras() {
        return extras;
    }

    public void setExtras(Map<String, String> extras) {
        this.extras = extras;
    }

    protected Map<String, String> extras = new ConcurrentHashMap()
            ;
}
