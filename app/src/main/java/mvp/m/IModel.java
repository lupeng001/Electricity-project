package mvp.m;

import java.io.File;
import java.util.HashMap;

import bean.AddAddressBean;
import bean.Addressbean;
import bean.ChaCarBean;
import bean.CreatOrderBean;
import bean.DianZanBean;
import bean.FabuQuanziBean;
import bean.FootBean;
import bean.LoginBean;
import bean.MoneyBean;
import bean.MyCircleBean;
import bean.OrderAllBean;
import bean.PayBean;
import bean.QuanziBean;
import bean.RegisterBean;
import bean.ShowBean;
import bean.SouSuoBean;
import bean.TongbuCarBean;
import bean.WaitOrderBean;
import bean.XiangBean;
import weektest.baway.com.weidu.AddressActivity;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public interface IModel {
    //登录
    void getLoginCallBak(String phone,String pwd,LoginCallBack loginCallBack);
    interface LoginCallBack{
        void onSuceess(LoginBean loginBean1);
    }
    //注册
    void getRegister(String phone,String pwd,RegisterCallBack registerCallBack);
    interface RegisterCallBack{
        void onSuceess(RegisterBean registerBean);
    }
    //展示
    void getShow(ShowyeCallBack showyeCallBack);
    interface ShowyeCallBack{
        void onSuceess(ShowBean showBean);
    }
    //搜索
    void getSousuo(String keyword,int page,int count,SouSuoCallBack souSuoCallBack);
    interface SouSuoCallBack{
        void onSuceess(SouSuoBean souSuoBean);
    }
    //购物车
    void getShopCar(ShopCarCallBack shopCarCallBack);
    interface ShopCarCallBack{
        void onSuceess(ChaCarBean chaCarBean);
    }
    //圈子
    void getQuanzi(int page,int count,QuanziCallBack quanziCallBack);
    interface QuanziCallBack{
        void onSuceess(QuanziBean quanziBean);
    }
    //详情
    void getXiang(String id,XiangCallBack XiangCallBack);
    interface XiangCallBack{
        void onSuceess(XiangBean xiangBean);
    }
    //同步
    void getTongbu(String data,TongbuCallBack tongbuCallBack);
    interface TongbuCallBack{
        void onSuceess(TongbuCarBean tongbuCarBean);
    }
    //详情查询购物车
    void getXiangcar(XiangCarCallBack xiangCarCallBack);
    interface XiangCarCallBack{
        void onSuceess(ChaCarBean chaCarBean2);
    }
    //我的钱包
    void getMoney(MoneyCallBack moneyCallBack);
    interface MoneyCallBack{
        void onSuceess(MoneyBean moneyBean);
    }
    //地址展示
    void getAddress(AddressCallBack addressCallBack);
    interface AddressCallBack{
        void onSuceess(Addressbean addressbean);
    }
    //添加收货地址
    void getAddAddress(String name,String phone,String address,String code,AddAddressCallBack addressCallBack);
    interface AddAddressCallBack{
        void onSuceess(AddAddressBean addAddressBean);
    }
    //创建订单
    void getCreatOrder(String orderInfo,double totalPrice,int  id,OredrCallBack oredrCallBack);
    interface OredrCallBack{
        void onSuceess(CreatOrderBean orderBean);
    }
    //查询全部订单状态
    //创建订单
    void getOrderAll(int status,int page,int  count,OredrAllCallBack oredrAllCallBack);
    interface OredrAllCallBack{
        void onSuceess(OrderAllBean orderAllBean);
    }
    //支付订单
    void getcommitpay(String orderId,int payType,PayCallBack payCallBack);
    interface PayCallBack{
        void onSuceess(PayBean payBean);
    }
    //确定收货
    void getcommitorder(String orderId,WaitCallBack waitCallBack);
    interface WaitCallBack{
        void onSuceess(WaitOrderBean waitOrderBean);
    }
    //我的足迹
    void getfoot(int page,int count,FootCallBack footCallBack);
    interface FootCallBack{
        void onSuccess(FootBean footBean);
    }
    //圈子点赞
    void getdianzan(int page,DianzanCallBack dianzanCallBack);
    interface DianzanCallBack{
        void onsuccess(DianZanBean dianZanBean);
    }
//    //发布圈子
//    void getfabu(HashMap<String, String> data, File file,FabuCallBack fabuCallBack);
//    interface FabuCallBack{
//        void onsuccess(FabuQuanziBean fabuQuanziBean);
//    }
//我的圈子
    void getmycircle(int page,int count,MycircleCallBack mycircleCallBack);
    interface MycircleCallBack{
        void onsuccess(MyCircleBean myCircleBean);
    }
}
