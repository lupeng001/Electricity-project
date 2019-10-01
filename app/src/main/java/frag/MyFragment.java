package frag;

import android.app.Person;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import bean.FabuQuanziBean;
import bean.MyBean;
import bean.TouxiangBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import mvp.p.Persion;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Url;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import util.BitMap;
import util.MyUtil;
import weektest.baway.com.weidu.AddressActivity;
import weektest.baway.com.weidu.MoneyActivity;
import weektest.baway.com.weidu.MyCircleActivity;
import weektest.baway.com.weidu.MyFootActivity;
import weektest.baway.com.weidu.R;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class MyFragment extends BaseFragment {
    @BindView(R.id.text_head_name)
    TextView textHeadName;
    @BindView(R.id.img_information)
    ImageView imgInformation;
    @BindView(R.id.text_information_my)
    TextView textInformationMy;
    @BindView(R.id.re1)
    RelativeLayout re1;
    @BindView(R.id.img_circle_my)
    ImageView imgCircleMy;
    @BindView(R.id.text_circle_my)
    TextView textCircleMy;
    @BindView(R.id.re2)
    RelativeLayout re2;
    @BindView(R.id.img_food_my)
    ImageView imgFoodMy;
    @BindView(R.id.text_foot_my)
    TextView textFootMy;
    @BindView(R.id.re3)
    RelativeLayout re3;
    @BindView(R.id.img_wallet_my)
    ImageView imgWalletMy;
    @BindView(R.id.text_wallet_my)
    TextView textWalletMy;
    @BindView(R.id.re4)
    RelativeLayout re4;
    @BindView(R.id.img_address_my)
    ImageView imgAddressMy;
    @BindView(R.id.text_address_my)
    TextView textAddressMy;
    @BindView(R.id.re5)
    RelativeLayout re5;
    @BindView(R.id.img_my_head)
    ImageView imgMyHead;
    Unbinder unbinder;
    private Button touxiangs;
    private Bitmap bitmap;
    private MultipartBody.Part image;
    private TouxiangBean touxiangBean1;
    private MyBean myBean1;

    @Override
    protected void bindEvent() {
        textAddressMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AddressActivity.class);
                startActivity(intent);
            }
        });
        textFootMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),MyFootActivity.class);
                startActivity(intent);
            }
        });
        textCircleMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),MyCircleActivity.class);
                startActivity(intent);
            }
        });
        imgMyHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View touxiang = LayoutInflater.from(getContext()).inflate(R.layout.mytouxiang_layout, null, false);
                touxiangs = touxiang.findViewById(R.id.my_xiangce);
                touxiangs.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent(Intent.ACTION_PICK);
                        intent.setType("image/*");
                        startActivityForResult(intent,0);
                    }
                });
                PopupWindow popupWindow = new PopupWindow(touxiang, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

                popupWindow.setTouchable(true);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                popupWindow.showAtLocation(touxiang,Gravity.BOTTOM,0,0);
            }
        });
    }

    @Override
    protected void initData() {
        Observable<MyBean> mybean = MyUtil.getutil().api.mybean();
        mybean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MyBean myBean) {
                        myBean1 = myBean;
                        imgMyHead.setImageURI(Uri.parse(myBean.getResult().getHeadPic()));
                    }
                });

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int bindLayout() {
        return R.layout.my_fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.text_wallet_my)
    public void onViewClicked() {
        Intent intent = new Intent(getContext(), MoneyActivity.class);
        startActivity(intent);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri data1 = data.getData();
        try {
            bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), data1);
        } catch (IOException e) {
            e.printStackTrace();
        }



        imgMyHead.setImageBitmap(bitmap);
        File file = BitMap.compressImage(bitmap);
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file.getAbsoluteFile());
        image = MultipartBody.Part.createFormData("image", file.getName(), requestBody);
        Observable<TouxiangBean> touxiangs = MyUtil.getutil().api.touxiang(image);
        touxiangs.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TouxiangBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(TouxiangBean touxiangBean) {
                        touxiangBean1 = touxiangBean;
                        Toast.makeText(getContext(), touxiangBean1.getMessage(),Toast.LENGTH_LONG).show();
                        imgMyHead.setImageURI(Uri.parse(touxiangBean1.getHeadPath()));
                    }
                });

    }

    @Override
    public void onPause() {

        Log.i("------------onpush",MyFragment.this+"");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i("------------onstop",MyFragment.this+"");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.i("------------onDestroy",MyFragment.this+"");
        super.onDestroy();
    }

    @Override
    public void onStart() {
        Log.i("------------onStart",MyFragment.this+"");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i("------------onResume",MyFragment.this+"");
        super.onResume();
    }

    @Override
    public void onAttach(Context context) {
        Log.i("------------onAttach",MyFragment.this+"");
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        Log.i("------------onDetach",MyFragment.this+"");
        super.onDetach();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i("-----------Created",MyFragment.this+"");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i("------------onCreate",MyFragment.this+"");
        super.onCreate(savedInstanceState);
    }


}
