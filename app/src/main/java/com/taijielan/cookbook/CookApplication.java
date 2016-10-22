package com.taijielan.cookbook;

import android.app.Application;
import android.util.Log;

import com.taijielan.cookbook.api.IApi;
import com.taijielan.cookbook.component.CookComponent;
import com.taijielan.cookbook.component.DaggerCookComponent;
import com.taijielan.cookbook.module.ApiModule;
import com.taijielan.cookbook.module.AppModule;

import javax.inject.Inject;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/18 11 42
 * @修改者 admin
 * @修改日期 2016/10/18 11 42
 * @修改内容
 */

public class CookApplication extends Application {

    private static CookApplication instance;
    private CookComponent cookComponent;


    public CookComponent getCookComponent() {
        return cookComponent;
    }

    public static CookApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        cookComponent = DaggerCookComponent.builder().apiModule(new ApiModule()).appModule(new AppModule(this, this.getApplicationContext())).build();
        cookComponent.inject(this);
    }
}
