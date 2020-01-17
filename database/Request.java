package database;
import java.io.Serializable;

public class Request implements Serializable{
    /**
     * Request object to send to the server
     */
    private static final long serialVersionUID = 1L;
    public String id;
    public String password;
    public String request;
    public int type;//0 if query, 1 if update
    public int requestID;//enumerate type of resquest (select or update or meove etc)
    public String args;

    Request(String id, String password,int type, int requestID, String args){
        this.id =id;
        this.password = password;
        this.type = type;
        this.requestID = requestID;
        this.args = args;
    }

}