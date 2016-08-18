package com.kind.perm.core.shrio;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import com.kind.common.uitls.codec.MD5Utils;

/**
 * Function:shrio密码校验扩展类. <br/>
 * Date: 2016年5月26日 下午5:59:08 <br/>
 * 
 * @author weiguo.liu
 * @version
 * @since JDK 1.7
 * @see
 */
public class CustomizedCredentialsMatcher extends SimpleCredentialsMatcher {
	@Override
	public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		Object tokenCredentials = encrypt(String.valueOf(token.getPassword()));
		Object accountCredentials = getCredentials(info);
		//将密码加密与系统加密后的密码校验，内容一致就返回true,不一致就返回false
		return equals(tokenCredentials, accountCredentials);
	}

	/**
	 * 将传进来密码加密方法
	 * @param data
	 * @return
	 */
	private String encrypt(String data) {
		String encryData = MD5Utils.getStringMD5(data);
		return encryData;
	}
}
