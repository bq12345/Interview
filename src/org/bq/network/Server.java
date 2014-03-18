
/*
 * Copyright (c) 2013. Designed By BaiQiang.
 */

package org.bq.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public Server() throws IOException {
		ServerSocket server = new ServerSocket(8000);
		Socket client = server.accept();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				client.getInputStream()));
		PrintWriter out = new PrintWriter(client.getOutputStream());
		while (true) {
			String str = in.readLine();
			System.out.println(str);
			out.println("Receive from Client...." + str.toUpperCase());
			out.flush();
			if (str.equals("quit"))
				break;
		}
		client.close();
		server.close();
	}

	public static void main(String[] args) throws IOException {
		new Server();
	}
}