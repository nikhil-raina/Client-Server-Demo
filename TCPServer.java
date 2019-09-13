import java.net.*;
import java.io.*;

public class TCPServer {
    public static void main(String[] args) {
        // args supply message and hostname of destination
        try {
            int serverPort = 7896;
            ServerSocket listneSocket = new ServerSocket(serverPort);
            while(true){
                Socket clientSocket = listneSocket.accept();
                Connection c = new Connection(clientSocket);
            }
        } catch (IOException e) {
            System.out.println("Listen: " + e.getMessage());
        } 
    }
}