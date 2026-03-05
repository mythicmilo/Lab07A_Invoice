import java.util.ArrayList;

public class Invoice
{
    private String title;
    private Address custAddress;
    private ArrayList<LineItem> lineItems;
    private double totalAmount;

    //Invoice constructor
    public Invoice (String title, Address custAddress, ArrayList<LineItem> lineItems, double totalAmount)
    {
        this.title = title;
        this.custAddress = custAddress;
        this.lineItems = lineItems;
    }

    private void calculateAmountDue()
    {
        totalAmount = 0;
        for (LineItem item : lineItems)
        {
            totalAmount += item.getLineItemTotal();
        }
    }

    //for JUnit tests
    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public Address getCustAddress() {return custAddress;}

    public void setCustAddress(Address custAddress) {this.custAddress = custAddress;}

    public ArrayList<LineItem> getLineItems() {return lineItems;}

    public void setLineItems(ArrayList<LineItem> lineItems) {this.lineItems = lineItems;}

    public double getTotalAmount() {return totalAmount;}

    public void setTotalAmount(double totalAmount) {this.totalAmount = totalAmount;}
}
