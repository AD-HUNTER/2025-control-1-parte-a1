package es.upm.grise.profunduzacion.cruiseController;

import es.upm.grise.profundizacion.cruiseControl.CruiseControl;
import es.upm.grise.profundizacion.cruiseControl.IncorrectSpeedException;
import es.upm.grise.profundizacion.cruiseControl.SpeedSetAboveSpeedLimitException;
import es.upm.grise.profundizacion.cruiseControl.Speedometer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CruiseControlTest {

    @BeforeEach
    void setUp() {
        org.mockito.MockitoAnnotations.openMocks(this);
    }
    @Mock
    private Speedometer speedometer;

    @Test
    void testConstructor() {
        CruiseControl cruiseControl = new CruiseControl(speedometer);
        assertTrue(cruiseControl.getSpeedLimit() == null);
        assertTrue(cruiseControl.getSpeedSet() == null);
    }

    @Test
    void testSetSpeedLimit() {
        CruiseControl cruiseControl = new CruiseControl(speedometer);
        cruiseControl.setSpeedLimit(100);
        assertTrue(cruiseControl.getSpeedLimit() == 100);
    }
    @Test
    void testSetNegativeSpeed() throws IncorrectSpeedException, SpeedSetAboveSpeedLimitException {
        CruiseControl cruiseControl = new CruiseControl(speedometer);
        try{
            cruiseControl.setSpeedSet(-100);
        } catch (IncorrectSpeedException e) {}
        assertTrue(cruiseControl.getSpeedSet() == null);
    }
    void testSetNegativeSpeedWithLimit() throws IncorrectSpeedException, SpeedSetAboveSpeedLimitException {
        CruiseControl cruiseControl = new CruiseControl(speedometer);
        cruiseControl.setSpeedLimit(100);
        try{
            cruiseControl.setSpeedSet(-100);
        } catch (IncorrectSpeedException e) {}
        assertTrue(cruiseControl.getSpeedSet() == null);
    }
    @Test
    void testSpeedLimitSurpassed() throws IncorrectSpeedException, SpeedSetAboveSpeedLimitException {
        CruiseControl cruiseControl = new CruiseControl(speedometer);
        cruiseControl.setSpeedLimit(50);
        assertTrue(cruiseControl.getSpeedLimit() == 50);
        try {
        cruiseControl.setSpeedSet(100);
        } catch (SpeedSetAboveSpeedLimitException e) {}
        assertTrue(cruiseControl.getSpeedSet() == null);
    }
    @Test
    void testSpeedSet() throws IncorrectSpeedException, SpeedSetAboveSpeedLimitException {
        CruiseControl cruiseControl = new CruiseControl(speedometer);
        cruiseControl.setSpeedLimit(100);
        assertTrue(cruiseControl.getSpeedLimit() == 100);
        cruiseControl.setSpeedSet(50);
        assertTrue(cruiseControl.getSpeedSet() == 50);
    }
}
