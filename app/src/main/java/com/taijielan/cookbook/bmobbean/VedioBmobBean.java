package com.taijielan.cookbook.bmobbean;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;


/**
 * @author 作者  admin
 * @类名 视频的信息
 * @实现的主要功能
 * @创建日期 2016/10/31 14 27
 * @修改者 admin
 * @修改日期 2016/10/31 14 27
 * @修改内容
 */

public class VedioBmobBean extends BmobObject {

    private String name;
    private BmobFile strUrl;
    private String strPic;

    public String getStrPic() {
        return strPic;
    }

    public void setStrPic(String strPic) {
        this.strPic = strPic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BmobFile getBmobFile() {
        return strUrl;
    }

    public void setBmobFile(BmobFile bmobFile) {
        this.strUrl = bmobFile;
    }
}
