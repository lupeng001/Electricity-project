package adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.sql.RowId;
import java.text.SimpleDateFormat;

import bean.FootBean;
import weektest.baway.com.weidu.R;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class FootAdapter extends RecyclerView.Adapter<FootAdapter.ViewHolder> {
    Context context;
    FootBean footBean;

    public FootAdapter(Context context, FootBean footBean) {
        this.context = context;
        this.footBean = footBean;
    }

    @NonNull
    @Override
    public FootAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(viewGroup.getContext(), R.layout.footitem_layout, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull FootAdapter.ViewHolder viewHolder, int i) {
        viewHolder.simpleDraweeView.setImageURI(Uri.parse(footBean.getResult().get(i).getMasterPic()));
        viewHolder.name.setText(footBean.getResult().get(i).getCommodityName());

        viewHolder.count.setText("已浏览"+footBean.getResult().get(i).getBrowseNum()+"次");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(footBean.getResult().get(i).getBrowseTime());
        viewHolder.time.setText(dateString);
    }

    @Override
    public int getItemCount() {
        return footBean.getResult().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView simpleDraweeView;
        TextView name,count,time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.footitem_simp);
            name = itemView.findViewById(R.id.footitem_name);
            count = itemView.findViewById(R.id.footitem_count);
            time = itemView.findViewById(R.id.footitem_time);
        }
    }
}
