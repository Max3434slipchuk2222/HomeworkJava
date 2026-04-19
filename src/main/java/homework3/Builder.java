package homework3;

public class Builder extends Human {
    private String specialization;

    public Builder(String name, int age, String specialization) {
        super(name, age);
        this.specialization = specialization;
    }

    public void build() {
        System.out.println(getName() + " будує об'єкт за спеціальністю: " + specialization);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(", Професія: Будівельник, Спеціалізація: " + specialization);
    }
}