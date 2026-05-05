public class User {
    private String name;
    private int pin;
    private BankAccount account;

    public User(String name, int pin, double initialBalance) {
        this.name = name;
        this.pin = pin;
        this.account = new BankAccount(initialBalance);
    }

    public String getName() {
        return name;
    }

    public int getPin() {
        return pin;
    }

    public BankAccount getAccount() {
        return account;
    }

    // Для смены PIN
    public void setPin(int newPin) {
        this.pin = newPin;
    }
}