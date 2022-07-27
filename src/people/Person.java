package people;

public abstract class Person {
    String name;
    String surname;
    String fatherName;
    int age;
    Person(String n, String s,String f, int a) {
        name = n;
        surname = s;
        fatherName = f;
        age = a;
    }
    @Override
    public String toString() {
        return "name: " + name + "\tsurname: " + surname + "\tfather's name: " + fatherName + "\tage: " + age;
    }


}
