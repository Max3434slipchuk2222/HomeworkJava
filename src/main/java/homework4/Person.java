package homework4;

import java.util.ArrayList;
import java.util.List;

public class Person {
    String code;
    String name;
    String city;
    List<Fine> fines = new ArrayList<>();

    Person(String code, String name, String city) {
        this.code = code;
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Людина: код = " + code + ", ПІБ = " + name + ", місто = " + city + ", штрафи = " + fines;
    }
}
