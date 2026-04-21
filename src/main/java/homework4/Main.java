package homework4;

import java.time.LocalDate;
import java.util.*;

public class Main {


    static Map<String, Person> db = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    static void Menu() {
        System.out.println("\nМеню:");
        System.out.println("1. Додати людину");
        System.out.println("2. Додати штраф людині");
        System.out.println("3. Повний друк бази");
        System.out.println("4. Друк по коду");
        System.out.println("5. Друк по типу штрафу");
        System.out.println("6. Друк по місту");
        System.out.println("7. Видалити штраф");
        System.out.println("8. Змінити людину і її штрафи");
        System.out.println("0. Вихід");
        System.out.print("Ваш вибір: ");
    }

    static void addPerson() {
        System.out.print("Введіть код: ");
        String code = scanner.nextLine();
        if (db.containsKey(code)) {
            System.out.println("Людина з таким кодом вже існує.");
            return;
        }

        System.out.print("Введіть ПІБ: ");
        String name = scanner.nextLine();

        System.out.print("Введіть місто: ");
        String city = scanner.nextLine();

        db.put(code, new Person(code, name, city));
        System.out.println("Людину додано.");
    }

    static void addFine() {
        System.out.print("Введіть код людини: ");
        String code = scanner.nextLine();

        Person p = db.get(code);
        if (p == null) {
            System.out.println("Людину не знайдено.");
            return;
        }

        System.out.print("Введіть ID штрафу: ");
        String id = scanner.nextLine();

        System.out.print("Введіть тип штрафу: ");
        String type = scanner.nextLine();

        System.out.print("Введіть місто штрафу: ");
        String city = scanner.nextLine();

        System.out.print("Введіть суму: ");
        double amount = Double.parseDouble(scanner.nextLine());

        LocalDate date;
        while (true) {
            try {
                System.out.print("Введіть дату (yyyy-MM-dd): ");
                date = LocalDate.parse(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Помилка: введіть коректну дату у форматі yyyy-MM-dd, наприклад 2009-12-29.");
            }
        }

        p.fines.add(new Fine(id, type, city, amount, date));
        System.out.println("Штраф додано.");
    }

    static void printAll() {
        if (db.isEmpty()) {
            System.out.println("База порожня.");
            return;
        }
        for (Person p : db.values()) {
            System.out.println(p);
        }
    }

    static void printByCode() {
        System.out.print("Введіть код: ");
        String code = scanner.nextLine();
        Person p = db.get(code);
        if (p == null) System.out.println("Не знайдено.");
        else System.out.println(p);
    }

    static void printByFineType() {
        System.out.print("Введіть тип штрафу: ");
        String type = scanner.nextLine();

        boolean found = false;
        for (Person p : db.values()) {
            for (Fine f : p.fines) {
                if (f.type.equalsIgnoreCase(type)) {
                    System.out.println(p);
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("Нічого не знайдено.");
        }
    }

    static void printByCity() {
        System.out.print("Введіть місто: ");
        String city = scanner.nextLine();

        boolean found = false;
        for (Person p : db.values()) {
            if (p.city.equalsIgnoreCase(city)) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Нічого не знайдено.");
        }
    }

    static void removeFine() {
        System.out.print("Введіть код людини: ");
        String code = scanner.nextLine();

        Person p = db.get(code);
        if (p == null) {
            System.out.println("Людину не знайдено.");
            return;
        }

        System.out.print("Введіть ID штрафу для видалення: ");
        String fineId = scanner.nextLine();

        boolean removed = p.fines.removeIf(f -> f.id.equals(fineId));
        if (removed) System.out.println("Штраф видалено.");
        else System.out.println("Штраф не знайдено.");
    }

    static void replacePerson() {
        System.out.print("Введіть код людини: ");
        String code = scanner.nextLine();

        Person p = db.get(code);
        if (p == null) {
            System.out.println("Людину не знайдено.");
            return;
        }

        System.out.print("Введіть новий ПІБ: ");
        String name = scanner.nextLine();

        System.out.print("Введіть нове місто: ");
        String city = scanner.nextLine();

        List<Fine> newFines = new ArrayList<>();
        System.out.print("Скільки нових штрафів додати? ");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            System.out.println("Штраф #" + (i + 1));
            System.out.print("ID: ");
            String id = scanner.nextLine();

            System.out.print("Тип: ");
            String type = scanner.nextLine();

            System.out.print("Місто: ");
            String fineCity = scanner.nextLine();

            System.out.print("Сума: ");
            double amount = Double.parseDouble(scanner.nextLine());

            LocalDate date;
            while (true) {
                try {
                    System.out.print("Дата (yyyy-MM-dd): ");
                    date = LocalDate.parse(scanner.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Помилка: введіть коректну дату у форматі yyyy-MM-dd.");
                }
            }

            newFines.add(new Fine(id, type, fineCity, amount, date));
        }

        p.name = name;
        p.city = city;
        p.fines = newFines;

        System.out.println("Дані оновлено.");
    }

    public static void main(String[] args) {
        while (true) {
            Menu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addPerson();
                case "2" -> addFine();
                case "3" -> printAll();
                case "4" -> printByCode();
                case "5" -> printByFineType();
                case "6" -> printByCity();
                case "7" -> removeFine();
                case "8" -> replacePerson();
                case "0" -> {
                    System.out.println("Дякую що відвідали нашу програму.");
                    return;
                }
                default -> System.out.println("Ви вказали некоректний вибір.");
            }
        }
    }
}
