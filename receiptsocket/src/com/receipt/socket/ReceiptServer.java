package com.receipt.socket;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * A Socket based server implementation supporting multiple clients. Each new
 * client is served by a new thread
 **/
public class ReceiptServer {

	private static int portNumber = 4444;

	public static void main(String[] args) {

		try {
			ServerSocket serverSocket = new ServerSocket(portNumber);
			while (true) {//daemon - listen until the process is stopped by user
				new ReceiptServerThread(serverSocket.accept()).start();
			}
		} catch (IOException e) {
			System.err.println("Could not listen on port " + portNumber);
			System.exit(-1);
		}
	}
}
