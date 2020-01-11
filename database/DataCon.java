package database;

import java.sql.*;
import database.DataId;
import database.DataServ;

public class DataCon {
    public DataId did;
    public DataServ dserv;
    public Connection con;

    public static void main(String[] args) {
        System.out.println("Beginning ...");
        DataCon datacon = new DataCon();
        datacon.connect();

        try {   
            Statement stmt=datacon.con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from Eleve");

            while(rs.next()){System.out.println(rs.getInt(1)+"  "+rs.getInt(2));} //+"  "+rs.getString(3));
        }catch( Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("Hello World!1");
        try {   
            Statement stmt=datacon.con.createStatement();
            ResultSet rs=stmt.executeQuery("call afficherGroupe("+1+")");

            while(rs.next()){System.out.println(rs.getInt(1)+"  "+rs.getInt(2));} //+"  "+rs.getString(3));
        }catch( Exception e){
            System.out.println(e.getMessage());
        }

        datacon.disconnect();
        System.out.println("Hello World!2");
    }

    DataCon(){
        this.did = new DataId("user", "1234");
        this.dserv = new DataServ();
    }

    /*public ResultSet query(String query){
        ResultSet rs;
        try{
            Statement stmt=con.createStatement();
            rs=stmt.executeQuery(query);
        }catch(Exception e){
            System.out.println(e.getMessage());
            rs = new ResultSet();
        }  
        return rs;
    }*/


    public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con=DriverManager.getConnection(
                    "jdbc:mysql://"+dserv.url+":"+dserv.port+"/mydb",did.username,did.password);
            //here mydb is database name, root is username and password
        }catch( Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void disconnect(){
        try{
            con.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}