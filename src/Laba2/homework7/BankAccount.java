package Laba2.homework7;

public class BankAccount implements Transaction {

    private double balance;

    @Override
    public void deposit(double value) {
        balance += value;
    }

    @Override
    public void withdrawal(double value) {
        balance -= value;
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
