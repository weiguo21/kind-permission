package com.kind.common.uitls;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * ClassName: StringUtils <br/>
 * Function: 字符串工具类，用于实现一些字符串的常用操作. <br/>
 * date: 2016-3-28 下午4:03:40 <br/>
 * 
 * @author weiguo21
 * @version
 * @since JDK 1.7
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {
	private static final Logger logger=LoggerFactory.getLogger(StringUtils.class);

	public static final String NUMBERS_AND_LETTERS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static final String NUMBERS = "0123456789";

	public static final String LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static final String CAPITAL_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static final String LOWER_CASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";

	public static final String defaultKeyAndValueSeparator = ":";

	public static final String defaultValueEntitySeparator = ",";

	public static final String defaultKeyOrValueQuote = "\"";

	/**
	 * 判断字符串是否为空或长度为0
	 * 
	 * @param str
	 * @return 若字符串为null或长度为0, 返回true; 否则返回false.
	 * 
	 *         <pre>
	 *         isEmpty(null) = true;
	 *         isEmpty(&quot;&quot;) = true;
	 *         isEmpty(&quot;  &quot;) = false;
	 *         </pre>
	 */
	public static boolean isEmpty(String str) {
		return (str == null || str.length() == 0);
	}

	/**
	 * 判断字符串是否为空或长度为0，或仅由空格组成
	 * 
	 * @param str
	 * @return 若字符串为null或长度为0或仅由空格组成, 返回true; 否则返回false.
	 */
	public static boolean isBlank(String str) {
		return (isEmpty(str) || (str.trim().length() == 0));
	}

	/**
	 * 判断字符串是否不为空。
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(String str) {
		return (isNotEmpty(str) || (str.trim().length() > 0));
	}

	/**
	 * 将字符串首字母大写后返回
	 * 
	 * @param str
	 *            原字符串
	 * @return 首字母大写后的字符串
	 */
	public static String capitalizeFirstLetter(String str) {
		return (isEmpty(str) || !Character.isLetter(str.charAt(0))) ? str
				: Character.toUpperCase(str.charAt(0)) + str.substring(1);
	}

	/**
	 * 如果不是普通字符，则按照utf8进行编码
	 * 
	 * @param str
	 *            原字符
	 * @return 编码后字符，编码错误返回null
	 */
	public static String utf8Encode(String str) {
		if (!isEmpty(str) && str.getBytes().length != str.length()) {
			try {
				return URLEncoder.encode(str, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return null;
			}
		}
		return str;
	}

	/**
	 * 如果不是普通字符，则按照utf8进行编码，编码异常则返回defultReturn
	 * 
	 * @param str
	 *            源字符串
	 * @param defultReturn
	 *            默认出错返回
	 * @return
	 */
	public static String utf8Encode(String str, String defultReturn) {
		if (!isEmpty(str) && str.getBytes().length != str.length()) {
			try {
				return URLEncoder.encode(str, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				return defultReturn;
			}
		}
		return str;
	}

	/**
	 * null字符串转换为长度为0的字符串
	 * 
	 * @param str
	 *            待转换字符串
	 * @return
	 * @see
	 * 
	 *      <pre>
	 *      nullStrToEmpty(null) = &quot;&quot;;
	 *      nullStrToEmpty(&quot;&quot;) = &quot;&quot;;
	 *      nullStrToEmpty(&quot;aa&quot;) = &quot;&quot;;
	 *      </pre>
	 */
	public static String nullStrToEmpty(String str) {
		return (str == null ? "" : str);
	}

	/**
	 * 以固定格式得到当前时间的字符串
	 * 
	 * @param format
	 *            时间格式，同时间的format，如"yyyy-MM-dd HH:mm:ss"
	 * @return 时间字符串，若format为空或长度为空或只包含空格，则默认为"yyyy-MM-dd HH:mm:ss"
	 */
	public static String currentDate(String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(isBlank(format) ? "yyyy-MM-dd HH:mm:ss" : format);
		return dateFormat.format(new Date());
	}

	/**
	 * 以"yyyy-MM-dd HH:mm:ss"格式得到当前时间
	 * 
	 * @return "yyyy-MM-dd HH:mm:ss"
	 */
	public static String currentDate() {
		return currentDate("");
	}

	/**
	 * 以固定格式得到当前时间的字符串，包含毫秒
	 * 
	 * @param format
	 *            时间格式，同时间的format，如"yyyy-MM-dd HH:mm:ss SS"
	 * @return 时间字符串，若format为空或长度为空或只包含空格，则默认为"yyyy-MM-dd HH:mm:ss SS"
	 */
	public static String currentDateInMills(String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(isBlank(format) ? "yyyy-MM-dd HH-mm-ss SS" : format);
		return dateFormat.format(new Timestamp(System.currentTimeMillis()));
	}

	/**
	 * 以"yyyy-MM-dd HH:mm:ss SS"格式得到当前时间
	 * 
	 * @return "yyyy-MM-dd HH:mm:ss SS"
	 */
	public static String currentDateInMills() {
		return currentDateInMills("");
	}

	/**
	 * 处理时间，用来显示状态更新时间
	 * 
	 * @param time
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String processTime(Long time) {
		long oneDay = 24 * 60 * 60 * 1000;
		Date now = new Date();
		Date orginalTime = new Date(time);
		long nowDay = now.getTime() - (now.getHours() * 3600 + now.getMinutes() * 60 + now.getSeconds()) * 1000;
		long yesterday = nowDay - oneDay;
		String nowHourAndMinute = toDoubleDigit(orginalTime.getHours()) + ":" + toDoubleDigit(orginalTime.getMinutes());
		if (time >= now.getTime()) {
			return "刚刚";
		} else if ((now.getTime() - time) < (60 * 1000)) {
			return (now.getTime() - time) / 1000 + "秒前 " + nowHourAndMinute + " ";
		} else if ((now.getTime() - time) < (60 * 60 * 1000)) {
			return (now.getTime() - time) / 1000 / 60 + "分钟前 " + nowHourAndMinute + " ";
		} else if ((now.getTime() - time) < (24 * 60 * 60 * 1000)) {
			return (now.getTime() - time) / 1000 / 60 / 60 + "小时前 " + nowHourAndMinute + " ";
		} else if (time >= nowDay) {
			return "今天 " + nowHourAndMinute;
		} else if (time >= yesterday) {
			return "昨天 " + nowHourAndMinute;
		} else {
			return toDoubleDigit(orginalTime.getMonth()) + "-" + toDoubleDigit(orginalTime.getDate()) + " "
					+ nowHourAndMinute + ":" + toDoubleDigit(orginalTime.getSeconds());
		}
	}

	/**
	 * 将一位整数十位加0变成两位整数
	 * 
	 * @param number
	 * @return
	 */
	public static String toDoubleDigit(int number) {
		if (number >= 0 && number < 10) {
			return "0" + ((Integer) number).toString();
		}
		return ((Integer) number).toString();
	}

	/**
	 * 得到href链接的innerHtml
	 * 
	 * @param href
	 *            href内容
	 * @return href的innerHtml
	 *         <ul>
	 *         <li>空字符串返回""</li>
	 *         <li>若字符串不为空，且不符合链接正则的返回原内容</li>
	 *         <li>若字符串不为空，且符合链接正则的返回最后一个innerHtml</li>
	 *         </ul>
	 */
	public static String getHrefInnerHtml(String href) {
		if (isEmpty(href)) {
			return "";
		}
		// String hrefReg =
		// "[^(<a)]*<[\\s]*a[\\s]*[^(a>)]*>(.+?)<[\\s]*/a[\\s]*>.*";
		String hrefReg = ".*<[\\s]*a[\\s]*.*>(.+?)<[\\s]*/a[\\s]*>.*";
		Pattern hrefPattern = Pattern.compile(hrefReg, Pattern.CASE_INSENSITIVE);
		Matcher hrefMatcher = hrefPattern.matcher(href);
		if (hrefMatcher.matches()) {
			return hrefMatcher.group(1);
		}
		return href;
	}

	/**
	 * 得到固定长度的随机字符串，字符串由数字和字母混合组成
	 * 
	 * @param length
	 *            长度
	 * @return
	 * @see {@link com.eryansky.common.utils.StringUtils#getRandom(String source, int length)}
	 */
	public static String getRandomNumbersAndLetters(int length) {
		return getRandom(NUMBERS_AND_LETTERS, length);
	}

	/**
	 * 得到固定长度的随机字符串，字符串由数字混合组成
	 * 
	 * @param length
	 *            长度
	 * @return
	 * @see {@link com.eryansky.common.utils.StringUtils#getRandom(String source, int length)}
	 */
	public static String getRandomNumbers(int length) {
		return getRandom(NUMBERS, length);
	}

	/**
	 * 得到固定长度的随机字符串，字符串由字母混合组成
	 * 
	 * @param length
	 *            长度
	 * @return
	 * @see {@link com.eryansky.common.utils.StringUtils#getRandom(String source, int length)}
	 */
	public static String getRandomLetters(int length) {
		return getRandom(LETTERS, length);
	}

	/**
	 * 得到固定长度的随机字符串，字符串由大写字母混合组成
	 * 
	 * @param length
	 *            长度
	 * @return
	 * @see {@link com.eryansky.common.utils.StringUtils#getRandom(String source, int length)}
	 */
	public static String getRandomCapitalLetters(int length) {
		return getRandom(CAPITAL_LETTERS, length);
	}

	/**
	 * 得到固定长度的随机字符串，字符串由小写字母混合组成
	 * 
	 * @param length
	 *            长度
	 * @return
	 * @see {@link com.eryansky.common.utils.StringUtils#getRandom(String source, int length)}
	 */
	public static String getRandomLowerCaseLetters(int length) {
		return getRandom(LOWER_CASE_LETTERS, length);
	}

	/**
	 * 得到固定长度的随机字符串，字符串由source中字符混合组成
	 * 
	 * @param source
	 *            源字符串
	 * @param length
	 *            长度
	 * @return
	 *         <ul>
	 *         <li>若source为null或为空字符串，返回null</li>
	 *         <li>否则见</li>
	 *         </ul>
	 */
	public static String getRandom(String source, int length) {
		return StringUtils.isEmpty(source) ? null : getRandom(source.toCharArray(), length);
	}

	/**
	 * 得到固定长度的随机字符串，字符串由sourceChar中字符混合组成
	 * 
	 * @param sourceChar
	 *            源字符数组
	 * @param length
	 *            长度
	 * @return
	 *         <ul>
	 *         <li>若sourceChar为null或长度为0，返回null</li>
	 *         <li>若length小于0，返回null</li>
	 *         </ul>
	 */
	public static String getRandom(char[] sourceChar, int length) {
		if (sourceChar == null || sourceChar.length == 0 || length < 0) {
			return null;
		}
		StringBuilder str = new StringBuilder("");
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			str.append(sourceChar[random.nextInt(sourceChar.length)]);
		}
		return str.toString();
	}

	/**
	 * html的转移字符转换成正常的字符串
	 * 
	 * @param source
	 * @return
	 */
	public static String htmlEscapeCharsToString(String source) {
		if (StringUtils.isEmpty(source)) {
			return "";
		} else {
			return source.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replaceAll("&quot;",
					"\"");
		}
	}

	/**
	 * 去掉字符串两边的符号，返回去掉后的结果
	 * 
	 * @param source
	 *            原字符串
	 * @param symbol
	 *            符号
	 * @return
	 */
	public static String RemoveBothSideSymbol(String source, String symbol) {
		if (isEmpty(source) || isEmpty(symbol)) {
			return source;
		}

		int firstIndex = source.indexOf(symbol);
		int lastIndex = source.lastIndexOf(symbol);
		try {
			return source.substring(((firstIndex == 0) ? symbol.length() : 0),
					((lastIndex == source.length() - 1) ? (source.length() - symbol.length()) : source.length()));
		} catch (IndexOutOfBoundsException e) {
			return "";
		}
	}

	/**
	 * 字符串匹配(仅支持"*"匹配).
	 * 
	 * @param pattern
	 *            模板
	 * @param str
	 *            要验证的字符串
	 * @return
	 */
	public static boolean simpleWildcardMatch(String pattern, String str) {
		return wildcardMatch(pattern, str, "*");
	}

	/**
	 * 字符串匹配.
	 * 
	 * @param pattern
	 *            模板
	 * @param str
	 *            要验证的字符串
	 * @param wildcard
	 *            通配符
	 * @return
	 */
	public static boolean wildcardMatch(String pattern, String str, String wildcard) {
		if (StringUtils.isEmpty(pattern) || StringUtils.isEmpty(str)) {
			return false;
		}
		final boolean startWith = pattern.startsWith(wildcard);
		final boolean endWith = pattern.endsWith(wildcard);
		String[] array = org.apache.commons.lang3.StringUtils.split(pattern, wildcard);
		int currentIndex = -1;
		int lastIndex = -1;
		switch (array.length) {
		case 0:
			return true;
		case 1:
			currentIndex = str.indexOf(array[0]);
			if (startWith && endWith) {
				return currentIndex >= 0;
			}
			if (startWith) {
				return currentIndex + array[0].length() == str.length();
			}
			if (endWith) {
				return currentIndex == 0;
			}
			return str.equals(pattern);
		default:
			for (String part : array) {
				currentIndex = str.indexOf(part);
				if (currentIndex > lastIndex) {
					lastIndex = currentIndex;
					continue;
				}
				return false;
			}
			return true;
		}
	}

	/**
	 * 替换掉HTML标签方法
	 * 
	 * @param html
	 * @return
	 */
	public static String replaceHtml(String html) {
		if (isBlank(html)) {
			return "";
		}
		String regEx = "<.+?>";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(html);
		String s = m.replaceAll("");
		return s;
	}

	/**
	 * 缩略字符串（不区分中英文字符）
	 * 
	 * @param str
	 *            目标字符串
	 * @param length
	 *            截取长度
	 * @return
	 */
	public static String abbr(String str, int length) {
		if (str == null) {
			return "";
		}
		try {
			StringBuilder sb = new StringBuilder();
			int currentLength = 0;
			for (char c : replaceHtml(StringEscapeUtils.unescapeHtml4(str)).toCharArray()) {
				currentLength += String.valueOf(c).getBytes("GBK").length;
				if (currentLength <= length - 3) {
					sb.append(c);
				} else {
					sb.append("...");
					break;
				}
			}
			return sb.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 缩略字符串（替换html）
	 * 
	 * @param str
	 *            目标字符串
	 * @param length
	 *            截取长度
	 * @return
	 */
	public static String rabbr(String str, int length) {
		return abbr(replaceHtml(str), length);
	}

	/**
	 * 转换为Double类型
	 */
	public static Double toDouble(Object val) {
		if (val == null) {
			return 0D;
		}
		try {
			return Double.valueOf(trim(val.toString()));
		} catch (Exception e) {
			return 0D;
		}
	}

	/**
	 * 转换为Float类型
	 */
	public static Float toFloat(Object val) {
		return toDouble(val).floatValue();
	}

	/**
	 * 转换为Long类型
	 */
	public static Long toLong(Object val) {
		return toDouble(val).longValue();
	}

	/**
	 * 转换为Integer类型
	 */
	public static Integer toInteger(Object val) {
		return toLong(val).intValue();
	}

	/**
	 * 将字符串数组转成字符串用“,”隔开
	 * 
	 * @param array
	 *            数组
	 * @return
	 */
	public static String array2string(String array[]) {
		if (array == null) {
			return "";
		}
		String str = "";
		for (int i = 0; i < array.length; i++) {
			str += array[i] + ",";
		}
		return str.substring(0, str.length() - 1);
	}

	public static String encode(String obj) throws UnsupportedEncodingException {
		if (StringUtils.isEmpty(obj)) {
			return null;
		}
		return URLEncoder.encode(obj, "UTF-8");
	}

	public static String decode(String obj) throws UnsupportedEncodingException {
		if (StringUtils.isEmpty(obj)) {
			return null;
		}
		return URLDecoder.decode(obj, "UTF-8");
	}

	public static int getWordsCount(String words) {
		if (isEmpty(words)) {
			return 0;
		}
		char[] wordsArr = null;
		wordsArr = words.toCharArray();
		int count = 0;
		for (char ch : wordsArr) {
			if (Character.toString(ch).matches("[\\u4E00-\\u9FA5]+")) {
				count++;

			}
		}
		return count;

	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		StringUtils.encode(null);
		logger.debug("汉字数:"+StringUtils.getWordsCount("你好我们"));;
	}
}