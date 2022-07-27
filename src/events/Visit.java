package events;

import people.Patient;

import java.time.LocalDate;
import java.util.Date;

public class Visit extends Event{
    String type;
    public Visit(LocalDate d, Patient p) {
        super(d,p);
        type = "Visit";
    }
}
