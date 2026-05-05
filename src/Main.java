public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    BankAccount account = new BankAccount(1000);

    while (true) {
        System.out.println("\n===== БАНКОМАТ =====");
        System.out.println("1. Проверить баланс");
        System.out.println("2. Пополнить");
        System.out.println("3. Снять");
        System.out.println("4. Выход");
        System.out.print("Выберите действие: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.printf("Баланс: %.2f руб.%n", account.getBalance());
                break;
            case 2:
                System.out.print("Сумма пополнения: ");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
                break;
            case 3:
                System.out.print("Сумма снятия: ");
                double withdrawAmount = scanner.nextDouble();
                account.withdraw(withdrawAmount);
                break;
            case 4:
                System.out.println();
                System.out.println("До свидания!");
                scanner.close();
                return;
            default:
                System.out.println("Неверный выбор. Попробуйте снова.");
        }
    }
}