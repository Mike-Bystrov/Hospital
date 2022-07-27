package drugs;

import java.time.LocalDate;

public abstract class Drugs{
    String name;
    Drugs(String n) {
        name = n;
    }
    @Override
    public String toString() {
        return name;
    }

}
