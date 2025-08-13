package MachineCodingRound.FlipkartWallet.model;

import MachineCodingRound.FlipkartWallet.enums.TransactionType;

import java.util.Date;

public class Transaction {
    private String transactionId;

    private String userName;
    private Date timeStamp;
    private TransactionType transactionType;
    private double amount;

    public Transaction(String userName, Date timeStamp, TransactionType transactionType, double amount) {
        this.userName = userName;
        this.timeStamp = timeStamp;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
