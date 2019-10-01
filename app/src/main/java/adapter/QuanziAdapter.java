package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import bean.QuanziBean;
import util.StringUtils;
import weektest.baway.com.weidu.R;


/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class QuanziAdapter extends RecyclerView.Adapter<QuanziAdapter.ViewHolder> {

   QuanziBean quanziBean;
    Context context;
    List<String> strings = new ArrayList<>();
    private List<QuanziBean.ResultBean> lists;
    private int greatNum;

    public QuanziAdapter(QuanziBean quanziBean, Context context) {
        this.quanziBean = quanziBean;
        this.context = context;
    }

    @NonNull
    @Override
    public QuanziAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(viewGroup.getContext(), R.layout.quanzi_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final QuanziAdapter.ViewHolder viewHolder, final int i) {

        viewHolder.textView1.setText(quanziBean.getResult().get(i).getNickName());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(quanziBean.getResult().get(i).getCreateTime());
        viewHolder.textView2.setText(dateString);
        viewHolder.textView3.setText(quanziBean.getResult().get(i).getContent());
        viewHolder.count.setText(quanziBean.getResult().get(i).getGreatNum()+"");
        lists = quanziBean.getResult();
        greatNum = lists.get(i).getGreatNum();
        if(lists.get(i).getWhetherGreat()==2){
            viewHolder.dianzan.setBackgroundResource(R.drawable.dianzan);
        }else{
            viewHolder.dianzan.setBackgroundResource(R.drawable.bg_goods);
        }
        viewHolder.dianzan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lists.get(i).getWhetherGreat()==1){
                    lists.get(i).setWhetherGreat(2);
                    if(onItemClickListenter!=null){
                        onItemClickListenter.getData(lists,i);
                    }
                    viewHolder.dianzan.setBackgroundResource(R.drawable.dianzan);
                    greatNum -=1;
                    viewHolder.count.setText(greatNum +"");
                }else{
                    lists.get(i).setWhetherGreat(1);
                    viewHolder.dianzan.setBackgroundResource(R.drawable.bg_goods);
                    EventBus.getDefault().post(lists.get(i).getId()+"");
                    greatNum +=1;
                    viewHolder.count.setText(greatNum +"");
                }
            }
        });
        Glide.with(context).load(quanziBean.getResult().get(i).getHeadPic()).into(viewHolder.imageView);
        String pic = quanziBean.getResult().get(i).getImage();
        viewHolder.imageAdapter.getData(pic);
        if (StringUtils.isEmpty(pic)){
            viewHolder.recyclerView.setVisibility(View.GONE);
        }else {
            viewHolder.recyclerView.setVisibility(View.VISIBLE);
            String[] split = pic.split(",");
            viewHolder.imageAdapter.clear();
            viewHolder.imageAdapter.addList(split);
            if (split.length ==1){
                //  myViewHolder.recyclerView.setLayoutManager(new GridLayoutManager(context,1));
                viewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
                viewHolder.recyclerView.setNestedScrollingEnabled(false);
            }else if (split.length==2||split.length==4){
                viewHolder.recyclerView.setLayoutManager(new GridLayoutManager(context,2));
            }else{
                viewHolder.recyclerView.setLayoutManager(new GridLayoutManager(context,3));
            }
            viewHolder.recyclerView.setLayoutManager(viewHolder.gridLayoutManager);
            viewHolder.imageAdapter.notifyDataSetChanged();
        }



//        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                EventBus.getDefault().post(new MessageEvent(quanziBean.getResult().get(i).getNickName()));
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return quanziBean.getResult().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        RecyclerView recyclerView;
        TextView textView1,textView2,textView3,count;
        ImageAdapter imageAdapter;
        GridLayoutManager gridLayoutManager;
        Button dianzan;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageAdapter = new ImageAdapter(context);
            count = itemView.findViewById(R.id.quanziitem_count);
            dianzan = itemView.findViewById(R.id.quanziitem_zan);
            imageView = itemView.findViewById(R.id.quanzi_touxiang);
            recyclerView = itemView.findViewById(R.id.quanzi_recycler);
            textView1 = itemView.findViewById(R.id.quanzi_name);
            textView2 = itemView.findViewById(R.id.quanzi_time);
            textView3 = itemView.findViewById(R.id.quanzitext);
            recyclerView.setAdapter(imageAdapter);
            recyclerView.setLayoutManager(gridLayoutManager);
            gridLayoutManager = new GridLayoutManager(context,3);
        }
    }

    private  OnItemClickListenter  onItemClickListenter;
    //回调方法
    public  void     getDataCancle(OnItemClickListenter  onItemClickListenter){
        this.onItemClickListenter=onItemClickListenter;
    }
    //自定义接口
    public   interface   OnItemClickListenter{
        void   getData( List<QuanziBean.ResultBean>  lists,int position);
    }
}
