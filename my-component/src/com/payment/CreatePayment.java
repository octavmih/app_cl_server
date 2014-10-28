package com.payment;

import com.babel.core.function.crud.Create;

public interface CreatePayment extends Create{
	public Payment createPayment(Payment p);

}
