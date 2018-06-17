package Encryption.MD5;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.DigestInputStream;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;


public class MD5 {


    public static void main(String[] args) throws Exception {

    }

    /**
     * 使用MAC 算法的 消息摘要
     * @param data
     * @throws Exception
     */
    public static void encodeByMAC(String data) throws Exception {
// KeyGenerator keyGen = KeyGenerator.getInstance("HmacMD5"); 
// SecretKey key = keyGen.generateKey(); //这个每次生成的key不一样, 此处不能使用 

        PBEKeySpec keySpec = new PBEKeySpec("randomkey^(^&*^%$".toCharArray());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        SecretKey key = keyFactory.generateSecret(keySpec);

        /*
         * 此类提供“消息验证码”（Message Authentication Code，MAC）算法的功能。
         * MAC 基于秘密密钥提供一种方式来检查在不可靠介质上进行传输或存储的信息的完整性。
         * 通常，消息验证码在共享秘密密钥的两个参与者之间使用，以验证这两者之间传输的信息。
         * 基于加密哈希函数的 MAC 机制也叫作 HMAC。结合秘密共享密钥，
         * HMAC 可以用于任何加密哈希函数（如 MD5 或 SHA-1）
         */
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(key);
        byte[] dest = mac.doFinal(data.getBytes());
        System.out.println(dest.length);
        System.out.println("MAC摘要：" + Arrays.toString(dest));
    }

    /**
     * md5加密 使用消息摘要MessageDigest 处理
     *
     * @throws Exception
     */
    public static String encodeByMD5(String str) throws Exception {
        MessageDigest md5;
        md5 = MessageDigest.getInstance("MD5");
        md5.update(str.getBytes()); //先更新摘要
        byte[] digest = md5.digest(); //再通过执行诸如填充之类的最终操作完成哈希计算。在调用此方法之后，摘要被重置。

        /*
         * 使用指定的 byte 数组对摘要进行最后更新，然后完成摘要计算。
         * 也就是说，此方法首先调用 update(input)，
         * 向 update 方法传递 input 数组，然后调用 digest()。
         */
// byte[] digest = md5.digest(str.getBytes()); 

        String hex = toHex(digest);
        return hex;
    }


    /**
     * 文件数据摘要
     *
     * @throws Exception
     */
    public static String md5File() throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        DigestOutputStream dos = new DigestOutputStream(new FileOutputStream(new File("abc.txt")), messageDigest);
        dos.close();
        byte[] digest = messageDigest.digest();

//        System.out.println("使用流读文件，该文件的摘要为:" + toHex(digest));
        return toHex(digest);
    }
    public  String getMD5ByFile(String path) throws IOException, NoSuchAlgorithmException {
        return getMD5ByFile(new File(path));
    }
    /**
     * 对一个文件获取md5值
     *
     * @return md5串
     * @throws NoSuchAlgorithmException
     */
    public static String getMD5ByFile(File file) throws IOException,
            NoSuchAlgorithmException {

        MessageDigest messagedigest = MessageDigest.getInstance("MD5");
        FileInputStream in = new FileInputStream(file);
        FileChannel ch = in.getChannel();
        MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0,
                file.length());
        messagedigest.update(byteBuffer);
        return toHex(messagedigest.digest());
    }

    /**
     * md5 摘要转16进制
     *
     * @param digest
     * @return
     */
    private static String toHex(byte[] digest) {
        StringBuilder sb = new StringBuilder();
        int len = digest.length;

        String out = null;
        for (int i = 0; i < len; i++) {
//  out = Integer.toHexString(0xFF & digest[i] + 0xABCDEF); //加任意 salt 
            out = Integer.toHexString(0xFF & digest[i]);//原始方法
            if (out.length() == 1) {
                sb.append("0");//如果为1位 前面补个0
            }
            sb.append(out);
        }
        return sb.toString();
    }

} 