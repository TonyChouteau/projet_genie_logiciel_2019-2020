package database;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
public class Server {
    static final int port = 1095;
    public ArrayList<ArrayList<String>> comptes;
    public DataCon datacon;
    
    public static void main (String[] args) throws IOException,
        ClassNotFoundException {
        ServerSocket s = new ServerSocket(port);
        Socket socket = s.accept();
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        String oserver = (String) in.readObject();
        System.out.println("recu = " + oserver);
        oserver = (String) in.readObject();
        System.out.println("recu = " + oserver);
        oserver = (String) in.readObject();
        System.out.println("recu = " + oserver);
        socket.close();
    }

    public static void connection_db(){
        this.datacon = new DataCon();
        datacon.connect();
    }

}