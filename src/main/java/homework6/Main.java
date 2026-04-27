package homework6;

import java.util.Arrays;
import java.util.Random;

public class Main {

    private static int[] array;
    private static int sum;
    private static double average;

    public static void main(String[] args) throws InterruptedException {
        int arraySize = 10;

        Thread generatorThread = new Thread(() -> {
            System.out.println("Генерація масиву");
            array = new int[arraySize];
            Random random = new Random();
            for (int i = 0; i < arraySize; i++) {
                array[i] = random.nextInt(100);
            }
            System.out.println("Масив заповнено");
        });

        Thread sumThread = new Thread(() -> {
            try {
                generatorThread.join();
                System.out.println("Очікування на заповнення масиву");

                System.out.println("Обчислення суми");
                sum = 0;
                for (int num : array) {
                    sum += num;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread avgThread = new Thread(() -> {
            try {
                generatorThread.join();
                System.out.println("Очікування на заповнення масиву");

                System.out.println("Обчислення середнього арифметичного");
                double currentSum = 0;
                for (int num : array) {
                    currentSum += num;
                }
                average = currentSum / array.length;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        generatorThread.start();
        sumThread.start();
        avgThread.start();

        sumThread.join();
        avgThread.join();

        System.out.println("Згенерований масив: " + Arrays.toString(array));
        System.out.println("Сума елементів: " + sum);
        System.out.println("Середнє арифметичне: " + average);
    }
}
