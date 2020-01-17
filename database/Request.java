package database;
import java.io.Serializable;

public class Request implements Serializable{
    /**
     * Request object to send to the server
     */
    private static final long serialVersionUID = 1L;
    public String login;
    public String password;
    public String request;
    public int type;
    // 0 if query, 1 if update
    public int requestID;
    // enumerate type of resquest (select or update or meove etc)
    public String args;

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRequest() {
        return this.request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getRequestID() {
        return this.requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public String getArgs() {
        return this.args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    

    Request(String login, String password, String request, int type, int requestID, String args){
        this.login =login;
        this.password = password;
        this.request = request;
        this.type = type;
        this.requestID = requestID;
        this.args = args;
    }

	public Request(String login, String password, String request, int type) {
        this.login =login;
        this.password = password;
        this.request = request;
        this.requestID = type;
	}

}