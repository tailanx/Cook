package com.taijielan.cookbook.base.u;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.PopupWindow;

import com.taijielan.cookbook.R;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/11 18 00
 * @修改者 admin
 * @修改日期 2016/10/11 18 00
 * @修改内容
 */

public class ClickView implements View.OnClickListener {
    private SHARE_MEDIA share_media;
    private UMImage image;
    private Context context;
    private ShareAction shareAction;
    private Dialog dialog;
    private PopupWindow popupWindow;


    public ClickView(Context context, SHARE_MEDIA share, Bitmap b, Dialog dialog, PopupWindow popupWindow) {
        this.context = context;
        this.share_media = share;
        this.dialog = dialog;
        this.popupWindow = popupWindow;
        shareAction = new ShareAction((Activity) context);
        if (null == b) {
            b = BitmapFactory.decodeResource(context.getResources(), R.drawable.appicon);
        }
        image = new UMImage(context, b);
    }

    @Override
    public void onClick(View view) {
        if (null != dialog && dialog.isShowing()) {
            dialog.dismiss();
        }
        if (null != popupWindow && popupWindow.isShowing()) {
            popupWindow.dismiss();
        }


        shareAction.setPlatform(share_media).setCallback(umShareListener).withMedia(image).
                withTitle("【瓷肌】你的美丽，从\"瓷\"开始-人气整形美容互动社区").
                withText("【瓷肌】你的美丽，从\"瓷\"开始-人气整形美容互动社区").withTargetUrl("http://www.yueniapp.com").share();
    }

    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onResult(SHARE_MEDIA share_media) {
            ViewUtil.showView((Activity) context, context.getString(R.string.shared_suc));
        }

        @Override
        public void onError(SHARE_MEDIA share_media, Throwable throwable) {
            ViewUtil.showView((Activity) context, context.getString(R.string.shared_fail));
        }

        @Override
        public void onCancel(SHARE_MEDIA share_media) {
            ViewUtil.showView((Activity) context, context.getString(R.string.shared_cancel));
        }
    };

}
