//package com.taijielan.cookbook.base.u;
//
//import android.content.Context;
//import android.text.TextUtils;
//
//import com.umeng.analytics.MobclickAgent;
//
///**
// * @author 作者  admin
// * @类名
// * @实现的主要功能
// * @创建日期 2016/9/20 09 53
// * @修改者 admin
// * @修改日期 2016/9/20 09 53
// * @修改内容
// */
//
//public class Umeng {
//    private static final String appkey = "57d111e8e0f55a8cd3002730";
//
//    public static void onResume(Context context) {
//        MobclickAgent.onResume(context);
//    }
//
//    public static void onPause(Context context) {
//        MobclickAgent.onPause(context);
//    }
//
//    /**
//     * 手动设置channel
//     *
//     * @param context
//     */
//    public static void setChannel(Context context) {
//        String channel;
//        if (TextUtils.isEmpty(SharePrenerceUtil.getStrData(context, PrenerceKeyConstant.CHANNNE_ID))) {
//            channel = ManifestUtil.getChannel(context);
//        } else {
//            channel = SharePrenerceUtil.getStrData(context, PrenerceKeyConstant.CHANNNE_ID);
//        }
//        if (!TextUtils.isEmpty(channel)) {
//            MobclickAgent.startWithConfigure(new MobclickAgent.UMAnalyticsConfig(context, appkey, channel));
//            SharePrenerceUtil.saveStrData(context, PrenerceKeyConstant.CHANNNE_ID, channel);
//        }
//    }
//}
