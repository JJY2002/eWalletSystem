import java.lang.Math;

public class Merchant extends User {
  private String bankAccount;
  private String businessName;

  public Merchant(String bankAccount, String businessName, String username, String password, String email) {
  super((int)Math.random(), username, password, email);
  this.bankAccount = bankAccount;
  this.businessName = businessName;
  }

  public String getBankAccount() {
    return bankAccount;
  }

  public String getBusinessName() {
    return businessName;
  }
}