package com.taijielan.cookbook.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.taijielan.cookbook.CookApplication;
import com.taijielan.cookbook.model.SearchModel;

import javax.inject.Inject;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/17 17 53
 * @修改者 admin
 * @修改日期 2016/10/17 17 53
 * @修改内容
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Inject
    protected SearchModel searchModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setConfig();
        setContentView(getView());
        CookApplication.getInstance().getCookComponent().inject(this);
        initView();

    }

    public void setConfig() {
    }
    public abstract int getView();
    public abstract  void initView();
}
