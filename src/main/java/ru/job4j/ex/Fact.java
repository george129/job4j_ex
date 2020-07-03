package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
        Fact f = new Fact();
        System.out.println(f.calc(-01));
    }

    public int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Argument n must be of positive value");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}