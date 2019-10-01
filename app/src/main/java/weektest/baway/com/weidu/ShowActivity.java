package weektest.baway.com.weidu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import frag.HomeFragment;
import frag.MyFragment;
import frag.OrderFragment;
import frag.QuanziFragment;
import frag.ShopCarFragment;

public class ShowActivity extends BaseActivity {
private ArrayList<Fragment> list = new ArrayList<>();

    @BindView(R.id.shuye_viewpager)
    ViewPager shuyeViewpager;
    @BindView(R.id.shoueye_home)
    RadioButton shoueyeHome;
    @BindView(R.id.shoueye_quanzi)
    RadioButton shoueyeQuanzi;
    @BindView(R.id.shoueye_shop)
    RadioButton shoueyeShop;
    @BindView(R.id.shoueye_dingdan)
    RadioButton shoueyeDingdan;
    @BindView(R.id.shoueye_my)
    RadioButton shoueyeMy;
    private RadioGroup radioGroup;

    @Override
    protected void bindEvent() {

    }

    @Override
    protected void initData() {
        ButterKnife.bind(this);
        list.add(new HomeFragment());
        list.add(new QuanziFragment());
        list.add(new ShopCarFragment());
        list.add(new OrderFragment());
        list.add(new MyFragment());
        shuyeViewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.shoueye_home:
                        shuyeViewpager.setCurrentItem(0);
                        break;
                    case R.id.shoueye_quanzi:
                        shuyeViewpager.setCurrentItem(1);
                        break;
                    case R.id.shoueye_shop:
                        shuyeViewpager.setCurrentItem(2);
                        break;
                    case R.id.shoueye_dingdan:
                        shuyeViewpager.setCurrentItem(3);
                        break;
                    case R.id.shoueye_my:
                        shuyeViewpager.setCurrentItem(4);
                        break;
                }
            }
        });
    }

    @Override
    protected void initView() {
        radioGroup = findViewById(R.id.shouye_radgrop);
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_show;
    }


}
