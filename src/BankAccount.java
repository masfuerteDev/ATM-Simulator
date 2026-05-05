import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class BankAccount {
    private ArrayList<Transaction> transactions;
    private double balance;

    public BankAccount(double balance) {
        this.transactions = new ArrayList<>();
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Ошибка: сумма должна быть больше нуля.");
            return;
        }
        balance += amount;
        System.out.printf("Пополнено на %.2f руб. Новый баланс: %.2f руб.%n", amount, balance);

        Date now = new Date();
        Transaction transaction = new Transaction("Пополнение", amount, now, balance);
        transactions.add(transaction);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Ошибка: сумма должна быть больше нуля.");
            return;
        }
        if (balance < amount) {
            System.out.printf("Недостаточно средств. Доступно: %.2f руб.%n", balance);
            return;
        }
        balance -= amount;
        System.out.printf("Снято %.2f руб. Остаток: %.2f руб.%n", amount, balance);

        Date now = new Date();
        Transaction transaction = new Transaction("Снятие", amount, now, balance);
        transactions.add(transaction);
    }

    public void printHistory() {
        if (transactions.isEmpty()) {
            System.out.println("История операций пуста.");
            return;
        }
        System.out.println("\n===== ИСТОРИЯ ОПЕРАЦИЙ =====");
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        for (Transaction t : transactions) {
            System.out.printf("%s | %s | %.2f руб. | Баланс: %.2f руб.%n",
                    sdf.format(t.getDate()), t.getType(), t.getAmount(), t.getBalanceAfter());
        }
        System.out.println();
    }
}