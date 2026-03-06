import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineItemTest
{
    LineItem l1;
    Product p1, p2;

    @BeforeEach
    void setUp()
    {
        p1 = new Product("Apple", 1.5);
        p2 = new Product("Orange", 2.5);
        l1 = new LineItem(1, p1);
        l1.calculateTotal();
    }

    @Test
    void getQuantity()
    {
        assertEquals(1, l1.getQuantity());
    }

    @Test
    void setQuantity()
    {
        l1.setQuantity(3);
        assertEquals(3, l1.getQuantity());
    }

    @Test
    void getLineItemTotal()
    {
        assertEquals(1.5, l1.getLineItemTotal());
    }

    @Test
    void setLineItemTotal()
    {
        l1.setLineItemTotal(5.5);
        assertEquals(5.5, l1.getLineItemTotal());
    }

    @Test
    void getProduct()
    {
        assertEquals(p1, l1.getProduct());
    }

    @Test
    void setProduct()
    {
        l1.setProduct(p2);
        assertEquals(p2, l1.getProduct());
    }
}