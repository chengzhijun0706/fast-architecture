package com.justdoit.elementlibrary.utils;

import android.content.pm.Signature;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import timber.log.Timber;

public class DigestUtils {
    private static String TAG = DigestUtils.class.getSimpleName();
    private static char[] CH_HEXS = "0123456789ABCDEF".toCharArray();

    private static String hex2str(byte[] input) {
        StringBuilder sb = new StringBuilder();
        for (byte bt : input) {
            sb.append(CH_HEXS[(bt & 0xf0) >> 4]);
            sb.append(CH_HEXS[(bt & 0x0f)]);
        }
        return sb.toString();
    }

    /** Message Digest Algorithm */
    public static byte[] MDA(byte[] input, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        return md.digest(input);
    }

    public static String MD5(String str) {
        try {
            return MD5(str.getBytes("utf-8"));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Timber.w(TAG, ex);
        }
        return "00000000000000000000000000000000";
    }

    public static String MD5(byte[] input) throws NoSuchAlgorithmException {
        return hex2str(MDA(input, "md5"));
    }

    public static String SHA1(String str) {
        try {
            return SHA1(str.getBytes("utf-8"));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Timber.w(TAG, ex);
        }
        return "0000000000000000000000000000000000000000";
    }

    public static String SHA1(byte[] input) throws NoSuchAlgorithmException {
        return hex2str(MDA(input, "md5"));
    }

    /** 校验签名 */
    public static boolean verifySignature(Signature signature, String md5, String sha1) {
        String sign = signature.toCharsString();
        return md5.equalsIgnoreCase(MD5(sign)) || sha1.equalsIgnoreCase(SHA1(sign));
    }
}