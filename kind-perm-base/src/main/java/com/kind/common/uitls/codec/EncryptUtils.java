package com.kind.common.uitls.codec;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * 
 * Function: 加密算法工具类(扩展md5以外的其他算法). <br/>
 * Date: 2016年6月29日 上午10:07:05 <br/>
 * 
 * @author weiguo21
 * @version
 * @since JDK 1.7
 * @see
 */
@SuppressWarnings("unused")
public class EncryptUtils {
	private final static String MD5_DIGEST = "MD5";

	private final static String SHA1_DIGEST = "SHA-1";

	public static String md5Encrypt(String str) {
		if (str == null)
			return str;
		MessageDigest localMessageDigest = null;
		try {
			localMessageDigest = MessageDigest.getInstance(MD5_DIGEST);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		localMessageDigest.update(str.getBytes());
		byte[] arrayOfByte = localMessageDigest.digest();
		return byte2Hex(arrayOfByte);
	}

	public static String byte2Hex(byte[] paramArrayOfByte) {
		String str1 = "";
		String str2 = "";
		for (int i = 0; i < paramArrayOfByte.length; i++) {
			str2 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
			if (str2.length() == 1)
				str1 = str1 + "0" + str2;
			else
				str1 = str1 + str2;
		}
		return str1.toLowerCase();
	}

	public static byte[] hex2Byte(String paramString) {
		if (paramString == null)
			return null;
		if (paramString.length() % 2 == 1)
			paramString = "0" + paramString;
		paramString = paramString.toLowerCase();
		byte[] arrayOfByte = new byte[paramString.length() / 2];
		int i = 0;
		for (int j = 0; j < paramString.length(); j += 2) {
			String str = paramString.substring(j, j + 2);
			arrayOfByte[(i++)] = Integer.valueOf(str, 16).byteValue();
		}
		return arrayOfByte;
	}

	/**
	 * 产生一个六位数的随机密码
	 * 
	 * @return
	 * @author cary
	 */
	public static String generatePassword() {
		int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Random rand = new Random();
		for (int i = 10; i > 1; i--) {
			int index = rand.nextInt(i);
			int tmp = array[index];
			array[index] = array[i - 1];
			array[i - 1] = tmp;
		}
		int result = 0;
		for (int i = 0; i < 6; i++)
			result = result * 10 + array[i];
		return String.valueOf(result);
	}

	public static void main(String[] args) {
		String password = EncryptUtils.md5Encrypt("67883473927");
		System.out.println(password);
	}

}
