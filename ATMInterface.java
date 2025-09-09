import java.util.Scanner;

class ATMInterface {
    private double balance;

    public ATMInterface(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Successfully deposited: ₹" + amount);
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("✅ Successfully withdrawn: ₹" + amount);
        } else if (amount > balance) {
            System.out.println("❌ Insufficient balance.");
        } else {
            System.out.println("❌ Invalid withdrawal amount.");
        }
    }

    public void checkBalance() {
        System.out.println("💰 Current Balance: ₹" + balance);
    }
}

class ATM {
    private ATMInterface account;
    private Scanner sc;
    private final int pin = 1234;  // default PIN

    public ATM(ATMInterface account) {
        this.account = account;
        this.sc = new Scanner(System.in);
    }

    private boolean authenticate() {
        System.out.print("🔑 Enter your 4-digit PIN: ");
        int enteredPin = sc.nextInt();
        if (enteredPin == pin) {
            System.out.println("✅ Authentication successful.\n");
            return true;
        } else {
            System.out.println("❌ Incorrect PIN. Access denied.");
            return false;
        }
    }

    public void showMenu() {
        if (!authenticate()) return;

        while (true) {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1️⃣  Check Balance");
            System.out.println("2️⃣  Deposit");
            System.out.println("3️⃣  Withdraw");
            System.out.println("4️⃣  Exit");
            System.out.print("👉 Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("🙏 Thank you for using the ATM!");
                    return;
                default:
                    System.out.println("❌ Invalid option. Please try again.");
            }
        }
    }



    public static void main(String[] args) {
        ATMInterface userAccount = new ATMInterface(100000);
         
        ATM atm = new ATM(userAccount);
        atm.showMenu();
    }
}

