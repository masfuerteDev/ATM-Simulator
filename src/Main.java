import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int attempts = 5;
        boolean pinOk = false;

        // Цикл проверки PIN (до 5 попыток)
        while (attempts > 0 && !pinOk) {
            System.out.print("Введите PIN-код (4 цифры): ");
            int pin = sc.nextInt();

            // Проверка, что PIN четырехзначный
            if (pin >= 1000 && pin <= 9999) {
                if (pin == 1111) {
                    pinOk = true;
                    System.out.println("Здравствуйте, Пользователь!");
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

        // Если PIN правильный - запускаем банкомат
        if (pinOk) {
            BankAccount bankAccount = new BankAccount(5000);

            while (true) {
                System.out.println("\n===== БАНКОМАТ =====");
                System.out.println("1. Проверить баланс");
                System.out.println("2. Пополнить");
                System.out.println("3. Снять");
                System.out.println("4. Выход");
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
                        System.out.println("\nДо свидания!");
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