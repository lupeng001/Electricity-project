package bawei.com.jmessage;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder{


    public BaseViewHolder(View itemView) {
        super(itemView);
        findView(itemView);
    }

    public abstract void findView(View view);
    public abstract void setHolderData(Object o,int position);


}
