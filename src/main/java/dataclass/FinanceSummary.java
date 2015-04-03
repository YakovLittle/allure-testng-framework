package dataclass;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import java.math.BigDecimal;

/**
 * Created by s.lugovskiy on 12.03.2015 12:16.
 */
public class FinanceSummary {

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


    /**
     *
     * @param balance Account balance:
     * @param available Итого доступно к выплате:
     * @param onHold В холде
     * @param onAdvPayment В ожидании оплаты от рекламодателя:
     * @param onProcessing На выводе:
     * @param holdTotal Итого комиссия на рассмотрении
     */
    public FinanceSummary(float balance, float available, float onHold, float onAdvPayment, float onProcessing,float holdTotal, float issuedCredit) {
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
    public FinanceSummary(float balance, float available, float onHold, float onAdvPayment, float onProcessing, float issuedCredit) {
        this.balance = round(balance,2);
        this.available = round(available,2);
        this.onHold = round(onHold,2);
        this.onAdvPayment = round(onAdvPayment,2);
        this.onProcessing = round(onProcessing,2);
        this.holdTotal = round(onHold + onAdvPayment + onProcessing,2);
        this.issuedCredit = round(issuedCredit,2);
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
        FinanceSummary that = (FinanceSummary) o;
        if (Float.compare(that.available, available) != 0) return false;
        if (Float.compare(that.balance, balance) != 0) return false;
        if (Float.compare(that.holdTotal, holdTotal) != 0) return false;
        if (Float.compare(that.onAdvPayment, onAdvPayment) != 0) return false;
        if (Float.compare(that.onHold, onHold) != 0) return false;
        if (Float.compare(that.onProcessing, onProcessing) != 0) return false;
        if (Float.compare(that.issuedCredit, issuedCredit) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (balance != +0.0f ? Float.floatToIntBits(balance) : 0);
        result = 31 * result + (available != +0.0f ? Float.floatToIntBits(available) : 0);
        result = 31 * result + (onHold != +0.0f ? Float.floatToIntBits(onHold) : 0);
        result = 31 * result + (onAdvPayment != +0.0f ? Float.floatToIntBits(onAdvPayment) : 0);
        result = 31 * result + (onProcessing != +0.0f ? Float.floatToIntBits(onProcessing) : 0);
        result = 31 * result + (holdTotal != +0.0f ? Float.floatToIntBits(holdTotal) : 0);
        result = 31 * result + (issuedCredit != +0.0f ? Float.floatToIntBits(issuedCredit) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FinanceSummary{" +
                "баланс = " + balance +
                ", доступно = " + available +
                ", в холде = " + onHold +
                ", в холде рекла = " + onAdvPayment +
                ", на выводе = " + onProcessing +
                ", Итого на рассмотрении = " + holdTotal +
                ",issuedCredit = " + issuedCredit +
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
