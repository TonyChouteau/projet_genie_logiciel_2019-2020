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
        Response rep;
        Request req = (Request) is.readObject();
        connection_db();
        System.out.println(req.request);
        rep = handle_request(req);
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

    public Response handle_request(Request req){
        System.out.println(req.type);
        Response  res;
        if(req.type == 0){
            res = datacon.query(req.request);
        }else{
            res = datacon.update(req.request);
        }
        return res;
    }



}