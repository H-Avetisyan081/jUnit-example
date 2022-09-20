import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
    private double balance;
    private double minimumBalance;

    private String holderName;

    private boolean isActive = true;

    public double withDraw(double amount) {
        if (balance - amount > minimumBalance) {
            balance -= amount;
            return balance;
        } else throw new RuntimeException();

    }

    public double deposit(double amount) {
        return balance += amount;
    }

    public BankAccount(double balance, double minimumBalance) {
        this.balance = balance;
        this.minimumBalance = minimumBalance;
    }
}
