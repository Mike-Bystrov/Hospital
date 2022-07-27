package events;

import people.Patient;

import java.time.LocalDate;

public abstract class Event {
    LocalDate date;
    Patient patient;
    Event(LocalDate d, Patient p) {
        date = d;
        patient = p;
    }

    public LocalDate getDate() {
        return date;
    }

    public Patient getPatient() {
        return patient;
    }

    @Override
    public String toString() {
        return date.toString() + " " + patient.toString() + " ";
    }
}
