package drugs;

import java.time.LocalDate;
import java.util.Date;

public class GrammDrugs extends Drugs{
    int grammes;
    public GrammDrugs(String n, int gr) {
        super(n);
        grammes = gr;
    }

    @Override
    public String toString() {
        return super.toString()+ " " + grammes + " gr";
    }
}
