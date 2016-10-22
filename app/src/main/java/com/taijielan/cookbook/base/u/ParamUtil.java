package com.taijielan.cookbook.base.u;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/21 10 22
 * @修改者 admin
 * @修改日期 2016/10/21 10 22
 * @修改内容
 */

public class ParamUtil {

    private Map<String, String> map;

    public ParamUtil() {
        map = new HashMap<>();

    }

    public void addParams(String k, String v) {
        map.put(k, v);
    }

    public Map<String, String> getMap() {
        return map;
    }


}
