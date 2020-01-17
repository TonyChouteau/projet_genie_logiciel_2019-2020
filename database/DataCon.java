package database;

import java.sql.*;
import database.*;
import java.util.ArrayList; 
import java.util.List; 

public class DataCon {
    /**
     * Connection object to access an outside database
     * 
     * use : 
     * 1-Create Datacon object
     * 2-apply connect() method to initiate connection
     * 3-query("Your SQL commande as a String") method to get what you want
     * 4-disconnect() because you are not savage
     * 
     * If you still don't understand go see the main which is an example of working code.
     */
    private DataId did;
    private DataServ dserv;
    private Connection con; 
    

    public static void main(String[] args) {//example of query
        /**
         * Example of connecting to the database
         */
        int tmpint;
        System.out.println("Beginning ...");
        DataCon datacon = new DataCon();
        datacon.connect();
        System.out.println("connection finished or failed");
        ArrayList<ArrayList<String>> res = datacon.query("select * from Eleve;");
        System.out.println(res.toString());

        System.out.println("test update");
        tmpint = datacon.update("insert into Eleve values (14,1);");
        System.out.println("update fait, nb : "+String.valueOf(tmpint));

        res = datacon.query("select * from Eleve;");
        System.out.println(res.toString());

        /*ArrayList<ArrayList<String>> res = datacon.query("select * from Maquette");
        System.out.println(res.toString());

        System.out.println("Hello World!1");

        res = datacon.query("call afficherGroupe("+1+")");
        System.out.println(res.toString());

        System.out.println("ajout eleve");
        res = datacon.query("call creerEleve("+1+")");
        //System.out.println(res.toString());

        res = datacon.query("Select * from Eleve");
        System.out.println(res.toString());

        System.out.println("supprime eleve");
        res = datacon.query("call supprimerEleve(16)");
        //System.out.println(res.toString());

        res = datacon.query("Select * from Eleve");
        System.out.println(res.toString());*/

        datacon.disconnect();
        System.out.println("Good bye World!");
    }

    DataCon(){
        /**
         * Example for prod server
         */
        this.did = new DataId();
        this.dserv = new DataServ();
    }

    DataCon(DataId did, DataServ dserv){
        /**
         * Constructor for real case utilization.
         * did is the user and dserv is the remote server
         */
        this.did = did;
        this.dserv = dserv;
    }

    public ArrayList<ArrayList<String>> query(String query){
        /**
         * Gets an SQL Query as String and returns the results as a List<List<String>>
         */
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        ResultSet rs;
        ResultSetMetaData rsmd;
        ArrayList<String> record;
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
            System.out.println("query error : "+ e.getMessage());
            return list;
        }  
        return list;
    }

    public int update(String request){
        int res;
        try{
            Statement stmt=con.createStatement();
            res = stmt.executeUpdate(request);
        }catch(Exception e){
            System.out.println("update error : "+ e.getMessage());
            return 0;
        } 
        return res;
    }

    public void connect() throws Exception{
        /**
         * Connects the connection Object to the sql database
         */
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.con=DriverManager.getConnection(
                    "jdbc:mysql://"+dserv.getUrl()+":"+dserv.getPort()+"/"+dserv.databasedused,did.getUsername(),did.getPassword());
            //here mydb is database name, root is username and password
    }

    public void disconnect(){
        /**
         * Close the connection
         */
        try{
            con.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}