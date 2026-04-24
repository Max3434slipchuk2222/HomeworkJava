package org.example;

import java.util.function.BinaryOperator;

public class Main {

    static class Fraction {
        int numerator;
        int denominator;

        public Fraction(int numerator, int denominator) {
            if (denominator == 0) {
                throw new IllegalArgumentException("Знаменник не може дорівнювати нулю!");
            }
            this.numerator = numerator;
            this.denominator = denominator;
        }

        @Override
        public String toString() {
            return numerator + "/" + denominator;
        }
    }

    public static void main(String[] args) {
        Fraction f1 = new Fraction(6, 5);
        Fraction f2 = new Fraction(1, 3);

        System.out.println("Перший дріб: " + f1);
        System.out.println("Другий дріб: " + f2);
        System.out.println("Завдання №2:");

        BinaryOperator<Fraction> add = (a, b) -> new Fraction(
                (a.numerator * b.denominator) + (b.numerator * a.denominator),
                a.denominator * b.denominator
        );

        BinaryOperator<Fraction> subtract = (a, b) -> new Fraction(
                (a.numerator * b.denominator) - (b.numerator * a.denominator),
                a.denominator * b.denominator
        );

        BinaryOperator<Fraction> multiply = (a, b) -> new Fraction(
                a.numerator * b.numerator,
                a.denominator * b.denominator
        );

        BinaryOperator<Fraction> divide = (a, b) -> new Fraction(
                a.numerator * b.denominator,
                a.denominator * b.numerator
        );

        System.out.println("Сума дробів: " + add.apply(f1, f2));
        System.out.println("Різниця дробів: " + subtract.apply(f1, f2));
        System.out.println("Множення дробів: " + multiply.apply(f1, f2));
        System.out.println("Ділення дробів: " + divide.apply(f1, f2));
    }
}