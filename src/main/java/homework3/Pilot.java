package homework3;

public class Pilot extends Human {
    private String aircraftType;

    public Pilot(String name, int age, String aircraftType) {
        super(name, age);
        this.aircraftType = aircraftType;
    }

    public void fly() {
        System.out.println("Пілот " + getName() + " керує літаком типу: " + aircraftType);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(", Професія: Пілот, Тип літака: " + aircraftType);
    }
}