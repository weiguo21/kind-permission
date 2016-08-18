package com.kind.common.datasource;

public class KindDataSourceHolder {

	private static final ThreadLocal<String> dataSourceHolder = new ThreadLocal<String>();
	
	public static void setDataSourceKey(String data_source_key) {
		dataSourceHolder.set(data_source_key);
	}

	public static String getDataSourceKey() {
		String key = dataSourceHolder.get();
		clearCustomerKey();
		return key;
	}

	public static void clearCustomerKey() {
		dataSourceHolder.remove();
	}

}