package TZJanosi.LongBased;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
    @Test
    void CalculationBasicTest() {
        Service service = new Service(6, "125 17");
        assertEquals(22, service.parallelCalculation());
    }
    @Test
    void CalculationTest() {
        Service service = new Service(25, "125 17");
        assertEquals(55312, service.parallelCalculation());
    }
    @Test
    void CalculationWithProblemDataTest() {
        Service service = new Service(25, "64599 31 674832 2659361 1 0 8867 321");
        assertEquals(199986, service.parallelCalculation());
    }
    @Test
    void CalculationWithProblemData50Test() {
        Service service = new Service(50, "64599 31 674832 2659361 1 0 8867 321");
        assertEquals(6855170414L, service.parallelCalculation());
    }

}