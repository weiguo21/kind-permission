package com.kind.common.uitls;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BytesUtils {
    
    
    /**
     * 功能：获取字符串字节的长度
     * 
     * @param str
     * @return
     */
    public static int getWordCount(String s) {
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            int ascii = Character.codePointAt(s, i);
            if (ascii >= 0 && ascii <= 255)
                length++;
            else
                length += 2;

        }
        return length;

    }
    
    /**
     * 页面传值URLDecoder的解码
     * 
     * @param str
     * @return
     */
    public static String setURLDecoderToString(String s) {
        String name = "";
        try {
            name = java.net.URLDecoder.decode(s, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return name;

    }

    /**
     * 取字符串的前M个字符和取字符串的后M个字符
     * 
     * @param str
     *            被处理字符串
     * @param m
     *            截取长度
     * @return Map<String, String>
     */
    public static Map<String, String> substring(String str, int m) {
        try {
            Map<String, String> stringMap = new HashMap<String, String>();
            int rem = 0;
            String beforeStr = "";
            String afterStr = "";
            if (str == null)
                return null;
            char[] tempChar = str.toCharArray();
            String temStr = "";
            if (tempChar.length > m) {
                while (m != 0) {
                    temStr = String.valueOf(tempChar[m]);
                    if (!temStr.equals("/"))
                        m--;
                    else
                        break;
                }
            }
            for (int i = 0; (i < tempChar.length && m > rem); i++) {
                String s1 = String.valueOf(tempChar[i]);
                byte[] b = s1.getBytes();
                rem += b.length;
                beforeStr += tempChar[i];
            }
            for (int i = m; i < tempChar.length; i++) {
                afterStr += tempChar[i];
            }
            stringMap.put("before", beforeStr);
            stringMap.put("after", afterStr);

            return stringMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String str = "9461/9462/5691/5692/9203/9206/9461/9462/5691/5692/9203/9206/2700/2701/2702/2703/2704/2705/2706/2707";
//		System.out.println(substring(str, 50).get("before"));
//		System.out.println(substring(str, 50).get("after"));
		List<String> aaa = new ArrayList<String>();
		aaa.add("aa1");
		aaa.add("aa2");
		aaa.add("aa3");
		aaa.add("aa4");
		aaa.add("aa5");
		aaa.add("aa6");
		aaa.add("aa7");
		aaa.add("aa8");
		aaa.add("aa9");
		aaa.add("aa10");
		aaa.add("aa11");
		aaa.add("aa12");
		System.out.println(aaa.size());
		int aa = 1;
		int bb = 5;
		int rem = 0;
		for (int i = (aa-1); (i < aaa.size() && bb > rem); i++){
		    rem += 1;
		    System.out.println(aaa.get(i));
		}
	}

}
