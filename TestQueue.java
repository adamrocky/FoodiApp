import java.util.*;
import java.io.*;
import java.text.*;

public class TestQueue 
{
    public static void main(String[] args) throws Exception 
    {
        // Read from the customer data file
        FileReader fr = new FileReader("customer.txt");
        BufferedReader br = new BufferedReader(fr);

        Scanner input = new Scanner(System.in);
        input.useDelimiter("\n");
        DecimalFormat df = new DecimalFormat("0.00");
        
        Customer temp = null;
        Food food = null;
        Drink drink = null;
        
        double totPriceAftDisc = 0.0;
        double totFoodPrice = 0;
        int Count = 0;
        double aveFoodPrice = 0.0;
        
        int countAsian = 0;
        int countBakery = 0;
        int countDessert = 0;
        int countSoda = 0;
        int countMineralWater = 0;
        int countEnergyDrink = 0;
        
        int countCash = 0;
        int countOnlinePayment = 0;
        
        // Create the queue to hold customer objects
        Queue<Customer> qCust = new Queue();
        Queue<Customer> tempA = new Queue();

        String indata = null;

        // Reading customer data and enqueuing it into the queue
        while ((indata = br.readLine()) != null) 
        {
            StringTokenizer st = new StringTokenizer(indata, ";");

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
            String zip = st.nextToken();

            String paymentMethod = st.nextToken();

            // Create a new Customer object
            Customer customer = new Customer(custName, custPhoneNo, custEmail, foodId, foodName, foodPrice, drinkId, drinkName, drinkPrice, street, city, zip, paymentMethod);

            // Enqueue the customer object into the queue
            qCust.enqueue(customer);
        }
        

        //1. Display customer order
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                                                                     CUSTOMER INFORMATION                                                                                                                                        |");                                           
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| Customer Name        | Phone Number    | Email                          | Food ID    | Food Name                 | Food Price | Drink ID   | Drink Name                | Drink Price| Street                         | City                 | Zip Code   | Payment Method       |");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        
        while(!qCust.isEmpty())
        {
            temp = qCust.dequeue();
            System.out.println(temp);
            tempA.enqueue(temp);
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        
        //restore
        while(!tempA.isEmpty())
        {
            qCust.enqueue(tempA.dequeue());//yang buang tadi akan masuk balik
        }
        
        // 1) total price after the customer chooses their food and drinks 
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                                                                   TOTAL PRICE FOR EACH CUSTOMER                                                                                                                                              |");           
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| Customer Name        | Phone Number    | Email                          | Food ID    | Food Name                 | Food Price | Drink ID   | Drink Name                | Drink Price| Street                         | City                 | Zip Code   | Payment Method       | Total Price|");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");;
        
        while(!qCust.isEmpty())
        {
            temp = qCust.dequeue();
            System.out.println(temp.toDisplayTotPrice());
            tempA.enqueue(temp);
        }
        
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        
        //restore
        while(!tempA.isEmpty())
        {
            qCust.enqueue(tempA.dequeue());//yang buang tadi akan masuk balik
        }
        
        // 2)calculate the total price after discount based on the payment method that the customer chooses 
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                                                               TOTAL PRICE AFTER DISCOUNT FOR EACH CUSTOMER                                                                                                                                   |");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| Customer Name        | Phone Number    | Email                          | Food ID    | Food Name                 | Food Price | Drink ID   | Drink Name                | Drink Price| Street                         | City                 | Zip Code   | Payment Method       | Total Price|");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        
        // Process customers again for discount calculation
        while (!qCust.isEmpty()) 
        {
            temp = qCust.dequeue();

            totPriceAftDisc = temp.getCalcTotPriceAftDisc(temp.getFoodPrice_Food(), temp.getDrinkPrice_Drink());
            
            tempA.enqueue(temp);
        }
        
        //restore
        while(!tempA.isEmpty())
        {
            qCust.enqueue(tempA.dequeue());//yang buang tadi akan masuk balik
        }
        
        //System.out.println("\nThe Total Price After Discount: " + totPriceAftDisc);
        while(!qCust.isEmpty())
        {
            temp = qCust.dequeue();
            System.out.println(temp.toDisplayTotAftDisc());
            tempA.enqueue(temp);
        }
        
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        
        //restore
        while(!tempA.isEmpty())
        {
            qCust.enqueue(tempA.dequeue());//yang buang tadi akan masuk balik
        }
           
        //3)Count the most and least popular food and drinks 
        while(!qCust.isEmpty())
        {
            temp = qCust.dequeue();
            
            // Count food categories
            if(temp.getFoodId_Food().charAt(0) == 'A')
            {
                countAsian++;
            }
            else if(temp.getFoodId_Food().charAt(0) == 'B')
            {
                countBakery++;
            }
            else if(temp.getFoodId_Food().charAt(0) == 'D')
            {
                countDessert++;
            }

            // Count drink categories
            if(temp.getDrinkId_Drink().charAt(0) == 'S')
            {
                countSoda++;
            }
            else if(temp.getDrinkId_Drink().charAt(0) == 'M')
            {
                countMineralWater++;
            }
            else if(temp.getDrinkId_Drink().charAt(0) == 'E')
            {
                countEnergyDrink++;
            }

            tempA.enqueue(temp);
        }

        // Print most and least popular food
        System.out.println("\nMost popular food: ");
        if(countAsian >= countBakery && countAsian >= countDessert) 
        {
            System.out.println("Asian (Quantity: " +countAsian + ")");
        } 
        else if(countBakery >= countAsian && countBakery >= countDessert) 
        {
            System.out.println("Bakery (Quantity: " + countBakery + ")");
        } 
        else 
        {
            System.out.println("Dessert (Quantity: " + countDessert + ")");
        }

        System.out.println("\nLeast popular food: ");
        if(countAsian <= countBakery && countAsian <= countDessert) 
        {
            System.out.println("Asian (Quantity: " + countAsian + ")");
        } 
        else if(countBakery <= countAsian && countBakery <= countDessert) 
        {
            System.out.println("Bakery (Quantity: " + countBakery + ")");
        } 
        else 
        {
            System.out.println("Dessert (Quantity: " + countDessert + ")");
        }

        // Print most and least popular drink
        System.out.println("\nMost popular drink: ");
        if(countSoda >= countMineralWater && countSoda >= countEnergyDrink) 
        {
            System.out.println("Soda (Quantity: " + countSoda + ")");
        } 
        else if(countMineralWater >= countSoda && countMineralWater >= countEnergyDrink) 
        {
            System.out.println("Mineral Water (Quantity: " + countMineralWater + ")");
        } 
        else 
        {
            System.out.println("Energy Drink (Quantity: " + countEnergyDrink + ")");
        }

        System.out.println("\nLeast popular drink: ");
        if(countSoda <= countMineralWater && countSoda <= countEnergyDrink) 
        {
            System.out.println("Soda (Quantity: " + countSoda + ")");
        } 
        else if(countMineralWater <= countSoda && countMineralWater <= countEnergyDrink) 
        {
            System.out.println("Mineral Water (Quantity: " + countMineralWater + ")");
        } 
        else 
        {
            System.out.println("Energy Drink (Quantity: " + countEnergyDrink + ")");
        }

        // restore the queue
        while(!tempA.isEmpty())
        {
            qCust.enqueue(tempA.dequeue());
        }
        
        //4)Count how many customers chooses cash or online payment as the payment method 
        while(!qCust.isEmpty())
        {
            temp = qCust.dequeue();
            
            if(temp.getPaymentMethod_Payment().charAt(0) == 'O')
            {
                countCash++;
            }
            else if(temp.getPaymentMethod_Payment().charAt(0) == 'C')
            {
                countOnlinePayment++;
            }
            
            tempA.enqueue(temp);
        }
        
        System.out.println("\nNumber of customers who chose Cash: " + countCash);
        System.out.println("Number of customers who chose Online Payment: " + countOnlinePayment);  
        
        // restore the queue
        while(!tempA.isEmpty())
        {
            qCust.enqueue(tempA.dequeue());
        }
        
        //(5)Calculate average total price from each customer
        while (!qCust.isEmpty()) 
        {
            temp = qCust.dequeue();
                
            totFoodPrice += temp.getFoodPrice_Food() + temp.getDrinkPrice_Drink(); // Accumulate food prices
            Count++; // Count each customer
                
            tempA.enqueue(temp); // Move to the next customer
        }
            
        if (Count > 0) 
        {
            aveFoodPrice = totFoodPrice / Count;
            System.out.println(String.format("\nThe average food price among all customers is: RM%.2f", aveFoodPrice));
        } 
        else 
        {
            System.out.println("\nNo customers available to calculate the average food price.");
        }
            
        // Restore custQ from tempQ
        while (!tempA.isEmpty()) 
        {
            qCust.enqueue(tempA.dequeue());
        }
        
        //6)Search the customer’s personal information or the delivery address to change
        System.out.println("\n-----Search Customer details using Customer Name-----");
        System.out.print("Enter customer Name to search: ");
        String search = input.next(); // Get the input as it is
                    
        boolean found = false; 
        
        while (!qCust.isEmpty()) 
        {
            temp = qCust.dequeue(); // Dequeue one item at a tie
         
            if (temp.getCustName().equalsIgnoreCase(search)) 
            {
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("|                                                                                                               CUSTOMER FOUND                                                                                                                                                                 |");
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("| Customer Name        | Phone Number    | Email                          | Food ID    | Food Name                 | Food Price | Drink ID   | Drink Name                | Drink Price| Street                         | City                 | Zip Code   | Payment Method       | Total Price|");
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");       
                System.out.println(temp.toDisplayTotAftDisc()); // Display matching customer
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                found = true;
            }
            
            tempA.enqueue(temp); // Temporarily store non-matching customers
        }
        
        // Restore the queue
        while (!tempA.isEmpty()) 
        {
            qCust.enqueue(tempA.dequeue());
        }
        
        // Display result
        if(!found) 
        {
            System.out.println("Record not found!");
        }
        

        //6)update the customer’s personal information
        System.out.println("\n\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                                                                         CUSTOMER DETAIL LIST                                                                                                                                                 |");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");;
        System.out.println("| Customer Name        | Phone Number    | Email                          | Food ID    | Food Name                 | Food Price | Drink ID   | Drink Name                | Drink Price| Street                         | City                 | Zip Code   | Payment Method       | Total Price|");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        while(!qCust.isEmpty())
        {
            temp = qCust.dequeue();
            System.out.println(temp.toDisplayTotAftDisc());
            tempA.enqueue(temp);
        }
        
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            
        // restore the queue
        while(!tempA.isEmpty())
        {
            qCust.enqueue(tempA.dequeue());
        }
          
        //(7)Update and remove
        System.out.print("\nEnter customer name to update personal information:  ");
        String updateCondition = input.next();
        while (!qCust.isEmpty())
        {
            temp = qCust.dequeue();
            
            if(temp.getCustName().equalsIgnoreCase(updateCondition))
            {
                System.out.print("\nEnter the New Phone Number: ");
                String condition4 = input.next();
                    
                temp.setCustPhoneNo(condition4);
            }
            
            if(temp.getCustName().equalsIgnoreCase(updateCondition))
            {
                System.out.print("\nEnter the New Street: ");
                String condition = input.next();
                    
                temp.setStreet_Delivery(condition);
            }
            
            if(temp.getCustName().equalsIgnoreCase(updateCondition))
            {
                System.out.print("\nEnter the New City: ");
                String condition2 = input.next();
                    
                temp.setCity_Delivery(condition2);
            }
            
            if(temp.getCustName().equalsIgnoreCase(updateCondition))
            {
                System.out.print("\nEnter the New Zip Code: ");
                String condition3 = input.next();
                    
                temp.setZipCode_Delivery(condition3);
            }
            
            tempA.enqueue(temp);
        }
            
        // restore the queue
        while(!tempA.isEmpty())
        {
            qCust.enqueue(tempA.dequeue());
        }
            
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                                                                 UPDATE CUSTOMER LIST                                                                                                                                                         |");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| Customer Name        | Phone Number    | Email                          | Food ID    | Food Name                 | Food Price | Drink ID   | Drink Name                | Drink Price| Street                         | City                 | Zip Code   | Payment Method       | Total Price|");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            
        while(!qCust.isEmpty())
        {
            temp = qCust.dequeue();
            System.out.println(temp.toDisplayTotAftDisc());
            tempA.enqueue(temp);
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            
        // restore the queue
        while(!tempA.isEmpty())
        {
            qCust.enqueue(tempA.dequeue());
        }
        
        // (8) Remove customer 
        System.out.println("\n-----Remove Customer-----");
        System.out.print("Enter customer name to remove: ");
        String removeName = input.next();
        boolean found2 = false;
        
        // Process the queue and remove the specified customer
        while (!qCust.isEmpty()) 
        {
            temp = qCust.dequeue();
        
            if (temp.getCustName().equalsIgnoreCase(removeName)) 
            {
                System.out.println("Customer \"" + removeName + "\" has been removed.");
                found2 = true; //Kalau betul dia remove
            } 
            else 
            {
                tempA.enqueue(temp); //display benda sama
            }
        }  
        
        //restore
        while(!tempA.isEmpty())
        {
            qCust.enqueue(tempA.dequeue());//yang buang tadi akan masuk balik
        }
        
        // Display After Dia remove
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                                                                         CUSTOMER DETAIL LIST                                                                                                                                                 |");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| Customer Name        | Phone Number    | Email                          | Food ID    | Food Name                 | Food Price | Drink ID   | Drink Name                | Drink Price| Street                         | City                 | Zip Code   | Payment Method       | Total Price|");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            
        while(!qCust.isEmpty())
        {
            temp = qCust.dequeue();
            System.out.println(temp.toDisplayTotAftDisc());
            tempA.enqueue(temp);
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                
        //restore
        while(!tempA.isEmpty())
        {
            qCust.enqueue(tempA.dequeue());//yang buang tadi akan masuk balik
        }
               
        br.close();
        fr.close();
    }
}

