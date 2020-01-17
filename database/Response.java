package database;

import java.util.ArrayList;

public class Response {

    ArrayList<ArrayList<String>> content;
    String error;

    public Response(ArrayList<ArrayList<String>> content, String error){
        this.error = error;
        this.content = content;
    }
}