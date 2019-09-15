import java.net.*;
import java.io.*;

public class TCPClient {
    public static void main(String[] args) {
        // args supply message and hostname of destination
        Socket socket = null;
        try {
            int serverPort = 7896;
            socket = new Socket(args[1], serverPort);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(args[0]);
            String data = in.readUTF();
            System.out.println("Received: " + data);
        } catch (UnknownHostException e) {
            System.out.println("Sock: " + e.getMessage());
        } catch (EOFException e) {
            System.out.println("EOF: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {
                    System.out.println("close" + e.getMessage());
                }
            }
        }
    }
}