package Assignment.Model;

public class Transaction {
    private String date;
    private double amount;
    private String type;

    public Transaction(String date, double amount, String type) {
        this.date = date;
        this.amount = amount;
        this.type = type;
    }

    // Getters and setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}