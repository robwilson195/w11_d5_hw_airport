import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    private Plane plane;

    @Before
    public void setUp(){
        this.plane = new Plane(AirlineType.BRITISHAIRWAYS, PlaneType.BOEING747);
    }

    @Test
    public void hasPlaneType() {
        assertEquals(PlaneType.BOEING747, plane.getPlaneType());
    }

    @Test
    public void hasCapacity() {
        assertEquals(3, plane.getPlaneType().getCapacity());
    }

    @Test
    public void hasAirline() {
        assertEquals(AirlineType.BRITISHAIRWAYS, plane.getAirline());
    }
}
