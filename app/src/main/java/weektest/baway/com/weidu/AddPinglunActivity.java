package weektest.baway.com.weidu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jaiky.imagespickers.ImageConfig;
import com.jaiky.imagespickers.ImageSelector;
import com.jaiky.imagespickers.ImageSelectorActivity;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import bean.AddPinglunBean;
import bean.OrderAllBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import util.GlideLoader;
import util.MyUtil;

public class AddPinglunActivity extends AppCompatActivity {

    @BindView(R.id.fbQzXrec)
    XRecyclerView fbQzXrec;
    @BindView(R.id.fbPingYu)
    EditText fbPingYu;
    @BindView(R.id.fbSim)
    SimpleDraweeView fbSim;
    @BindView(R.id.fbPhoto)
    RelativeLayout fbPhoto;
    @BindView(R.id.fbTbCheck)
    CheckBox fbTbCheck;
    @BindView(R.id.fbButton)
    Button fbButton;
    private List<OrderAllBean.OrderListBean> orderList1;
    private int id;
    private String orderId;
    private ArrayList<String> pathlist;
    private ArrayList<String> path = new ArrayList<>();
    private ArrayList<File> fileList;
    private File file1;
    private HashMap<String, String> hashMap;
    private String usetId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pinglun);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        orderId = intent.getStringExtra("orderId");
        usetId = intent.getStringExtra("usetId");




        fbSim.setOnClickListener(new View.OnClickListener() {
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
                        .setContainer(fbPhoto, 4, true)
                        // 多选时的最大数量   （默认 9 张）
                        .mutiSelectMaxSize(9)
                        // 开启拍照功能 （默认关闭）
                        .showCamera()
                        // 已选择的图片路径
                        .pathList(path)
                        // 拍照后存放的图片路径（默认 /temp/picture） （会自动创建）
                        .filePath("/temp/picture")
                        .build();
                ImageSelector.open(AddPinglunActivity.this, imageConfig1);   // 开启图片选择器
            }
        });
        fbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = fbPingYu.getText().toString();
                fileList = new ArrayList<>();
                for (int i = 0; i < path.size(); i++) {
                    file1 = new File(path.get(i));
                    fileList.add(file1);
                }
                MultipartBody.Part[] parts = new MultipartBody.Part[path.size()];
                int index=0;
                for (File file : fileList) {
                    RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                    MultipartBody.Part image = MultipartBody.Part.createFormData("image", file.getName(), requestBody);
                    parts[index] = image;
                    index++;
                }
                hashMap = new HashMap<>();
                hashMap.put("commodityId",""+usetId);
                hashMap.put("orderId",""+orderId);
                hashMap.put("content",""+s);
                Observable<AddPinglunBean> pinglun = MyUtil.getutil().api.pinglun(hashMap, parts);
                pinglun.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<AddPinglunBean>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(AddPinglunBean addPinglunBean) {
                                Toast.makeText(AddPinglunActivity.this,addPinglunBean.getMessage()+"",Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            pathlist = data.getStringArrayListExtra(ImageSelectorActivity.EXTRA_RESULT);
            path.clear();
            path.addAll(pathlist);
        }
    }
}
