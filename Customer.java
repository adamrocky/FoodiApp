import java.text.DecimalFormat;
public class Customer
{
    private String custName;
    private String custPhoneNo;
    private String custEmail;
    private Food food;
    private Drink drink;
    private Delivery delivery;
    private Payment payment;
    
    public Customer(String custName, String custPhoneNo, String custEmail, String foodId, String foodName, double foodPrice, String drinkId, String drinkName, double drinkPrice, String street, String city, String zipCode, String paymentMethod)
    {
        this.custName = custName;
        this.custPhoneNo = custPhoneNo;
        this.custEmail = custEmail;
        food = new Food(foodId, foodName, foodPrice);
        drink = new Drink(drinkId, drinkName, drinkPrice);
        delivery = new Delivery(street, city, zipCode);
        payment = new Payment(paymentMethod);
    }
    
    public void setAll(String custName, String custPhoneNo, String custEmail, String foodId, String foodName, double foodPrice, String drinkId, String drinkName, double drinkPrice, String street, String city, String zipCode, String paymentMethod)
    {
        this.custName = custName;
        this.custPhoneNo = custPhoneNo;
        this.custEmail = custEmail;
        food.setFood(foodId, foodName, foodPrice);
        drink.setDrink(drinkId, drinkName, drinkPrice);
        delivery.setDelivery(street, city, zipCode);
        payment.setPayment(paymentMethod);
    }
    
    public void setCustPhoneNo(String custPhoneNo){
        this.custPhoneNo = custPhoneNo;
    }
    
    public void setStreet_Delivery(String Street_Delivery)
    {
        delivery.setStreet(Street_Delivery);
    }
    
    public void setCity_Delivery(String City_Delivery)
    {
        delivery.setCity(City_Delivery);
    }
    
    public void setZipCode_Delivery(String ZipCode_Delivery)
    {
        delivery.setZipCode(ZipCode_Delivery);
    }
    
    public String getCustName()
    {
        return custName;
    }
    
    public String getCustPhoneNo()
    {
        return custPhoneNo;
    }
    
    public String getCustEmail()
    {
        return custEmail;
    }
    
    public String getFoodId_Food()
    {
        return food.getFoodId();
    }
    
    public String getFoodName_Food()
    {
        return food.getFoodName();
    }
    
    public double getFoodPrice_Food()
    {
        return food.getFoodPrice();
    }
    
    public String getDrinkId_Drink()
    {
        return drink.getDrinkId();
    }
    
    public String getDrinkName_Drink()
    {
        return drink.getDrinkName();
    }
        
    public double getDrinkPrice_Drink()
    {
        return drink.getDrinkPrice();
    }
    
    public String getStreet_Delivery()
    {
        return delivery.getStreet();
    }
    
    public String getCity_Delivery()
    {
        return delivery.getCity();
    }
    
    public String getZipCode_Delivery()
    {
        return delivery.getZipCode();
    }
    
    public String getPaymentMethod_Payment()
    {
        return payment.getPaymentMethod();
    }
    
    public double getCalcTotPriceAftDisc(double fPrice, double dPrice)
    {  
        return payment.calcTotPriceAftDisc(fPrice, dPrice);
    }
    
    public String toString()
    {
        DecimalFormat df = new DecimalFormat("0.00"); 
        return String.format(
            "| %-20s | %-15s | %-30s | %-10s | %-25s | %-10s | %-10s | %-25s | %-10s | %-30s | %-20s | %-10s | %-20s |", 
            custName, 
            custPhoneNo, 
            custEmail,
            food.getFoodId(), 
            food.getFoodName(), 
            df.format(food.getFoodPrice()), // Format food price
            drink.getDrinkId(), 
            drink.getDrinkName(), 
            df.format(drink.getDrinkPrice()), // Format drink price
            delivery.getStreet(), 
            delivery.getCity(), 
            delivery.getZipCode(),
            payment.getPaymentMethod());
            
    }
    
    public String toDisplayTotPrice()
    {
        DecimalFormat df = new DecimalFormat("0.00"); 
        double totalPriceBeforeDiscount = 0.0;
        return String.format(
            "| %-20s | %-15s | %-30s | %-10s | %-25s | %-10s | %-10s | %-25s | %-10s | %-30s | %-20s | %-10s | %-20s | %-10s |", 
            custName, 
            custPhoneNo, 
            custEmail,
            food.getFoodId(), 
            food.getFoodName(), 
            df.format(food.getFoodPrice()), // Format food price
            drink.getDrinkId(), 
            drink.getDrinkName(), 
            df.format(drink.getDrinkPrice()), // Format drink price
            delivery.getStreet(), 
            delivery.getCity(), 
            delivery.getZipCode(),
            payment.getPaymentMethod(),
            df.format(totalPriceBeforeDiscount = food.getFoodPrice() + drink.getDrinkPrice())); // Display total price before discount
    }
    
    public String toDisplayTotAftDisc()
    {
        DecimalFormat df = new DecimalFormat("0.00");
        return String.format(
            "| %-20s | %-15s | %-30s | %-10s | %-25s | %-10s | %-10s | %-25s | %-10s | %-30s | %-20s | %-10s | %-20s | %-10s |", 
            custName, 
            custPhoneNo, 
            custEmail,
            food.getFoodId(), 
            food.getFoodName(), 
            df.format(food.getFoodPrice()), // Format food price
            drink.getDrinkId(), 
            drink.getDrinkName(), 
            df.format(drink.getDrinkPrice()), // Format drink price
            delivery.getStreet(), 
            delivery.getCity(), 
            delivery.getZipCode(),
            payment.getPaymentMethod(),
            df.format(payment.calcTotPriceAftDisc(food.getFoodPrice(), drink.getDrinkPrice()))); // Format total price after discount
    }
}