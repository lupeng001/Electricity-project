package weektest.baway.com.weidu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import bean.PayBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mvp.p.Persion;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class PayActivity extends BaseActivity {
    @BindView(R.id.pay_sum)
    Button paySum;
    private String orderId;
    private int typeId = 1;
    private Persion persion;

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
        orderId = intent.getStringExtra("orderId");
        persion = new Persion(this);

    }


    @Override
    protected int bindLayout() {
        return R.layout.activity_pay;
    }



    @OnClick(R.id.pay_sum)
    public void onViewClicked() {
        persion.getpay(orderId,typeId);
    }

    public void getShow(PayBean payBean) {
        if (payBean.getStatus().equals("0000")){
            ToastData("请求成功");
            finish();
        }
        else {
            ToastData("请求失败");

        }
    }
}
