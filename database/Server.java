package database;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
public class Server implements Runnable{
    static final int port = 1095;
    public ArrayList<ArrayList<String>> comptes;
    public DataCon datacon;
    ServerSocket s;// = new ServerSocket(port);
    Socket socket;// = s.accept();
    Request requete;
    ObjectInputStream in;
    /*public static void main (String[] args) throws IOException,
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
    }*/

    public static void connection_db(){
    }

    @Override
    public void run(){
        this.datacon = new DataCon();
        try{//connection 
            datacon.connect();
        }catch(Exception e){
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();//close if unable to connect
        }

        //socket creation
        try{
            this.s = new ServerSocket(port);
            socket = s.accept();
            in = new ObjectInputStream(socket.getInputStream());
        }catch(Exception e){
            System.out.println(e.getMessage());
        Thread.currentThread().interrupt();//close if unable to connect
        }
        
        while(true){//listen to socket
            try{//connection 
                requete = (Request) in.readObject();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            if(requete.type == 0){
                ArrayList<ArrayList<String>> rep =  datacon.query(requete.args);
                System.out.println(rep.toString());
            }    
        }
        /*
        socket.close();
        datacon.disconnect();*/

    }



}