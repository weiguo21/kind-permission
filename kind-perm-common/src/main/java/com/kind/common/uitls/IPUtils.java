package com.kind.common.uitls;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Function:获取客户端IP. <br/>
 * Date: 2016年4月24日 上午11:20:14 <br/>
 * 
 * @author weiguo21
 * @version
 * @since JDK 1.7
 * @see
 */
public class IPUtils {
	private static final Logger logger = LoggerFactory.getLogger(IPUtils.class);

	/**
	 * 获取IP
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("http_client_ip");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip != null && ip.indexOf(",") != -1) {
			ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();
		}
		if ("0:0:0:0:0:0:0:1".equals(ip)) {
			ip = "127.0.0.1";
		}
		return ip;
	}

	/**
	 * 获取本地MAC地址.
	 * 
	 * @param ia
	 * @return
	 * @throws Exception
	 */
	public static String getLocalMAC() throws Exception {
		InetAddress ia = InetAddress.getLocalHost();
		/**
		 * 获得网络接口对象（即网卡），并得到MAC地址.
		 */
		byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
		/**
		 * 下面代码是把MAC地址拼装成String
		 */
		StringBuffer macBuilder = new StringBuffer();
		for (int i = 0; i < mac.length; i++) {
			if (i != 0) {
				macBuilder.append("-");
			}
			/**
			 * MAC[i] & 0xFF 是为了把byte转化为正整数
			 */
			String s = Integer.toHexString(mac[i] & 0xFF);
			macBuilder.append(s.length() == 1 ? 0 + s : s);
		}
		/**
		 * 把字符串所有小写字母改为大写成为正规的MAC地址并返回
		 */
		return macBuilder.toString().toUpperCase();
	}

	/**
	 * 通过IP地址获取MAC地址.
	 * 
	 * @param ip(String,127.0.0.1格式)
	 * 
	 * 
	 * @return MAC String
	 * @throws Exception
	 */
	public static String getMAC(String ip) {
		String line = "";
		String macAddress = "";
		final String MAC_ADDRESS_PREFIX = "MAC Address = ";
		final String LOOPBACK_ADDRESS = "127.0.0.1";
		/**
		 * 如果为127.0.0.1,则获取本地MAC地址。
		 */
		if (LOOPBACK_ADDRESS.equals(ip)) {
			InetAddress inetAddress;
			byte[] mac;
			try {
				inetAddress = InetAddress.getLocalHost();
				mac = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
			} catch (Exception e) {
				e.printStackTrace();
				return "";
			}
			/**
			 * 此方法需要jdk1.6+
			 */
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mac.length; i++) {
				if (i != 0) {
					sb.append("-");
				}
				/**
				 * MAC[i] & 0xFF 是为了把byte转化为正整数
				 */
				String s = Integer.toHexString(mac[i] & 0xFF);
				sb.append(s.length() == 1 ? 0 + s : s);
			}
			macAddress = sb.toString().trim().toUpperCase();
			return macAddress;
		}
		/**
		 * 获取非本地IP的MAC地址
		 */
		try {
			Process p = Runtime.getRuntime().exec("nbtstat -A " + ip);
			InputStreamReader isr = new InputStreamReader(p.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			while ((line = br.readLine()) != null) {
				if (line != null) {
					int index = line.indexOf(MAC_ADDRESS_PREFIX);
					if (index != -1) {
						macAddress = line.substring(index + MAC_ADDRESS_PREFIX.length()).trim().toUpperCase();
					}
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}
		return macAddress;
	}

	public static void main(String[] args) throws Exception {
		logger.debug("Local MAC:" + IPUtils.getLocalMAC());
	}
}
