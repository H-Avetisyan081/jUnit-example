import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@ExtendWith(BankAccountParameterResolver.class)
@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
public class BankAccountTimeoutTest {


    @Test

    void testDepositTimeoutAssertion(BankAccount bankAccount){
        try{
            Thread.sleep(200);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        bankAccount.deposit(300);
        assertEquals(300,bankAccount.getBalance());

    }

    @Test
    void testTimeoutDepositAnnotation(BankAccount bankAccount){
        try{
            Thread.sleep(200);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        bankAccount.deposit(300);
        assertTimeout(Duration.ofMillis(500),()->{
            Thread.sleep(100);
        });
    }
}
