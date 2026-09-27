public class BankAccount {

    private int bankAccount;

    public BankAccount(int bankAccount) {
        this.bankAccount = bankAccount;
    }

    public synchronized void deposit(int sum) {
        bankAccount += sum;
    }

    public synchronized void withdraw(int sum) {
        bankAccount -= sum;
    }

    public synchronized int getBalance() {
        return bankAccount;
    }

}