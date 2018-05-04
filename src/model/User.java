package model;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class User {
    private String name;
    private String password;
    private String id;

    public User(String name,String password){
        super();
        this.name=name;
        this.password=password;
        this.id = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
    }
    public User(String name,String password , String id){
        super();
        this.name=name;
        this.password=password;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());

    }
}