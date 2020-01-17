/**
 * Client to test Server class
 */
package database;
import java.io.*;
import java.net.*;
public class Client {
 static final int port = 1095;
 static final String host = "127.0.0.1"; // localhost

 public static void main (String[] args) throws UnknownHostException,
    IOException {
    Socket socket = new Socket(host, port);
    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
    String o = "1";
    out.writeObject(o);
    o = "2";
    out.writeObject(o);
    o = "3";
    out.writeObject(o);
    socket.close();
 }
}