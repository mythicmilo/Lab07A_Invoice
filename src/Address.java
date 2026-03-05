public class Address
{
    private String custName;
    private String street;
    private String city;
    private String state;
    private String zip;

    //Address constructor
    public Address (String custName, String street, String city, String state, String zip)
    {
        this.custName = custName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    //for JUnit tests
    public String getCustName() {return custName;}

    public void setCustName(String custName) {this.custName = custName;}

    public String getStreet() {return street;}

    public void setStreet(String street) {this.street = street;}

    public String getCity() {return city;}

    public void setCity(String city) {this.city = city;}

    public String getState() {return state;}

    public void setState(String state) {this.state = state;}

    public String getZip() {return zip;}

    public void setZip(String zip) {this.zip = zip;}
}

