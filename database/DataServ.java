package database;

public class DataServ{
    /**
     * Object to represent the remote server which the database to which we connect
     */
    public String url;
    public int port;
    public String databasedused;
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
        this.databasedused = "mydb";
    }

    DataServ(){//default serv prod
        /**
         * Constructor
         */
        this.url = "barn-e-01";
        this.port = 3306;
        this.databasedused = "1920_INFO2_ERiP";
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