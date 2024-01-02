import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

class Main {
  public static void main(String[] args) {
    // List of Users registered
    List<User> users = new ArrayList();
    List<Transaction> transactions = new ArrayList();
    
    // Logged in user
    User login = null;
    Scanner scanner = new Scanner(System.in);

    // Choice for Login or Register
    int choice;
    // Check logged in or not
    boolean loggedIn = false;
    // Loop login or register if not logged in yet
    do {
      System.out.println("Select an option:");
      System.out.println("1. Login");
      System.out.println("2. Register");
      System.out.print("Enter your choice: ");
      choice = scanner.nextInt();
      System.out.print("\033[H\033[2J");  
      System.out.flush();  
      if (choice != 1 && choice != 2) {
        System.out.println("Invalid choice, please try again.");
      }
      
      if (choice == 1) {
        if (users.size() > 0) {
          // Login input
          scanner.nextLine();
          System.out.print("Enter your username: ");
          String username = scanner.nextLine();
          System.out.print("Enter your password: ");
          String password = scanner.nextLine();
          // Finding user
          for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
              login = user;
            }
          }
          // Check if login object is null
          if (login != null) {
            System.out.println("Login successful!");
            loggedIn = true;
          } 
          else {
            System.out.print("\033[H\033[2J");  
            System.out.flush();  
            System.out.println("User not found");
          }
        }
        // No registered output
        else {
          System.out.print("\033[H\033[2J");  
          System.out.flush();  
          System.out.println("No registered users");
        }
      } 
      // Register
      if (choice == 2) {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        choice = 0;
        // Registering user
        do {
          System.out.println("Select register option:");
          System.out.println("1. Merchant");
          System.out.println("2. Customer");
          System.out.print("Enter your choice: ");
          choice = scanner.nextInt();
          System.out.print("\033[H\033[2J");  
          System.out.flush();
          if (choice != 1 && choice != 2) {
            System.out.println("Invalid choice, please try again.");
          }
        } while (choice != 1 && choice != 2);

        // Register input
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();
        System.out.print("Enter email: ");
        String email = scanner.next();
        // Merchant
        if (choice == 1) {
          System.out.print("Enter bank account: ");
          String bankAccount = scanner.next();
          System.out.print("Enter business name: ");
          String businessName = scanner.next();
          User merchant = new Merchant(bankAccount, businessName, username, password, email);
          users.add(merchant);
          System.out.print("\033[H\033[2J");  
          System.out.flush();  
        } 
        // Customer
        else {
          User customer = new Customer(0, username, password, email);
          users.add(customer);
          System.out.print("\033[H\033[2J");  
          System.out.flush();  
        }
      }
    } while (loggedIn == false);
    // Logged in output
    boolean logout = false;
    choice = 0;
    do {
      if(login instanceof Merchant) {
        System.out.println("Merchant");
      }
      System.out.println("Username: " + login.getUsername());
      System.out.println("Wallet Balance: RM" + login.getWallet().getBalance());
      System.out.println("1. Transfer Money");
      System.out.println("2. View Transaction History");
      System.out.println("3. Logout");
      System.out.print("Enter your choice: ");
      choice = scanner.nextInt();
      System.out.print("\033[H\033[2J");  
      System.out.flush(); 
      switch (choice) {
        case 1:
          // Transfer money
          HashMap<int,User> recipient = new HashMap<int,User>();
          int count = 1;
          for(User user : users) {
            if(user != login) {
              recipient.put(count,user);
              count++;
            }
          }
          System.out.println("Select recipient:");
          for(int i : recipient.keySet()) {
            System.out.println(i + ". " + recipient.get(i).getUsername());
          }
          System.out.print("Enter your choice: ");
          int recipientChoice = scanner.nextInt();
          System.out.print("Enter amount: ");
          double amount = scanner.nextDouble();
          // Transfer money
          Transaction transaction = new Transaction((int)Math.random(), login, recipient.get(recipientChoice), amount, "Transferring");
          login.transferMoney(amount, recipient.get(recipientChoice));
          transaction.setStatus("Completed");
          transactions.add(transaction);
          break;
        case 2:
          // View transaction history
          HashMap<int,Transaction> historyList = new HashMap<int,Transaction>();
          int count = 1;
          for(Transaction transaction : transactions) {
            if(transaction.getSender() == login) {
              historyList.put(count,transaction);
              count++;
            }
          }
          System.out.println("Transaction History:");
          for(int i : historyList.keySet()) {
            System.out.println(i + ". " + historyList.get(i).getSender().getUsername());
            System.out.println("Amount: RM" + historyList.get(i).getAmount());
          }
          break;
        case 3:
          // Logout
          logout = true;
          break;
      }
    }
    while (logout == false);
  }
}