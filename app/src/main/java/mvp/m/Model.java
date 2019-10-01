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
import bean.MoneyBean;
import bean.MyCircleBean;
import bean.OrderAllBean;
import bean.PayBean;
import bean.QuanziBean;
import bean.TongbuCarBean;
import bean.WaitOrderBean;
import bean.XiangBean;
import util.MyUtil;
import bean.LoginBean;
import bean.RegisterBean;
import bean.ShowBean;
import bean.SouSuoBean;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class Model implements IModel{

    private MyUtil util  = MyUtil.getutil();;
    private LoginBean loginBean1;
    private RegisterBean registerBean1;
    private ShowBean showBean1;
    private SouSuoBean souSuoBean1;
    private ChaCarBean chaCarBean1;
    private QuanziBean quanziBean1;
    private XiangBean xiang1;
    private TongbuCarBean tongbuCarBean1;
    private ChaCarBean xiangchacar;
    private MoneyBean moneyBean1;
    private Addressbean addressbean1;
    private AddAddressBean addAddressBean1;
    private CreatOrderBean orderBean1;
    private OrderAllBean orderAllBean1;
    private PayBean payBean1;
    private WaitOrderBean waitOrderBean1;
    private FootBean footBean1;
    private DianZanBean dianzanbean1;
    private FabuQuanziBean fabuQuanziBean1;
    private MyCircleBean myCircleBean1;

    @Override
    public void getLoginCallBak(String phone, String pwd, final LoginCallBack loginCallBack) {

        Observable<LoginBean> login = util.api.getlogin(phone, pwd);
        login.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onCompleted() {
                        loginCallBack.onSuceess(loginBean1);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        loginBean1 = loginBean;
                    }
                });
    }

    @Override
    public void getRegister(String phone, String pwd, final RegisterCallBack registerCallBack) {
        Observable<RegisterBean> register = util.api.getregister(phone, pwd);
        register.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterBean>() {
                    @Override
                    public void onCompleted() {
                        registerCallBack.onSuceess(registerBean1);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(RegisterBean registerBean) {
                        registerBean1 = registerBean;
                    }
                });
    }

    @Override
    public void getShow(final ShowyeCallBack showyeCallBack) {
        Observable<ShowBean> show = util.api.getshow();
        show.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShowBean>() {
                    @Override
                    public void onCompleted() {
                        showyeCallBack.onSuceess(showBean1);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ShowBean showBean) {
                        showBean1 = showBean;
                    }
                });
    }

    @Override
    public void getSousuo(String keyword, int page, int count, final SouSuoCallBack souSuoCallBack) {
        Observable<SouSuoBean> getsousuo = util.api.getsousuo(keyword, page, count);
        getsousuo.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SouSuoBean>() {
                    @Override
                    public void onCompleted() {
                        souSuoCallBack.onSuceess(souSuoBean1);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(SouSuoBean souSuoBean) {
                        souSuoBean1 = souSuoBean;
                    }
                });
    }

    @Override
    public void getShopCar(final ShopCarCallBack shopCarCallBack) {
        Observable<ChaCarBean> chacar = util.api.getchaCar();
        chacar.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ChaCarBean>() {
                    @Override
                    public void onCompleted() {
                        shopCarCallBack.onSuceess(chaCarBean1);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ChaCarBean chaCarBean) {
                        chaCarBean1 = chaCarBean;
                    }
                });
    }

    @Override
    public void getQuanzi(int page, int count, final QuanziCallBack quanziCallBack) {
        Observable<QuanziBean> getquanzi = util.api.getquanzi(page, count);
        getquanzi.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<QuanziBean>() {
                    @Override
                    public void onCompleted() {
                        quanziCallBack.onSuceess(quanziBean1);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(QuanziBean quanziBean) {
                        quanziBean1 = quanziBean;
                    }
                });
    }

    @Override
    public void getXiang(String id, final XiangCallBack XiangCallBack) {
        final Observable<XiangBean> xiang = util.api.getxiang(id);
        xiang.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<XiangBean>() {
                    @Override
                    public void onCompleted() {
                        XiangCallBack.onSuceess(xiang1);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(XiangBean xiangBean) {
                        xiang1 = xiangBean;
                    }
                });
    }

    @Override
    public void getTongbu(String data, final TongbuCallBack tongbuCallBack) {
        Observable<TongbuCarBean> tongbu = util.api.gettongbu(data);
        tongbu.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TongbuCarBean>() {
                    @Override
                    public void onCompleted() {
                            tongbuCallBack.onSuceess(tongbuCarBean1);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(TongbuCarBean tongbuCarBean) {
                        tongbuCarBean1 = tongbuCarBean;
                    }
                });
    }

    @Override
    public void getXiangcar(final XiangCarCallBack xiangCarCallBack) {
        Observable<ChaCarBean> charcar = util.api.getchaCar();
        charcar.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ChaCarBean>() {
                    @Override
                    public void onCompleted() {
                        xiangCarCallBack.onSuceess(xiangchacar);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ChaCarBean chaCarBean) {
                        xiangchacar = chaCarBean;
                    }
                });
    }

    @Override
    public void getMoney(final MoneyCallBack moneyCallBack) {
        Observable<MoneyBean> money = util.api.getmoneybean();
        money.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MoneyBean>() {
                    @Override
                    public void onCompleted() {
                        moneyCallBack.onSuceess(moneyBean1);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MoneyBean moneyBean) {
                        moneyBean1 = moneyBean;
                    }
                });
    }

    @Override
    public void getAddress(final AddressCallBack addressCallBack) {
        Observable<Addressbean> address = util.api.getaddress();
        address.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Addressbean>() {
                    @Override
                    public void onCompleted() {
                addressCallBack.onSuceess(addressbean1);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Addressbean addressbean) {
                        addressbean1 = addressbean;
                    }
                });
    }

    @Override
    public void getAddAddress(String name, String phone, String address, String code, final AddAddressCallBack addAddressCallBack) {
        Observable<AddAddressBean> addaddressbean = util.api.getaddaddressbean(name, phone, address, code);
        addaddressbean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AddAddressBean>() {
                    @Override
                    public void onCompleted() {
                        addAddressCallBack.onSuceess(addAddressBean1);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(AddAddressBean addAddressBean) {
                        addAddressBean1 = addAddressBean;
                    }
                });
    }

    @Override
    public void getCreatOrder(String orderInfo, double totalPrice, int id, final OredrCallBack oredrCallBack) {
        Observable<CreatOrderBean> orderbean = util.api.getcreatorederbean(orderInfo, totalPrice, id);
        orderbean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CreatOrderBean>() {
                    @Override
                    public void onCompleted() {
                        oredrCallBack.onSuceess(orderBean1);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(CreatOrderBean orderBean) {
                        orderBean1 = orderBean;
                    }
                });
    }

    @Override
    public void getOrderAll(int status, int page, int count, final OredrAllCallBack oredrAllCallBack) {
        Observable<OrderAllBean> orderall = util.api.getorderallbean(status, page, count);
        orderall.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OrderAllBean>() {
                    @Override
                    public void onCompleted() {
                        oredrAllCallBack.onSuceess(orderAllBean1);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(OrderAllBean orderAllBean) {
                        orderAllBean1 = orderAllBean;
                    }
                });
    }

    @Override
    public void getcommitpay(String orderId, int payType, final PayCallBack payCallBack) {
        Observable<PayBean> paybean = util.api.getpaybean(orderId, payType);
        paybean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PayBean>() {
                    @Override
                    public void onCompleted() {
                        payCallBack.onSuceess(payBean1);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(PayBean payBean) {
                        payBean1 = payBean;
                    }
                });
    }

    @Override
    public void getcommitorder(String orderId, final WaitCallBack waitCallBack) {
        MyUtil.getutil().api.getwaitorder(orderId)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<WaitOrderBean>() {
                            @Override
                            public void onCompleted() {
                            waitCallBack.onSuceess(waitOrderBean1);
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(WaitOrderBean waitOrderBean) {
                                waitOrderBean1 = waitOrderBean;
                            }
                        });
    }

    @Override
    public void getfoot(int page, int count, final FootCallBack footCallBack) {
        Observable<FootBean> footbean = util.api.getfoot(page, count);
        footbean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FootBean>() {
                    @Override
                    public void onCompleted() {
                        footCallBack.onSuccess(footBean1);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(FootBean footBean) {
                        footBean1 = footBean;
                    }
                });
    }

    @Override
    public void getdianzan(int page, final DianzanCallBack dianzanCallBack) {
        final Observable<DianZanBean> dianzanbean = util.api.getdianzan(page);
        dianzanbean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DianZanBean>() {
                    @Override
                    public void onCompleted() {
                        dianzanCallBack.onsuccess(dianzanbean1);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DianZanBean dianZanBean) {
                        dianzanbean1 = dianZanBean;
                    }
                });
    }

    @Override
    public void getmycircle(int page, int count, final MycircleCallBack mycircleCallBack) {
        Observable<MyCircleBean> mycircle = MyUtil.getutil().api.mycircle(page, count);
        mycircle.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyCircleBean>() {
                    @Override
                    public void onCompleted() {
                        mycircleCallBack.onsuccess(myCircleBean1);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MyCircleBean myCircleBean) {
                        myCircleBean1 = myCircleBean;
                    }
                });
    }

//    @Override
//    public void getfabu(HashMap<String, String> data, File file, final FabuCallBack fabuCallBack) {
//        Observable<FabuQuanziBean> getfabu = MyUtil.getutil().api.getfabu(data, file);
//        getfabu.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<FabuQuanziBean>() {
//                    @Override
//                    public void onCompleted() {
//                        fabuCallBack.onsuccess(fabuQuanziBean1);
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(FabuQuanziBean fabuQuanziBean) {
//                        fabuQuanziBean1 = fabuQuanziBean;
//                    }
//                });
//    }


}
