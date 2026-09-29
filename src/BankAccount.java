import java.util.concurrent.atomic.AtomicLong;

public class BankAccount {

    private static final AtomicLong nextId = new AtomicLong(1);
    private final long id = nextId.getAndIncrement();
    private long bankAccount;

    public BankAccount(long bankAccount) {
        this.bankAccount = bankAccount;
    }

    public long getId() {
        return id;
    }

    public synchronized void deposit(long sum) {

        if (sum <= 0) {
            throw new IllegalArgumentException("Сумма перевода должна быть больше 0");
        }

        bankAccount += sum;
    }

    public synchronized void withdraw(long sum) {

        if (sum <= 0) {
            throw new IllegalArgumentException("Сумма перевода должна быть больше 0");
        }

        if (bankAccount - sum < 0) {
            throw new IllegalArgumentException("Не достаточно средств на счёте");
        }

        bankAccount -= sum;
    }

    public synchronized long getBalance() {
        return bankAccount;
    }

}