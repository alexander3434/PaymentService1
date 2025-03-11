package Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import io.murkka34.service.TransactionalPaymentService;
public class TransactionalPaymentServiceTest {
    @Test
    public void testTransactionalPaymentService() {
        TransactionalPaymentService service = new TransactionalPaymentService();

        service.transfer("A", "B", new BigDecimal("100"));
        assertEquals(BigDecimal.ZERO, service.balance("A"));
        assertEquals(new BigDecimal("100"), service.balance("B"));

        service.transfer("B", "A", new BigDecimal("50"));
        assertEquals(new BigDecimal("50"), service.balance("A"));
        assertEquals(new BigDecimal("50"), service.balance("B"));
    }
}
