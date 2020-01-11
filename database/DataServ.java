package database;

public class DataServ{
    public String url;
    public int port;
    DataServ(String url, int port){
        this.url = url;
        this.port = port;
    }

    DataServ(){//default local
        this.url = "localhost";
        this.port = 3306;
    }

}