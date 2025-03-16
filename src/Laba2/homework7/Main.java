package Laba2.homework7;

public class Main {
    public static void main(String[] args) {
        BankAccount bank = new BankAccount();

        bank.deposit(100);
        System.out.println("Текущий баланс: " + bank.getBalance());

        bank.withdrawal(24);
        System.out.println("Баланс средств после списания: " + bank.getBalance());
    }
}
