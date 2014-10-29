package com.receipt.socket.test;

import org.junit.Before;
import org.junit.Test;

import com.receipt.socket.CreateCSVReceipt;
import com.receipt.socket.ReceiptSocketFactory;

/**
 * Test for the business logic only: create a new receipt from text implementing
 * the CreateCSVReceipt protocol. No client-server Socket yet.
 * 
 * @author liviu.cretu
 * 
 */
public class CreateCSVReceiptTest {

	CreateCSVReceipt createCSVReceiptWorker;

	@Before
	public void init() {
		createCSVReceiptWorker = ReceiptSocketFactory.createCSVReceiptFactory();

	}

	@Test
	public void test1() {
		String msg = buildNewReceiptCSVText();
		createCSVReceiptWorker.createCSVReceipt(msg);
		//Expecting just to execute successfully
		

	}

	public static String buildNewReceiptCSVText() {
		StringBuilder msgBuilder = new StringBuilder().append("Customer 1")
				.append("\n").append("customer1@gmail.com").append("\n")
				.append("customer1 address").append("\n")
				.append("item1, 2, 100").append("\n").append("item2, 10, 25").append("\n");
		return msgBuilder.toString();
	}

}
