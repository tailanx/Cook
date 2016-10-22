//package com.taijielan.cookbook.base.u;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.graphics.Color;
//import android.graphics.drawable.ColorDrawable;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.widget.LinearLayout;
//import android.widget.PopupWindow;
//
//import com.taijielan.cookbook.R;
//import com.umeng.socialize.bean.SHARE_MEDIA;
//
///**
// * @author 作者  admin
// * @类名
// * @实现的主要功能
// * @创建日期 2016/10/11 16 44
// * @修改者 admin
// * @修改日期 2016/10/11 16 44
// * @修改内容
// */
//
//public class SharePop extends PopupWindow {
//    private Activity activity;
//    private View view;
//
//    private SharePop(Build build) {
//        this.activity = build.a;
//        view = LayoutInflater.from(activity).inflate(R.layout.activity_popupwindon_shared, null);
//        this.setContentView(view);
//        this.setFocusable(true);
//        this.setWidth(ViewUtil.dipToPx(activity, 179));
//        this.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
//        this.setOutsideTouchable(true);
//        this.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        initView();
//    }
//
//    private void initView() {
//        view.findViewById(R.id.re_shared_wxcircle).setOnClickListener(new ClickView(activity, SHARE_MEDIA.WEIXIN_CIRCLE, null, null, this));
//        view.findViewById(R.id.re_shared_wxfriend).setOnClickListener(new ClickView(activity, SHARE_MEDIA.WEIXIN_CIRCLE, null, null, this));
//        view.findViewById(R.id.re_shared_qq).setOnClickListener(new ClickView(activity, SHARE_MEDIA.WEIXIN_CIRCLE, null, null, this));
//        view.findViewById(R.id.re_shared_zone).setOnClickListener(new ClickView(activity, SHARE_MEDIA.WEIXIN_CIRCLE, null, null, this));
//        view.findViewById(R.id.re_shared_more).setOnClickListener(view1 -> {
//            Intent intent = new Intent();
//            intent.setAction(Intent.ACTION_SEND);
//            intent.putExtra(Intent.EXTRA_TEXT, activity.getResources().getString(R.string.shop_comming));
//            intent.setType("text/plain");
//            activity.startActivity((Intent.createChooser(intent, activity.getResources().getText(R.string.share_to_text))));
//        });
//    }
//
//    public void show(View parent, int x, int y) {
//        if (!isShowing()) {
//            this.showAsDropDown(parent, x, y);
//        } else {
//            this.dismiss();
//        }
//
//    }
//
//    public static class Build {
//        private Activity a;
//
//        public Build setContext(Activity c) {
//            this.a = c;
//            return this;
//        }
//
//        public SharePop create() {
//            return new SharePop(this);
//        }
//
//
//    }
//
//
//}
