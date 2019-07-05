package practicum2;

import java.net.Socket;
import java.io.PrintWriter;

class Client {
  public static void main(String[] arg) throws Exception {
    Socket s = new Socket("localhost", 4711);
    PrintWriter out = null;
    
    out = new PrintWriter( s.getOutputStream() );
    out.write("Dit is regel 1 ");
    out.write("Dit is regel 2 ");
    out.flush();
    s.close();
  }
}