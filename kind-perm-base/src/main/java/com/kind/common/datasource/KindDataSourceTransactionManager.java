package com.kind.common.datasource;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;

public class KindDataSourceTransactionManager extends DataSourceTransactionManager {

	private static final long serialVersionUID = -7775738079919982096L;

	@Override
	protected void doCleanupAfterCompletion(Object transaction) {
		super.doCleanupAfterCompletion(transaction);
		KindDataSourceHolder.clearCustomerKey();
	}

}
