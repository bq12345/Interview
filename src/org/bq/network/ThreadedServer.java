/*
 * Copyright (c) 2013. Designed By BaiQiang.
 */

package org.bq.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadedServer {
	public ThreadedServer() throws Exception {
		ServerSocket server = new ServerSocket(8000);
		int socketNo = 1;
		while (true) {
			Socket socket = server.accept();
			System.out.println("----Start a thread for socket No" + socketNo + "------");
			System.out.println("The socket name ======="
					+ socket.getInetAddress().getHostName());
			HandleASocket task = new HandleASocket(socket);
			new Thread(task).start();
			socketNo++;
		}
	}
	public static void main(String[] args) throws Exception {
		new ThreadedServer();
	}
}

class HandleASocket implements Runnable {
	private Socket socket;

	public HandleASocket(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			while (true) {
				String str = in.readLine();
				System.out.println(str);
				out.println("Receive from socket...." + str.toUpperCase());
				out.flush();
				if (str.equals("quit"))
					break;
			}
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
