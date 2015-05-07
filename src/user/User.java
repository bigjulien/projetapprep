package user;

public class User {
    private String name;
    private String password;

    public User(String name, String pwd) {
        this.name = name;
        this.password = pwd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }
}
