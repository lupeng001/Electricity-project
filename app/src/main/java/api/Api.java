package api;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import bean.AddAddressBean;
import bean.AddPinglunBean;
import bean.Addressbean;
import bean.BannerBean;
import bean.ChaCarBean;
import bean.CreatOrderBean;
import bean.DianZanBean;
import bean.FabuQuanziBean;
import bean.FootBean;
import bean.LoginBean;
import bean.MoneyBean;
import bean.MyBean;
import bean.MyCircleBean;
import bean.OrderAllBean;
import bean.PayBean;
import bean.QuanziBean;
import bean.RegisterBean;
import bean.ShowBean;
import bean.SouSuoBean;
import bean.TongbuCarBean;
import bean.TouxiangBean;
import bean.WaitOrderBean;
import bean.XiangBean;
import okhttp3.MultipartBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public interface Api {
    //接口
    public String Url = "http://mobile.bwstudent.com/small/";
    //登录接口
    @FormUrlEncoded
    @POST("user/v1/login")
    Observable<LoginBean> getlogin(@Field("phone") String phone,@Field("pwd") String pwd);
    //注册接口
    @FormUrlEncoded
    @POST("user/v1/register")
    Observable<RegisterBean> getregister(@Field("phone") String phone,@Field("pwd") String pwd);
    //展示
    @GET("commodity/v1/commodityList")
    Observable<ShowBean> getshow();
    //首页轮播
    @GET("commodity/v1/bannerShow")
    Observable<BannerBean> getbanner();
    //搜索
    @GET("commodity/v1/findCommodityByKeyword")
    Observable<SouSuoBean> getsousuo(@Query("keyword") String keyword,@Query("page") int page,@Query("count") int count);
    //查询购物车
    @GET("order/verify/v1/findShoppingCart")
    Observable<ChaCarBean> getchaCar();
    //圈子
    @GET("circle/v1/findCircleList")
    Observable<QuanziBean> getquanzi(@Query("page") int page,@Query("count") int count);
    //详情
    @GET("commodity/v1/findCommodityDetailsById")
    Observable<XiangBean> getxiang(@Query("commodityId") String commodityId);
    //同步购物车
    @FormUrlEncoded
    @PUT("order/verify/v1/syncShoppingCart")
    Observable<TongbuCarBean> gettongbu(@Field("data") String data);
    //我的钱包
    @GET("user/verify/v1/findUserWallet?page=1&count=10")
    Observable<MoneyBean> getmoneybean();
    //查询收货地址
    @GET("user/verify/v1/receiveAddressList")
    Observable<Addressbean> getaddress();

    //添加 收货地址
    @FormUrlEncoded
    @POST("user/verify/v1/addReceiveAddress")
    Observable<AddAddressBean> getaddaddressbean(@Field("realName") String name,@Field("phone") String phone ,@Field("address") String address ,@Field("zipCode") String zipCode);
    @FormUrlEncoded
    //创建订单
    @POST("order/verify/v1/createOrder")
    Observable<CreatOrderBean> getcreatorederbean(@Field("orderInfo") String orderInfo,@Field("totalPrice") double totalPrice,@Field("addressId") int addressId);
   //查询订单
    @GET("order/verify/v1/findOrderListByStatus")
    Observable<OrderAllBean> getorderallbean(@Query("status") int status,@Query("page") int page,@Query("count") int count);
    //支付
    @FormUrlEncoded
    @POST("order/verify/v1/pay")
    Observable<PayBean> getpaybean(@Field("orderId") String orderId,@Field("payType") int payType);
    //确定收货
    @FormUrlEncoded
    @PUT("order/verify/v1/confirmReceipt")
    Observable<WaitOrderBean> getwaitorder(@Field("orderId") String orderld);
    //我的足迹
    @GET("commodity/verify/v1/browseList")
    Observable<FootBean> getfoot(@Query("page") int page,@Query("count") int count);
    //圈子点赞
    @FormUrlEncoded
    @POST("circle/verify/v1/addCircleGreat")
    Observable<DianZanBean> getdianzan(@Field("circleId") int id);
    //发布圈子
    @Multipart
    @POST("circle/verify/v1/releaseCircle")
    Observable<FabuQuanziBean> getfabu(@QueryMap HashMap<String, String> params, @Part MultipartBody.Part[] file);
    //商品品论
    @Multipart
    @POST("commodity/verify/v1/addCommodityComment")
    Observable<AddPinglunBean> pinglun(@QueryMap HashMap<String, String> params,@Part MultipartBody.Part[] file);
    //我的圈子
    @GET("circle/verify/v1/findMyCircleById")
    Observable<MyCircleBean> mycircle(@Query("page") int page,@Query("count") int count);
    //头像
    @Multipart
    @POST("user/verify/v1/modifyHeadPic")
    Observable<TouxiangBean> touxiang(@Part MultipartBody.Part image);
    @GET("user/verify/v1/getUserById")
    Observable<MyBean> mybean();
}
