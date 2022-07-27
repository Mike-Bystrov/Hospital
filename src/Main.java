import drugs.BaseDrugs;
import drugs.GrammDrugs;
import drugs.Receipt;
import events.*;
import people.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import windows.*;

public class Main {
    public static void main(String[] args) {

        DataBase base = new DataBase();
        BaseDrugs baseDrugs = null;
        try{
            baseDrugs = new BaseDrugs(new File("C:\\myFirstProject\\grammDrugs.txt"), new File("C:\\myFirstProject\\mlDrugs.txt"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        var window = new SearchWindow();
        window.setBase(base);
        window.setBaseDrugs(baseDrugs);
    }
}
