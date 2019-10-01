package util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import api.Api;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class MyUtil {

    public final Api api;

    //单例模式
    private MyUtil(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .writeTimeout(5000, TimeUnit.SECONDS)
                .readTimeout(5000, TimeUnit.SECONDS)
                .connectTimeout(5000, TimeUnit.SECONDS)
                .addNetworkInterceptor(new Logg())
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        Retrofit build = new Retrofit.Builder()
                .baseUrl(Api.Url)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        api = build.create(Api.class);
    }
    private static class HttpUtil{
      static   MyUtil myUtil =new MyUtil();
    }
    public static MyUtil getutil(){
        return HttpUtil.myUtil;
    }
private class Logg implements Interceptor{

    @Override
    public Response intercept(Chain chain) throws IOException {
        SharedPreferences sp = MyApp.getContentInstace().getSharedPreferences("Login", Context.MODE_PRIVATE);
        Request request = chain.request();
        Request.Builder header = request.newBuilder()
                .addHeader("userId", sp.getString("userId", ""))
                .addHeader("sessionId", sp.getString("sessionId", ""));
        Request build = header.build();
        Response response = chain.proceed(build);
        Log.e("qwe1231111", "hou" + sp.getString("userId", ""));
        Log.e("qwe123", "hou" + response);
        return response;
    }
}
}
