package com.taijielan.cookbook.base.u;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 作者  admin
 * @类名 权限设置
 * @实现的主要功能
 * @创建日期 2016/9/19 11 09
 * @修改者 admin
 * @修改日期 2016/9/19 11 09
 * @修改内容
 */

public class PermissionUtil {
    public static final int REQUESTCODE = 100;
    private List<String> permissionList;
    private Context activity;

    public PermissionUtil(Context c) {
        this.activity = c;
        permissionList = new ArrayList<>();
        permissionList.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        permissionList.add(Manifest.permission.READ_PHONE_STATE);
        permissionList.add(Manifest.permission.CAMERA);
    }

    /**
     * 设置所有权限
     */
    public void setAllPermission() {
        for (int i = 0; i < permissionList.size(); i++) {
            if (ContextCompat.checkSelfPermission(activity, permissionList.get(i)) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) activity, permissionList.get(i))) {
                    ViewUtil.showView((Activity) activity, "please give me the permission");
                } else {
                    ActivityCompat.requestPermissions((Activity) activity, new String[]{permissionList.get(i)}, REQUESTCODE);
                }

            }
        }
    }

    /**
     * 设置单个权限
     *
     * @return
     */
    public boolean setPermission(String strPermission) {
        if (ActivityCompat.checkSelfPermission(activity, strPermission) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) activity, strPermission)) {
                ViewUtil.showView((Activity) activity, "please give me the permission");
            } else {
                ActivityCompat.requestPermissions((Activity) activity, new String[]{strPermission}, REQUESTCODE);
            }
            return false;
        }
        return true;
    }

    /**
     * 检查是不是统一某个权限
     */
    public boolean isSetPermission(String permission) {
        if (ActivityCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
            return false;
        }
        return true;
    }
}
