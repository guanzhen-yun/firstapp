package com.test.firstapp;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.test.firstapp.config.ConfigManager;
import com.test.firstapp.config.LogUtils;
import com.test.firstapp.config.ParamsInterceptor;
import com.test.firstapp.config.SSLSocketClient;
import com.test.firstapp.net.Constants;
import com.test.net.RetrofitManager;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.https.HttpsUtils;

import java.util.concurrent.TimeUnit;

import me.jessyan.retrofiturlmanager.RetrofitUrlManager;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class MyApp extends Application {
    private static final String TAG = "MyApp";
    private static MyApp app;
    public static Context mAppContext = null;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        RetrofitManager.initClient(getOkhttpClient(), ConfigManager.getInstance().getHost());
        initNetInfo();
        initOkhttpUtils();
    }

    public static MyApp getApp() {
        return app;
    }

    /**
     * 创建OkHttpClient
     */
    private static OkHttpClient getOkhttpClient() {
        HttpLoggingInterceptor.Logger logger =
                (String message) -> LogUtils.d("OkHttp_Log", message);
        OkHttpClient.Builder builder = RetrofitUrlManager.getInstance().with(new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(
                        new HttpLoggingInterceptor(logger).setLevel(HttpLoggingInterceptor.Level.BODY)))
                .addInterceptor(new ParamsInterceptor());

        if (BuildConfig.DEBUG) {
            builder.sslSocketFactory(SSLSocketClient.getSSLSocketFactory());
            builder.hostnameVerifier(SSLSocketClient.getHostnameVerifier());
        }
        return builder.build();
    }

    private void initOkhttpUtils() {
        //okhttp
        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager).build();
        OkHttpUtils.initClient(okHttpClient);
    }

    /**
     * 初始化域名信息
     */
    public static void initNetInfo() {
        RetrofitUrlManager.getInstance().putDomain(Constants.DOMAIN_ALI_KEY, ConfigManager.getInstance().getHost());
    }

    public interface OnConnectListener {
        void onConnect();
    }

    public static Context getAppContext() {
        return mAppContext;
    }

}
