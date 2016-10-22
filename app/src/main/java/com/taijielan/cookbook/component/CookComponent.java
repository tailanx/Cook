package com.taijielan.cookbook.component;

import android.content.Context;
import android.view.LayoutInflater;

import com.taijielan.cookbook.CookApplication;
import com.taijielan.cookbook.api.IApi;
import com.taijielan.cookbook.model.FoodModel;
import com.taijielan.cookbook.module.ApiModule;
import com.taijielan.cookbook.module.AppModule;
import com.taijielan.cookbook.ui.activity.BaseActivity;
import com.taijielan.cookbook.ui.fragment.BaseFramgment;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/18 12 13
 * @修改者 admin
 * @修改日期 2016/10/18 12 13
 * @修改内容
 */
@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface CookComponent {

    void inject(CookApplication application);

    void inject(BaseActivity activity);

    void inject(BaseFramgment framgment);

    CookApplication getApplication();

    IApi getIApi();

    Context getContext();

    LayoutInflater getLayoutInflater();

    OkHttpClient getOkhttpClient();


}
