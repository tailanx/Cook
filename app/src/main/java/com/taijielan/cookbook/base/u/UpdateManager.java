//package com.taijielan.cookbook.base.u;
//
//import android.Manifest;
//import android.app.Activity;
//import android.app.Notification;
//import android.app.NotificationManager;
//import android.content.Context;
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Handler;
//import android.os.Message;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.WindowManager;
//import android.widget.RemoteViews;
//import android.widget.TextView;
//
//import com.yueniapp.shop.ShopApplication;
//import com.yueniapp.shop.base.constant.PrenerceKeyConstant;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//
//import static com.yueniapp.shop.base.constant.PrenerceKeyConstant.DOWN_APK_START;
//
///**
// * @author 作者  admin
// * @类名
// * @实现的主要功能
// * @创建日期 2016/6/13 11 48
// * @修改者 admin
// * @修改日期 2016/6/13 11 48
// * @修改内容
// */
//
//public class UpdateManager implements View.OnClickListener {
//    private Context mContext;
//    // 返回的安装包url
//    private String apkUrl;
//
//    /**
//     * 更新说明
//     **/
//    private String note = "";
//
//    private static final int DOWN_UPDATE = 1;
//    private static final int DOWN_OVER = 2;
//    private static final int DOWN_START = 3;
//    private static final int DOWN_FAUIL = 4;
//    private int progress;
//    private Thread downLoadThread;
//
//    private NotificationManager manager;
//    private Notification notification;
//    //添加权限
//    private PermissionUtil permissUtil;
//
//    private boolean interceptFlag = false;
//
//    public String getNote() {
//        return note;
//    }
//
//    public void setNote(String note) {
//        this.note = note;
//    }
//
//    public void setApkUrl(String apkUrl) {
//        this.apkUrl = apkUrl;
//    }
//
//    private Handler mHandler = new Handler() {
//        public void handleMessage(Message msg) {
//            switch (msg.what) {
//                case DOWN_UPDATE:
//                    notification.contentView.setTextViewText(R.id.content_view_text1, progress + "%");
//                    notification.contentView.setProgressBar(R.id.content_view_progress, 100, progress, false);
//                    manager.notify(0, notification);
//                    break;
//                case DOWN_OVER:
//                    SharePrenerceUtil.saveBolData(mContext, PrenerceKeyConstant.DOWNLOAD_APK_SUC, true);
//                    SharePrenerceUtil.saveIntData(mContext, DOWN_APK_START, 1);
//                    manager.cancelAll();
//                    installApk();
//                    break;
//                case DOWN_START:
//                    notification.contentView.setTextViewText(R.id.content_view_text1, SharePrenerceUtil.getIntData(mContext, DOWN_APK_START) + "%");
//                    notification.contentView.setProgressBar(R.id.content_view_progress, 100, SharePrenerceUtil.getIntData(mContext, DOWN_APK_START), false);
//                    manager.notify(0, notification);
//                    break;
//                case DOWN_FAUIL:
//                    ViewUtil.showView((Activity) mContext, mContext.getString(R.string.down_error));
//                    File file = new File(FileUtil.saveFileName);
//                    if (file.exists()) {
//                        file.delete();
//                    }
//                    break;
//                default:
//                    break;
//            }
//        }
//
//    };
//
//    public UpdateManager(Context context) {
//        this.mContext = context;
//        permissUtil = new PermissionUtil(context);
//    }
//
//    /**
//     *
//     */
//    public void checkUpdateInfo() {
//        showNoticeDialog();
//    }
//
//    private Dialog_Main noticeDialog;
//
//    private void showNoticeDialog() {
//        /** 确认和取消按钮 **/
//        TextView content;
//        // 获取一个布局填充器
//        // 加载一块布局
//        View dialogView = ((LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.dialog_update, null);
//        content = (TextView) dialogView.findViewById(R.id.dialog_text_content);
//        content.setText(note);//mContext.getString(R.string.update_version_Title_note) +"\n\t\t"+
//        // 设置点击事件
//        dialogView.findViewById(R.id.dialog_cancel_btn).setOnClickListener(this);
//        dialogView.findViewById(R.id.dialog_confirm_btn).setOnClickListener(this);
//        // 实例化窗口
//        noticeDialog = new Dialog_Main(mContext, R.style.mystyle, dialogView);
//        // 显示窗口
//        noticeDialog.show();
//        // 获取一个布局参数
//        WindowManager.LayoutParams lp = noticeDialog.getWindow().getAttributes();
//        // 设置布局宽度
//        lp.width = ViewUtil.getDisplayMetrics(mContext).widthPixels - 100; // 设置宽度
//        // 为窗口设置布局参数
//        noticeDialog.getWindow().setAttributes(lp);
//    }
//
//    /**
//     * 点击选在下载应用
//     */
//    private void showDownloadDialog() {
//        manager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
//        if (FileUtil.isDownReadly() &&
//                SharePrenerceUtil.getBolData(mContext, PrenerceKeyConstant.DOWNLOAD_APK_SUC)) {
//            installApk();
//        } else {
//            setNoticeView();
//            downloadApk();
//        }
//    }
//
//    /**
//     * 显示通知
//     */
//    private void setNoticeView() {
//        notification = new Notification.Builder(mContext).setSmallIcon(R.drawable.check_icon_fail).setAutoCancel(true).build();
//        RemoteViews remoteViews = new RemoteViews(mContext.getPackageName(), R.layout.dialog_version_update);
//        notification.contentView = remoteViews;
//        notification.tickerText = mContext.getString(R.string.update_version_Title);
//        manager.notify(0, notification);
//    }
//
//
//    private Runnable mdownApkRunnable = new Runnable() {
//
//
//        @Override
//        public void run() {
//            FileOutputStream fos = null;
//            try {
//                URL url = new URL(apkUrl);
//                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                conn.connect();
//                int length = conn.getContentLength();
//                InputStream is = conn.getInputStream();
//
//                File file = new File(FileUtil.savePath);
//                if (!file.exists()) {
//                    file.mkdir();
//                }
//                File ApkFile = new File(FileUtil.saveFileName);
//                fos = new FileOutputStream(ApkFile);
//
//                int count = 0;
//                byte buf[] = new byte[1024];
//                int countLength = conn.getContentLength();
//                int j = 0;
//
//                do {
//                    int numread = is.read(buf);
//                    count += numread;
//                    progress = (int) (((float) count / length) * 100);
//                    // 10%加载一次
//                    int i = (count * 100) / countLength;
//                    if (i > j * 10) {
//                        j++;
//                        // 更新进度
//                        mHandler.sendEmptyMessage(DOWN_UPDATE);
//                    }
//                    if (numread <= 0) {
//                        // 下载完成通知安装
//                        mHandler.sendEmptyMessage(DOWN_OVER);
//                        break;
//                    }
//                    fos.write(buf, 0, numread);
//                } while (!interceptFlag);// 点击取消就停止下载.
//                fos.close();
//                is.close();
//            } catch (MalformedURLException e) {
//                LogUtil.i("info", e.getMessage(), e);
//            } catch (IOException e) {
//                LogUtil.i("info", e.getMessage(), e);
//            } finally {
//                if (null != fos) {
//                    try {
//                        fos.close();
//                    } catch (IOException e) {
//                        LogUtil.i("info", e.getMessage(), e);
//                    }
//                }
//            }
//
//        }
//    };
//
//
//    /**
//     * 下载apk
//     */
//    private synchronized void downloadApk() {
//        downLoadThread = new Thread(mdownApkRunnable);
//        downLoadThread.start();
//    }
//
//    /**
//     * 安装apk
//     */
//    private void installApk() {
//        File apkfile = new File(FileUtil.saveFileName);
//        ShopApplication.getInstance().clear();
//        if (!apkfile.exists()) {
//            return;
//        }
//        Intent i = new Intent(Intent.ACTION_VIEW);
//        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        i.setDataAndType(Uri.fromFile(apkfile), "application/vnd.android.package-archive");
//        mContext.startActivity(i);
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.dialog_confirm_btn:
//                if (permissUtil.isSetPermission(Manifest.permission.READ_EXTERNAL_STORAGE)) {
//                    noticeDialog.dismiss();
//                    showDownloadDialog();
//                } else {
//                    ViewUtil.showView((Activity) mContext, "请打开读取文件权限");
//                }
//                break;
//            case R.id.dialog_cancel_btn:
//                noticeDialog.dismiss();
//                interceptFlag = true;
//
//                break;
//            default:
//                break;
//        }
//    }
//}