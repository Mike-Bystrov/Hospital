package events;

import drugs.Receipt;
import people.Patient;

import java.time.LocalDate;
import java.util.Date;

public class DrugsEvent extends Event{
    String type;
    Receipt receipt;
    public DrugsEvent(LocalDate d, Patient p, Receipt rep) {
        super(d,p);
        type = "Drugs";
        receipt = rep;
    }
    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + receipt.toString();
    }
}
