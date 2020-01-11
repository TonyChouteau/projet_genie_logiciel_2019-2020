package database;

import java.sql.*;
import database.*;

public class DataCon {
    public DataId did;
    public DataServ dserv;
    public Connection con;

    public static void main(String[] args) {//example of query
        System.out.println("Beginning ...");
        DataCon datacon = new DataCon();
        datacon.connect();

        Result res = datacon.query("select * from Eleve");

        try {   
            while(res.infos.next()){System.out.println(res.infos.getInt(1)+"  "+res.infos.getInt(2));} //+"  "+rs.getString(3));
        }catch( Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("Hello World!1");

        res = datacon.query("call afficherGroupe("+1+")");

        try {   
            while(res.infos.next()){System.out.println(res.infos.getInt(1)+"  "+res.infos.getInt(2));} //+"  "+rs.getString(3));
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

    public Result query(String query){
        Result res;
        ResultSet rs;
        try{
            Statement stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            res = new Result(rs);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new Result();
        }  
        return res;
    }


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