import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentBank {

    private CopyOnWriteArrayList<BankAccount> total = new CopyOnWriteArrayList<>();

    public BankAccount createAccount(long cash) {
        BankAccount bankAccount = new BankAccount(cash);
        total.add(bankAccount);
        return bankAccount;
    }

    public void transfer(BankAccount take, BankAccount give, long sum) {

        if (take == give) {
            throw new IllegalArgumentException("Себе переводить нельзя");
        }

        BankAccount first = take.getId() < give.getId() ? take : give;
        BankAccount next = take.getId() < give.getId() ? give : take;

        synchronized (first) {
            synchronized (next) {
                take.withdraw(sum);
                give.deposit(sum);
            }
        }

    }

    public long getTotalBalance() {

        long totalBalance = 0;

        for (BankAccount acc : total) {
            totalBalance += acc.getBalance();
        }
        return totalBalance;
    }

}
