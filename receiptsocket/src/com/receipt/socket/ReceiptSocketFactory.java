package com.receipt.socket;

import javax.persistence.Persistence;

import com.receipt.CreateReceiptLocalJPA;

public class ReceiptSocketFactory {

	public static CreateCSVReceipt createCSVReceiptFactory() {
		CreateReceiptLocalJPA x = new CreateReceiptLocalJPA();
		x.setEm(Persistence.createEntityManagerFactory("BabelConnReceiptSocket")
				.createEntityManager());
		
		
		return new CreateCSVReceiptImpl(x);
	}
}
