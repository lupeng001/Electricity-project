package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;
import java.util.List;

import util.MyUtil;
import bean.BannerBean;
import bean.ShowBean;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import weektest.baway.com.weidu.R;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class ShouyeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ShowBean showBean;
    private int Type0 = 0;
    private int Type1 = 1;
    private int Type2 = 2;
    private int Type3 = 3;

    private ArrayList<String> list;
    private BannerBean bannerBean1;

    public ShouyeAdapter(Context context, ShowBean showBean) {
        this.context = context;
        this.showBean = showBean;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
         View view;
        if (i==Type0){
            view = LayoutInflater.from(context).inflate(R.layout.banner_layout, viewGroup, false);
            return new BannerViewHolder(view);
        }else if (i==Type1){
            view = LayoutInflater.from(context).inflate(R.layout.rxxp_layout, viewGroup, false);
            return new RxxpViewHolder(view);
        }else if (i == Type2){
            view = LayoutInflater.from(context).inflate(R.layout.pzsh_layout, viewGroup, false);
            return new PzshViewHolder(view);
        }else if (i==Type3){
            view = LayoutInflater.from(context).inflate(R.layout.mlss_layout, viewGroup, false);
            return new MlshViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int i) {
            if (viewHolder instanceof BannerViewHolder){
                MyUtil.getutil().api.getbanner()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<BannerBean>() {
                            @Override
                            public void onCompleted() {
                                list = new ArrayList<>();
                                 List<BannerBean.ResultBean> result = bannerBean1.getResult();
                                for (int j = 0; j < result.size(); j++) {
                                    list.add(result.get(j).getImageUrl());
                                }
                                ((BannerViewHolder) viewHolder).xBanner.setData(list,null);
                                ((BannerViewHolder) viewHolder).xBanner.setPoinstPosition(XBanner.RIGHT);
                                ((BannerViewHolder) viewHolder).xBanner.setPageTransformer(Transformer.Cube);


                                ((BannerViewHolder) viewHolder).xBanner.setmAdapter(new XBanner.XBannerAdapter() {
                                    @Override
                                    public void loadBanner(XBanner banner, View view, int position) {
                                        Glide.with(context).load(list.get(position)).into((ImageView) view);
                                    }
                                });
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(BannerBean bannerBean) {
                                bannerBean1 = bannerBean;
                            }
                        });

//                                ((BannerViewHolder) viewHolder).xBanner.setPageTransformer(Transformer.Accordion);
//                                ((BannerViewHolder) viewHolder).xBanner.setPageChangeDuration(1000);
            }else if (viewHolder instanceof RxxpViewHolder){
                RxxpViewHolder rxxpViewHolder = (RxxpViewHolder) viewHolder;
                rxxpViewHolder.textView.setText(showBean.getResult().getRxxp().getName());
                List<ShowBean.ResultBean.RxxpBean.CommodityListBean> rxxplist = showBean.getResult().getRxxp().getCommodityList();
                RxxpAdapter rxxpAdapter =new RxxpAdapter(context,rxxplist);
                LinearLayoutManager linearLayoutManager =new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
                rxxpViewHolder.recyclerView.setLayoutManager(linearLayoutManager);
                rxxpViewHolder.recyclerView.setAdapter(rxxpAdapter);

            }else if (viewHolder instanceof PzshViewHolder)
            {
                PzshViewHolder pzshViewHolder = (PzshViewHolder) viewHolder;
                pzshViewHolder.textView.setText(showBean.getResult().getMlss().getName());
                List<ShowBean.ResultBean.MlssBean.CommodityListBeanXX> mlsslist = showBean.getResult().getMlss().getCommodityList();
                PzshAdapter pzshAdapter =new PzshAdapter(context,mlsslist);
                LinearLayoutManager linearLayoutManager =new LinearLayoutManager(context);
                pzshViewHolder.recyclerView.setLayoutManager(linearLayoutManager);
                pzshViewHolder.recyclerView.setAdapter(pzshAdapter);

            }else if (viewHolder instanceof MlshViewHolder){
                MlshViewHolder mlshViewHolder = (MlshViewHolder) viewHolder;
                mlshViewHolder.textView.setText(showBean.getResult().getPzsh().getName());
                List<ShowBean.ResultBean.PzshBean.CommodityListBeanX> pzshlist = showBean.getResult().getPzsh().getCommodityList();
                MlssAdapter mlssAdapter =new MlssAdapter(context,pzshlist);

                mlshViewHolder.recyclerView.setLayoutManager(new GridLayoutManager(context,2));
                mlshViewHolder.recyclerView.setAdapter(mlssAdapter);
            }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return Type0;
        }else if (position == 1) {
            return Type1;
        } else if (position == 2) {
            return Type2;
        } else if (position==3){
            return Type3;
        }
        return super.getItemViewType(position);
    }

    public class BannerViewHolder extends RecyclerView.ViewHolder{
        private XBanner xBanner;
        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            xBanner = itemView.findViewById(R.id.shouye_xbanner);
        }
    }
    public class RxxpViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private RecyclerView recyclerView;
        public RxxpViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.rxxp_name);
            recyclerView = itemView.findViewById(R.id.rxxp_recycler);
        }
    }
    public class PzshViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private RecyclerView recyclerView;
        public PzshViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.pzsh_name);
            recyclerView = itemView.findViewById(R.id.pzsh_recycler);
        }
    }
    public class MlshViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private RecyclerView recyclerView;
        public MlshViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.mlss_name);
            recyclerView = itemView.findViewById(R.id.mlss_recycler);
        }
    }
}
