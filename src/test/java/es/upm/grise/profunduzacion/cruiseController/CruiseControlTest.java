package es.upm.grise.profunduzacion.cruiseController;

import es.upm.grise.profundizacion.cruiseControl.CruiseControl;
import es.upm.grise.profundizacion.cruiseControl.IncorrectSpeedException;
import es.upm.grise.profundizacion.cruiseControl.SpeedSetAboveSpeedLimitException;
import es.upm.grise.profundizacion.cruiseControl.Speedometer;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CruiseControlTest {

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
    void testNegativeSpeedLimit() throws IncorrectSpeedException, SpeedSetAboveSpeedLimitException {
        CruiseControl cruiseControl = new CruiseControl(speedometer);
        assertTrue(cruiseControl.getSpeedSet() == null);
        cruiseControl.setSpeedLimit(100);
        try{
        cruiseControl.setSpeedSet(-100);
        } catch (IncorrectSpeedException e) {}
    }
    @Test
    void testSpeedLimit() throws IncorrectSpeedException, SpeedSetAboveSpeedLimitException {
        CruiseControl cruiseControl = new CruiseControl(speedometer);
        cruiseControl.setSpeedLimit(50);
        assertTrue(cruiseControl.getSpeedLimit() == 50);
        try {
        cruiseControl.setSpeedSet(100);
        } catch (SpeedSetAboveSpeedLimitException e) {}
        assertTrue(cruiseControl.getSpeedSet() == null);
    }
}
