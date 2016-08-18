package com.kind.common.uitls;

/**
 * 
 * Function: 数值类型处理. <br/>
 * Date: 2016年6月24日 上午11:20:34 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
public class NumberUtils {
	/**
	 * 验证Integer是否为空.
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isEmptyInteger(Integer obj) {
		if (obj == null || obj.equals(0)) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isEmptyLong(Long obj) {
		if (obj == null || obj.equals(0)) {
			return true;
		}
		return false;
	}

}
