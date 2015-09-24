/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lecturer;

/**
 * Thomas O Halloran
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class Validation {
    
    private String userStringInput = "";
    private static int uniqueID = 1000000;
    private int userIntInput = 0;
    private double userDoubleInput = 0;
    private boolean quit = false;
    
    DecimalFormat df = new DecimalFormat("#0.00");
    Scanner scanner = new Scanner(System.in);
    
    public Validation () {}
  
    public String createName()
    {
        do
        {
            String tempHolder = "";
            quit = true;
            System.out.print("Please enter the name:");
            userStringInput = scanner.nextLine();
        
            tempHolder = userStringInput.replaceAll("\\s", "");
            
            if( ( ! tempHolder.matches("[a-zA-Z]+") ) || ( tempHolder.length() < 6 ) )
                {
                    System.out.println("Please enter letters only and at least 6 characters.");
                    quit = false;
                }
        }while(quit != true);
        return userStringInput;
    }
    
    public String createAddress()
    {
        do
        {
            quit = true;
            System.out.print("Please enter the address:");
            userStringInput = scanner.nextLine();
            
            if( userStringInput.replaceAll("\\s", "").length() < 10 )
                {
                    System.out.println("Please enter at least 10 characters for the address.");
                    quit = false;
                }
            
            if( userStringInput.indexOf(",") == -1 )
                {
                    System.out.println("Please ensure to seperate the address using commas"
                                      +"\n eg. 174, New Drive, Cork, Ireland");
                    quit = false;
                }
            
            if ( quit == true )
                {
                    String[] split = userStringInput.split(",");
        
                    for (int i = 1; i < split.length; i++)
                        {
                            if( ! split[i].replaceAll("\\s", "").matches("[a-zA-Z]+"))
                                {
                                    quit = false;
                                }
                        }
            
                    if ( quit == false )
                        {
                        System.out.println("Please ensure address only contains door number and letters and is"
                                         + "\nseperated by a comma ',' eg. 174, New Drive, Cork, Ireland");
                        }
                }
        }while(quit!=true);
        return userStringInput;
    }
    
    
    public String createUniqueID()
    {
        uniqueID++;
        userStringInput = "R"+uniqueID;
        return userStringInput;
    }
   
    public int createAge()
    {
        quit = true;
        do
        {   
            System.out.print("Please enter the age:");
            while(!scanner.hasNextInt())
                {
                    System.out.print("Please enter a valid age:");
                    scanner.next();
                }
            userIntInput = scanner.nextInt();
            scanner.nextLine();
            quit = true;
            
            if( userIntInput < 0 )
                {
                    System.out.println("Error: negative numbers are not valid.");
                    quit = false;
                }
            
            if( userIntInput > 115 )
                {
                    System.out.println("Are you sure "+userIntInput+" is correct??");
                    System.out.print("Enter 'Y' for yes or any other key for no:");
                    userStringInput = scanner.nextLine();
                    
                    if( userStringInput.equalsIgnoreCase("Y") )
                        {
                            quit = true;
                        }
                        else
                            {
                                quit = false;
                            }
                }
            
            
        }while(quit!=true);
        return userIntInput;
    }
    
    
    public double createPrice()
    {
        do
        {
            quit = true;
            System.out.print("Please enter the price:€");
            while(!scanner.hasNextDouble())
                {
                    System.out.print("Please enter a valid price:€");
                    scanner.next();
                }
            userDoubleInput = scanner.nextDouble();
            scanner.nextLine();
            quit = true;
        
            if( userDoubleInput < 0.01 )
                {
                    System.out.println("Please enter a price greater than 0.");
                    quit = false;
                }
        }while(quit!=true);
        return Double.parseDouble(df.format(userDoubleInput));
    }
    
    public int createPhoneNum()
    {
        do
        {
            quit = true;
            System.out.print("Please enter the phone number: ");
            while(!scanner.hasNextInt())
                {
                    System.out.print("Please enter a valid phone number: ");
                    scanner.next();
                }
            userIntInput = scanner.nextInt();
            scanner.nextLine();
            quit = true;
        
            if( userIntInput < 0 )
                {
                    System.out.println("Error: negative numbers are not valid.");
                    quit = false;
                }
            
            userStringInput = ""+userIntInput;
            if( userStringInput.length() < 8 )
                {
                    System.out.println("Please enter at least 8 digits, 021432847.");
                    quit = false;
                }
        
        
        }while(quit!=true);
        return userIntInput;
    }
    

}