package Laba3.Homework2;

public class Main {
    public static int convert(int value) {
        int mod = value % 2;

        if (value == 0) {
            return mod;
        }
        convert(value / 2);

        System.out.print(mod);
        return mod;
    }

    public static void main(String[] args) {
        convert(10);
    }
}
