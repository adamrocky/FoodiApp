public class Delivery
{
    private String street;
    private String city;
    private String zipCode;
    
    //constructor
    public Delivery(String street, String city, String zipCode)
    {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }
    
    //mutator
    public void setDelivery(String street, String city, String zipCode)
    {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }
    
    public void setStreet(String street)
    {
        this.street = street;
    }
    
    public void setCity(String city)
    {
        this.city = city;
    }
    
    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }
    
    //accessor
    public String getStreet()
    {
        return street;
    }
    
    public String getCity()
    {
        return city;
    }
    
    public String getZipCode()
    {
        return zipCode;
    }
    
    public String toString() {
       return String.format("%-25s %-20s %-10s", street, city, zipCode);
    }  
}