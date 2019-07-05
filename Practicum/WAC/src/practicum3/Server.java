package practicum3;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class Server {
 public static void main(String[] arg) throws Exception {
   String message = "";
   ServerSocket ss = new ServerSocket(4711);
   Socket s = ss.accept();
   Scanner is = new Scanner(s.getInputStream());


   while (is.hasNextLine()) {
    message = is.next();
    System.out.println(message + "\n");
    
    if (message.equals("stop")) {
      break;
    }
  }
  is.close();
  s.close();
  ss.close();
}
}