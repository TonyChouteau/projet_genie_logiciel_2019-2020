package database;

public class DataId{
    /**
     * Object to identify a user on the database server
     */
    private String username;
    private String password;
    
    DataId(String username, String password){
        this.username = username;
        this.password = password;
    }

    DataId(){//constructor prod group
        this.username = "1920_INFO2_FluffyCorp";
        this.password = "PXESKqxehqGPSjc8xgy4Sx56LCZY3V27";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    protected String getPassword() { //security problems
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}