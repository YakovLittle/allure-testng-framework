package roles;

/**
 * Created by s.lugovskiy on 04.03.2015 13:07.
 */
public class TestManager implements User{

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

    public TestManager() {
        this.name = System.getProperty("oauthMgr");
        this.password = System.getProperty("oauthMgrPassword");
        this.remoteAuth = System.getProperty("oauthRemoteAuth");
    }

    public TestManager(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", remoteAuth='" + remoteAuth + '\'' +
                '}';
    }
}
