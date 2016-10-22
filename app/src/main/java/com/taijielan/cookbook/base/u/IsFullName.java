package com.taijielan.cookbook.base.u;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;

import com.taijielan.cookbook.R;

import java.util.regex.Pattern;

/**
 * 工具类 用来进行非空的验证
 *
 * @author admin
 */
public class IsFullName {
    // 手机号码的正则表达式
    private static String phoneRegEx = "^(1[3-9])\\d{9}$";
    private static Pattern pattern = Pattern.compile(phoneRegEx);

    /**
     * 判断 用户名和密码是不是为空
     *
     * @param context 上下文
     * @param strUser 用户名
     * @param strPass 用户密码
     * @return true 是有效的 false是无效的
     */
    public static boolean isValidUserPass(Context context, String strUser,
                                          String strPass) {
        boolean flag = false;
        if (TextUtils.isEmpty(strUser)) {
            setTip(context, R.string.is_null_username);
        } else if (TextUtils.isEmpty(strPass)) {
            setTip(context, R.string.is_null_password);
        } else if (!pattern.matcher(strUser).find()) {
            setTip(context, R.string.phone_no_match);
        } else {
            flag = true;
        }
        return flag;
    }

    /**
     * 验证 用户名 密码 单选框
     *
     * @param context
     * @param strUser
     * @param strPass
     * @param isCheck
     * @return
     */
    public static boolean isValidateLogin(Context context, String strUser, String strPass, boolean isCheck) {
        boolean flag = false;
        if (TextUtils.isEmpty(strUser)) {
            setTip(context, R.string.is_null_username);
        } else if (TextUtils.isEmpty(strPass)) {
            setTip(context, R.string.is_null_password);
        } else if (!pattern.matcher(strUser).find()) {
            setTip(context, R.string.phone_no_match);
        } else if (!isCheck) {
            setTip(context, R.string.login_register_register_agreement_alert);
        } else {
            flag = true;
        }
        return flag;

    }

    /**
     * 用户注册验证
     *
     * @param context 上下文问
     * @param strUser 用户账号
     * @param strSms  短信
     * @return true 是有用的账号 false 是无效的账号
     */
    public static boolean isValidUserReg(Context context, String strUser,
                                         String strSms, String strPwd) {
        boolean flag = false;
        if (TextUtils.isEmpty(strUser)) {
            setTip(context, R.string.is_null_username);
        } else if (TextUtils.isEmpty(strPwd)) {
            setTip(context, R.string.is_null_password);
        } else if (strPwd.length() < 6) {
            setTip(context, R.string.bad_pwd);
        } else if (TextUtils.isEmpty(strSms)) {
            setTip(context, R.string.is_null_verification);
        } else if (!pattern.matcher(strUser).find()) {
            setTip(context, R.string.phone_no_match);
        } else {
            flag = true;
        }
        return flag;
    }

    /**
     * 验证是不是手机号码
     *
     * @param context
     * @param strPhone
     * @return
     */
    public static boolean isPhone(Context context, String strPhone) {
        boolean flag = false;
        if (TextUtils.isEmpty(strPhone)) {
            setTip(context, R.string.is_null_username);
        } else if (!pattern.matcher(strPhone).find()) {
            setTip(context, R.string.phone_no_match);
        } else {
            flag = true;
        }
        return flag;
    }

    /**
     * 验证是不是手机验证码
     *
     * @param context
     * @return
     */
    public static boolean isSMS(Context context, String strSMS) {
        boolean flag = false;
        if (TextUtils.isEmpty(strSMS)) {
            setTip(context, R.string.is_null_verification);
        } else {
            flag = true;
        }
        return flag;
    }

    public static boolean isNotNullSearch(Context context, String s) {
        boolean flag = false;
        if (TextUtils.isEmpty(s)) {
            setTip(context, context.getString(R.string.search_content_null));
        } else {
            flag = true;
        }
        return flag;

    }

    /**
     * 验证俩次输入的密码是不是一样的
     *
     * @param context
     * @param strFirst
     * @param strSecond
     * @return
     */
    public static boolean isDouVeri(Context context, String strFirst,
                                    String strSecond) {
        boolean flag = false;
        if (TextUtils.isEmpty(strFirst) || TextUtils.isEmpty(strSecond) || strFirst.length() < 6 || strSecond.length() < 6) {
            setTip(context, R.string.error_createNewpassword_hint);
        } else if (!strFirst.equals(strSecond)) {
            setTip(context, R.string.dif_pwd);
        } else {
            flag = true;
        }
        return flag;
    }

    public static boolean isOldNewPwd(Context context, String oldPwd, String newPwd) {
        boolean flag = false;
        if (TextUtils.isEmpty(oldPwd) || oldPwd.length() < 5) {
            setTip(context, R.string.bad_pwd);
        } else if (TextUtils.isEmpty(newPwd) || newPwd.length() < 5) {
            setTip(context, R.string.error_createNewpassword_hint);
        } else {
            flag = true;
        }
        return flag;
    }

    /**
     * 验证手机号码和短信
     *
     * @param context
     * @param strPhone
     * @param strSms
     * @return
     */
    public static boolean isResetBind(Context context, String strPhone, String strSms) {
        boolean flag = false;
        if (TextUtils.isEmpty(strPhone)) {
            setTip(context, R.string.is_null_username);
        } else if (!pattern.matcher(strPhone).find()) {
            setTip(context, R.string.phone_no_match);
        } else if (TextUtils.isEmpty(strSms)) {
            setTip(context, R.string.is_null_verification);
        } else {
            flag = true;
        }
        return flag;
    }


    /**
     * 弹出对话框
     */
    public static void setTip(Context context, int c) {
        ViewUtil.showView((Activity) context, context.getString(c));
//        new MaterialDialog.Builder(context).content(context.getString(c)).positiveText(context.getString(R.string.sure)).show();
    }

    /**
     * 弹出对话框
     */
    public static void setTip(Context context, String c) {
        ViewUtil.showView((Activity) context, c);
//        new MaterialDialog.Builder(context).content(c).positiveText(context.getString(R.string.sure)).show();
    }

}
