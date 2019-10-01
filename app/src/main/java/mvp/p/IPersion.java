package mvp.p;

import java.io.File;
import java.util.HashMap;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public interface IPersion {
    //登录
    void getlogin(String phone,String pwd);
    //注册
    void getregister(String phone,String pwd);
    //首页展示
    void getShow();
    //搜索
    void getsousuo(String keyword,int page,int count);
    //查询购物车
    void getchacar();
    //圈子
    void getquanzi(int page,int count);
    //详情
    void getxiang(String id);
    //同步
    void gettongbu(String data);
    void getxiangcar();
    //钱包
    void getmoney();
    //地址展示
    void getaddress();
    //添加收货地址
    void getaddaddress(String name,String phone,String address,String code);
    //支付页面
    void getclose();
    //创建订单
    void getorder(String orderInfo,double price,int id);
    //全部订单
    void getorderall(int status,int page,int count);
    //代付款
    void getwaitorder(int status,int page,int count);
    //代收货
    void getWithpayment(int status,int page,int count);
    //待评论
    void getcomment(int status,int page,int count);
    //已完成
    void getover(int status,int page,int count);
    //支付
    void getpay(String orderId,int payType);
    //确定收货
    void getwait(String orderId);
    //我的足迹
    void getfoot(int page,int count);
    //点赞
    void getzan(int id);
    //发布圈子
//    void getfabu(HashMap<String, String> data, File file);
    //我的圈子
    void mycircle(int page,int count);
}
