public class Product
{
    private String name;
    private double unitPrice;

    //Product constructor
    public Product (String name, double unitPrice)
    {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    //for JUnit tests
    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public double getUnitPrice() {return unitPrice;}

    public void setUnitPrice(double unitPrice) {this.unitPrice = unitPrice;}
}
