public class Food
{
    private String foodId;
    private String foodName;
    private double foodPrice;
    
    public Food(String foodId, String foodName, double foodPrice)
    {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }
    
    public void setFood(String foodId, String foodName, double foodPrice)
    {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodPrice = foodPrice;   
    }
    
    public String getFoodId()
    {
        return foodId;
    }
    
    public String getFoodName()
    {
        return foodName;
    }
    
    public double getFoodPrice()
    {
        return foodPrice;
    }
        
    public String toString()
    {
        return String.format("%-10s %-25s %-10s", foodId, foodName, foodPrice);
    }
}