package frag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(bindLayout(), container, false);
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
        bindEvent();
    }

    protected abstract void bindEvent();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int bindLayout();
    //找控件
    protected <T extends  View> T bindView(int resId){
        return (T) getView().findViewById(resId);
    }
}
