import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@DisplayName("test BankAccount class")
class BankAccountTest {

    @Test
    @DisplayName("withdraw 500 successfully")
    void testWithdraw() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withDraw(300);
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    @DisplayName("deposit 400 successfully")
    void testDeposit() {
        BankAccount bankAccount = new BankAccount(400, 0);
        bankAccount.deposit(500);
        assertEquals(900, bankAccount.getBalance(),"unexpected value");
    }

    @Test
    @DisplayName("Withdraw will become negative")
    public void testWithdrawNotStuckAtZero() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withDraw(800);
        assertNotEquals(0, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Test activation account after creation")
    public void testActive() {
        BankAccount bankAccount = new BankAccount(500, 0);
        assumeTrue(bankAccount != null);
        assertTrue(bankAccount.isActive());
    }

    @Test
    @DisplayName("Test set holder name")
    public void testHolderName() {
        BankAccount bankAccount = new BankAccount(500, 0);
        bankAccount.setHolderName("Gugush");
        assertNotNull(bankAccount.getHolderName());
    }

    @Test
    @DisplayName("Test that we can`t withdraw below minimum")
    public void testWithDrawBelowMinimum() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertThrows(RuntimeException.class, () -> bankAccount.withDraw(2000));
    }

    @Test

    public void testWithDrawAndDepositWithoutException() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertAll(() -> bankAccount.deposit(200), () -> bankAccount.withDraw(450));
    }

    @Test
    @DisplayName("Deposit speed test")
    public void testDepositTimeout() {
        BankAccount bankAccount = new BankAccount(400, 0);
        assertTimeout(Duration.ofNanos(1), () -> bankAccount.deposit(200));
    }

}