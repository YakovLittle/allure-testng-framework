package roles;

/**
 * Created by s.lugovskiy on 04.03.2015 13:07.
 */
public class TestAdvertizer implements User{

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

    public TestAdvertizer() {
        this.name = System.getProperty("oauthAdv");
        this.password = System.getProperty("oauthAdvPassword");
        this.remoteAuth = System.getProperty("oauthAdvRemoteAuth");
    }

    public TestAdvertizer(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Advertizer{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", remoteAuth='" + remoteAuth + '\'' +
                '}';
    }
}
