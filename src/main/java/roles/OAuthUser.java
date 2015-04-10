package roles;

/**
 * Created by s.lugovskiy on 04.03.2015 13:07.
 */
public class OAuthUser implements User {

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

    public OAuthUser() {
        this.name = System.getProperty("oauthUser");
        this.password = System.getProperty("oauthPassword");
        this.remoteAuth = System.getProperty("oauthRemoteAuth");
    }

    public OAuthUser(String name, String password) {
        this.name = name;
        this.password = password;
        this.remoteAuth = System.getProperty("oauthRemoteAuth");
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
