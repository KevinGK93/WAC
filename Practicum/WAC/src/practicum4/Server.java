package practicum4;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class Server {
	public static void main(String[] arg) throws Exception {
		ServerSocket ss = new ServerSocket(4711);
		Socket s = ss.accept();
		InputStream is = s.getInputStream();
		OutputStream out = s.getOutputStream();
		String line = null;

		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		while ((line = br.readLine()) != null) {
			if (!line.equals("")) {
				System.out.println(line);
			} else {
				break;
			}
		}
		String response = "HTTP/1.1 200 OK\r\n";


		response = "\r\n<html><h1>It works!</h1></html>";
		out.flush();

		is.close();
		s.close();
		ss.close();
	}
}