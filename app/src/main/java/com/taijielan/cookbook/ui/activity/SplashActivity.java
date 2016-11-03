package com.taijielan.cookbook.ui.activity;

import android.content.Intent;
import android.util.Log;
import android.view.WindowManager;

import com.taijielan.cookbook.R;
import com.taijielan.cookbook.base.u.TaijielanConstant;
import com.taijielan.cookbook.bmobbean.VedioBmobBean;

import java.util.concurrent.TimeUnit;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;
import cn.bmob.v3.listener.SaveListener;
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
        BmobConfig bmobConfig = new BmobConfig.Builder(this).setApplicationId(TaijielanConstant.BMOB_KEY).setConnectTimeout(30).setFileExpiration(2500).setUploadBlockSize(1024 * 1024).build();
        Bmob.initialize(bmobConfig);
//        VedioBmobBean vedioBmobBean = new VedioBmobBean();
//        vedioBmobBean.setName("测试");
//        vedioBmobBean.save(this, new SaveListener() {
//
//            @Override
//            public void onSuccess() {
//                Log.e("okhttp", "创建成功");
//            }
//
//            @Override
//            public void onFailure(int i, String s) {
//                Log.e("okhttp", "创建失败");
//
//            }
//        });

        Observable.timer(4, TimeUnit.SECONDS).subscribe(aLong -> {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            SplashActivity.this.finish();
        });

    }


}
