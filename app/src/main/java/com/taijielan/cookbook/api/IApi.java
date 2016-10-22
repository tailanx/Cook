package com.taijielan.cookbook.api;

import android.util.ArrayMap;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/18 12 19
 * @修改者 admin
 * @修改日期 2016/10/18 12 19
 * @修改内容
 */

public interface IApi {
    /**
     * 获取滚动展示的集合,假如参数为空，要在里面加一个空格
     *
     * @return 当前html页面
     */
    @GET(" ")
    Observable<String> getSliderShowFood();

    /**
     * 获取更新或者加载更多的数据
     *     * @param lm      食品的种类
     */
    @GET("list.php")
    Observable<String> getLoadMoreDate(@Query("sortby") String sortby,@Query("page") int page,@Query("lm") int lm);

}
