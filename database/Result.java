package database;
import java.sql.*;

public class Result{
    ResultSet infos;
    public boolean valide;
    Result(){
        valide = false;
    }

    Result(ResultSet rs){
        valide =true;
        this.infos = rs;
    }

    public boolean isValid(){
        return valide;
    }

    public String toString(){
        String res = "";
        /*if(valide){
            while(infos.next()){
                System.out.println(infos.getInt(1)+"  "+infos.getInt(2));}
        }else{
            res = "Invalid Result";
        }*/
        return res;
    }
}