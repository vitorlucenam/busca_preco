package model;

public class User {
    private String name;
    private String email;
    private String user;
    private String password;
    private int age;
    private int cep;
    private int id;

    public User(String name, String email, String user, String password, int age, int cep, int id){
        super();
        this.name=name;
        this.email=email;
        this.user=user;
        this.password=password;
        this.age=age;
        this.cep=cep;
        this.id=id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}