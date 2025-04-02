package Laba3.Homework1;

public class Main {
    public static int fact(int n, int tab) {
        for (int i = 0; i < tab; i++) {
            System.out.print(" ");
        }
        System.out.println("fact(" + n + ")");
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fact(n - 2, tab + 1) + fact(n - 1, tab + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Ans: " + fact(5, 0));
    }
}
