package dataclass;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import java.math.BigDecimal;

/**
 * Created by s.lugovskiy on 12.03.2015 12:16.
 */
public class FinanceSummaryForBuling {

    private float balance;
    private float available;
    private float onHold;
    private float onAdvPayment;
    private float onOutput;
    private float onProcessing;
    private float issuedCredit;
    /**
     * всего в холде
     */
    private float holdTotal;

    private float opencommision;
    private float aprovedcommision;
    private float fromlastperiod;
    private float fromthismonth;
    private float feesandother;
    /**
     *
     * @param balance Account balance:
     * @param available Итого доступно к выплате:
     * @param onHold В холде
     * @param onAdvPayment В ожидании оплаты от рекламодателя:
     * @param onProcessing На выводе:
     * @param holdTotal Итого комиссия на рассмотрении
     */
    public FinanceSummaryForBuling(float balance, float available, float onHold, float onAdvPayment, float onProcessing, float holdTotal, float issuedCredit) {
        this.balance = round(balance,2);
        this.available = round(available,2);
        this.onHold = round(onHold,2);
        this.onAdvPayment = round(onAdvPayment,2);
        this.onProcessing = round(onProcessing,2);
        this.holdTotal = round(holdTotal,2);
        this.issuedCredit = round(issuedCredit,2);
        System.out.println(this);

    }

    /**
     *
     * @param balance Account balance:
     * @param available Итого доступно к выплате:
     * @param onHold В холде
     * @param onAdvPayment В ожидании оплаты от рекламодателя:
     * @param onProcessing На выводе:
       */
    public FinanceSummaryForBuling(float balance, float available, float onHold, float onAdvPayment, float onProcessing, float issuedCredit) {
        this.balance = round(balance,2);
        this.available = round(available,2);
        this.onHold = round(onHold,2);
        this.onAdvPayment = round(onAdvPayment,2);
        this.onProcessing = round(onProcessing,2);
        this.holdTotal = round(onHold + onAdvPayment + onProcessing,2);
        this.issuedCredit = round(issuedCredit,2);
        System.out.println(this);
    }

    public FinanceSummaryForBuling(float balance, float available, float onHold, float onAdvPayment, float onProcessing, float issuedCredit, float holdTotal, float opencommision, float aprovedcommision, float fromlastperiod, float fromthismonth, float feesandother) {
        this.balance = round(balance,2);
        this.available = round(available,2);
        this.onHold = round(onHold,2);
        this.onAdvPayment = round(onAdvPayment,2);

        this.onProcessing = round(onProcessing,2);
        this.issuedCredit = round(issuedCredit,2);
        this.holdTotal = round(holdTotal,2);
        this.opencommision = round(opencommision,2);
        this.aprovedcommision = round(aprovedcommision,2);
        this.fromlastperiod = round(fromlastperiod,2);
        this.fromthismonth = round(fromthismonth,2);
        this.feesandother = round(feesandother,2);
        System.out.println(this);
    }



    public static float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FinanceSummaryForBuling that = (FinanceSummaryForBuling) o;

        if (Float.compare(that.aprovedcommision, aprovedcommision) != 0) return false;
        if (Float.compare(that.available, available) != 0) return false;
        if (Float.compare(that.balance, balance) != 0) return false;
        if (Float.compare(that.feesandother, feesandother) != 0) return false;
        if (Float.compare(that.fromlastperiod, fromlastperiod) != 0) return false;
        if (Float.compare(that.fromthismonth, fromthismonth) != 0) return false;
        if (Float.compare(that.holdTotal, holdTotal) != 0) return false;
        if (Float.compare(that.issuedCredit, issuedCredit) != 0) return false;
        if (Float.compare(that.onAdvPayment, onAdvPayment) != 0) return false;
        if (Float.compare(that.onHold, onHold) != 0) return false;
        if (Float.compare(that.onOutput, onOutput) != 0) return false;
        if (Float.compare(that.onProcessing, onProcessing) != 0) return false;
        if (Float.compare(that.opencommision, opencommision) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (balance != +0.0f ? Float.floatToIntBits(balance) : 0);
        result = 31 * result + (available != +0.0f ? Float.floatToIntBits(available) : 0);
        result = 31 * result + (onHold != +0.0f ? Float.floatToIntBits(onHold) : 0);
        result = 31 * result + (onAdvPayment != +0.0f ? Float.floatToIntBits(onAdvPayment) : 0);
        result = 31 * result + (onOutput != +0.0f ? Float.floatToIntBits(onOutput) : 0);
        result = 31 * result + (onProcessing != +0.0f ? Float.floatToIntBits(onProcessing) : 0);
        result = 31 * result + (issuedCredit != +0.0f ? Float.floatToIntBits(issuedCredit) : 0);
        result = 31 * result + (holdTotal != +0.0f ? Float.floatToIntBits(holdTotal) : 0);
        result = 31 * result + (opencommision != +0.0f ? Float.floatToIntBits(opencommision) : 0);
        result = 31 * result + (aprovedcommision != +0.0f ? Float.floatToIntBits(aprovedcommision) : 0);
        result = 31 * result + (fromlastperiod != +0.0f ? Float.floatToIntBits(fromlastperiod) : 0);
        result = 31 * result + (fromthismonth != +0.0f ? Float.floatToIntBits(fromthismonth) : 0);
        result = 31 * result + (feesandother != +0.0f ? Float.floatToIntBits(feesandother) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FinanceSummary{" +
                "balance=" + balance +
                ", available=" + available +
                ", onHold=" + onHold +
                ", onAdvPayment=" + onAdvPayment +
                ", onOutput=" + onOutput +
                ", onProcessing=" + onProcessing +
                ", issuedCredit=" + issuedCredit +
                ", holdTotal=" + holdTotal +
                ", opencommision=" + opencommision +
                ", aprovedcommision=" + aprovedcommision +
                ", fromlastperiod=" + fromlastperiod +
                ", fromthismonth=" + fromthismonth +
                ", feesandother=" + feesandother +
                '}';
    }

    public float getBalance() {
        return balance;
    }

    public float getAvailable() {
        return available;
    }

    public float getOnHold() {
        return onHold;
    }

    @Step
    @Attachment
    public float getOnAdvPayment() {
        return onAdvPayment;
    }

    public float getOnOutput() {
        return onOutput;
    }

    public float getOnProcessing() {
        return onProcessing;
    }

    public float getHoldTotal() {
        return holdTotal;
    }

    public float getIssuedCredit() {
        return issuedCredit;
    }
}
