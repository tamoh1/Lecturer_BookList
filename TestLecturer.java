/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lecturer;


import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author R00050862
 */
public class TestLecturer {
    
    public static void main(String[] args) throws IOException{

        int userInputInt = 0;
        double userInputDouble = 0;
        String userInputString = "";
        String selection;
        boolean quit = false;
        boolean success = false;
        ArrayList<Lecturer> lecList = new ArrayList<Lecturer>();
        Scanner scanner = new Scanner(System.in);
        Validation val = new Validation();
        
        while ( quit != true)
        {
            System.out.println("Please choose one of the following:\n"
                              +"1. Add a Lecturer\n"
                              +"2. Find a Lecturer via ID number\n"
                              +"3. Add a book to the lecturers book list\n"
                              +"4. Remove a book from the lecturers book list\n"
                              +"5. Search for a book using the ISBN number\n"
                              +"6. Calculate the yearly book payment\n"
                              +"7. Output all book details to a file\n"
                              +"8. Quit Program");
            
            selection = scanner.nextLine();
            switch (selection)
            {
                case "1":       //Add a Lecturer
                    Lecturer newLec = new Lecturer();
                    //userInputString = validateStringInput(scanner, userInputString, quit, 1);
                    //newLec.setName(userInputString);
                    
                    newLec.setName(val.createName());
                    newLec.setID(val.createUniqueID());
                    
                    //userInputInt = validateIntInput(scanner, userInputInt, quit, 1);
                    //newLec.setID(userInputInt);
                    lecList.add(newLec);
                    
                    
                    
                    System.out.println("\n|---------------------------------------------|\n"
                                       +"   "+newLec.getName()+" has been added.\n"
                                       +"|---------------------------------------------|\n");
                    
                    System.out.println(newLec.getID());
                    break;
                
                case "2":       //Find a Lecturer via ID number

                    System.out.print("Please enter the lecture ID number:");
                    userInputString = scanner.nextLine();
                    
                    //userInputInt = validateIntInput(scanner, userInputInt, quit, 1);
                    success = false;
                    for(int i = 0; i<lecList.size();i++)
                    {
                        if( lecList.get(i).getID().equalsIgnoreCase(userInputString))
                            {
                                success = true;
                                System.out.println("\n|---------------------------------------------|");
                                lecList.get(i).print();
                                if( lecList.get(i).getBookList().getTotal() > 0 )
                                    {
                                        System.out.println("         ~ ~ ~       ");
                                        for( int j = 0; j<lecList.get(i).getBookList().getTotal() ;j++ )
                                        {
                                            if( lecList.get(i).getBookList().getBook(j) != null )
                                                {
                                                    System.out.println(lecList.get(i).getBookList().getBook(j));
                                                }
                                        }
                                    }
                                System.out.println("|---------------------------------------------|\n");
                            }
                    }
                    lecNotFound(success, userInputInt);
                    scanner.nextLine();
                    break;
                    
                case "3":       //Add a book to a lecturers book list
                    Book newBook = new Book();
                    userInputInt = validateIntInput(scanner, userInputInt, quit, 1);
                    scanner.nextLine();
                    success = false;
                    for(int i = 0; i<lecList.size();i++)
                    {
                        if( lecList.get(i).getID() == userInputInt)
                            {
                                success = true;
                                if( ! lecList.get(i).getBookList().isFull())
                                    {
                                        newBook = createBook(userInputString, userInputInt, userInputDouble, scanner, newBook, quit);
                                        lecList.get(i).addBook(newBook);
                                        System.out.println("\n|---------------------------------------------|"
                                                          +"\n  "+newBook.getBookName()+" has been added."
                                                          +"\n|---------------------------------------------|\n");
                                    }
                                    else
                                        {
                                            System.out.println("\n|---------------------------------------------|"
                                                      +"\n  Lecturer book list is already full.\n"
                                                      +"|---------------------------------------------|\n");
                                        }
                            }
                    }
                    lecNotFound(success, userInputInt);
                    break;
                
                case "4":       //Remove a book from a lecturers book list
                    newBook = new Book();
                    userInputInt = validateIntInput(scanner, userInputInt, quit, 1);
                    scanner.nextLine();
                    boolean success1 = false;
                    boolean success2 = true;
                    success = false;
                    for(int i = 0; i<lecList.size();i++)
                    {
                        if( lecList.get(i).getID() == userInputInt)
                            {
                                success1 = true;
                                if( !lecList.get(i).getBookList().isEmpty())
                                    {
                                        userInputInt = validateIntInput(scanner, userInputInt, quit, 2);
                                        newBook = lecList.get(i).getBookList().search(userInputInt);
                                        success = lecList.get(i).getBookList().removeBook(userInputInt);
                                        scanner.nextLine();
                                    }
                                    else
                                        {
                                            success2 = false;
                                            System.out.println("\n|---------------------------------------------|"
                                                      +"\n  Lecturer book list is already empty.\n"
                                                      +"|---------------------------------------------|\n");
                                        }
                            }
                    }
                    if ( success2 == true )
                        {
                            if( success == true )
                                {
                                    System.out.println("\n|---------------------------------------------|"
                                                        +"\n The following book has been removed:");
                                    newBook.print();
                                    System.out.println("|---------------------------------------------|\n");
                                }
                                else if ( success == false )
                                    {
                                        System.out.println("\n|---------------------------------------------|"
                                                          +"\n  No book found under that ISBN number: "+userInputInt
                                                          +"\n|---------------------------------------------|\n");
                                    }
                        }
                    lecNotFound(success1, userInputInt);
                    break;
                    
                case "5":       //Search for a book from the entire list of lecturers using the ISBN number
                    
                    userInputInt = validateIntInput(scanner, userInputInt, quit, 2);
                    scanner.nextLine();
                    success = false;
                    System.out.println("\n|---------------------------------------------|");
                    for(int i = 0; i<lecList.size();i++)
                    {
                        if(lecList.get(i).getBookList().search(userInputInt) != null )
                            {
                                success = true;
                                System.out.println(lecList.get(i).getBookList().search(userInputInt));
                            }
                    }
                    if( success == false)
                        {
                            System.out.println("  No book found under ISBN number "+userInputInt);
                        }
                    System.out.println("|---------------------------------------------|\n");
                    break;
                
                case "6":       //Calculate the yearly book payment for a lecturer
                    userInputInt = validateIntInput(scanner, userInputInt, quit, 1);
                    scanner.nextLine();
                    success = false;
                    for(int i = 0; i<lecList.size();i++)
                    {
                        if( lecList.get(i).getID() == userInputInt)
                            {
                                success = true;
                                System.out.println("\n|---------------------------------------------|");
                                lecList.get(i).print();
                                System.out.println(" Total Book List Cost: €"+lecList.get(i).getBookList().calculateYearlyBookPayment()
                                                  +"\n|---------------------------------------------|\n");
                            }
                    }
                    lecNotFound(success, userInputInt);
                    break;
                    
                case "7":       //Output all book details to a file
                    
                    try {
                            PrintStream printDetails = new PrintStream(new File("FullReport.txt"));
                            for(int i = 0; i< lecList.size();i++)
                            {
                                printDetails.println(lecList.get(i));
                                for(int j = 0; j< lecList.get(i).getBookList().getTotal();j++)
                                {
                                    printDetails.println(lecList.get(i).getBookList().getBook(j));
                                }
                                printDetails.println(" Total book list cost: €"+lecList.get(i).getBookList().calculateYearlyBookPayment());
                            }
                    }
                    catch   (IOException e) { e.printStackTrace(); }
                    
                    break;
                
                case "8":
                    
                    quit = true;
                    System.out.println( "|---------------------------------------|   \n"
                                       +"|----------  Have a nice day  ----------|   \n" 
                                       +"|---------------------------------------|   " );
                    break;    
                    
                    default : System.out.println("Please eneter a valid selection");
        
            }
        }
    }
    
    private static String validateStringInput(Scanner scanner, String userInputString, boolean quit, int option){
        quit = false;
        do{
            if( option == 1)
                {
                    System.out.print("Please enter the lecturer's name:");
                }
                else if ( option == 2)
                    {
                        System.out.print("Please enter the book name:");
                    }
                    else if( option == 3)
                        {
                            System.out.print("Enter the name of the author:");
                        }
            
            userInputString = scanner.nextLine();
            String tempHolder = userInputString.replaceAll("\\s", "");
            
            if(tempHolder.matches("[a-zA-z]+"))
                {
                    quit = true;
                }
                    else
                        {
                            System.out.println("Please enter letters only");
                        }
            
        }while( quit != true);
        return userInputString;
    }
    
    private static int validateIntInput(Scanner scanner, int userInputInt, boolean quit, int option){
        quit = false;
        do{
            if( option == 1)
                {
                    System.out.print("Enter the lecturer's ID number:");
                }
                else if( option == 2)
                    {
                        System.out.print("Enter the book's ISBN number:");
                    }
            
            while(!scanner.hasNextInt())
                {
                    System.out.println("Please enter at least 4 numbers i.e. 1267, 2634, 7523, etc...");
                    scanner.next();
                }
            userInputInt = scanner.nextInt();
            quit = true;
            if( userInputInt < 1000 )
                {
                    quit = false;
                    System.out.println("Enter at least 4 numbers");
                } 
        }while( quit != true);
        return userInputInt;
    }
    
    private static Book createBook(String userInputString, int userInputInt, double userInputDouble, Scanner scanner, Book newBook, boolean quit){
        do{
            quit = false;
            userInputString = validateStringInput(scanner, userInputString, quit, 2);
            newBook.setBookName(userInputString);
            userInputString = validateStringInput(scanner, userInputString, quit, 3);
            newBook.setBookAuthor(userInputString);
            userInputInt = validateIntInput(scanner, userInputInt, quit, 2);
            newBook.setBookISBN(userInputInt);
            do{
                System.out.print("Enter the price of the book:€");
                while(!scanner.hasNextDouble())
                    {
                        System.out.println("Please enter a valid price i.e. €24.50, €59.99, etc ...");
                        scanner.next();
                    }
                userInputDouble = scanner.nextDouble();
                if(userInputDouble > 79.99)
                    {
                        quit = false;
                        System.out.println("The maximum book price is €79.99");
                    }
                    else
                        {
                            quit = true;
                            newBook.setBookPrice(userInputDouble);
                        }
            }while(quit != true);
            
        }while(quit != true);
        scanner.nextLine();
        return newBook;
    }
    
    private static void lecNotFound( boolean success, int userInputInt){
        
        if( success == false )
                        {
                            System.out.println("\n|---------------------------------------------|"
                                              +"\n  No lecturer found under ID number: "+userInputInt
                                              +"\n|---------------------------------------------|\n");
                        }
        
    }
}
