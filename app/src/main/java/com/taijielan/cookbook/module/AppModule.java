package com.taijielan.cookbook.module;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;

import com.taijielan.cookbook.BuildConfig;
import com.taijielan.cookbook.CookApplication;
import com.taijielan.cookbook.base.u.CookieInterceptor;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/18 12 15
 * @修改者 admin
 * @修改日期 2016/10/18 12 15
 * @修改内容
 */

@Module
public class AppModule {
    public static final int CONNET_TIMEOUT = 30;
    private CookApplication application;
    private Context context;

    public AppModule(CookApplication a, Context t) {
        this.application = a;
        this.context = t;
    }

    @Provides
    @Singleton
    public CookApplication provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    @NonNull
    public OkHttpClient getOkhttpClient(CookieInterceptor cookieInterceptor) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().
                addInterceptor(interceptor).
                connectTimeout(CONNET_TIMEOUT, TimeUnit.SECONDS).
                readTimeout(CONNET_TIMEOUT, TimeUnit.SECONDS).
                addInterceptor(cookieInterceptor).build();
        return okHttpClient;
    }

    @Provides
    @Singleton
    public CookieInterceptor getCookiteInterceptor() {
        return new CookieInterceptor();
    }

    @Provides
    @Singleton
    public LayoutInflater getLayoutinflater(Context c) {
        return LayoutInflater.from(c);
    }

}
