package weektest.baway.com.weidu;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayout());
        initView();
        initData();
        bindEvent();
    }

    protected abstract void bindEvent();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int bindLayout();

    public void ToastData(String data){
        Toast.makeText(this,data,Toast.LENGTH_LONG).show();
    }
    public Context getContext(){
        return this;
    }
}
