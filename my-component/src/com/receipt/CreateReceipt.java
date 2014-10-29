package com.receipt;

import com.babel.core.function.crud.Create;

public interface CreateReceipt extends Create{
	
	public Receipt createReceipt(Receipt p);

}
