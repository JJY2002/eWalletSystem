public class User {
  private int userID;
  private String username;
  private String password;
  private String email;
  private Wallet wallet;

  public User(int userID, String username, String password, String email) {
    this.userID = userID;
    this.username = username;
    this.password = password;
    this.email = email;
    this.wallet = new Wallet(0);
  }

  public int getUserID() {
    return userID;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getEmail() {
    return email;
  }

  public Wallet getWallet() {
    return wallet;
  }
}