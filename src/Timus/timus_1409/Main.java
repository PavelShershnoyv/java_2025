package Timus.timus_1409;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int garryShot = scanner.nextInt();
        int larryShot = scanner.nextInt();

        int totalCans = garryShot + larryShot - 1;
        int garryMissed = totalCans - garryShot;
        int larryMissed = totalCans - larryShot;

        System.out.println(garryMissed + " " + larryMissed);
    }
}
