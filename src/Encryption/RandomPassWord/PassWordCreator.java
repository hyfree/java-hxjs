package Encryption.RandomPassWord;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class PassWordCreator {
	/**
	 * 获得密码
	 * @param len 密码长度
	 * @return
	 */
	public static String createPassWord(int len){
		long random = createRandomInt();
		return createPassWord(random, len);
	}
	
	public static String createPassWord(long random,int len){
		//Random rd = new Random(random);
		//SecureRandom number = SecureRandom.getInstance("SHA1PRNG");
		SecureRandom rd=null;
		try {
			rd=SecureRandom.getInstance("SHA1PRNG");
			rd.setSeed(random);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}finally {
		}
		final int  maxNum = 62;
		StringBuffer sb = new StringBuffer();
		int rdGet;//取得随机数
		char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			    'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
			    'x', 'y', 'z', 'A','B','C','D','E','F','G','H','I','J','K',
			    'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			    'X', 'Y' ,'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		
		int count=0;
		while(count < len){
			rdGet = Math.abs(rd.nextInt(maxNum));//生成的数最大为62-1
			if (rdGet >= 0 && rdGet < str.length) {
				sb.append(str[rdGet]);
			    count ++;
			}
		}
		return sb.toString();
	}

    /**
     * 生成随机数种子，实际上这个函数没有被调用
     * @return
     */
	public static long createRandomInt(){
		//得到0.0到1.0之间的数字，并扩大100000倍
//		double temp = Math.random()*100000;
        long temp= 0;
        try {
            temp = SecureRandom.getInstance("SHA1PRNG").nextInt(100000);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //如果数据等于100000，则减少1
		if(temp>=100000){
			temp = 99999;
		}
		long tempint = (int)Math.ceil(temp);
		return tempint;
	}
	
	public static void main(String[] args){
		PassWordCreator pwc = new PassWordCreator();
		System.out.println(pwc.createPassWord(8));

	}
}