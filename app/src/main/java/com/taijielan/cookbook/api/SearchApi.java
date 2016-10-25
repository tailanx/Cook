package com.taijielan.cookbook.api;

import com.taijielan.cookbook.bean.DetailCookBean;
import com.taijielan.cookbook.bean.SearchBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/18 17 27
 * @修改者 admin
 * @修改日期 2016/10/18 17 27
 * @修改内容
 */

public interface SearchApi {
    @GET("api/cook/name")
    Observable<SearchBean> searchByName(@Query("name") String name);

    @GET("api/cook/show")
    Observable<DetailCookBean> searchDeatail(@Query("id") String id);

}
