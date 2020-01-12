package database;

import java.sql.*;
import database.*;
import java.util.ArrayList; 
import java.util.List; 

public class DataCon {
    public DataId did;
    public DataServ dserv;
    public Connection con;

    public static void main(String[] args) {//example of query
        System.out.println("Beginning ...");
        DataCon datacon = new DataCon();
        datacon.connect();

        List<List<String>> res = datacon.query("select * from Eleve");
        System.out.println(res.toString());

        System.out.println("Hello World!1");

        res = datacon.query("call afficherGroupe("+1+")");
        System.out.println(res.toString());

        datacon.disconnect();
        System.out.println("Hello World!2");
    }

    DataCon(){
        this.did = new DataId("user", "1234");
        this.dserv = new DataServ();
    }

    public List<List<String>> query(String query){
        List<List<String>> list = new ArrayList<List<String>>();
        ResultSet rs;
        ResultSetMetaData rsmd;
        List<String> record;
        try{
            Statement stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            rsmd = rs.getMetaData();
            while (rs.next()){
                record = new ArrayList<String>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++){
                    record.add(rs.getString(i));
                }
                list.add(record); 
            }
        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return list;
        }  
        return list;
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