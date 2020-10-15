package com.jt.display.http;


import android.support.annotation.NonNull;
import android.util.Log;


import com.jt.display.base.Constants;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClient {

    private static volatile RetrofitClient instance;
    private APIService apiService;
    private APIService EncryptionapiService;

    private RetrofitClient() {
    }

    public static RetrofitClient getInstance() {
        if (instance == null) {
            synchronized (RetrofitClient.class) {
                if (instance == null) {
                    instance = new RetrofitClient();
                }
            }
        }
        return instance;
    }

    /**
     * 设置拦截器
     *
     * @return
     */
    private Interceptor getInterceptor() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        //显示日志
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return interceptor;
    }

    public APIService getApi() {
        //初始化一个client,不然retrofit会自己默认添加一个
        OkHttpClient client = new OkHttpClient().newBuilder()
                //设置拦截器
                .addInterceptor(getInterceptor())
                .addInterceptor(new Retry(Constants.HTTP_RETRY_COUNT))
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                //设置网络请求的Url地址
                .baseUrl(Constants.WMS_URL_BASE)
                //设置数据解析器
                .addConverterFactory(GsonConverterFactory.create())
//                .addConverterFactory(JsonConverterFactory.create())
                //设置网络请求适配器，使其支持RxJava与RxAndroid
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        //创建—— 网络请求接口—— 实例
        apiService = retrofit.create(APIService.class);
        return apiService;
    }


    public APIService getEncryptionApi() {
        //初始化一个client,不然retrofit会自己默认添加一个
        OkHttpClient client = new OkHttpClient().newBuilder()
                //设置拦截器
                .addInterceptor(getInterceptor())
                .addInterceptor(new Retry(Constants.HTTP_RETRY_COUNT))
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                //设置网络请求的Url地址
                .baseUrl(Constants.WMS_URL_BASE)
                //设置数据解析器
//                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(JsonConverterFactory.create())
                //设置网络请求适配器，使其支持RxJava与RxAndroid
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        //创建—— 网络请求接口—— 实例
        EncryptionapiService = retrofit.create(APIService.class);
        return EncryptionapiService;
    }


    class Retry implements Interceptor {

        public int maxRetry;//最大重试次数
        private int retryNum = 3;//假如设置为3次重试的话，则最大可能请求4次（默认1次+3次重试）

        public Retry(int maxRetry) {
            this.maxRetry = maxRetry;
        }

        @Override
        public Response intercept(@NonNull Chain chain) throws IOException {
            Request request = chain.request();
            Response response = chain.proceed(request);
            Log.i("Retry", "num:" + retryNum);
            while (!response.isSuccessful() && retryNum < maxRetry) {
                retryNum++;
                Log.i("Retry", "num:" + retryNum);
                response = chain.proceed(request);
            }
            return response;
        }
    }


}
