package homework3;

public class Sailor extends Human {
    private String shipName;

    public Sailor(String name, int age, String shipName) {
        super(name, age);
        this.shipName = shipName;
    }

    public void sail() {
        System.out.println("Моряк " + getName() + " відправляється у плавання на кораблі " + shipName);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(", Професія: Моряк, Корабель: " + shipName);
    }
}