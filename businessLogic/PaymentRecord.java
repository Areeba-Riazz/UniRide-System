package businessLogic;

import javafx.beans.property.*;

public class PaymentRecord {
    private final StringProperty transactionId;
    private final StringProperty date;
    private final DoubleProperty amount;
    private final StringProperty status;

    public PaymentRecord(String transactionId, String date, double amount, String status) {
        this.transactionId = new SimpleStringProperty(transactionId);
        this.date = new SimpleStringProperty(date);
        this.amount = new SimpleDoubleProperty(amount);
        this.status = new SimpleStringProperty(status);
    }

    public StringProperty transactionIdProperty() {
        return transactionId;
    }

    public String getTransactionId() {
        return transactionId.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public String getDate() {
        return date.get();
    }

    public DoubleProperty amountProperty() {
        return amount;
    }

    public double getAmount() {
        return amount.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public String getStatus() {
        return status.get();
    }
};