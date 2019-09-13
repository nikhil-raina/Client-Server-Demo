import java.io.*;
import java.net.Socket;

public class Connection extends Thread {
    DataInputStream in;
    DataOutputStream out;
    Socket clientSocekt;

    public Connection(Socket aClientSocket) {
        try {
            clientSocekt = aClientSocket;
            in = new DataInputStream(clientSocekt.getInputStream());
            out = new DataOutputStream(clientSocekt.getOutputStream());
            this.start();
        } catch (Exception e) {
            System.out.println("Connection: " + e.getMessage());
        }
    }

    public void main(String[] args) {
        try {       // an echo server
            String data = in.readUTF();
            out.writeUTF(data);
        } catch (EOFException e) {
            System.out.printnl("EOF: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            try {
                clientSocekt.close();
            } catch (IOException e) {
                System.out.println("Close Failed");
            }
        }
    }
}