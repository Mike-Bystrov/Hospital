package drugs;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class MlDrugs extends Drugs{
    int millilitres;
    public MlDrugs(String n, int ml) {
        super(n);
        millilitres = ml;
    }

    @Override
    public String toString() {
        return super.toString()+ " " + millilitres + " ml's";
    }
}
