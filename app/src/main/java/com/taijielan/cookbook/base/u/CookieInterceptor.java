package com.taijielan.cookbook.base.u;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/6/17 11 46
 * @修改者 admin
 * @修改日期 2016/6/17 11 46
 * @修改内容
 */

import android.content.Context;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/6/2 18 40
 * @修改者 admin
 * @修改日期 2016/6/2 18 40
 * @修改内容
 */
public class CookieInterceptor implements Interceptor {

//    private String appid = "2";
//    //设备的唯一标示
//    private String did;
//    //用户的useragent
//    private String useragent;
//    //版本信息
//    private String appVer;
//    @Inject
//    protected Context context;
//
////    {
////        did = SharePrenerceUtil.getStrData(ShopApplication.getInstance().getApplicationContext(), DEVICE_INFO_ID);
////        useragent = SharePrenerceUtil.getStrData(ShopApplication.getInstance().getApplicationContext(), PrenerceKeyConstant.USER_AGENT);
////        appVer = SharePrenerceUtil.getStrData(ShopApplication.getInstance().getApplicationContext(), PrenerceKeyConstant.APP_VERION);
////    }
//
    @Inject
    public CookieInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder().build();

        return chain.proceed(request);
    }
}
