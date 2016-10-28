package com.taijielan.cookbook.ui.activity;

import android.content.Intent;
import android.view.WindowManager;

import com.taijielan.cookbook.R;
import com.taijielan.cookbook.base.u.TaijielanConstant;

import java.util.concurrent.TimeUnit;

import cn.bmob.v3.Bmob;
import rx.Observable;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/18 15 44
 * @修改者 admin
 * @修改日期 2016/10/18 15 44
 * @修改内容
 */

public class SplashActivity extends BaseActivity {
    @Override
    public void setConfig() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    public int getView() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {
        Bmob.initialize(this, TaijielanConstant.BMOB_KEY);

        Observable.timer(4, TimeUnit.SECONDS).subscribe(aLong -> {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            SplashActivity.this.finish();
        });

    }


}
