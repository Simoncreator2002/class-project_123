import java.util.*; //imports Java's utility packages including hashmaps, stacks etc.

class Transaction {
    String farmerId;
    String type;
    double amount;

    // Declares a class Transaction and defines its attributes
    public Transaction(String farmerId, String type, double amount) {
        this.farmerId = farmerId;
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "FARMER ID: " + farmerId + " | " + type + " SHS " + amount;
    }
}

public class PROJECT {
    private static final HashMap<String, Double> balances = new HashMap<>();
    // Stores each farmer's account balance in a hashmap, where String=farmer'sId and Double=balance
    private static final Stack<Transaction> transactions = new Stack<>();
    // Stores all transactions in a stack, recent transactions are retrieved fast (LIFO)
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("WELCOME TO THE SACCO!!");

        while (true) {
            System.out.println("\n1. CREATE ACCOUNT\n2. DEPOSIT MONEY\n3. WITHDRAW MONEY\n4. CHECK TRANSACTION HISTORY\n5. CHECK BALANCE\n6. EXIT");
            System.out.println("PLEASE SELECT OPTION: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // To resolve scanner issues

            switch (option) {
                case 1 -> createAccount();
                case 2 -> depositMoney();
                case 3 -> withdrawMoney();
                case 4 -> checkTransactionHistory();
                case 5 -> checkBalance();
                case 6 -> {
                    System.out.println("THANK YOU FOR USING SACCO!!");
                    return;
                }
                default -> System.out.println("INVALID OPTION!!!");
            }
        }
    }

    private static void createAccount() {
        System.out.println("ENTER FARMER'S ID TO CREATE ACCOUNT");
        String acc = scanner.nextLine();
        if (balances.containsKey(acc)) {
            System.out.println("ACCOUNT ALREADY EXISTS!!!");
        } else {
            balances.put(acc, 0.0); // Initialize the balance to 0
            System.out.println("ACCOUNT CREATED");
        }
    }

    private static void depositMoney() {
        System.out.println("ENTER FARMER ID: ");
        String acc = scanner.nextLine();
        if (!balances.containsKey(acc)) {
            System.out.println("ACCOUNT DOESN'T EXIST");
            return;
        }

        System.out.println("ENTER AMOUNT");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // To clear the buffer
        if (amount <= 0) {
            System.out.println("INVALID AMOUNT");
            return; // Rejects negative amount
        }

        balances.put(acc, balances.get(acc) + amount); // Updates the balance
        transactions.push(new Transaction(acc, "DEPOSITED", amount)); // Adds transaction
        System.out.println("DEPOSIT SUCCESSFUL");
    }

    private static void withdrawMoney() {
        System.out.println("ENTER FARMER'S ID");
        String acc = scanner.nextLine();
        if (!balances.containsKey(acc)) {
            System.out.println("ACCOUNT DOESN'T EXIST");
            return;
        }

        System.out.println("ENTER AMOUNT");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // To clear the buffer
        if (amount <= 0) {
            System.out.println("INVALID AMOUNT");
            return; // Rejects negative amount
        } else if (amount > balances.get(acc)) {
            System.out.println("INSUFFICIENT FUNDS");
            return; // Rejects withdrawals greater than the amount in the account
        }

        balances.put(acc, balances.get(acc) - amount); // Updates the balance
        transactions.push(new Transaction(acc, "WITHDRAWN", amount)); // Adds transaction
        System.out.println("WITHDRAWAL SUCCESSFUL");
    }

    private static void checkTransactionHistory() {
        System.out.println("ENTER FARMER'S ID");
        String acc = scanner.nextLine();
        if (!balances.containsKey(acc)) {
            System.out.println("ACCOUNT DOESN'T EXIST");
            return;
        }

        boolean found = false;
        for (Transaction t : transactions) {
            if (t.farmerId.equals(acc)) {
                System.out.println(t); // Prints each transaction for this farmer
                found = true;
            }
        }

        if (!found) {
            System.out.println("NO TRANSACTION HISTORY");
        }
    }

    private static void checkBalance() {
        System.out.println("ENTER FARMER'S ID");
        String acc = scanner.nextLine();
        if (balances.containsKey(acc)) {
            System.out.println("CURRENT BALANCE IS SHS " + balances.get(acc));
        } else {
            System.out.println("ACCOUNT DOESN'T EXIST");
        }
    }
}
