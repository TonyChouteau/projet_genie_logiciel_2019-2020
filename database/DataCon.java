//example of sql request to server

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Beginning ...");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb","user","1234");
            //here mydb is database name, root is username and password
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from Eleve");

            while(rs.next()){System.out.println(rs.getInt(1)+"  "+rs.getInt(2));} //+"  "+rs.getString(3));
            con.close();
        }catch( Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Hello World!");





        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb","user","1234");
            //here mydb is database name, root is username and password
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("call afficherGroupe("+1+")");//lance la procedure afficherGroupe

            while(rs.next()){System.out.println(rs.getInt(1)+"  "+rs.getInt(2));} //+"  "+rs.getString(3));
            con.close();
        }catch( Exception e){
            System.out.println(e.getMessage());
        }
    }
}