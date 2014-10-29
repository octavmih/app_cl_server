package com.receipt.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * A Thread that delegates to a CreateCSVReceipt concrete implementation the
 * business logic for creating a new Receipt from the CSV string received.
 * 
 * @see CreateCSVReceiptImpl#createCSVReceipt(String) for the application-specific
 *      protocol.
 * @author liviu.cretu
 * 
 */
public class ReceiptServerThread extends Thread {

	private Socket socket = null;
	private CreateCSVReceipt worker = null;

	public ReceiptServerThread(Socket socket) {
		super("ReceiptServerThread");
		//keep the socket initiated by the client call
		this.socket = socket;
		//inject the worker that will actually execute the business logic
		this.worker = ReceiptSocketFactory.createCSVReceiptFactory();
	}

	public void run() {
		PrintWriter out=null;
		BufferedReader in =null;
		try {

			 out = new PrintWriter(socket.getOutputStream(), true);
			//socket.getInputStream().
			 in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			String inputLine, outputLine;
			//expecting a multi-line text according to CreateCSVReceipt protocol
			//read the string message line by line and reconstruct the client's message
			StringBuffer buf=new StringBuffer();
			
			while ((inputLine = in.readLine()) != null && inputLine.length()>0) {

				buf.append(inputLine).append("\n");			
					
			}
			System.out.println("client message"+ buf.toString());
			//delegate the business logic to the associated worker
			String receiptExternalId=this.worker.createCSVReceipt(buf.toString());
			System.out.println("new receipt created:"+receiptExternalId);
			//respond with the new receipt id
			out.println(receiptExternalId);

		} catch (Throwable e) {
			e.printStackTrace();
			out.print(e.getMessage());
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
