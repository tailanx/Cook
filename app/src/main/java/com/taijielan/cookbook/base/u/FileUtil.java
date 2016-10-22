package com.taijielan.cookbook.base.u;

import java.io.File;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/10 17 55
 * @修改者 admin
 * @修改日期 2016/10/10 17 55
 * @修改内容
 */

public class FileUtil {

    /* 下载包安装路径 */
    public static final String savePath = FileManager.getFilePath() + "apk/";
    public static final String saveFileName = savePath + "UpdateDemoRelease.apk";
    /**
     * 判断下载包是不是已经下载好了
     * @return
     */
    public static boolean isDownReadly(){
        File file  = new File(saveFileName);
        if(file.exists()){
            return true;
        }else {
            return false;
        }
    }
}
