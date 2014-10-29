package com.receipt;

import com.babel.core.function.crud.ReadByIdImpl;

public class ReadReceiptImpl extends ReadByIdImpl implements ReadReceipt {

	public ReadReceiptImpl() {

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public Receipt readReceipt(Long p) {
		return super.readById(Receipt.class, p);
	}
}