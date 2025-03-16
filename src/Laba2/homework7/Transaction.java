package Laba2.homework7;

public interface Transaction {
    public void deposit(double value);

    public void withdrawal(double value);

    public double getBalance();
}
