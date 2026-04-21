package homework4;

import java.time.LocalDate;

public class Fine {
    String id;
    String type;
    String city;
    double amount;
    LocalDate date;

    Fine(String id, String type, String city, double amount, LocalDate date) {
        this.id = id;
        this.type = type;
        this.city = city;
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Штраф: id = " + id + ", тип = " + type + "', місто = " + city +
                ", сума = " + amount + ", дата = " + date;
    }
}
