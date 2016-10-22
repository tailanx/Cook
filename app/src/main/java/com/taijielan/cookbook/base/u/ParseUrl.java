package com.taijielan.cookbook.base.u;

import android.text.TextUtils;

import com.taijielan.cookbook.bean.BannerBean;
import com.taijielan.cookbook.bean.CookBean;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/18 18 51
 * @修改者 admin
 * @修改日期 2016/10/18 18 51
 * @修改内容
 */

public class ParseUrl {
    public static List<BannerBean> getBanneBean(String s) {
        List<BannerBean> list = null;
        if (!TextUtils.isEmpty(s)) {
            list = new ArrayList<>();
            Document document = Jsoup.parse(s);
            Elements element = document.getElementsByClass("zzw_item_2");
            Elements elementTag = element.get(0).getElementsByTag("li");
            for (Element e : elementTag) {
                BannerBean bannerBean = new BannerBean();
                Elements elementsA = e.getElementsByTag("a");
                String link = elementsA.get(0).attr("href");
                String strTitle = elementsA.get(0).attr("title");
                Element elementImage = elementsA.get(0).getElementsByTag("img").get(0);
                String srcStr = elementImage.attr("src");
                bannerBean.setImage(srcStr);
                bannerBean.setImageUrl(link);
                bannerBean.setTitle(strTitle);
                list.add(bannerBean);
            }

        }
        return list;
    }

    public static List<CookBean> getLoadMore(String s) {
        List<CookBean> list = null;
        if (!TextUtils.isEmpty(s)) {
            list = new ArrayList<>();
            Document document = Jsoup.parse(s);
            Elements elements = document.getElementsByClass("listtyle1");
            for (Element element : elements) {
                CookBean bean = new CookBean();
                Elements elementsHref = element.getElementsByTag("a");
                String strHref = elementsHref.get(0).attr("href");
                String title = elementsHref.get(0).attr("title");
                String strImg = element.getElementsByTag("img").get(0).attr("src");
                String strSource = element.getElementsByTag("em").get(0).text();
                String strOther = element.getElementsByTag("span").get(0).text();
                Elements elements1Detail = element.getElementsByTag("ul");
                String strStep = elements1Detail.get(0).getElementsByClass("li1").get(0).text();
                String strSmell = elements1Detail.get(0).getElementsByClass("li2").get(0).text();
                bean.setHerf(strHref);
                bean.setImg(strImg);
                bean.setTitle(title);
                bean.setSource(strSource);
                bean.setStrOther(strOther);
                bean.setStrStep(strStep);
                bean.setStrSmell(strSmell);
                list.add(bean);
            }
        }
        return list;
    }

}
