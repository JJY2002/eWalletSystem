import java.lang.Math;

public class Customer extends User {
  private int loyaltyPoint;

  public Customer(int loyaltyPoint, String username, String password, String email) {
    super((int)Math.random(), username, password, email);
    this.loyaltyPoint = loyaltyPoint;
  }

  public int getLoyaltyPoint() {
    return loyaltyPoint;
  }

  public void setLoyaltyPoint(int loyaltyPoint) {
    this.loyaltyPoint = loyaltyPoint;
  }

}
