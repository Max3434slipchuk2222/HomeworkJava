package homework3;

public class Main {
    public static void main(String[] args) {
        Builder builder = new Builder("Олег", 35, "Муляр");
        Sailor sailor = new Sailor("Іван", 20, "Європа");
        Pilot pilot = new Pilot("Максим", 40, "Boeing B2");

        builder.displayInfo();
        builder.build();


        sailor.displayInfo();
        sailor.sail();

        pilot.displayInfo();
        pilot.fly();
    }
}