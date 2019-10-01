package weektest.baway.com.weidu;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import bean.ChaCarBean;
import bean.DateBean;
import bean.TongbuCarBean;
import bean.XiangBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mvp.p.Persion;

public class XiangActivity extends BaseActivity {


    @BindView(R.id.xiang_xbanner)
    XBanner xiangXbanner;
    @BindView(R.id.xiang_price)
    TextView xiangPrice;
    @BindView(R.id.xiang_shuliang)
    TextView xiangShuliang;
    @BindView(R.id.xiang_name)
    TextView xiangName;
    @BindView(R.id.xiang_height)
    TextView xiangHeight;
    @BindView(R.id.xiang_webview)
    WebView xiangWebview;
    @BindView(R.id.car_add)
    ImageView carAdd;
    @BindView(R.id.car_commit)
    ImageView carCommit;
    private ArrayList<String> bannerlist = new ArrayList<>();
    private XiangBean.ResultBean result;
    private Persion persion;
    private List<DateBean> list =new ArrayList<>();
    private int commodityId;
    private int count = 1;
    @Override
    protected void bindEvent() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        persion = new Persion(this);
        persion.getxiang(id);
        carAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                persion.getxiangcar();
            }
        });
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_xiang;
    }

    public void getShow(XiangBean xiangBean) {

        result = xiangBean.getResult();
        xiangName.setText("" + result.getCommodityName());
        xiangShuliang.setText("已售" + result.getCommentNum() + "件");
        xiangHeight.setText("重量" + result.getStock() + "");
        xiangPrice.setText("" + result.getPrice());
        commodityId = result.getCommodityId();
        String[] split = result.getPicture().split(",");
        for (int i = 0; i < split.length; i++) {
            bannerlist.add(split[i]);
        }
        xiangXbanner.setData(bannerlist, null);
        xiangXbanner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Glide.with(XiangActivity.this).load(bannerlist.get(position)).into((ImageView) view);
            }
        });
        WebSettings settings = xiangWebview.getSettings();
        settings.setJavaScriptEnabled(true);
        String js = "<script type=\"text/javascript\">" +
                "var imgs = document.getElementsByTagName('img');" + // 找到img标签
                "for(var i = 0; i<imgs.length; i++){" +  // 逐个改变
                "imgs[i].style.width = '100%';" +  // 宽度改为100%
                "imgs[i].style.height = 'auto';" +
                "}" +
                "</script>";
        xiangWebview.loadDataWithBaseURL(null, xiangBean.getResult().getDetails() + js, "text/html", "utf-8", null);
    }

    public void getTongbu(TongbuCarBean tongbuCarBean) {
        if (tongbuCarBean.getStatus().equals("0000")) {
            ToastData(tongbuCarBean.getMessage());
        } else {
            ToastData("同步失败");

        }
    }




    public void getXiangcar(ChaCarBean chaCarBean2) {

        for (int i = 0; i <chaCarBean2.getResult().size();i++){
            List<ChaCarBean.ResultBean> result = chaCarBean2.getResult();
            List<ChaCarBean.ResultBean.ShoppingCartListBean> shoppingCartList = result.get(i).getShoppingCartList();
            for (int j = 0; j < shoppingCartList.size(); j++) {
                list.add(new DateBean(shoppingCartList.get(j).getCommodityId(),1));
            }
        }
        list.add(new DateBean(commodityId,1));
        Log.i("json123", "initData: "+list);
        //添加新数据
        Gson gson = new Gson();
        String body = gson.toJson(list);
        Log.i("json", "initData: "+body);
        persion.gettongbu(body);
    }
}
