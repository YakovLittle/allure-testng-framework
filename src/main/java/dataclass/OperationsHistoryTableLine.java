package dataclass;

/**
 * Created by s.lugovskiy on 08.04.2015 13:08.
 */
public class OperationsHistoryTableLine {

    private String date;
    private float accrual;
    private float debiting;
    private String details;

    public OperationsHistoryTableLine(String date, float accrual, float debiting, String details) {
        this.date = date;
        this.accrual = accrual;
        this.debiting = debiting;
        this.details = details;
    }

    public String getDate() {
        return date;
    }

    public float getAccrual() {
        return accrual;
    }

    public float getDebiting() {
        return debiting;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "OperationsHistoryTableLine{" +
                "date='" + date + '\'' +
                ", accrual=" + accrual +
                ", debiting=" + debiting +
                ", details='" + details + '\'' +
                '}';
    }

    public OperationsHistoryTableLine get(){
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OperationsHistoryTableLine that = (OperationsHistoryTableLine) o;

        if (Float.compare(that.accrual, accrual) != 0) return false;
        if (Float.compare(that.debiting, debiting) != 0) return false;
        if (!date.equals(that.date)) return false;
        if (details != null ? !details.equals(that.details) : that.details != null) return false;

        return true;
    }

}
