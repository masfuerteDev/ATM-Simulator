import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        User user = new User("Иван", 1111, 5000);

        int attempts = 5;
        boolean pinOk = false;

        // 5 попыток ввода PIN
        while (attempts > 0 && !pinOk) {
            System.out.print("Введите PIN-код (4 цифры): ");
            int pin = sc.nextInt();

            if (pin >= 1000 && pin <= 9999) {
                if (pin == user.getPin()) {
                    pinOk = true;
                    System.out.println("Здравствуйте, " + user.getName() + "!");
                } else {
                    attempts--;
                    if (attempts > 0) {
                        System.out.println("Неверный PIN. Осталось попыток: " + attempts);
                    }
                }
            } else {
                System.out.println("PIN должен быть четырехзначным!");
            }
        }

        if (pinOk) {
            BankAccount bankAccount = user.getAccount();

            // Основной цикл работы банкомата
            while (true) {
                System.out.println("\n===== БАНКОМАТ =====");
                System.out.println("1. Проверить баланс");
                System.out.println("2. Пополнить");
                System.out.println("3. Снять");
                System.out.println("4. История операций");
                System.out.println("5. Выход");
                System.out.print("Выберите действие: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.printf("Баланс: %.2f руб.%n", bankAccount.getBalance());
                        break;
                    case 2:
                        System.out.print("Сумма пополнения: ");
                        double depositAmount = sc.nextDouble();
                        bankAccount.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Сумма снятия: ");
                        double withdrawAmount = sc.nextDouble();
                        bankAccount.withdraw(withdrawAmount);
                        break;
                    case 4:
                        bankAccount.printHistory();
                        break;
                    case 5:
                        System.out.println("\nДо свидания, " + user.getName() + "!");
                        sc.close();
                        return;
                    default:
                        System.out.println("Неверный выбор. Попробуйте снова.");
                }
            }
        } else {
            System.out.println("Карта заблокирована! Слишком много неверных попыток.");
        }
    }
}