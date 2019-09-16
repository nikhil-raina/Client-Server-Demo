import java.net.*;
import java.io.*;
import java.nio.Buffer;

public class TCPServer {
    public static void main(String[] args) {
        // args supply message and hostname of destination
        try {
            int serverPort = 7896;
            ServerSocket listenSocket = new ServerSocket(serverPort);
            Socket clientSocket = listenSocket.accept();
            int i = 0;
            while(i < 100){
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                System.out.println(in.readLine());
                out.println(i);
                i++;
//                Connection c = new Connection(clientSocket);
            }
        } catch (IOException e) {
            System.out.println("Listen: " + e.getMessage());
        } 
    }
}