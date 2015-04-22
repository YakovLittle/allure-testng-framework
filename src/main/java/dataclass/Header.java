package dataclass;

/**
 * Created by a.hodakov on 13.04.2015.
 */
public class Header {


    private float open;
    private float aproved;
    private float availible;

    @Override
    public String toString() {
        return "Header{" +
                "open=" + open +
                ", aproved=" + aproved +
                ", availible=" + availible +
                '}';
    }

    public float getOpen() {
        return open;
    }

    public float getAvailible() {
        return availible;
    }

    public float getAproved() {
        return aproved;
    }

    public Header(float open, float aproved, float availible) {
        this.open = open;
        this.aproved = aproved;
        this.availible = availible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Header header = (Header) o;

        if (Float.compare(header.aproved, aproved) != 0) return false;
        if (Float.compare(header.availible, availible) != 0) return false;
        if (Float.compare(header.open, open) != 0) return false;

        return true;
    }


}
