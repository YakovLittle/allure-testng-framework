package roles;

/**
 * Created by s.lugovskiy on 04.03.2015 13:07.
 */
public class Manager implements User {

    private String name;
    private String password;
    private String currency;
    private String remoteAuth;




    public String getName(){
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getCurrency() {
        return currency;
    }

    public String getRemoteAuth() {
        return remoteAuth;
    }

    public Manager() {
        this.name = System.getProperty("mgrname");
        this.password = System.getProperty("mgrpassword");
        this.remoteAuth = System.getProperty("mgrRemoteAuth");
    }

    public Manager(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Webmaster{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", remoteAuth='" + remoteAuth + '\'' +
                '}';
    }
}
