import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceTest
{
    Invoice i1;
    Address a1, a2;
    LineItem l1;
    Product p1;
    ArrayList<LineItem> items;

    @BeforeEach
    void setUp()
    {
        a1 = new Address("Milo Anderson", "123 Baker Street", "Doughville", "BA", "12345");
        a2 = new Address("Tom Wulf", "987 Main Street", "Cincinnati", "OH", "98765");
        p1 = new Product("Apple", 1.5);
        l1 = new LineItem(1, p1);
        items = new ArrayList<>();
        items.add(l1);
        i1 = new Invoice("Invoice", a1, items);
    }

    @Test
    void getTitle()
    {
        assertEquals("Invoice", i1.getTitle());
    }

    @Test
    void setTitle()
    {
        i1.setTitle("Random");
        assertEquals("Random", i1.getTitle());
    }

    @Test
    void getCustAddress()
    {
        assertEquals(a1, i1.getCustAddress());
    }

    @Test
    void setCustAddress()
    {
        i1.setCustAddress(a2);
        assertEquals(a2, i1.getCustAddress());
    }

    @Test
    void getLineItems()
    {
        assertEquals(items, i1.getLineItems());
    }

    @Test
    void getAmountDue()
    {
        assertEquals(1.5, i1.getAmountDue());
    }

    @Test
    void setAmountDue()
    {
        i1.setAmountDue(3.5);
        assertEquals(3.5, i1.getAmountDue());
    }
}