package weektest.baway.com.weidu;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jaiky.imagespickers.ImageConfig;
import com.jaiky.imagespickers.ImageSelector;
import com.jaiky.imagespickers.ImageSelectorActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import bean.FabuQuanziBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import mvp.p.Persion;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import util.BitMap;
import util.GlideLoader;
import util.MyUtil;

/**
 * @author dingtao
 * @date 2019/1/11 00:22
 * qq:1940870847
 */
public class AddCircleActivity extends BaseActivity {


    @BindView(R.id.bo_text)
    EditText boText;
    @BindView(R.id.bo_image_list)
    SimpleDraweeView image;
    //    CirCleAdapter cirCleAdapter;
    Bitmap bitmap;
    @BindView(R.id.back)
    ImageView back;


    private int commodityId = 1;
    private FabuQuanziBean fabuQuanziBean1;
    private HashMap<String, String> hashMap;
    private Persion persion;
    private ArrayList<String> path = new ArrayList<>();
    private List<String> pathList;
    private LinearLayout linearLayout;
    private ArrayList<File> fileList;
    private File file1;

    @Override
    protected void bindEvent() {

    }

    @Override
    protected void initData() {
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ImageConfig imageConfig1
                        = new ImageConfig.Builder(new GlideLoader())
                        .steepToolBarColor(getResources().getColor(R.color.blue))
                        .titleBgColor(getResources().getColor(R.color.blue))
                        .titleSubmitTextColor(getResources().getColor(R.color.white))
                        .titleTextColor(getResources().getColor(R.color.white))
                        // 开启多选   （默认为多选）
                        .mutiSelect()
                        .setContainer(linearLayout, 4, true)
                        // 多选时的最大数量   （默认 9 张）
                        .mutiSelectMaxSize(9)
                        // 开启拍照功能 （默认关闭）
                        .showCamera()
                        // 已选择的图片路径
                        .pathList(path)
                        // 拍照后存放的图片路径（默认 /temp/picture） （会自动创建）
                        .filePath("/temp/picture")
                        .build();


                ImageSelector.open(AddCircleActivity.this, imageConfig1);   // 开启图片选择器
            }
        });

    }

    @Override
    protected void initView() {
        linearLayout = findViewById(R.id.add_recycler);
        ButterKnife.bind(this);
        persion = new Persion(this);

//        cirCleAdapter = new CirCleAdapter();
//        cirCleAdapter.setSign(1);
//        cirCleAdapter.add(R.drawable.ic_launcher_background);
//        boImageList.setLayoutManager(new GridLayoutManager(this,3));
//        boImageList.setAdapter(cirCleAdapter);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String shuru = boText.getText().toString();
                fileList = new ArrayList<>();
                for (int i = 0; i < path.size(); i++) {
                    file1 = new File(path.get(i));
                    fileList.add(file1);
                }
                MultipartBody.Part[] parts = new MultipartBody.Part[path.size()];
                int index=0;
                for (File file :fileList) {
                    RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                    MultipartBody.Part image = MultipartBody.Part.createFormData("image", file.getName(), requestBody);
                    parts[index] = image;
                    index++;
                }

                File file = BitMap.compressImage(bitmap);
//                RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file.getAbsoluteFile());
//                MultipartBody.Part image_part = MultipartBody.Part.createFormData("image", file.getName(), requestBody);



                hashMap = new HashMap<>();
                hashMap.put("commodityId", "" + commodityId);
                hashMap.put("content", "" + shuru);
//        persion.getfabu(hashMap,file);
                Observable<FabuQuanziBean> getfabu = MyUtil.getutil().api.getfabu(hashMap, parts);
                getfabu.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<FabuQuanziBean>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(FabuQuanziBean fabuQuanziBean) {
                                fabuQuanziBean1 = fabuQuanziBean;
                                ToastData(fabuQuanziBean.getMessage() + "");
                            }
                        });
            }
        });

    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_add_circle;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

//    @OnClick(R.id.bo_image_list)
//    public void onViewClicked() {
//        Intent intent = new Intent(Intent.ACTION_PICK);
//        intent.setType("image/*");
//        startActivityForResult(intent, 0);
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            pathList = data.getStringArrayListExtra(ImageSelectorActivity.EXTRA_RESULT);
            path.clear();
            path.addAll(pathList);
        }
//        addRecycler.setLayoutManager(new GridLayoutManager(this,3));
//        adapter.ImageAdapter imageAdapter =new adapter.ImageAdapter(this);
//        imageAdapter.getDatas(path);
//        addRecycler.setAdapter(imageAdapter);
//        imageAdapter.notifyDataSetChanged();

    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        //获取图片
//        Uri data1 = data.getData();
//        try {
//            bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), dd
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        image.setImageBitmap(bitmap);
//    }

    public void getShow(FabuQuanziBean fabuQuanziBean) {
        String status = fabuQuanziBean.getStatus();
        if (status.equals("0000")) {
            ToastData(fabuQuanziBean.getMessage());
        }
    }
}
