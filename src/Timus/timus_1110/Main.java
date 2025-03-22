package Timus.timus_1110;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BigInteger m = in.nextBigInteger();
        BigInteger y = in.nextBigInteger();
        boolean flag = true;

        for (int i = 0; i < m.intValue(); i++) {
            BigInteger x = new BigInteger(String.valueOf(i));
            if (x.pow(n).mod(m).equals(y)) {
                flag = false;
                System.out.print(i + " ");
            }
        }

        if (flag) {
            System.out.println("-1");
        }
    }
}
