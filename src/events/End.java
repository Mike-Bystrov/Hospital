package events;

import people.Patient;

import java.time.LocalDate;
import java.util.Date;

public class End extends Event{
    String type;
    public End(LocalDate d, Patient p) {
        super(d,p);
        type = "End";
    }

}
