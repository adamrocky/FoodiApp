import java.text.*;

public class Payment
{
    private String paymentMethod;   //refer to the table
    
    public Payment(String paymentMethod)
    {
        this.paymentMethod = paymentMethod;
    }
    
    public void setPayment(String paymentMethod)
    {
        this.paymentMethod = paymentMethod;
    }
    
    public String getPaymentMethod()
    {
        return paymentMethod;
    }
    
    public double calcTotPriceAftDisc(double Fprice, double Dprice)
    {
        double totprice = (Fprice + Dprice);
        double totPriceAftDisc = 0.0;
        
        if(paymentMethod.equalsIgnoreCase("Online Payment"))
        {
            if(totprice > 20 && totprice < 40)
            {
                totPriceAftDisc = totprice - (totprice * 0.15);
            }
            else if(totprice > 10 && totprice < 20)
            {
                totPriceAftDisc = totprice - (totprice * 0.1);
            }
            else if(totprice < 10)
            {
                totPriceAftDisc = totprice - (totprice * 0.05);
            }
        }
        else if(paymentMethod.equalsIgnoreCase("Cash"))
        {
            if(totprice > 20 && totprice < 40)
            {
                totPriceAftDisc = totprice - (totprice * 0.1);
            }
            else if(totprice > 10 && totprice < 20)
            {
                totPriceAftDisc = totprice - (totprice * 0.07);
            }
            else if(totprice < 10)
            {
                totPriceAftDisc = totprice - (totprice * 0.03);
            }
        }
        
        return totPriceAftDisc;
    }
}