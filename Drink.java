public class Drink
{
    private String drinkId;
    private String drinkName;
    private double drinkPrice;
    
    public Drink(String drinkId, String drinkName, double drinkPrice)
    {
        this.drinkId = drinkId;
        this.drinkName = drinkName;
        this.drinkPrice = drinkPrice;
    }
    
    public void setDrink(String drinkId, String drinkName, double drinkPrice)
    {
        this.drinkId = drinkId;
        this.drinkName = drinkName;
        this.drinkPrice = drinkPrice;
    }
    
    public String getDrinkId()
    {
        return drinkId;
    }
    
    public String getDrinkName()
    {
        return drinkName;
    }
    
    public double getDrinkPrice()
    {
        return drinkPrice;
    }
    
    public String toString()
    {
        return String.format("%-10s %-25s %-10s", drinkId, drinkName, drinkPrice);
    }
}