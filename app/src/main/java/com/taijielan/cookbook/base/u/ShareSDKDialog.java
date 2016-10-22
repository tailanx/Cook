//package com.taijielan.cookbook.base.u;
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.drawable.BitmapDrawable;
//import android.os.Handler;
//import android.support.v7.app.AlertDialog;
//import android.text.TextUtils;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.widget.ImageView;
//
//import com.squareup.picasso.Callback;
//import com.squareup.picasso.Picasso;
//import com.umeng.socialize.bean.SHARE_MEDIA;
//
///**
// * @author 作者  admin
// * @类名
// * @实现的主要功能
// * @创建日期 2016/10/8 17 42
// * @修改者 admin
// * @修改日期 2016/10/8 17 42
// * @修改内容
// */
//
//public class ShareSDKDialog {
//    private Context context;
//    private LayoutInflater layoutInflater;
//    private AlertDialog dialog;
//    /**
//     * 分享的内容
//     */
//    private String strContent;
//    /**
//     * 分享产品id
//     */
//    private int id;
//    /**
//     * 分享图片url
//     */
//    private String urlPic;
//    /**
//     * 分享的url
//     */
//    private String shareUrl;
//    /**
//     * 分享的title
//     */
//    private String strTitle;
//
//    private Bitmap b;
//
//    private ShareSDKDialog(Build build) {
//        this.layoutInflater = LayoutInflater.from(build.context);
//        this.context = build.context;
//        this.strContent = build.strContent;
//        this.id = build.id;
//        this.urlPic = build.urlPic;
//        this.shareUrl = build.shareUrl;
//        this.strTitle = build.strTitle;
//
//        initView();
//    }
//
//    private void initView() {
//        View view = layoutInflater.inflate(R.layout.dialog_share, null);
//        dialog = new AlertDialog.Builder(context).setView(view).create();
//        ViewUtil.showDialog(context, dialog);
//        view.findViewById(R.id.iv_delete).setOnClickListener(view1 -> dialog.dismiss());
//
//        if (!TextUtils.isEmpty(urlPic)) {
//            ImageView imageView = new ImageView(context);
//            Picasso.with(context).load(urlPic).into(imageView, new Callback() {
//                @Override
//                public void onSuccess() {
//                    new Handler().postDelayed(() -> {
//                        b = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
//                        onclick(view);
//                    }, 10);
//                }
//
//                @Override
//                public void onError() {
//                    onclick(view);
//                }
//
//
//            });
//        } else {
//            onclick(view);
//        }
//    }
//
//    private void onclick(View view) {
//        view.findViewById(R.id.ll_qq).setOnClickListener(new ClickView(context,SHARE_MEDIA.QQ, b,dialog,null));
//        view.findViewById(R.id.ll_qzone).setOnClickListener(new ClickView(context,SHARE_MEDIA.QZONE, b,dialog,null));
//        view.findViewById(R.id.ll_wx_chat).setOnClickListener(new ClickView(context,SHARE_MEDIA.WEIXIN, b,dialog,null));
//        view.findViewById(R.id.ll_wx_fans).setOnClickListener(new ClickView(context,SHARE_MEDIA.WEIXIN_CIRCLE, b,dialog,null));
//    }
//
//    public void show() {
//        if (null != dialog) {
//            dialog.show();
//        }
//    }
//
//    public static class Build {
//        private Context context;
//        /**
//         * 分享的内容
//         */
//        private String strContent;
//        /**
//         * 分享产品id
//         */
//        private int id;
//        /**
//         * 分享图片url
//         */
//        private String urlPic;
//        /**
//         * 分享的url
//         */
//        private String shareUrl;
//        /**
//         * 分享的title
//         */
//        private String strTitle;
//
//
//        public Build setContext(Context context) {
//            this.context = context;
//            return this;
//        }
//
//        public Build setContent(String content) {
//            this.strContent = content;
//            return this;
//        }
//
//        public Build setId(int id) {
//            this.id = id;
//            return this;
//        }
//
//        public Build setUrlPic(String urlPic) {
//            this.urlPic = urlPic;
//            return this;
//        }
//
//        public Build setShareUrl(String url) {
//            this.shareUrl = url;
//            return this;
//        }
//
//        public Build setTilte(String title) {
//            this.strTitle = title;
//            return this;
//        }
//
//        public ShareSDKDialog create() {
//            return new ShareSDKDialog(this);
//        }
//
//    }
//
////    class ClickView implements View.OnClickListener {
////        private SHARE_MEDIA share_media;
////        private UMImage image;
////
////        public ClickView(SHARE_MEDIA share, Bitmap b) {
////            this.share_media = share;
////            if (null == b) {
////                b = BitmapFactory.decodeResource(context.getResources(), R.drawable.check_icon_fail);
////            }
////            image = new UMImage(context, b);
////        }
////
////        @Override
////        public void onClick(View view) {
////            if(null != dialog &&dialog.isShowing()){
////                dialog.dismiss();
////            }
////            shareAction.setPlatform(share_media).setCallback(umShareListener).withMedia(image).
////                    withTitle("【瓷肌】你的美丽，从\"瓷\"开始-人气整形美容互动社区").
////                    withText("【瓷肌】你的美丽，从\"瓷\"开始-人气整形美容互动社区").withTargetUrl("http://www.yueniapp.com").share();
////        }
////
////        private UMShareListener umShareListener = new UMShareListener() {
////            @Override
////            public void onResult(SHARE_MEDIA share_media) {
////                ViewUtil.showView((Activity) context, context.getString(R.string.shared_suc));
////            }
////
////            @Override
////            public void onError(SHARE_MEDIA share_media, Throwable throwable) {
////                ViewUtil.showView((Activity) context, context.getString(R.string.shared_fail));
////            }
////
////            @Override
////            public void onCancel(SHARE_MEDIA share_media) {
////                ViewUtil.showView((Activity) context, context.getString(R.string.shared_cancel));
////            }
////        };
////
////    }
//
//
//}
