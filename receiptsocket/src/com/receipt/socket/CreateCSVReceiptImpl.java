package com.receipt.socket;

import com.receipt.CreateReceipt;
import com.receipt.Receipt;
import com.receipt.ReceiptLine;

/**
 * @author liviu.cretu
 * @version 1.0
 * @created 26-Sep-2014 11:27:31 AM
 */
public class CreateCSVReceiptImpl implements CreateCSVReceipt {

	private CreateReceipt createReceiptDelegate;

	public CreateCSVReceiptImpl(CreateReceipt delegate) {
		createReceiptDelegate = delegate;

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * 
	 * @param p
	 *            - expecting CSV String implementing the CreateReceipt from CSV
	 *            protocol
	 */
	public String createCSVReceipt(String p) {
		Receipt receipt = new Receipt();
		try {
			String[] lines = p.split("\n");
			// first line should contain customer's name
			receipt.setCustomerName(lines[0]);
			// second line should contain the email address
			receipt.setCustomerEmail(lines[1]);
			// third line should contain the delivery address
			receipt.setDeliveryAddress(lines[2]);
			// next lines should contain the items
			ReceiptLine l = null;
			String[] line = null;
			for (int i = 3; i < lines.length; i++) {
				line = lines[i].split(", ");
				l = new ReceiptLine();
				l.setItem(line[0]);
				l.setQuantity(Double.valueOf(line[1]));
				l.setPrice(Double.valueOf(line[2]));
				receipt.addReceiptLine(l);
			}
		} catch (Throwable t) {
			t.printStackTrace();
			throw new RuntimeException(
					"Error! Code 400 - Bad Request:Invalid format! "
							+ t.getMessage());

		}

		try {
			Receipt nReceipt = this.getCreateReceiptDelegate().createReceipt(receipt);
			// If everything ok return some unique reference for future
			// identification of the new receipt.
			// Just for this simple test, we return the id, though not really
			// recommended in real life situations.
			return nReceipt.getId().toString();
		} catch (Throwable t) {
			t.printStackTrace();
			throw new RuntimeException("Error! Code 500: Internal Server Error! ");
		}

	}

	public CreateReceipt getCreateReceiptDelegate() {
		return createReceiptDelegate;
	}

	public void setCreateReceiptDelegate(CreateReceipt createReceiptDelegate) {
		this.createReceiptDelegate = createReceiptDelegate;
	}

}// end CreateCSVReceiptImpl