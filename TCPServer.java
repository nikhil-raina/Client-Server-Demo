import java.net.*;
import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;

public class TCPServer {
    public static void main(String[] args) {
        // args supply message and hostname of destination
        try {
            int serverPort = 7896;
            ServerSocket listenSocket = new ServerSocket(serverPort);
            Socket clientSocket = listenSocket.accept();
            int i = 0;
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            ArrayList result = (ArrayList) ois.readObject();
            System.out.println(result);
//             while(i < 100){
//                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

//                 System.out.println(in.readLine());
//                 out.println(i);
//                 i++;
// //                Connection c = new Connection(clientSocket);
//             }
        } catch (Exception e) {
            System.out.println("Listen: " + e.getMessage());
        } 
    }
}