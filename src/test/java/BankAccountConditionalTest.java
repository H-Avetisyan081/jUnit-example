import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

public class BankAccountConditionalTest {

    @Test
    @EnabledOnOs({OS.MAC})
    public void testOnMac() {

    }

    @Test
    @EnabledOnOs({OS.WINDOWS})
    public void testOnWin() {

    }


    @Test
    @EnabledOnJre({JRE.JAVA_11})
    public void testOnJre() {

    }
    @Test
    @EnabledOnJre({JRE.JAVA_9})
    public void testOnNoJre() {

    }



}
