package database;

import database.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server {
    static final int port = 1095;
    public DataCon datacon;
    ServerSocket s;// = new ServerSocket(port);
    Socket socket;// = s.accept();
    Request requete;
    ObjectInputStream in;
    /*
     * public static void main (String[] args) throws IOException,
     * ClassNotFoundException { ServerSocket s = new ServerSocket(port); Socket
     * socket = s.accept(); ObjectInputStream in = new
     * ObjectInputStream(socket.getInputStream()); String oserver = (String)
     * in.readObject(); System.out.println("recu = " + oserver); oserver = (String)
     * in.readObject(); System.out.println("recu = " + oserver); oserver = (String)
     * in.readObject(); System.out.println("recu = " + oserver); socket.close(); }
     */

    public Server() {
        init();
    }

    public void connection_db() {
        this.datacon = new DataCon();
        try {// connection
            datacon.connect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();// close if unable to connect
        }
    }

    public void init() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New Client");
                ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream is = new ObjectInputStream(socket.getInputStream());

                System.out.println("Run Server");
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            runS(is, os);
                        } catch (ClassNotFoundException | IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }).start();
                
            }
            //serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void runS(ObjectInputStream is, ObjectOutputStream os) throws IOException, ClassNotFoundException {
        ArrayList<ArrayList<String>> resArray;
        Response rep;
        Request req = (Request) is.readObject();
        connection_db();
        System.out.println(req.request);
        resArray = datacon.query(req.request);
        rep = new Response(resArray, "");
        os.writeObject(rep);
    }

    public static void main(String[] args) {
        new Thread(new Runnable(){
        
            @Override
            public void run() {
                new Server();
            }
        }).start();
    }

   /* @Override
    public void run(){
        

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

                String host = "127.0.0.1"; // localhost
                try{//connection 
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    out.writeObject(rep);
                    socket.close();
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
                
            }   
        }
        /*
        socket.close();
        datacon.disconnect();

    }*/

    /*public static ArrayList<ArrayList<String>> handle_request() throws Exception{
        ArrayList<ArrayList<String>>  res;
        return res;
    }*/



}