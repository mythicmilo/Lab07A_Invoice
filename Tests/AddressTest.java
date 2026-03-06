import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest
{
    Address a1;

    @BeforeEach
    void setUp()
    {
        a1 = new Address("Milo Anderson", "123 Baker Street", "Doughville", "BA", "12345");
    }

    @Test
    void getCustName()
    {
        assertEquals("Milo Anderson", a1.getCustName());
    }

    @Test
    void setCustName()
    {
        a1.setCustName("Tom Wulf");
        assertEquals("Tom Wulf", a1.getCustName());
    }

    @Test
    void getStreet()
    {
        assertEquals("123 Baker Street", a1.getStreet());
    }

    @Test
    void setStreet()
    {
        a1.setStreet("100 Main Street");
        assertEquals("100 Main Street", a1.getStreet());
    }

    @Test
    void getCity()
    {
        assertEquals("Doughville", a1.getCity());
    }

    @Test
    void setCity()
    {
        a1.setCity("Anytown");
        assertEquals("Anytown", a1.getCity());
    }

    @Test
    void getState()
    {
        assertEquals("BA", a1.getState());
    }

    @Test
    void setState()
    {
        a1.setState("OH");
        assertEquals("OH", a1.getState());
    }

    @Test
    void getZip()
    {
        assertEquals("12345", a1.getZip());
    }

    @Test
    void setZip()
    {
        a1.setZip("98765");
        assertEquals("98765", a1.getZip());
    }
}