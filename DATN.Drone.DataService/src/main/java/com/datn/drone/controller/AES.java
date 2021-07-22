/*
 *
 */
package com.datn.drone.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
 
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
 
// TODO: Auto-generated Javadoc
/**
 * The Class AES: Mã hóa mật khẩu người dùng bằng.
 */
public class AES {
 
    /** The secret key. */
    private static SecretKeySpec secretKey;
    
    /** The key. */
    private static byte[] key;
 
    /**
     * Mã hóa khóa.
     *
     * @param myKey the new key
     */
    public static void setKey(String myKey) 
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); 
            secretKey = new SecretKeySpec(key, "AES");
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } 
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
 
    /**
     * Mã hóa chuỗi ký tự nhập vào.
     *
     * @param strToEncrypt the str to encrypt
     * @param secret the secret
     * @return the string
     */
    public static String encrypt(String strToEncrypt, String secret) 
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } 
        catch (Exception e) 
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
 
    /**
     * Giải mã chuỗi ký tự đầu vào.
     *
     * @param strToDecrypt the str to decrypt
     * @param secret the secret
     * @return the string
     */
    public static String decrypt(String strToDecrypt, String secret) 
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } 
        catch (Exception e) 
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
    
//    public static void main(String[] args) 
//    {
//        final String secretKey = "@datdeptrai@@@anhxinhdep@@@910132!!!";
//         
//        String originalString = "5e86f1ac56de7131e29ed61e.5e875bd88c56ab1607f64e84";
//        //xl33LNCfpzZKkNHFjgbKD7aCjgzzOEkodKuwKubI9Rs=
//        //xl33LNCfpzZKkNHFjgbKD/z8JDdDZrQMibR82YxF3y8aCyk11e1zg9AcWwbNbJUefJY09wlOUl/R1/6+g07QzQ==
//        String encryptedString = AES.encrypt(originalString, secretKey) ;
//        String decryptedString = AES.decrypt(encryptedString, secretKey) ;
//         
//        System.out.println(originalString);
//        System.out.println(encryptedString);
//        System.out.println(decryptedString);
//    }
}
