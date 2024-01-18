import java.net.*;
import java.io.*;

public class httpserver {

    public static void main(String[] args) throws IOException{
        int port = 8081;
        ServerSocket serverSocket = new ServerSocket(port);
        System.err.println("server is running on port : "+port);
        
        while (true) {
             Socket clientSocket = serverSocket.accept();
             System.err.println("client is connected");
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             String s;
             while ((s = in.readLine()) != null) {
                System.out.println(s);
                if (s.isEmpty()) {
                    break;
                }
             }

             OutputStream clientOutput = clientSocket.getOutputStream();
             clientOutput.write("HTTP/1.1 200 OK\r\n".getBytes());
             clientOutput.write("\r\n".getBytes());
             clientOutput.write("<b>hello my name is mangesh</b>".getBytes());
             clientOutput.write("\r\n\r\n".getBytes());
             clientOutput.flush();
             System.err.println("client connection is closed");
             in.close();
             clientOutput.close();
        }
    }
}