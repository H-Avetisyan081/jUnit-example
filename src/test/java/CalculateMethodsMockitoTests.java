import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CalculateMethodsMockitoTests {

    @Mock
    CalculateMetods calculateMetods;


    @BeforeEach
    public void setupMock(){
        Mockito.when(calculateMetods.divide(6,3)).thenReturn(2.0);
    }

    @Test
    public void testDivide(){
        assertEquals(2.0,calculateMetods.divide(6,3));
    }

}
