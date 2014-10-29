package com.receipt;

/**
 * @author liviu.cretu
 * @version 1.0
 * @created 26-Sep-2014 10:55:53 AM
 */

public class CreateReceiptLocalJPA extends CreateReceiptImpl {

	
	

	public CreateReceiptLocalJPA() {

	}

	
	/**
	 * 
	 * @param p
	 */
	public Receipt createReceipt(Receipt p) {
		this.getEm().getTransaction().begin();
		Receipt r=super.createReceipt(p);
		this.getEm().getTransaction().commit();
		return r;
	}

	
}// end CreateReceiptEJB