package com.example.showe.rsatest;

import android.util.Base64;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

public class RSATest {

    /**
     * 加密演算法
     * */
    public static final String KEY_ALGORITHM = "RSA";

    /**
     * 簽名演算法
     * */
    public static final String SIGNATURE_ALGORITHM = "SHA1WITHRSA";

    /**
     * 隨機數演算法
     * */
    public static final String RANDOM_ALGORITHM = "SHA1PRNG";

    /**
     * <p>
     * 生成密鑰對(公鑰和私鑰)
     * </p>
     *
     * @return
     * @throws Exception
     */
    public static KeyPair generateKeyPair() {
        KeyPair keyPair = null;
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
            SecureRandom random = SecureRandom.getInstance(RANDOM_ALGORITHM);
            keyPairGenerator.initialize(2048, random);
            keyPair = keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return keyPair;
    }

    /**
     * <p>
     * 用公鑰對資料加密
     * </p>
     *
     * @param data 資料
     * @param publicKey 公鑰
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(String data, RSAPublicKey publicKey) {
        byte[] encryptedBytes = null;
        try {
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            encryptedBytes = cipher.doFinal(data.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedBytes;
    }

    /**
     * <p>
     * 用公鑰(BASE64編碼)對資料加密
     * </p>
     *
     * @param data 資料
     * @param publicKeyStr 公鑰(BASE64編碼)
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(String data, String publicKeyStr) {
        RSAPublicKey rsaPublicKey = getPublicKey(publicKeyStr);
        return encrypt(data, rsaPublicKey);
    }

    /**
     * <p>
     * 用私鑰對已加密資料解密
     * </p>
     *
     * @param encrypted 已加密資料
     * @param privateKey 私鑰
     * @return
     * @throws Exception
     */
    public static String decrypt(byte[] encrypted, RSAPrivateKey privateKey) {
        String decryptedStr = null;
        try {
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decryptedBytes = cipher.doFinal(encrypted);
            decryptedStr = new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptedStr;
    }

    /**
     * <p>
     * 用私鑰(BASE64編碼)對已加密資料解密
     * </p>
     *
     * @param encrypted 已加密資料
     * @param privateKeyStr 私鑰(BASE64編碼)
     * @return
     * @throws Exception
     */
    public static String decrypt(byte[] encrypted, String privateKeyStr) {
        RSAPrivateKey rsaPrivateKey = getPrivateKey(privateKeyStr);
        return decrypt(encrypted, rsaPrivateKey);
    }

    /**
     * <p>
     * 用私鑰對資料生成數位簽章
     * </p>
     *
     * @param data 資料
     * @param privateKey 私鑰
     * @return
     * @throws Exception
     */
    public static byte[] sign(String data, RSAPrivateKey privateKey) {
        byte[] signed = null;
        try {
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initSign(privateKey);
            signature.update(data.getBytes());
            signed = signature.sign();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return signed;
    }

    /**
     * <p>
     * 用私鑰(BASE64編碼)資料生成數位簽章
     * </p>
     *
     * @param data 資料
     * @param privateKeyStr 私鑰(BASE64編碼)
     * @return
     * @throws Exception
     */
    public static byte[] sign(String data, String  privateKeyStr) {
        RSAPrivateKey rsaPrivateKey = getPrivateKey(privateKeyStr);
        return sign(data, rsaPrivateKey);
    }

    /**
     * <p>
     * 用公鑰驗證數位簽章
     * </p>
     *
     * @param data 資料
     * @param sign  數位簽章
     * @param publicKey 公鑰
     * @return
     * @throws Exception
     */
    public static boolean verify(String data, byte[] sign, RSAPublicKey publicKey) {
        boolean verify = false;
        try {
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initVerify(publicKey);
            signature.update(data.getBytes());
            verify = signature.verify(sign);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return verify;
    }

    /**
     * <p>
     * 用公鑰(BASE64編碼)驗證數位簽章
     * </p>
     *
     * @param data 資料
     * @param sign  數位簽章
     * @param publicKeyStr 公鑰(BASE64編碼)
     * @return
     * @throws Exception
     */
    public static boolean verify(String data, byte[] sign, String publicKeyStr) {
        RSAPublicKey rsaPublicKey = getPublicKey(publicKeyStr);
        return verify(data, sign, rsaPublicKey);
    }

    /**
     * <p>
     * 獲取私鑰
     * </p>
     *
     * @param keyPair 密鑰對
     * @return
     * @throws Exception
     */
    public static RSAPrivateKey getPrivateKey(KeyPair keyPair) {
        return (RSAPrivateKey) keyPair.getPrivate();
    }

    /**
     * <p>
     * 獲取私鑰(BASE64編碼)
     * </p>
     *
     * @param keyPair 密鑰對
     * @return
     * @throws Exception
     */
    public static String getPrivateKeyStr(KeyPair keyPair) {
        RSAPrivateKey rsaPrivateKey = getPrivateKey(keyPair);
        return new String(Base64.encode(rsaPrivateKey.getEncoded(), Base64.DEFAULT));
    }

    /**
     * <p>
     * 獲取私鑰
     * </p>
     *
     * @param privateKeyStr 私鑰(BASE64編碼)
     * @return
     * @throws Exception
     */
    public static RSAPrivateKey getPrivateKey(String privateKeyStr) {
        RSAPrivateKey rsaPrivateKey = null;
        try {
            byte[] buffer = Base64.decode(privateKeyStr.getBytes(), Base64.DEFAULT);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
            rsaPrivateKey = (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsaPrivateKey;
    }

    /**
     * <p>
     * 獲取公鑰
     * </p>
     *
     * @param keyPair 密鑰對
     * @return
     * @throws Exception
     */
    public static RSAPublicKey getPublicKey(KeyPair keyPair) {
        return (RSAPublicKey) keyPair.getPublic();
    }

    /**
     * <p>
     * 獲取公鑰(BASE64編碼)
     * </p>
     *
     * @param keyPair 密鑰對
     * @return
     * @throws Exception
     */
    public static String getPublicKeyStr(KeyPair keyPair) {
        RSAPublicKey rsaPublicKey = getPublicKey(keyPair);
        return new String(Base64.encode(rsaPublicKey.getEncoded(), Base64.DEFAULT));
    }

    /**
     * <p>
     * 獲取公鑰
     * </p>
     *
     * @param publicKeyStr 公鑰(BASE64編碼)
     * @return
     * @throws Exception
     */
    public static RSAPublicKey getPublicKey(String publicKeyStr) {
        RSAPublicKey rsaPublicKey = null;
        try {
            byte[] buffer = Base64.decode(publicKeyStr.getBytes(), Base64.DEFAULT);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
            rsaPublicKey = (RSAPublicKey) keyFactory.generatePublic(keySpec);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsaPublicKey;
    }
}
