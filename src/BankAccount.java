/**
 * A class representing a bank account with basic operations.
 *
 * <p>This class provides functionality to deposit, withdraw, and check balance.
 * Account numbers are automatically generated when an account is created.</p>
 *
 * @author John Doe
 * @version 1.2
 * @since 2020-03-15
 * @see <a href="https://www.example.com/bank-api">Bank API Documentation</a>
 */
public class BankAccount {
    private static int nextAccountNumber = 1000;

    private final int accountNumber;
    private double balance;
    private String ownerName;

    /**
     * Constructs a new bank account with zero balance.
     *
     * @param ownerName The name of the account owner
     * @throws IllegalArgumentException if ownerName is null or empty
     */
    public BankAccount(String ownerName) {
        if (ownerName == null || ownerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Owner name cannot be empty");
        }

        this.accountNumber = nextAccountNumber++;
        this.balance = 0.0;
        this.ownerName = ownerName;
    }

    /**
     * Deposits the specified amount into the account.
     *
     * @param amount the amount to deposit (must be positive)
     * @return the new balance after deposit
     * @throws IllegalArgumentException if amount is negative
     */
    public double deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
        return balance;
    }

    /**
     * Withdraws the specified amount from the account.
     *
     * @param amount the amount to withdraw (must be positive and not exceed balance)
     * @return the new balance after withdrawal
     * @throws IllegalArgumentException if amount is negative or exceeds balance
     */
    public double withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
        return balance;
    }

    /**
     * Gets the current account balance.
     *
     * @return the current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Transfers money from this account to another account.
     *
     * @param recipient the account to receive the funds
     * @param amount the amount to transfer
     * @return true if transfer was successful, false otherwise
     * @throws IllegalArgumentException if amount is invalid
     * @throws NullPointerException if recipient is null
     */
    public boolean transfer(BankAccount recipient, double amount) {
        if (recipient == null) {
            throw new NullPointerException("Recipient account cannot be null");
        }
        if (amount <= 0 || amount > balance) {
            throw new IllegalArgumentException("Invalid transfer amount");
        }

        this.balance -= amount;
        recipient.balance += amount;
        return true;
    }

    /**
     * Returns a string representation of the account.
     * Format: "Account #12345: John Doe, Balance: $1000.00"
     *
     * @return string representation of the account
     */
    @Override
    public String toString() {
        return String.format("Account #%d: %s, Balance: $%.2f",
                accountNumber, ownerName, balance);
    }

}