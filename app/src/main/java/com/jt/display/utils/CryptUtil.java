package com.jt.display.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class CryptUtil {

    /**
     * 进行MD5加密
     *
     * @param info
     *            要加密的信息
     * @return String 加密后的字符串
     */
    public static String encryptToMD5(String info) {
        byte[] digesta = null;
        try {
            // 得到一个md5的消息摘要
            MessageDigest alga = MessageDigest.getInstance("MD5");
            // 添加要进行计算摘要的信息
            alga.update(info.getBytes());
            // 得到该摘要
            digesta = alga.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // 将摘要转为字符串
        String rs = HexUtil.encodeHexStr(digesta);
        return rs;
    }

    /**
     * 进行SHA加密
     *
     * @param info
     *            要加密的信息
     * @return String 加密后的字符串
     */
    public static String encryptToSHA(String info) {
        byte[] digesta = null;
        try {
            // 得到一个SHA-1的消息摘要
            MessageDigest alga = MessageDigest.getInstance("SHA-1");
            // 添加要进行计算摘要的信息
            alga.update(info.getBytes());
            // 得到该摘要
            digesta = alga.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // 将摘要转为字符串
        String rs = HexUtil.encodeHexStr(digesta);
        return rs;
    }



}
