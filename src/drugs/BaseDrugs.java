package drugs;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;

public class BaseDrugs {
    private static final HashSet<Drugs> drugs = new HashSet<>();

    public BaseDrugs(File file1, File file2) throws IOException {
        FillDrugs(file1, file2);
    }

    public Drugs getDrug(String name) {
        for (var x: drugs) {
            if (x.name.equals(name)) {
                return x;
            }
        }
        return null;
    }

    public static void FillDrugs(File fileGr, File fileMl) throws IOException {
        Scanner sc1 = new Scanner(fileGr);
        while (sc1.hasNextLine()) {
            String string = sc1.nextLine();
            var arr = string.split(",");
            var grammDrug = new GrammDrugs(arr[0],Integer.parseInt(arr[1]));
            drugs.add(grammDrug);
        }
        Scanner sc2 = new Scanner(fileMl);
        while (sc2.hasNextLine()) {
            String string = sc2.nextLine();
            var arr = string.split(",");
            var mlDrug = new MlDrugs(arr[0],Integer.parseInt(arr[1]));
            drugs.add(mlDrug);
        }
    }

    public Drugs[] getDrugs() {
        return (Drugs[]) drugs.stream().sorted().toArray();
    }
}
