import java.time.LocalDateTime;

public class Transaction {
  private int transactionId;
  private User sender;
  private User reciever;
  private double amount;
  private LocalDateTime timestamp;
  private String status;

  public Transaction(int transactionId, User sender, User reciever, double amount, LocalDateTime timestamp, String status) {
    this.transactionId = transactionId;
    this.sender = sender;
    this.reciever = reciever;
    this.amount = amount;
    this.timestamp = LocalDateTime.now();
    this.status = status;
  }

  public int getTransactionId() {
    return transactionId;
  }

  public User getSender() {
    return sender;
  }

  public User getReciever() {
    return reciever;
  }

  public double getAmount() {
    return amount;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}