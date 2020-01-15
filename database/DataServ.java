package database;

public class DataServ{
    /**
     * Object to represent the remote server which the database to which we connect
     */
    public String url;
    public int port;
    DataServ(String url, int port){
        this.url = url;
        this.port = port;
    }

    DataServ(int i){//default local
        /**
         * Constructor
         */
        this.url = "localhost";
        this.port = 3306;
    }

    DataServ(){//default serv prod
        /**
         * Constructor
         */
        this.url = "127.0.0.1/barn-e-01";
        this.port = 3306;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

}