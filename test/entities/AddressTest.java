package entities;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddressTest {
    Address location = new Address("12/b","Flower street","Colombo");

    @Test
    public void setNumber() {
        location.setNumber("13/b");
        assertEquals("13/b",location.getNumber());
    }

    @Test
    public void setStreet() {
        location.setStreet("Garden road");
        assertEquals("Garden road",location.getStreet());
    }


    @Test
    public void getNumber() {
        assertEquals("12/b",location.getNumber());
    }

    @Test
    public void getStreet() {
        assertEquals("Flower street",location.getStreet());
    }

    @Test
    public void getCity() {
        assertEquals("Colombo",location.getCity());
    }

    @Test
    public void testToString() {
        assertEquals("12/b, Flower street, Colombo.",location.toString());
    }
}
