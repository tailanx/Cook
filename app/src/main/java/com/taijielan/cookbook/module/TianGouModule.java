package com.taijielan.cookbook.module;

import com.taijielan.cookbook.api.SearchApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/22 17 02
 * @修改者 admin
 * @修改日期 2016/10/22 17 02
 * @修改内容
 */
@Module
public class TianGouModule {
    public static final String BASE_URL = "http://www.tngou.net";

    @Singleton
    @Provides
    public SearchApi provideMeiShijie(OkHttpClient okHttpClient) {
        return new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).
                addCallAdapterFactory(RxJavaCallAdapterFactory.create()).client(okHttpClient).build().create(SearchApi.class);
    }
}
