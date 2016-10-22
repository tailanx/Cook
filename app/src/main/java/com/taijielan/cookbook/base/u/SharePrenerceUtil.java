package com.taijielan.cookbook.base.u;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * @author 作者  admin
 * @类名 配置文件设置
 * @实现的主要功能
 * @创建日期 2016/9/19 10 20
 * @修改者 admin
 * @修改日期 2016/9/19 10 20
 * @修改内容
 */

public class SharePrenerceUtil {
    private static SharedPreferences sp;

    public static SharedPreferences getInstance(Context context) {
        if (null == sp) {
            sp = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return sp;
    }

    public static void saveIntData(Context context, String key, int value) {
        if (null == sp) {
            getInstance(context);
        }
        sp.edit().putInt(key, value).commit();
    }

    public static int getIntData(Context context, String key) {
        if (null == sp) {
            getInstance(context);
        }
        return sp.getInt(key, -1);
    }

    public static void saveStrData(Context context, String key, String value) {
        if (null == sp) {
            getInstance(context);
        }
        sp.edit().putString(key, value).commit();
    }

    public static String getStrData(Context context, String key) {
        if (null == sp) {
            getInstance(context);
        }
        return sp.getString(key, "");
    }

    public static void saveBolData(Context context, String key, boolean value) {
        if (null == sp) {
            getInstance(context);
        }
        sp.edit().putBoolean(key, value).commit();
    }

    public static Boolean getBolData(Context context, String key) {
        if (null == sp) {
            getInstance(context);
        }
        return sp.getBoolean(key, false);
    }

    public static void saveLongData(Context context, String key, long data) {
        if (null == sp) {
            getInstance(context);
        }
        sp.edit().putLong(key, data).commit();
    }

    public static long getLongData(Context context, String key) {
        if (null == sp) {
            getInstance(context);
        }
        return sp.getLong(key, -1);
    }

    public static void clear(Context context, String key) {
        if (null == sp) {
            getInstance(context);
        }
        sp.edit().remove(key).commit();
    }

}
