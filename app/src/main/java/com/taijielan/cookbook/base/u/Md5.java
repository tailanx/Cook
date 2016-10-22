package com.taijielan.cookbook.base.u;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5 加密
 *
 * @author 门前大桥下 ❀
 */
public class Md5 {

    /**
     * 外部调用
     *
     * @param password
     * @return
     */
    public static String Encipher(String password) {
        return new Md5().EncipherString(password);
    }

    private String EncipherString(String password) {
        String str = encryption(password);
        return str;

    }

    /**
     * @param plain 加密字符串
     * @return 32位小写密文
     */
    public String encryption(String plain) {
        String re_md5 = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plain.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }

            re_md5 = buf.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return re_md5;
    }

}