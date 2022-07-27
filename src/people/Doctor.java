package people;
public class Doctor extends Person{
    int degree;
    public Doctor(String name, String s,String f, int i, int i1) {
        super(name, s,f, i);
        degree = i1;
    }

    @Override
    public String toString() {
        return super.toString() + "\tdegree: " + degree + "\tspec: doctor";
    }
}
