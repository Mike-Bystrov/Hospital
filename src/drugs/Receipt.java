package drugs;

public class Receipt {
    Drugs drug;
    String text;
    public Receipt(Drugs d, String t) {
        drug = d;
        text = t;
    }
    public void setDrug(Drugs drug) {
        this.drug = drug;
    }
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return drug.toString() + " " + text;
    }
}
