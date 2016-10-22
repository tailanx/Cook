package com.taijielan.cookbook.base.u;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;

import com.taijielan.cookbook.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/9/19 11 43
 * @修改者 admin
 * @修改日期 2016/9/19 11 43
 * @修改内容
 */

public class ViewUtil {

    public static String formatTime(long time, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(new Date(time));
    }

    /**
     * 显示snackbar
     *
     * @param activity
     * @param s
     */
    public static void showView(Activity activity, String s) {
        Snackbar.make(activity.getWindow().getDecorView(), s, Snackbar.LENGTH_SHORT).show();
    }

    /**
     * 获取用户代理
     *
     * @param activity
     * @return
     */
    public static String getUserAgent(Activity activity) {
        return new WebView(activity).getSettings().getUserAgentString();
    }

    /**
     * 获取应用的版本name
     *
     * @param activity
     * @return
     */
    public static String getVersionName(Activity activity) {
        try {
            PackageManager packageManager = activity.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(activity.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            LogUtil.e("info", e.getMessage(), e);
        }
        return "";
    }

    /***
     * 获取应用的版本
     *
     * @param activity
     * @return
     */
    public static int getVersionCode(Activity activity) {
        try {
            PackageInfo packageInfo = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (Exception e) {
            LogUtil.e("info", e.getMessage(), e);
        }
        return 0;
    }

    /**
     * 获取当前运行的进程
     */
    public static String getProcess(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == pid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(dm);
        return dm;
    }

    /**
     * dp to px
     *
     * @param context
     * @param dp
     * @return
     */
    public static int dipToPx(Context context, double dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (density * dp + 0.5f);
    }

    public static int pxToDip(Context context, double value) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (value / scale + 0.5f);
    }

    public static void showDialog(Context context, AlertDialog dialog) {
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setWindowAnimations(R.style.mystyle);
        window.setBackgroundDrawableResource(android.R.color.transparent);

        WindowManager.LayoutParams windowManager = window.getAttributes();
        windowManager.width = ViewUtil.getDisplayMetrics(context).widthPixels;
        window.setAttributes(windowManager);
        dialog.setCanceledOnTouchOutside(true);
    }

    /**
     * 隐藏软键盘
     *
     * @param context
     * @param view
     */
    public static void hideSoftInput(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /***
     * 显示软键盘
     *
     * @param context
     * @param view
     */
    public static void showSoftInput(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(view, InputMethodManager.SHOW_FORCED);

    }


}
