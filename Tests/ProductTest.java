import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest
{
    Product p1;

    @BeforeEach
    void setUp()
    {
        p1 = new Product("Apple", 1.5);
    }

    @Test
    void getName()
    {
        assertEquals("Apple", p1.getName());
    }

    @Test
    void setName()
    {
        p1.setName("Orange");
        assertEquals("Orange", p1.getName());
    }

    @Test
    void getUnitPrice()
    {
        assertEquals(1.5, p1.getUnitPrice());
    }

    @Test
    void setUnitPrice()
    {
        p1.setUnitPrice(2.5);
        assertEquals(2.5, p1.getUnitPrice());
    }
}