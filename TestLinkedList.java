import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.text.*;

public class TestLinkedList{
    public static void main (String [] args) throws IOException{
        FileReader fr = new FileReader("customer.txt");
        BufferedReader br = new BufferedReader(fr);
        
        Scanner input = new Scanner (System.in);
        input.useDelimiter("\n");
        DecimalFormat df = new DecimalFormat("0.00");
        String indata = null;
        
        LinkedList <Customer> customerLL = new LinkedList();
        
        while((indata =br.readLine()) != null){
            StringTokenizer st = new StringTokenizer (indata,";");
            
            String custName = st.nextToken();
            String custPhoneNo = st.nextToken();
            String custEmail = st.nextToken();
            
            String foodId = st.nextToken();
            String foodName = st.nextToken();
            double foodPrice = Double.parseDouble(st.nextToken());
            
            String drinkId = st.nextToken();
            String drinkName = st.nextToken();
            double drinkPrice = Double.parseDouble(st.nextToken());
            
            String street = st.nextToken();
            String city = st.nextToken();
            String zipCode = st.nextToken();
            
            String paymentMethod = st.nextToken();
            
            Customer c = new Customer (custName, custPhoneNo, custEmail, foodId, foodName, foodPrice, drinkId, drinkName, drinkPrice, street, city, zipCode, paymentMethod);
            customerLL.addFirst(c);
    
        }
        
        //1. Display customer order
        System.out.println("+----------------------+-----------------+--------------------------------+------------+---------------------------+------------+------------+---------------------------+------------+--------------------------------+----------------------+------------+----------------------+");
        System.out.println("| Customer Name        | Phone Number    | Email                          | Food ID    | Food Name                 | Food Price | Drink ID   | Drink Name                | Drink Price| Street                         | City                 | Zip Code   | Payment Method       |");
        System.out.println("+----------------------+-----------------+--------------------------------+------------+---------------------------+------------+------------+---------------------------+------------+--------------------------------+----------------------+------------+----------------------+");
        
        Customer c = customerLL.getFirst();
        
        while(c !=null){
            System.out.println(c.toString());
            c = customerLL.getNext();
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        
        
        //1) To calculate the total price after the customer chooses their food and drinks 
        
        System.out.println("\nTotal prices for each customer:");
        System.out.println("+----------------------+-----------------+--------------------------------+------------+---------------------------+------------+------------+---------------------------+------------+--------------------------------+----------------------+------------+----------------------+------------+");
        System.out.println("| Customer Name        | Phone Number    | Email                          | Food ID    | Food Name                 | Food Price | Drink ID   | Drink Name                | Drink Price| Street                         | City                 | Zip Code   | Payment Method       | Total Price|");
        System.out.println("+----------------------+-----------------+--------------------------------+------------+---------------------------+------------+------------+---------------------------+------------+--------------------------------+----------------------+------------+----------------------+------------+");
        c = customerLL.getFirst();
        while(c != null ){
                System.out.println(c.toDisplayTotPrice());
                c = customerLL.getNext();
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        
        
        // 2)calculate the total price after discount based on the payment method that the customer chooses
        System.out.println("\nTotal prices After Discount for each customer:");
        System.out.println("+----------------------+-----------------+--------------------------------+------------+---------------------------+------------+------------+---------------------------+------------+--------------------------------+----------------------+------------+----------------------+------------+");
        System.out.println("| Customer Name        | Phone Number    | Email                          | Food ID    | Food Name                 | Food Price | Drink ID   | Drink Name                | Drink Price| Street                         | City                 | Zip Code   | Payment Method       | Total Price|");
        System.out.println("+----------------------+-----------------+--------------------------------+------------+---------------------------+------------+------------+---------------------------+------------+--------------------------------+----------------------+------------+----------------------+------------+");
        
        c = customerLL.getFirst();
        double totPriceAfterDisc = 0.0;
        while (c!=null){
            totPriceAfterDisc = c.getCalcTotPriceAftDisc (c.getFoodPrice_Food(),c.getDrinkPrice_Drink());
            c = customerLL.getNext();
        }
        
        c = customerLL.getFirst();
        while (c!=null){
            System.out.println(c.toDisplayTotAftDisc());
            c = customerLL.getNext();
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        
        //3)Count the most and least popular food and drinks
        int countAsian = 0;
        int countBakery = 0;
        int countDessert = 0;
        
        int countSoda = 0;
        int countMineralWater = 0;
        int countEnergyDrink = 0;
        
        c = customerLL.getFirst();
        while (c != null){
            
            if (c.getFoodId_Food().charAt(0) == 'A'){
                countAsian++;
            }
            else if (c.getFoodId_Food().charAt(0) == 'B'){
                countBakery++;
            }
            else if (c.getFoodId_Food().charAt(0) == 'D'){
                countDessert++;
            }
            
            if (c.getDrinkId_Drink().charAt(0) == 'S'){
                countSoda++;
            }
            else if (c.getDrinkId_Drink().charAt(0) == 'M'){
                countMineralWater++;
            }
            else if (c.getDrinkId_Drink().charAt(0) == 'E'){
                countEnergyDrink++;
            }
            
            c = customerLL.getNext();
        }
        
        System.out.println("\nMost popular food: ");
        if (countAsian >= countBakery && countAsian >= countDessert){
            System.out.println("Asian (Quantity: " + countAsian + ")");
        }
        else if (countBakery >= countAsian && countBakery >= countDessert){
            System.out.println("Bakery (Quantity: " + countBakery + ")");
        }
        else {
            System.out.println("Dessert (Quantity: " + countDessert + ")");
        }
        
        System.out.println("\nLeast popular food: ");
        if (countAsian <= countBakery && countAsian <= countDessert){
            System.out.println("Asian (Quantity: " + countAsian + ")");
        }
        else if (countBakery <= countAsian && countBakery <= countDessert){
            System.out.println("Bakery (Quantity: " + countBakery + ")");
        }
        else {
            System.out.println("Dessert (Quantity: " + countDessert + ")");
        }
        
        System.out.println("\nMost popular drink: ");
        if (countSoda >= countMineralWater && countSoda >= countEnergyDrink){
            System.out.println("Soda (Quantity: " + countSoda + ")");
        }
        else if (countMineralWater >= countSoda && countMineralWater >= countEnergyDrink){
            System.out.println("Mineral Water (Quantity: " + countMineralWater + ")");
        }
        else {
            System.out.println("Energy Drink (Quantity: " + countEnergyDrink + ")");
        }
        
        System.out.println("\nLeast popular drink: ");
        if (countSoda <= countMineralWater && countSoda <= countEnergyDrink){
            System.out.println("Soda (Quantity: " + countSoda + ")");
        }
        else if (countMineralWater <= countSoda && countMineralWater <= countEnergyDrink){
            System.out.println("Mineral Water (Quantity: " + countMineralWater + ")");
        }
        else {
            System.out.println("Energy Drink (Quantity: " + countEnergyDrink + ")");
        }
        
        //4)Count how many customers chooses cash or online payment as the payment method 
        c = customerLL.getFirst();
        int countCash = 0;
        int countOnlinePayment = 0;
        while(c != null){
            if (c.getPaymentMethod_Payment().charAt(0) == 'O'){
                countCash++;
            }
            else if (c.getPaymentMethod_Payment().charAt(0) == 'C'){
                countOnlinePayment++;
            }
            c = customerLL.getNext();
        }
        
        System.out.println("\nNumber of customers who chose Cash : " + countCash);
        System.out.println("Number of customers who chose Online Payment: " + countOnlinePayment);
        
        //5)Calculate average total price from each customer
        c = customerLL.getFirst();
        double totFoodPrice = 0.0;
        int count = 0;
        double avgFoodPrice = 0.0;
        while (c != null) 
        {
                totFoodPrice += c.getFoodPrice_Food() + c.getDrinkPrice_Drink(); // Accumulate food prices
                count++; // Count each customer
                
                c = customerLL.getNext();
        }
        
        if (count > 0) 
        {
                avgFoodPrice = totFoodPrice / count;
                 System.out.println(String.format("\nThe average food price among all customers is: RM%.2f", avgFoodPrice));
        } else 
        {
                System.out.println("\nNo customers available to calculate the average food price.");
        }
        
        //5)Search the customer personal information or the delivery address to change
        c = customerLL.getFirst();
        System.out.println("\n-----Search Customer details using Customer Name-----");
        System.out.print("Enter customer Name to search: ");
        String search = input.next(); // Get the input as it is
        
        boolean found = false;
        
        while (c != null){
            if (c.getCustName().equalsIgnoreCase(search)){
                System.out.println("\nCustomer found!");
                System.out.println("+----------------------+-----------------+--------------------------------+------------+---------------------------+------------+------------+---------------------------+------------+--------------------------------+----------------------+------------+----------------------+------------+");
                System.out.println("| Customer Name        | Phone Number    | Email                          | Food ID    | Food Name                 | Food Price | Drink ID   | Drink Name                | Drink Price| Street                         | City                 | Zip Code   | Payment Method       | Total Price|");
                System.out.println("+----------------------+-----------------+--------------------------------+------------+---------------------------+------------+------------+---------------------------+------------+--------------------------------+----------------------+------------+----------------------+------------+");       
                System.out.println(c.toDisplayTotAftDisc()); // Display matching customer
                found = true;
            }
            c = customerLL.getNext();
        }
        
        if (!found){
            System.out.println("Record not found!");
        }
        
        //6)update the customer personal information
        System.out.println("\n-----Customer List-----");
        System.out.println("+----------------------+-----------------+--------------------------------+------------+---------------------------+------------+------------+---------------------------+------------+--------------------------------+----------------------+------------+----------------------+------------+");
        System.out.println("| Customer Name        | Phone Number    | Email                          | Food ID    | Food Name                 | Food Price | Drink ID   | Drink Name                | Drink Price| Street                         | City                 | Zip Code   | Payment Method       | Total Price|");
        System.out.println("+----------------------+-----------------+--------------------------------+------------+---------------------------+------------+------------+---------------------------+------------+--------------------------------+----------------------+------------+----------------------+------------+");
        
        c = customerLL.getFirst();
        while (c != null){
            System.out.println(c.toDisplayTotAftDisc());
            c = customerLL.getNext();
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        
        //Update and remove
        c = customerLL.getFirst();
        System.out.print("\nEnter customer name to update personal information:  ");
        String updateCondition = input.next();
        
        while (c != null){
            if (c.getCustName().equalsIgnoreCase(updateCondition)){
                System.out.print("\nEnter the new Phone Number: ");
                String condition = input.next();
                
                c.setCustPhoneNo(condition);
            }
            
            if (c.getCustName().equalsIgnoreCase(updateCondition)){
                System.out.print("\nEnter the new Street: ");
                String condition2 = input.next();
                
                c.setStreet_Delivery(condition2);
            }
            
            if (c.getCustName().equalsIgnoreCase(updateCondition)){
                System.out.print("\nEnter the new City: ");
                String condition3 = input.next();
                
                c.setCity_Delivery(condition3);
            }
            
            if (c.getCustName().equalsIgnoreCase(updateCondition)){
                System.out.print("\nEnter the new Zip Code: ");
                String condition4 = input.next();
                
                c.setZipCode_Delivery(condition4);
            }
            c = customerLL.getNext();
        }
        
        System.out.println("\n-----updated customer information-----");
        System.out.println("+----------------------+-----------------+--------------------------------+------------+---------------------------+------------+------------+---------------------------+------------+--------------------------------+----------------------+------------+----------------------+------------+");
        System.out.println("| Customer Name        | Phone Number    | Email                          | Food ID    | Food Name                 | Food Price | Drink ID   | Drink Name                | Drink Price| Street                         | City                 | Zip Code   | Payment Method       | Total Price|");
        System.out.println("+----------------------+-----------------+--------------------------------+------------+---------------------------+------------+------------+---------------------------+------------+--------------------------------+----------------------+------------+----------------------+------------+");
        
        c = customerLL.getFirst();
        
        while (c != null){
            System.out.println(c.toDisplayTotAftDisc());
            c = customerLL.getNext();
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        
        /*** (7) Remove customer ******************
        c = customerLL.getFirst();
        System.out.println("\n-----Remove Customer-----");
        System.out.print("Enter customer name to remove: ");
        String removeName = input.next();
        boolean found2 = false;
        LinkedList <Customer> removeLL = new LinkedList ();
        
        Customer obj;
        // Process the queue and remove the specified customer
        while (c != null){
            if (c.getCustName().equalsIgnoreCase(removeName)){
                found2 = true;
                break;
            }
            else
            {
                found2 = false;
            }
            c = customerLL.getNext();
        }
        
        if (found2){
            System.out.println("Customer" + removeName + "has been removed");
            removeLL.addLast(c);
            obj = removeLL.getFirst();
            customerLL.addFirst(obj);
            customerLL.removeFirst();
        }
        
        // Display After Dia remove
        System.out.println("\n-----Customer List-----");
        System.out.println("+----------------------+-----------------+--------------------------------+------------+---------------------------+------------+------------+---------------------------+------------+--------------------------------+----------------------+------------+----------------------+------------+");
        System.out.println("| Customer Name        | Phone Number    | Email                          | Food ID    | Food Name                 | Food Price | Drink ID   | Drink Name                | Drink Price| Street                         | City                 | Zip Code   | Payment Method       | Total Price|");
        System.out.println("+----------------------+-----------------+--------------------------------+------------+---------------------------+------------+------------+---------------------------+------------+--------------------------------+----------------------+------------+----------------------+------------+");
        
        c = customerLL.getFirst();
        while (c != null){
            System.out.println(c.toDisplayTotAftDisc());
            c = customerLL.getNext();
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        ***/
        br.close();
        fr.close();
    }
}
