package hibernate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by s.lugovskiy on 26.03.2015 12:16.
 */
public class Geotimetest{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String test;
    private int time;
    private String timestamp;
    private String host;
    private String geo;

    public int getId() {
        return id;
    }

    public String getTest() {
        return test;
    }

    public int getTime() {
        return time;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHost() {
        return host;

    }

    public String getGeo() {
        return geo;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }

    @Override
    public String toString() {
        return "Geotimetest{" +
                "id=" + id +
                ", test='" + test + '\'' +
                ", time=" + time +
                ", timestamp='" + timestamp + '\'' +
                ", host='" + host + '\'' +
                ", geo='" + geo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Geotimetest that = (Geotimetest) o;

        if (id != that.id) return false;
        if (time != that.time) return false;
        if (geo != null ? !geo.equals(that.geo) : that.geo != null) return false;
        if (host != null ? !host.equals(that.host) : that.host != null) return false;
        if (test != null ? !test.equals(that.test) : that.test != null) return false;
        if (timestamp != null ? !timestamp.equals(that.timestamp) : that.timestamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (test != null ? test.hashCode() : 0);
        result = 31 * result + time;
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + (host != null ? host.hashCode() : 0);
        result = 31 * result + (geo != null ? geo.hashCode() : 0);
        return result;
    }
}
