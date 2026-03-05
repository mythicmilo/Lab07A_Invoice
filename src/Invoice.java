import java.util.ArrayList;

public class Invoice
{
    private String title;
    private Address custAddress;
    private ArrayList<LineItem> lineItems;
    private double amountDue;

    //Invoice constructor
    public Invoice (String title, Address custAddress, ArrayList<LineItem> lineItems)
    {
        this.title = title;
        this.custAddress = custAddress;
        this.lineItems = lineItems;
        calculateAmountDue();
    }

    public void calculateAmountDue()
    {
        amountDue = 0;
        for (LineItem item : lineItems)
        {
            amountDue += item.getLineItemTotal();
        }
    }

    //for JUnit tests
    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public Address getCustAddress() {return custAddress;}

    public void setCustAddress(Address custAddress) {this.custAddress = custAddress;}

    public ArrayList<LineItem> getLineItems() {return lineItems;}

    public double getAmountDue() {return amountDue;}

    public void setAmountDue(double amountDue) {this.amountDue = amountDue;}
}
