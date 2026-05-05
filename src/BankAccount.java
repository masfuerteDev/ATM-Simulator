public class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            System.out.println("Некорректная сумма. Введите положительное число.");
            return;
        }
        balance += amount;
        System.out.printf("Пополнено на %.2f руб. Новый баланс: %.2f руб.%n", amount, balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Ошибка: сумма должна быть больше нуля.");
            return;
        }

        if (balance >= amount) {
            balance -= amount;
            System.out.printf("Снято %.2f руб. Остаток: %.2f руб.%n", amount, balance);
        } else {
            System.out.printf("Недостаточно средств. Доступно: %.2f руб.%n", balance);
        }
    }
}
