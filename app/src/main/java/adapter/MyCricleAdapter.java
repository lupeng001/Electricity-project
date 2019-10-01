package adapter;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import bean.MyCircleBean;
import weektest.baway.com.weidu.MyCircleActivity;
import weektest.baway.com.weidu.R;


public class MyCricleAdapter extends XRecyclerView.Adapter<MyCricleAdapter.CricleViewHolder> implements MyCircleActivity.onEditorLisenter {
     Context context;
     List<MyCircleBean.ResultBean> responses;
     private boolean f=true;
     private int numcricle;
     private Handler handler=new Handler();

    public MyCricleAdapter(Context context, List<MyCircleBean.ResultBean> responses) {
        this.context = context;
        this.responses = responses;
    }

    @NonNull
    @Override
    public CricleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.my_circle_item_layout,null,false);
        CricleViewHolder cricleViewHolder = new CricleViewHolder(view);
        return cricleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CricleViewHolder cricleViewHolder, final int i) {
        cricleViewHolder.big_img_cricle.setImageURI(responses.get(i).getImage());
        cricleViewHolder.time_cricle.setText(responses.get(i).getCreateTime()+"");
        cricleViewHolder.content_cricle.setText(responses.get(i).getContent());
        cricleViewHolder.num_cricle.setText(responses.get(i).getGreatNum()+"");
        final String image = responses.get(i).getImage();
        int greatNum = responses.get(i).getGreatNum();
        numcricle=greatNum;

        /*cricleViewHolder.big_img_cricle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PhotoViewActivity.class);
                intent.putExtra("image",image);
                context.startActivity(intent);
            }
        });*/

        cricleViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cricleViewHolder.box_myCircle.isChecked()){
                    cricleViewHolder.box_myCircle.setChecked(false);
                }else {
                    cricleViewHolder.box_myCircle.setChecked(true);
                }

            }
        });

        cricleViewHolder.box_myCircle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                responses.get(i).setIschck(cricleViewHolder.box_myCircle.isChecked());
            }
        });

        /*
        * 不点赞的时候
        * */
        cricleViewHolder.num_cricle.setText(numcricle+"");
        cricleViewHolder.greatY_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numcricle--;
                responses.get(i).setGreatNum(numcricle);
                cricleViewHolder.num_cricle.setText(responses.get(i).getGreatNum()+"");

                cricleViewHolder.greatY_circle.setVisibility(View.GONE);
                cricleViewHolder.greatN_circle.setVisibility(View.VISIBLE);
            }
        });



        /*
        * 点赞的时候
        * */
        cricleViewHolder.greatN_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                 * 数量的变化
                 * */
                numcricle++;
                responses.get(i).setGreatNum(numcricle);
                cricleViewHolder.num_cricle.setText(responses.get(i).getGreatNum()+"");
                /*
                 * 显示隐藏
                 * */
                cricleViewHolder.greatN_circle.setVisibility(View.GONE);
                cricleViewHolder.greatY_circle.setVisibility(View.VISIBLE);
                /*
                 * 动画效果
                 * */
                ObjectAnimator scaleX = ObjectAnimator.ofFloat(cricleViewHolder.greatY_circle, "scaleX", cricleViewHolder.greatY_circle.getScaleX(), 1f, 2f);
                ObjectAnimator scaleY = ObjectAnimator.ofFloat(cricleViewHolder.greatY_circle, "scaleY", cricleViewHolder.greatY_circle.getScaleY(), 1f, 2f);
                ObjectAnimator scaleX1 = ObjectAnimator.ofFloat(cricleViewHolder.greatY_circle, "scaleX", cricleViewHolder.greatY_circle.getScaleX(), 2f, 1f);
                ObjectAnimator scaleY1 = ObjectAnimator.ofFloat(cricleViewHolder.greatY_circle, "scaleY", cricleViewHolder.greatY_circle.getScaleY(), 2f, 1f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(scaleX).with(scaleX1).with(scaleY).with(scaleY1);
                animatorSet.setDuration(500);
                animatorSet.start();
            }
        });

    }

    @Override
    public int getItemCount() {
        return responses.size();
    }
/*
* 编辑
* */
    @Override
    public void onSendEditor() {

    }

    public class CricleViewHolder extends XRecyclerView.ViewHolder {

        private final SimpleDraweeView big_img_cricle;

        private final TextView time_cricle;
        private final TextView content_cricle;
        private final ImageView greatN_circle,greatY_circle;
        private final TextView num_cricle;
        private final CheckBox box_myCircle;

        public CricleViewHolder(@NonNull View itemView) {
            super(itemView);
            big_img_cricle = itemView.findViewById(R.id.big_img_circle);

            time_cricle = itemView.findViewById(R.id.time_cricle);
            content_cricle = itemView.findViewById(R.id.content_cricle);
            greatN_circle = itemView.findViewById(R.id.greatN_circle);
            greatY_circle = itemView.findViewById(R.id.greatY_circle);
            num_cricle = itemView.findViewById(R.id.num_circle);
            box_myCircle = itemView.findViewById(R.id.box_my_cirlce);
        }
    }
    public interface onZanLisenter{
        void onSendZan();
    }
    private onZanLisenter lisenter;

    public void setLisenter(onZanLisenter lisenter) {
        this.lisenter = lisenter;
    }
}
