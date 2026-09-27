import java.util.ArrayList;

public class ConcurrentBank {

    private ArrayList<BankAccount> total = new ArrayList<>();

    public BankAccount createAccount(int cash) {
        BankAccount bankAccount = new BankAccount(cash);
        total.add(bankAccount);
        return bankAccount;
    }

    public synchronized void transfer(BankAccount take, BankAccount give, int sum) {
        take.withdraw(sum);
        give.deposit(sum);
    }

    public int getTotalBalance() {

        int totalBalance = 0;

        for (BankAccount acc : total) {
            totalBalance += acc.getBalance();
        }
        return totalBalance;
    }

}
