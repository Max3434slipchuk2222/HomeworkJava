package homework1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Program {

    static Scanner scanner = new Scanner(System.in);

    static void task01() {
        System.out.println("Завдання 1:");
        System.out.println("Your time is limited");
        System.out.println("\tso don't waste it");
        System.out.println("\t\tliving someone else's life");
        System.out.println("\t\t\tSteve Jobs");
        System.out.println();
    }

    static void task02() {
        System.out.println("Завдання 2:");
        System.out.print("Введіть число: ");
        double value = scanner.nextDouble();
        System.out.print("Введіть відсоток: ");
        double percent = scanner.nextDouble();
        double result = value * percent / 100;
        System.out.printf("%.0f%% від %.0f = %.2f%n", percent, value, result);
        System.out.println();
    }

    static void task03() {
        System.out.println("Завдання 3:");
        System.out.print("Введіть перше число: ");
        int a = scanner.nextInt();
        System.out.print("Введіть друге число: ");
        int b = scanner.nextInt();
        System.out.print("Введіть третє число: ");
        int c = scanner.nextInt();
        int result = Integer.parseInt("" + a + b + c);
        System.out.println("Сформоване число: " + result);
        System.out.println();
    }

    static void task04() {
        System.out.println("Завдання 4:");
        System.out.print("Введіть шестизначне число: ");
        String input = scanner.next().trim();

        if (input.length() != 6 || !input.matches("\\d{6}")) {
            System.out.println("Помилка: введіть коректне шестизначне число!");
            System.out.println();
            return;
        }

        char[] d = input.toCharArray();
        char tmp = d[0]; d[0] = d[5]; d[5] = tmp;
        tmp = d[1]; d[1] = d[4]; d[4] = tmp;
        System.out.println("Результат: " + new String(d));
        System.out.println();
    }

    static void task05() {
        System.out.println("Завдання 5:");
        System.out.print("Введіть номер місяця (1-12): ");
        int month = scanner.nextInt();

        if (month < 1 || month > 12) {
            System.out.println("Помилка: номер місяця має бути від 1 до 12!");
        } else if (month == 12 || month == 1 || month == 2) {
            System.out.println("Winter");
        } else if (month <= 5) {
            System.out.println("Spring");
        } else if (month <= 8) {
            System.out.println("Summer");
        } else {
            System.out.println("Autumn");
        }
        System.out.println();
    }


    static void task06() {
        System.out.println("Завдання 6:");
        System.out.print("Введіть кількість метрів: ");
        double meters = scanner.nextDouble();

        System.out.println("1 - Милі  2 - Дюйми  3 - Ярди");
        System.out.print("Ваш вибір: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> System.out.printf("%.2f м = %.6f миль%n",   meters, meters / 1609.344);
            case 2 -> System.out.printf("%.2f м = %.4f дюймів%n", meters, meters * 39.3701);
            case 3 -> System.out.printf("%.2f м = %.4f ярдів%n",  meters, meters * 1.09361);
            default -> System.out.println("Помилка: невірний вибір!");
        }
        System.out.println();
    }

    static void task07() {
        System.out.println("Завдання 7:");
        System.out.print("Введіть перше число: ");
        int a = scanner.nextInt();
        System.out.print("Введіть друге число: ");
        int b = scanner.nextInt();

        int start = Math.min(a, b);
        int end   = Math.max(a, b);
        if (a > b) System.out.printf("Нормалізація: початок = %d, кінець = %d%n", start, end);

        System.out.print("Непарні від " + start + " до " + end + ": ");
        for (int i = start; i <= end; i++) {
            if (i % 2 != 0) System.out.print(i + " ");
        }
        System.out.println("\n");
    }


    static void task08() {
        System.out.println("Завдання 8:");
        System.out.print("Введіть початок діапазону: ");
        int start = scanner.nextInt();
        System.out.print("Введіть кінець діапазону: ");
        int end = scanner.nextInt();
        if (start > end) { int t = start; start = end; end = t; }

        for (int i = start; i <= end; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%d*%d=%-4d", i, j, i * j);
            }
            System.out.println();
        }
        System.out.println();
    }

    static void task09() {
        System.out.println("Завдання 9:");
        int[] arr = generateArray(15, -10, 10);
        System.out.println("Масив: " + Arrays.toString(arr));

        int min = arr[0], max = arr[0], neg = 0, pos = 0, zero = 0;
        for (int v : arr) {
            if (v < min) min = v;
            if (v > max) max = v;
            if (v < 0) neg++;
            else if (v > 0) pos++;
            else zero++;
        }

        System.out.println("Мінімум:        " + min);
        System.out.println("Максимум:       " + max);
        System.out.println("Від'ємних:      " + neg);
        System.out.println("Додатних:       " + pos);
        System.out.println("Нулів:          " + zero);
        System.out.println();
    }


    static void task10() {
        System.out.println("Завдання 10:");
        int[] arr = generateArray(15, -10, 10);
        System.out.println("Початковий масив: " + Arrays.toString(arr));
        System.out.println("Парні:    " + Arrays.toString(Arrays.stream(arr).filter(v -> v % 2 == 0).toArray()));
        System.out.println("Непарні:  " + Arrays.toString(Arrays.stream(arr).filter(v -> v % 2 != 0).toArray()));
        System.out.println("Від'ємні: " + Arrays.toString(Arrays.stream(arr).filter(v -> v < 0).toArray()));
        System.out.println("Додатні:  " + Arrays.toString(Arrays.stream(arr).filter(v -> v > 0).toArray()));
        System.out.println();
    }


    static void drawLine(int length, String direction, char symbol) {
        if (length <= 0) { System.out.println("Помилка: довжина має бути > 0!"); return; }
        if (direction.equalsIgnoreCase("H")) {
            System.out.println(String.valueOf(symbol).repeat(length));
        } else if (direction.equalsIgnoreCase("V")) {
            for (int i = 0; i < length; i++) System.out.println(symbol);
        } else {
            System.out.println("Помилка: напрям має бути H або V!");
        }
    }

    static void task11() {
        System.out.println("Завдання 11:");
        System.out.print("Довжина лінії: ");
        int length = scanner.nextInt();
        System.out.print("Напрям (H / V): ");
        String dir = scanner.next();
        System.out.print("Символ: ");
        char sym = scanner.next().charAt(0);
        drawLine(length, dir, sym);
        System.out.println();
    }

    static void sortArray(int[] arr, boolean ascending) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                boolean swap = ascending ? arr[j] > arr[j + 1] : arr[j] < arr[j + 1];
                if (swap) { int t = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = t; }
            }
        }
    }
    static int[] generateArray(int size, int min, int max) {
        Random rnd = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = rnd.nextInt(max - min + 1) + min;
        return arr;
    }
    static void task12() {
        System.out.println("Завдання 12:");
        int[] arr = generateArray(10, 0, 99);
        System.out.println("Початковий масив: " + Arrays.toString(arr));
        System.out.println("1 - За зростанням  2 - За спаданням");
        System.out.print("Ваш вибір: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            sortArray(arr, true);
            System.out.println("За зростанням: " + Arrays.toString(arr));
        } else if (choice == 2) {
            sortArray(arr, false);
            System.out.println("За спаданням:  " + Arrays.toString(arr));
        } else {
            System.out.println("Помилка: невірний вибір!");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        task01();
        task02();
        task03();
        task04();
        task05();
        task06();
        task07();
        task08();
        task09();
        task10();
        task11();
        task12();
    }
}
