package com.receipt;

import com.babel.core.function.crud.Update;

public interface SaveReceipt extends Update{

	public Receipt saveReceipt(Receipt p);
}
