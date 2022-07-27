package windows;

import events.Event;
import events.EventFilter;
import people.*;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;

public class DataBase {
    ArrayList<Event> events   = new ArrayList<>();
    HashSet<Patient> patients = new HashSet<>();
    ArrayList<Patient> namePatients = new ArrayList<>();

    public void addEvent(Event ev) {
        events.add(ev);
    }

    public void addPatient(Patient pat) {
        patients.add(pat);
    }

    public void printAllEvents(EventFilter filter, PrintStream wr) {
        for (var c: events) {
            System.out.println(c);
        }
    }

    public void printAllPatients(PrintStream wr) {
        for (var c: patients) {
            System.out.println(c);
        }
    }

    public Patient isSuchPatient (String pat) {
        String[] arr = pat.split(" ");
        for (Patient x: patients) {
            if (x.getName().equals(arr[0]) && x.getSurname().equals(arr[1]) && x.getFatherName().equals(arr[2])) {
                return x;
            }
        }
        return null;
    }

    public boolean checkPatient(Patient patient) {
        boolean b = false;
        for (var x: patients)  {
            if (x.equals(patient)) {
                return true;
            }
        }
        return false;
    }

}
