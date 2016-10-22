package com.taijielan.cookbook.module;

import com.taijielan.cookbook.api.IApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/18 12 18
 * @修改者 admin
 * @修改日期 2016/10/18 12 18
 * @修改内容
 */
@Module
public class ApiModule {
    /**
     * 判断是不是内网环境
     */
    private static final  String base = "http://www.meishij.net/";

    @Singleton
    @Provides
    public IApi provideIApi(OkHttpClient okHttpClient) {
        return new Retrofit.Builder().baseUrl(base).addConverterFactory(ScalarsConverterFactory.create()).
                addCallAdapterFactory(RxJavaCallAdapterFactory.create()).
                client(okHttpClient).build().create(IApi.class);
    }

}
