package Laba4;

public class Example8 {
    public static int m() {
        try {
            System.out.println("0");
            throw new RuntimeException();
        } finally {
            System.out.println("1");
        }
    }
    public static void main(String[] args) {
        try {
            System.out.println(m());
        } catch (RuntimeException e) { // Исправлена ошибка
            System.out.println("2 " + e);
        }
    }
}
