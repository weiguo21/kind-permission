/**
 * Project Name:kafa-common-base
 * File Name:IDUtils.java
 * Package Name:com.kafa.common.uitls
 * Date:2016年8月11日下午7:36:07
 * Copyright (c) 2016, http://www.mcake.com All Rights Reserved.
 *
*/

package com.kind.common.uitls;

import java.util.Random;

/**
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2016年8月11日 下午7:36:07 <br/>
 * @author   weiguo.liu
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
/**
 * 
 * Function: 各种id生成策略. <br/>
 * Date:     2016年8月11日 下午7:35:44 <br/>
 * @author   weiguo.liu
 * @version  
 * @since    JDK 1.7
 * @see
 */
public class IDUtils {

	/**
	 * 图片名生成
	 */
	public static String genImageName() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上三位随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		//如果不足三位前面补0
		String str = millis + String.format("%03d", end3);
		return str;
	}
	
	/**
	 * 商品id生成
	 * @return
	 */
	public static long genProductId() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		//如果不足两位前面补0
		String str = millis + String.format("%02d", end2);
		long id = new Long(str);
		return id;
	}
	
	public static void main(String[] args) {
		for(int i=0;i< 100;i++)
		System.out.println(genProductId());
	}
}
