package practicum5;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception {
		while (true) {
			ServerSocket ss = new ServerSocket(4711);
			Socket s = ss.accept();
			MyServlet MyServlet = new MyServlet(s);
			MyServlet.start();

			ss.close();
		}
	}
}
