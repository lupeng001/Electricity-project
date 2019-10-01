package mvp.p;

import java.io.File;
import java.util.HashMap;

import adapter.WaitOrderAdapter;
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
import frag.Dingdan_daifukuan;
import frag.Dingdan_daipinglun;
import frag.Dingdan_daishouhuo;
import frag.Dingdan_quanbu;
import frag.Dingdan_wancheng;
import frag.HomeFragment;
import frag.QuanziFragment;
import frag.ShopCarFragment;
import mvp.m.IModel;
import mvp.m.Model;
import weektest.baway.com.weidu.AddCircleActivity;
import weektest.baway.com.weidu.AddaddressActivity;
import weektest.baway.com.weidu.AddressActivity;
import weektest.baway.com.weidu.CloseActivity;
import weektest.baway.com.weidu.MainActivity;
import weektest.baway.com.weidu.MoneyActivity;
import weektest.baway.com.weidu.MyCircleActivity;
import weektest.baway.com.weidu.MyFootActivity;
import weektest.baway.com.weidu.PayActivity;
import weektest.baway.com.weidu.RegisterActivity;
import weektest.baway.com.weidu.SouSuoActivity;
import weektest.baway.com.weidu.XiangActivity;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class Persion implements IPersion {
    MainActivity mainActivity;
    private final Model model;
    RegisterActivity registerActivity;
    HomeFragment homeFragment;
    SouSuoActivity souSuoActivity;
    ShopCarFragment shopCarFragment;
    QuanziFragment quanziFragment;
    XiangActivity xiangActivity;
    MoneyActivity moneyActivity;
    AddressActivity addressActivity;
    AddaddressActivity addaddressActivity;
    CloseActivity closeActivity;
    Dingdan_quanbu dingdan_quanbu;
    Dingdan_daifukuan dingdan_daifukuan;
    Dingdan_daishouhuo dingdan_daishouhuo;
    Dingdan_daipinglun dingdan_daipinglun;
    Dingdan_wancheng dingdan_wancheng;
    PayActivity payActivity;
    WaitOrderAdapter waitOrderAdapter;
    MyFootActivity myFootActivity;
AddCircleActivity circleActivity;
MyCircleActivity myCircleActivity;

    public Persion(MyCircleActivity myCircleActivity) {
        this.myCircleActivity = myCircleActivity;
        model = new Model();
    }

    public Persion(AddCircleActivity circleActivity) {
        this.circleActivity = circleActivity;
        model = new Model();
    }

    public Persion(MyFootActivity myFootActivity) {
        this.myFootActivity = myFootActivity;
        model =new Model();
    }

    public Persion(WaitOrderAdapter waitOrderAdapter) {
        this.waitOrderAdapter = waitOrderAdapter;
        model =new Model();
    }

    public Persion(PayActivity payActivity) {
        this.payActivity = payActivity;
        model = new Model();
    }

    public Persion(Dingdan_wancheng dingdan_wancheng) {
        this.dingdan_wancheng = dingdan_wancheng;
        model =new Model();
    }

    public Persion(Dingdan_daipinglun dingdan_daipinglun) {
        this.dingdan_daipinglun = dingdan_daipinglun;
        model = new Model();
    }

    public Persion(Dingdan_daishouhuo dingdan_daishouhuo) {
        this.dingdan_daishouhuo = dingdan_daishouhuo;
        model = new Model();
    }

    public Persion(Dingdan_daifukuan dingdan_daifukuan) {
        this.dingdan_daifukuan = dingdan_daifukuan;
        model = new Model();
    }

    public Persion(Dingdan_quanbu dingdan_quanbu) {
        this.dingdan_quanbu = dingdan_quanbu;
        model =new Model();
    }

    public Persion(CloseActivity closeActivity) {
        this.closeActivity = closeActivity;
        model =new Model();
    }

    public Persion(AddaddressActivity addaddressActivity) {
        this.addaddressActivity = addaddressActivity;
        model =new Model();
    }

    public Persion(AddressActivity addressActivity) {
        this.addressActivity = addressActivity;
        model =new Model();
    }

    public Persion(MoneyActivity moneyActivity) {
        this.moneyActivity = moneyActivity;
        model =new Model();
    }

    public Persion(XiangActivity xiangActivity) {
        this.xiangActivity = xiangActivity;
        model =new Model();
    }

    public Persion(QuanziFragment quanziFragment) {
        this.quanziFragment = quanziFragment;
        model =new Model();
    }

    public Persion(ShopCarFragment shopCarFragment) {
        this.shopCarFragment = shopCarFragment;
        model = new Model();
    }

    public Persion(SouSuoActivity souSuoActivity) {
        this.souSuoActivity = souSuoActivity;
        model = new Model();
    }

    public Persion(HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
        model = new Model();
    }

    public Persion(RegisterActivity registerActivity) {
        this.registerActivity = registerActivity;
        model = new Model();
    }

    public Persion(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        model = new Model();
    }

    @Override
    public void getlogin(String phone, String pwd) {
        model.getLoginCallBak(phone, pwd, new IModel.LoginCallBack() {
            @Override
            public void onSuceess(LoginBean loginBean1) {
                mainActivity.getShow(loginBean1);
            }
        });
    }

    @Override
    public void getregister(String phone, String pwd) {
        model.getRegister(phone, pwd, new IModel.RegisterCallBack() {
            @Override
            public void onSuceess(RegisterBean registerBean) {
                registerActivity.getshow(registerBean);
            }
        });
    }

    @Override
    public void getShow() {
        model.getShow(new IModel.ShowyeCallBack() {
            @Override
            public void onSuceess(ShowBean showBean) {
                homeFragment.getshow(showBean);
            }
        });
    }

    @Override
    public void getsousuo(String keyword, int page, int count) {
        model.getSousuo(keyword, page, count, new IModel.SouSuoCallBack() {
            @Override
            public void onSuceess(SouSuoBean souSuoBean) {
                souSuoActivity.getshow(souSuoBean);
            }
        });
    }

    @Override
    public void getchacar() {
        model.getShopCar(new IModel.ShopCarCallBack() {
            @Override
            public void onSuceess(ChaCarBean chaCarBean) {
                shopCarFragment.getShow(chaCarBean);
            }
        });
    }

    @Override
    public void getquanzi(int page, int count) {
        model.getQuanzi(page, count, new IModel.QuanziCallBack() {
            @Override
            public void onSuceess(QuanziBean quanziBean) {
                quanziFragment.getShow(quanziBean);
            }
        });
    }

    @Override
    public void getxiang(String id) {
        model.getXiang(id, new IModel.XiangCallBack() {
            @Override
            public void onSuceess(XiangBean xiangBean) {
                xiangActivity.getShow(xiangBean);
            }
        });
    }

    @Override
    public void gettongbu(String data) {
        model.getTongbu(data, new IModel.TongbuCallBack() {
            @Override
            public void onSuceess(TongbuCarBean tongbuCarBean) {
                xiangActivity.getTongbu(tongbuCarBean);
            }
        });
    }

    @Override
    public void getxiangcar() {
        model.getXiangcar(new IModel.XiangCarCallBack() {
            @Override
            public void onSuceess(ChaCarBean chaCarBean2) {
                xiangActivity.getXiangcar(chaCarBean2);
            }
        });
    }

    @Override
    public void getmoney() {
        model.getMoney(new IModel.MoneyCallBack() {
            @Override
            public void onSuceess(MoneyBean moneyBean) {
                moneyActivity.getShow(moneyBean);
            }
        });
    }

    @Override
    public void getaddress() {
        model.getAddress(new IModel.AddressCallBack() {
            @Override
            public void onSuceess(Addressbean addressbean) {
                addressActivity.getShow(addressbean);
            }
        });
    }

    @Override
    public void getaddaddress(String name, String phone, String address, String code) {
        model.getAddAddress(name, phone, address, code, new IModel.AddAddressCallBack() {
            @Override
            public void onSuceess(AddAddressBean addAddressBean) {
                addaddressActivity.getShow(addAddressBean);
            }
        });
    }

    @Override
    public void getclose() {
        model.getAddress(new IModel.AddressCallBack() {
            @Override
            public void onSuceess(Addressbean addressbean) {
                closeActivity.getShow(addressbean);
            }
        });
    }

    @Override
    public void getorder(String orderInfo, double price, int id) {
         model.getCreatOrder(orderInfo, price, id, new IModel.OredrCallBack() {
             @Override
             public void onSuceess(CreatOrderBean orderBean) {
                 closeActivity.getOrder(orderBean);
             }
         });
    }

    @Override
    public void getorderall(int status, int page, int count) {
        model.getOrderAll(status, page, count, new IModel.OredrAllCallBack() {
            @Override
            public void onSuceess(OrderAllBean orderAllBean) {
                dingdan_quanbu.getShow(orderAllBean);
            }
        });
    }

    @Override
    public void getwaitorder(int status, int page, int count) {
        model.getOrderAll(status, page, count, new IModel.OredrAllCallBack() {
            @Override
            public void onSuceess(OrderAllBean orderAllBean) {
                dingdan_daifukuan.getShow(orderAllBean);
            }
        });
    }

    @Override
    public void getWithpayment(int status, int page, int count) {
        model.getOrderAll(status, page, count, new IModel.OredrAllCallBack() {
            @Override
            public void onSuceess(OrderAllBean orderAllBean) {
                dingdan_daishouhuo.getShow(orderAllBean);
            }
        });
    }

    @Override
    public void getcomment(int status, int page, int count) {
        model.getOrderAll(status, page, count, new IModel.OredrAllCallBack() {
            @Override
            public void onSuceess(OrderAllBean orderAllBean) {
                dingdan_daipinglun.getShow(orderAllBean);
            }
        });
    }

    @Override
    public void getover(int status, int page, int count) {
        model.getOrderAll(status, page, count, new IModel.OredrAllCallBack() {
            @Override
            public void onSuceess(OrderAllBean orderAllBean) {
                dingdan_wancheng.getShow(orderAllBean);
            }
        });
    }

    @Override
    public void getpay(String orderId, int payType) {
        model.getcommitpay(orderId, payType, new IModel.PayCallBack() {
            @Override
            public void onSuceess(PayBean payBean) {
                payActivity.getShow(payBean);
            }
        });
    }

    @Override
    public void getwait(String orderId) {
        model.getcommitorder(orderId, new IModel.WaitCallBack() {
            @Override
            public void onSuceess(WaitOrderBean waitOrderBean) {
                waitOrderAdapter.getShow(waitOrderBean);
            }
        });
    }

    @Override
    public void getfoot(int page, int count) {
        model.getfoot(page, count, new IModel.FootCallBack() {
            @Override
            public void onSuccess(FootBean footBean) {
                myFootActivity.getShow(footBean);
            }
        });
    }

    @Override
    public void getzan(int id) {
        model.getdianzan(id, new IModel.DianzanCallBack() {
            @Override
            public void onsuccess(DianZanBean dianZanBean) {
                quanziFragment.getDianzan(dianZanBean);
            }
        });
    }

    @Override
    public void mycircle(int page, int count) {
model.getmycircle(page, count, new IModel.MycircleCallBack() {
    @Override
    public void onsuccess(MyCircleBean myCircleBean) {
        myCircleActivity.getShow(myCircleBean);
    }
});
    }

//    @Override
//    public void getfabu(HashMap<String, String> data, File file) {
//        model.getfabu(data, file, new IModel.FabuCallBack() {
//            @Override
//            public void onsuccess(FabuQuanziBean fabuQuanziBean) {
//                circleActivity.getShow(fabuQuanziBean);
//            }
//        });
//    }

}
