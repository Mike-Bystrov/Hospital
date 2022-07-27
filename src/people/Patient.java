package people;
import drugs.Drugs;
import java.util.ArrayList;

public class Patient extends Person{
    ArrayList<Drugs> drugs = new ArrayList<>();

    public Patient(String name, String n,String f, int i) {
        super(name, n,f, i);
    }

    public String getName() {
        return this.name;
    }
    public String getSurname() {
        return this.surname;
    }
    public String getFatherName() {
        return this.fatherName;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return super.toString() + "\tspec: patient";
    }

    public void addDrugs(Drugs dr) {
        drugs.add(dr);
    }

    public void getAllDrugs() {
        drugs.stream().distinct().forEach(el-> System.out.println(el + " "));
    }

    @Override
    public boolean equals(Object patient) {
        if (!patient.getClass().equals(this.getClass())) {
            return false;
        } else {
            return ((Patient) patient).name.equals(this.name) &&
                    ((Patient) patient).age == this.age;
        }
    }


}
