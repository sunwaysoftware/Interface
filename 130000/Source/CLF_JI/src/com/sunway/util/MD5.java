package com.sunway.util;

import java.io.Serializable;
import java.security.MessageDigest;

/**
 * @author Andy.Gao
 * 
 */
public class MD5 implements Serializable {

	private static final long serialVersionUID = -8049849400436491864L;

	/**
	 * MD5加密
	 * @param pwd 明碼
	 * @return 密碼
	 */
	public static void main(String[] args) {
		System.out.println(MD5.MD5Encrypt("admin"));
	}
	
	/**
	 * MD5字符加密
	 * @param pwd 加密前的字符
	 * @return 加密后的字符
	 */
	public final static String MD5Encrypt(String pwd) {
		char hexDigits[] ={ '1', '2', '3', '4', '5', '6', '7', '8', 
							'9', '0', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = pwd.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}
}
