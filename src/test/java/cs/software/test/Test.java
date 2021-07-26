package cs.software.test;

import cs.software.main.Centro;
import cs.software.main.Logistica;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ApplicationTests {

    @Test
    void canCreateCentros() {
        Logistica centros = new Logistica();
        centros.subscribe(0,9,0);
    }

}
