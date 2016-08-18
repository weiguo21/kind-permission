package com.kind.common.dto;

/**
 * Function:http返回状态码. <br/>
 * Date: 2016年6月3日 下午1:57:33 <br/>
 * 
 * @author weiguo21
 * @version
 * @since JDK 1.7
 * @see
 */
public class ResultT<T> {
	public static final ResultT<String> SUCCESS = new ResultT<String>(null);
	public static final ResultT<String> FAIL = new ResultT<String>(500, null);

	private int code;
	private String msg;
	private T content;

	public ResultT(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public ResultT(T content) {
		this.code = 200;
		this.content = content;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ReturnT [code=" + code + ", msg=" + msg + ", content=" + content + "]";
	}

}
