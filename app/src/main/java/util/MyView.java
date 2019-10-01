package util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import adapter.CarAdapter;
import bean.ChaCarBean;
import weektest.baway.com.weidu.R;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class MyView extends LinearLayout  implements View.OnClickListener {
    private int shu;
    private TextView add,jian;
    private EditText editText;
    private CarAdapter carAdapter1;
    private List<ChaCarBean.ResultBean.ShoppingCartListBean> result1;
    private int i1;
    private int count;

    public MyView(Context context) {
        super(context);
        initView(context);
    }



    public MyView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }
    private void initView(Context context) {
        View view = View.inflate(context,R.layout.myview_item, null);
        add=  view.findViewById(R.id.zidingyiadd);
        jian =  view.findViewById(R.id.zidingyijian);
        editText = view.findViewById(R.id.zidingyiaedtext);
        add.setOnClickListener(this);
        jian.setOnClickListener(this);
        editText.setText(shu+"");
        addView(view);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.zidingyiadd:
                shu++;
                editText.setText(shu+"");
                numCallBack.getBack();
                result1.get(i1).setCount(shu);
                carAdapter1.notifyDataSetChanged();
                break;
            case R.id.zidingyijian:
                if (shu>1){
                    shu--;
                    editText.setText(shu+"");
                    numCallBack.getBack();
                    result1.get(i1).setCount(shu);
                    carAdapter1.notifyDataSetChanged();
                }else {
                    Toast.makeText(getContext(),"数量最少为1",Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }
    public void setData(CarAdapter carAdapter, List<ChaCarBean.ResultBean.ShoppingCartListBean> result, int i) {
        this.carAdapter1 = carAdapter;
        this.result1 = result;
        this.i1 = i;
        count = result1.get(i).getCount();
        editText.setText(result1.get(i).getCount() + "");
    }

    numCallBack numCallBack;
    public void setNumCallBack(numCallBack numCallBack){
        this.numCallBack = numCallBack;
    }

    public interface numCallBack{
        void getBack();
    }

}