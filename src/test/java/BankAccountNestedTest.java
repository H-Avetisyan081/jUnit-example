import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountNestedTest {
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
        assertEquals(900, bankAccount.getBalance());
    }

    @Nested
    class WhenBalanceEqualsZero{
        @Test
        @DisplayName("Withdrawing below minimum balance: exception")
        public void testWithdrawMinimumBalanceIsZero(){
            BankAccount bankAccount = new BankAccount(0, 0);
            assertThrows(RuntimeException.class, ()->bankAccount.withDraw(500));
        }
        @Test
        public void testWithdrawMinimumBalanceIsNegative1000(){
            BankAccount bankAccount = new BankAccount(0, -1000);
            bankAccount.withDraw(500);
            assertEquals(-500,bankAccount.getBalance());
        }

    }
}
