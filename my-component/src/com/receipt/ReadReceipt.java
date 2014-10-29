package com.receipt;

import com.babel.core.function.crud.ReadById;

public interface ReadReceipt extends ReadById{
	
	public Receipt readReceipt(Long p);
}
