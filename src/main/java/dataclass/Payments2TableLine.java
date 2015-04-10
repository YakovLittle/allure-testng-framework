package dataclass;

import api.assertions.Assertions;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by s.lugovskiy on 08.04.2015 9:51.
 */
public class Payments2TableLine {

    private String month;
    private float open;
    private float cancelled;
    private float approved;
    private float transfered;
    private float hold;
    private float system;
    private float advertisers;
    private float total;
    private float processing;
    private float paid;
    private float chargeback;

    @Override
    public String toString() {
        return "Payments2TableLine{" +
                "month='" + month + '\'' +
                ", open=" + open +
                ", cancelled=" + cancelled +
                ", approved=" + approved +
                ", transfered=" + transfered +
                ", hold=" + hold +
                ", system=" + system +
                ", advertisers=" + advertisers +
                ", total=" + total +
                ", processing=" + processing +
                ", paid=" + paid +
                ", chargeback=" + chargeback +
                '}';
    }

    public Payments2TableLine(String month, float open, float cancelled, float approved, float transfered, float hold, float system, float advertisers, float total, float processing, float paid) {
        this.month = month;
        this.open = open;
        this.cancelled = cancelled;
        this.approved = approved;
        this.transfered = transfered;
        this.hold = hold;
        this.system = system;
        this.advertisers = advertisers;
        this.total = total;
        this.processing = processing;
        this.paid = paid;
        //log();
    }

    public Payments2TableLine(String month, float open, float cancelled, float approved, float transfered, float hold, float system, float advertisers, float total, float processing, float paid, float chargeback) {

        this.month = month;
        this.open = open;
        this.cancelled = cancelled;
        this.approved = approved;
        this.transfered = transfered;
        this.hold = hold;
        this.system = system;
        this.advertisers = advertisers;
        this.total = total;
        this.processing = processing;
        this.paid = paid;
        this.chargeback = chargeback;
        //log();
    }

    public float getOpen() {
        return open;
    }

    public float getCancelled() {
        return cancelled;
    }

    public String getMonth() {
        return month;
    }

    public float getApproved() {
        return approved;
    }


    public float getChargeback() {
        return chargeback;
    }


    public float getTransfered() {
        return transfered;

    }


    public float getHold() {
        return hold;
    }


    public float getSystem() {
        return system;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payments2TableLine that = (Payments2TableLine) o;

        if (Float.compare(that.advertisers, advertisers) != 0) return false;
        if (Float.compare(that.approved, approved) != 0) return false;
        if (Float.compare(that.cancelled, cancelled) != 0) return false;
        if (Float.compare(that.chargeback, chargeback) != 0) return false;
        if (Float.compare(that.hold, hold) != 0) return false;
        if (Float.compare(that.open, open) != 0) return false;
        if (Float.compare(that.paid, paid) != 0) return false;
        if (Float.compare(that.processing, processing) != 0) return false;
        if (Float.compare(that.system, system) != 0) return false;
        if (Float.compare(that.total, total) != 0) return false;
        if (Float.compare(that.transfered, transfered) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (open != +0.0f ? Float.floatToIntBits(open) : 0);
        result = 31 * result + (cancelled != +0.0f ? Float.floatToIntBits(cancelled) : 0);
        result = 31 * result + (approved != +0.0f ? Float.floatToIntBits(approved) : 0);
        result = 31 * result + (transfered != +0.0f ? Float.floatToIntBits(transfered) : 0);
        result = 31 * result + (hold != +0.0f ? Float.floatToIntBits(hold) : 0);
        result = 31 * result + (system != +0.0f ? Float.floatToIntBits(system) : 0);
        result = 31 * result + (advertisers != +0.0f ? Float.floatToIntBits(advertisers) : 0);
        result = 31 * result + (total != +0.0f ? Float.floatToIntBits(total) : 0);
        result = 31 * result + (processing != +0.0f ? Float.floatToIntBits(processing) : 0);
        result = 31 * result + (paid != +0.0f ? Float.floatToIntBits(paid) : 0);
        result = 31 * result + (chargeback != +0.0f ? Float.floatToIntBits(chargeback) : 0);
        return result;
    }

    public float getAdvertisers() {
        return advertisers;
    }

    public float getTotal() {
        return total;
    }

    public float getProcessing() {
        return processing;
    }

    public float getPaid() {
        return paid;
    }

    @Step
    @Attachment
    public String logPayment(){
        return this.toString();
    }

    @Step
    public void checkColumns(){
        Assertions.assertGreaterOrEquals(cancelled,0);
        Assertions.assertGreaterOrEquals(approved,0);
        Assertions.assertGreaterOrEquals(transfered,0);
        Assertions.assertGreaterOrEquals(hold,0);
        Assertions.assertGreaterOrEquals(advertisers,0);
        Assertions.assertGreaterOrEquals(total,0);
        Assertions.assertGreaterOrEquals(processing,0);
        Assertions.assertGreaterOrEquals(paid,0);
        Assertions.assertGreaterOrEquals(chargeback,0);
    }
}
