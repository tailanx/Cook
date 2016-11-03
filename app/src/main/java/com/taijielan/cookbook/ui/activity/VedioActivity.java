package com.taijielan.cookbook.ui.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.taijielan.cookbook.R;
import com.taijielan.cookbook.base.u.MyMediaController;
import com.taijielan.cookbook.base.u.ViewUtil;
import com.taijielan.cookbook.bmobbean.VedioBmobBean;
import com.taijielan.cookbook.ui.view.IVedioActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.VideoView;

/**
 * @author 作者  admin
 * @类名 播放视频
 * @实现的主要功能
 * @创建日期 2016/11/3 11 08
 * @修改者 admin
 * @修改日期 2016/11/3 11 08
 * @修改内容
 */

public class VedioActivity extends BaseActivity implements IVedioActivity, Handler.Callback {

    @ViewInject(R.id.rl_content)
    private RelativeLayout reContent;
    @ViewInject(R.id.surface_view)
    private VideoView videoView;
    private VedioBmobBean vedioBmobBean;
    private MyMediaController myMediaController;
    private Handler handler;

    public static final int BATTER_ACTION = 100;
    public static final int TIME_ACTION = 200;

    public static Intent getIntent(Context context, VedioBmobBean bmobBean) {
        Intent intent = new Intent(context, VedioActivity.class);
        intent.putExtra("bmobBean", bmobBean);
        return intent;

    }

    @Override
    public void setConfig() {
        super.setConfig();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        vedioBmobBean = (VedioBmobBean) getIntent().getSerializableExtra("bmobBean");
        if (null == vedioBmobBean) {
            this.finish();
            return;
        }
    }

    @Override
    public int getView() {
        return R.layout.activity_vedio;
    }

    @Override
    public void initView() {
        ViewUtils.inject(this);
        handler = new Handler(this);
        Uri uri = Uri.parse(vedioBmobBean.getBmobFile().getUrl());
        if (!LibsChecker.checkVitamioLibs(this)) {
            return;
        }
        myMediaController = new MyMediaController(this, videoView, this);
        myMediaController.show(2000);
        //设置全屏
        videoView.setVideoLayout(VideoView.VIDEO_LAYOUT_STRETCH, 0);
        videoView.setVideoURI(uri);
        videoView.setMediaController(myMediaController);


        videoView.setOnPreparedListener(mp -> {
            reContent.setVisibility(View.GONE);
            ViewUtil.showView(this, getString(R.string.go_to_ready));
            videoView.start();
            //设置title
            myMediaController.setFileName(vedioBmobBean.getName());
        });
        videoView.setOnErrorListener((mp, what, extra) -> {
            ViewUtil.showView(VedioActivity.this, getString(R.string.go_to_error));
            this.finish();
            return false;
        });
        videoView.setOnCompletionListener(mp -> this.finish());

        //中等画质
        videoView.setVideoQuality(MediaPlayer.VIDEOQUALITY_MEDIUM);
        //获取焦点
        videoView.requestFocus();
        registBatteryBoradCast();
        new Thread(() -> {
            while (true) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                String dateStr = simpleDateFormat.format(new Date());
                Message msg = Message.obtain();
                msg.what = TIME_ACTION;
                msg.obj = dateStr;
                handler.sendMessage(msg);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


    @Override
    public void showDialog() {
        reContent.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideDialog() {
        reContent.setVisibility(View.GONE);
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction() == Intent.ACTION_BATTERY_CHANGED) {
                int level = intent.getIntExtra("level", 0);
                int totle = intent.getIntExtra("scale", 100);
                Message message = Message.obtain();
                message.what = BATTER_ACTION;
                message.obj = level * 100 / totle;
                handler.sendMessage(message);
            }
        }
    };

    private void registBatteryBoradCast() {
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case BATTER_ACTION:
                myMediaController.setBattery(msg.obj + "");
                break;
            case TIME_ACTION:
                myMediaController.setTime(msg.obj + "");
                break;
            default:
                break;
        }

        return false;
    }
}
