package database;

import java.io.Serializable;
import java.util.ArrayList;

public class Response implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    ArrayList<ArrayList<String>> content;
    String error;

    public Response(ArrayList<ArrayList<String>> content, String error){
        this.error = error;
        this.content = content;
    }
}