package com.sangbill.concurrent.executor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {

	class NetworkService implements Runnable{
		private final ServerSocket serverSocket;
		private final ExecutorService pool;

		
		public NetworkService(int port, int poolSize) throws IOException {
			serverSocket = new ServerSocket(port);
			pool = Executors.newFixedThreadPool(poolSize);
		}


		@Override
		public void run() {
			try {
				for (;;) {
					pool.execute(new Handler(serverSocket.accept()));
				}
			} catch (Exception e) {
				pool.shutdown();
			}
		}
	}
	
	public class Handler implements Runnable {
		private final Socket socket;
		public Handler(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			//reed and service request on socket
		}
	}
}
