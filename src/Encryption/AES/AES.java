package Encryption.AES;

import Encryption.RandomPassWord.PassWordCreator;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import static Encryption.hex.HEX.parseByte2HexStr;
import static Encryption.hex.HEX.parseHexStr2Byte;



public class AES{
        /**
         * AES加密
         * @param content 需要加密的内容
         * @param password  加密密码
         * @return 密文
         */
        public static byte[] encrypt(String content, String password) {
            try {
                KeyGenerator kgen = KeyGenerator.getInstance("AES");//AES的key生产者
                kgen.init(128, new SecureRandom(password.getBytes()));;// 利用用户密码作为随机数初始化出
                // 128位的key生产者
                //加密没关系，SecureRandom是生成安全随机数序列，password.getBytes()是种子，只要种子相同，序列就一样，所以解密只要有password就行
                SecretKey secretKey = kgen.generateKey();// 根据用户密码，生成一个密钥
                byte[] enCodeFormat = secretKey.getEncoded();// 返回基本编码格式的密钥，如果此密钥不支持编码，则返回null
                SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");// 转换为AES专用密钥
                Cipher cipher = Cipher.getInstance("AES");// 创建密码器
                byte[] byteContent = content.getBytes("utf-8");
                cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
                byte[] result = cipher.doFinal(byteContent);// DES
                return result; // Encryption
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IllegalBlockSizeException e) {
                e.printStackTrace();
            } catch (BadPaddingException e) {
                e.printStackTrace();
            }finally {

            }
            return null;
        }
    /**解密
     * @param content  待解密内容
     * @param password 解密密钥
     * @return
     */
    public static byte[] decrypt(byte[] content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");// 创建AES的Key生产者
            kgen.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();// 根据用户密码，生成一个密钥
            byte[] enCodeFormat = secretKey.getEncoded();// 返回基本编码格式的密钥
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");//转换为AES专用密钥
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(content);//解密
            return result; // Encryption
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
//        Test1();
//        Test2();
        Test3();
    }
    public static void Test1(){
        String content = "test";
        String password = "12345678";
        //Encryption
        System.out.println("加密前：" + content);
        byte[] encryptResult = encrypt(content, password);
        System.out.println("加密后：" + new String(encryptResult));
        //解密
        byte[] decryptResult = decrypt(encryptResult,password);
        System.out.println("解密后：" + new String(decryptResult));
    }
    /**
     * 改进的
     */
    public static void  Test2(){
        String content = "test";
        String password = "12345678";
        //Encryption
        System.out.println("加密前：" + content);
        byte[] encryptResult = encrypt(content, password);
        String encryptResultStr = parseByte2HexStr(encryptResult);
        System.out.println("加密后：" + encryptResultStr);
        //解密
        byte[] decryptFrom = parseHexStr2Byte(encryptResultStr);
        byte[] decryptResult = decrypt(decryptFrom,password);
        System.out.println("解密后：" + new String(decryptResult));
    }
    public static void Test3(){
        String content = "test";
        String password =PassWordCreator.createPassWord(128);
        //Encryption
        System.out.println("加密前：" + content);
        byte[] encryptResult = encrypt(content, password);
        String encryptResultStr = parseByte2HexStr(encryptResult);
        System.out.println("加密后：" + encryptResultStr);
        //解密
        byte[] decryptFrom = parseHexStr2Byte(encryptResultStr);
        byte[] decryptResult = decrypt(decryptFrom,password);
        System.out.println("解密后：" + new String(decryptResult));
    }
}
