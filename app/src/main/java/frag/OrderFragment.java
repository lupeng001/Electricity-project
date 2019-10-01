package frag;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

import java.util.ArrayList;

import weektest.baway.com.weidu.R;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class OrderFragment extends BaseFragment {
    private RadioGroup radioGroup;
    private ViewPager viewPager;
    private ArrayList<Fragment> list = new ArrayList<>();
    @Override
    protected void bindEvent() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        viewPager = bindView(R.id.dingdan_viewpager);
        radioGroup = bindView(R.id.dingdan_radgrop);
        list.add(new Dingdan_quanbu());
        list.add(new Dingdan_daifukuan());
        list.add(new Dingdan_daishouhuo());
        list.add(new Dingdan_daipinglun());
        list.add(new Dingdan_wancheng());
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
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
                    case R.id.dingdan_radio1:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.dingdan_radio2:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.dingdan_radio3:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.dingdan_radio4:
                        viewPager.setCurrentItem(3);
                        break;
                    case R.id.dingdan_radio5:
                        viewPager.setCurrentItem(4);
                        break;
                }
            }
        });
    }

    @Override
    protected int bindLayout() {
        return R.layout.dingdan_fragment;
    }
}
