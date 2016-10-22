package com.taijielan.cookbook.base.u;

import android.os.Environment;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/10 17 56
 * @修改者 admin
 * @修改日期 2016/10/10 17 56
 * @修改内容
 */

public class FileManager {

    public static final String PACKACKNAME = "com.yueniapp.shop";

    /**
     * 检测是否存在SD卡
     *
     * @return
     */
    public static boolean hasSDCard() {
        String status = Environment.getExternalStorageState();
        return status.equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * 获取数据路径
     *
     * @return
     */
    public static String getFilePath() {
        if (hasSDCard()) {
            return getRootFilePath() + "Android/data/" + PACKACKNAME + "/cache/";
        } else {
            return getRootFilePath() + "data/" + PACKACKNAME + "/cache/";
        }
    }

    /**
     * 处理SD卡结果，若存在SD卡，返回SD卡路径，不存在则返回手机内存路径
     *
     * @return
     */
    public static String getRootFilePath() {
        if (hasSDCard()) {
            return Environment.getExternalStorageDirectory().getAbsolutePath() + "/";
        } else {
            return Environment.getDataDirectory().getAbsolutePath() + "/data/";
        }
    }
}
