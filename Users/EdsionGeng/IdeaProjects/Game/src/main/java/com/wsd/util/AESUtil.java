
package com.wsd.util;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Cipher;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import javax.crypto.spec.IvParameterSpec;

public class AESUtil {
    public static void main(String[] args) throws Exception {
        String aa=aesEncrypt("235467","1@#^fdssd345+)8*sdfswdssda+     ");
         String bb=aesDecrypt(aa);
        System.out.println(aa);
    }

    public static String aesEncrypt(String str, String key) throws Exception {
        if (str == null || key == null) return null;
        String iv="E4ghj*Ghg!rNIfb&";
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keyspec = new SecretKeySpec(key.getBytes("utf-8"), "AES");
        IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes("utf-8"));
        cipher.init(Cipher.ENCRYPT_MODE, keyspec,ivspec);
        byte[] bytes = cipher.doFinal(str.getBytes("utf-8"));
        return new BASE64Encoder().encode(bytes);
    }
    public static String aesDecrypt(String str) throws Exception {
        if (str == null || str == "") return "0";
        String key="1@#^fdssd345+)8*sdfswdssda+     ";
        String iv="E4ghj*Ghg!rNIfb&";
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keyspec = new SecretKeySpec(key.getBytes("utf-8"), "AES");
        IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes("utf-8"));
        cipher.init(Cipher.DECRYPT_MODE, keyspec,ivspec);
        byte[] bytes = new BASE64Decoder().decodeBuffer(str);
        bytes = cipher.doFinal(bytes);
        return new String(bytes, "utf-8");
    }
    public static int   GetUid(String userid){
        String uid= null;
        try {
            uid = aesDecrypt(userid);

        } catch (Exception e) {
            e.printStackTrace();
        }
        int fuid;
        try{
            fuid=Integer.parseInt(uid);
        }
        catch (Exception e)
        {
            fuid=0;
        }
        return fuid;
    }
}