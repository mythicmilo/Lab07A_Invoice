public class LineItem
{
    private int quantity;
    private double lineItemTotal;
    private Product product;

    //LineItem constructor
    public LineItem (int quantity, Product product)
    {
        this.quantity = quantity;
        this.product = product;
        calculateTotal();
    }

    public void calculateTotal()
    {
        lineItemTotal = product.getUnitPrice() * quantity;
    }

    //for JUnit tests
    public int getQuantity() {return quantity;}

    public void setQuantity(int quantity) {this.quantity = quantity;}

    public double getLineItemTotal() {return lineItemTotal;}

    public void setLineItemTotal(double lineItemTotal) {this.lineItemTotal = lineItemTotal;}

    public Product getProduct() {return product;}

    public void setProduct(Product product) {this.product = product;}
}
