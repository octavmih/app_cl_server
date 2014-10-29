package com.receipt;

import com.babel.core.function.crud.UpdateImpl;


public class SaveReceiptImpl extends UpdateImpl implements SaveReceipt {

	public SaveReceiptImpl() {

	}
	public void finalize() throws Throwable {
		super.finalize();
	}
	public Receipt saveReceipt(Receipt p) {
		return super.update(p);
	}
}
