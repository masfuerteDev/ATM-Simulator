import java.util.Date;

public class Transaction {
    private String type;
    private double amount;
    private Date date;
    private double balanceAfter;

    public Transaction(String type, double amount, Date date, double balanceAfter) {
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.balanceAfter = balanceAfter;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public double getBalanceAfter() {
        return balanceAfter;
    }
}