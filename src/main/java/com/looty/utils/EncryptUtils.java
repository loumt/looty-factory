/**
 * Copyright (c) www.bugull.com
 */
package com.looty.utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.SecureRandom;


/**
 * 加解密工具类
 *
 * @author helloWorld
 */
public class EncryptUtils {

    /**
     * Hex字符
     */
    public static final String HEX_DIGITS = "0123456789ABCDEF";

    /**
     * UTF-8
     */
    public static final String UTF_8 = "UTF-8";


    /**
     * 字节数组转成16进制字符串
     *
     * @param bytes
     * @return
     */
    public static String bytesToHexString(byte[] bytes) {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bytes.length; ++i) {
            int v = bytes[i] & 0xff;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * 获取MD5.字节数组
     *
     * @param bytes
     * @return
     * @throws Exception
     */
    public static byte[] getMd5(byte[] bytes) throws Exception {
        if (bytes == null) {
            throw new Exception("illegal params.");
        }
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(bytes);
        return md5.digest();
    }

    /**
     * 获取MD5值，返回16进制字符串
     *
     * @param str
     * @return
     * @throws Exception
     */
    public static String getMd5Hex(String str) throws Exception {
        if (StringUtil.isEmpty(str)) {
            throw new Exception("illegal params.");
        }
        return bytesToHexString(str.getBytes(UTF_8));
    }

    /**
     * 获取SHA1值。
     *
     * @param bytes
     * @return
     * @throws Exception
     */
    public static byte[] getSha1(byte[] bytes) throws Exception {
        if (bytes == null) {
            throw new Exception("illegal params.");
        }
        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
        sha1.update(bytes);
        return sha1.digest();
    }

    /**
     * 获取SHA1值。
     *
     * @param str
     * @return
     * @throws Exception
     */
    public static String getSha1Hex(String str) throws Exception {
        if (StringUtil.isEmpty(str)) {
            throw new Exception("illegal params.");
        }
        return bytesToHexString(getSha1(str.getBytes(UTF_8)));
    }

    /**
     * @param content
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] getHmacSha1(byte[] content, byte[] key) throws Exception {
        SecretKeySpec signingKey = new SecretKeySpec(key, "HmacSHA1");
        Mac mac = Mac.getInstance(signingKey.getAlgorithm());
        mac.init(signingKey);
        return mac.doFinal(content);
    }

    /**
     * @param content
     * @param key
     * @return
     * @throws Exception
     */
    public static String getHmacSha1Hex(String content, String key) throws Exception {
        SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(UTF_8), "HmacSHA1");
        Mac mac = Mac.getInstance(signingKey.getAlgorithm());
        mac.init(signingKey);
        return bytesToHexString(mac.doFinal(content.getBytes(UTF_8)));
    }

    /**
     * @param opmode
     * @param key
     * @param opmode
     * @return
     * @throws Exception
     */
    public static byte[] aes(int opmode, byte[] content, byte[] key) throws Exception {
        SecureRandom secureRandom = null;
        //if (android.os.Build.VERSION.SDK_INT >= 17) {//SHA1PRNG强随机种子算法,要区别4.2以上版本的调用方法
        secureRandom = SecureRandom.getInstance("SHA1PRNG", "Crypto");
        //} else {
        //	secureRandom = SecureRandom.getInstance("SHA1PRNG");
        //}
        secureRandom.setSeed(key);
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128, secureRandom);
        Cipher cipher = Cipher.getInstance("AES/ECB/ZeroBytePadding");
        cipher.init(opmode, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));
        return cipher.doFinal(content);
    }

    /**
     * AES加密，返回16进制字符串
     *
     * @param content
     * @param key
     * @return
     * @throws Exception
     */
    public static String aesEncryptHex(String content, String key) throws Exception {
        if (StringUtil.isEmpty(content) || StringUtil.isEmpty(key)) {
            throw new Exception("illegal params.");
        }
        return bytesToHexString(aes(Cipher.ENCRYPT_MODE, content.getBytes(UTF_8), key.getBytes(UTF_8)));
    }


}
