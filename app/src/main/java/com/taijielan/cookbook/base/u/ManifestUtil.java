package com.taijielan.cookbook.base.u;

import android.content.Context;
import android.content.pm.ApplicationInfo;

import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/9/20 17 36
 * @修改者 admin
 * @修改日期 2016/9/20 17 36
 * @修改内容
 */

public class ManifestUtil {

    /**
     * 获取META-INFO下面的渠道
     *
     * @param context
     * @return
     */
    public static String getChannel(Context context) {
        String retChannel = "csapp";
        ApplicationInfo appinfo = context.getApplicationInfo();
        String sourceDir = appinfo.sourceDir;
        String ret = "";
        ZipFile zipfile = null;
        try {
            zipfile = new ZipFile(sourceDir);
            Enumeration<?> entries = zipfile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = ((ZipEntry) entries.nextElement());
                String entryName = entry.getName();
                if (entryName.startsWith("META-INF/CSchannel_")) {
                    ret = entryName;
                    break;
                }
            }
        } catch (IOException e) {
            LogUtil.e("info", e.getMessage(), e);
        } finally {
            if (zipfile != null) {
                try {
                    zipfile.close();
                } catch (IOException e) {
                    LogUtil.e("info", e.getMessage(), e);
                }
            }
        }

        String[] split = ret.split("_");
        if (split != null && split.length >= 2) {
            retChannel = ret.substring(split[0].length() + 1);
        }
        return retChannel;
    }
}
