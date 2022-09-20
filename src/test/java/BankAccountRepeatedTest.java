import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountRepeatedTest {


        @RepeatedTest(5)
        @DisplayName("deposit 400 successfully")
        void testDepositRepetitionInfo(BankAccount bankAccount, RepetitionInfo repetitionInfo)  {
            bankAccount.deposit(500);
            assertEquals(500, bankAccount.getBalance());
            System.out.println( repetitionInfo.getCurrentRepetition());
        }
}