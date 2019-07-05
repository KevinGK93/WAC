package practicum6;

import java.io.*;
import java.net.Socket;

public class MyServlet extends Thread{
    private Socket socket;
    public MyServlet(Socket sock){
        socket = sock;
    }
    public void run(){
        try{

            InputStream is = socket.getInputStream();
            InputStreamReader inputReader = new InputStreamReader(is);
            BufferedReader bufferedReader = new BufferedReader(inputReader);
            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out,true);
            String line = bufferedReader.readLine();
            writer.println("HTTP/1.1 200 OK\n\n<h1>It works!</h1>");
            writer.println("");
            Thread.sleep(10000);
            socket.close();

        }catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
