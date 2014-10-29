package com.receipt;

import com.babel.core.function.crud.CreateImpl;


public class CreateReceiptImpl extends CreateImpl implements CreateReceipt{

	public CreateReceiptImpl() {

	}

	public void finalize() throws Throwable {
		super.finalize();
	}


	public Receipt createReceipt(Receipt p) {
		return super.create(p);
	}
}