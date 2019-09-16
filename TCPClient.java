import java.net.*;
import java.io.*;

public class TCPClient {
    public static void main(String[] args) {
        // args supply message and hostname of destination
        Socket socket = null;
        try {
            int serverPort = 7896;
            socket = new Socket(args[0], serverPort);
//            DataInputStream in = new DataInputStream(socket.getInputStream());
//            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            int i = 0;
            while (i < 100) {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out.println(i);
//            String data = in.readUTF();
                System.out.println("Received: " + in.readLine());
                i++;
            }
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