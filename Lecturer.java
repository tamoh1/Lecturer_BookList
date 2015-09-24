package lecturer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Student Name: Thomas O Halloran
 * Student Number: R00050862
 * Email: Thomas.OHalloran@mycit.ie
 * Subject : OOP1
 */
public class Lecturer {

    private String name;
    private String ID;
    private final int MAXNOOFBOOKS = 15;
    private BookList newBookList = new BookList(MAXNOOFBOOKS);
    
    public Lecturer () {}
    
    public Lecturer (String lecName, String lecID)
        {
            name = lecName;
            ID = lecID;
        }
    
    public void setName( String lecName)
    {
        name = lecName;
    }
    
    public void setID( String lecID)
    {
        ID = lecID;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getID()
    {
        return ID;
    }
    
    public void addBook ( Book newBook )
    {
        newBookList.add(newBook);
    }
    
    public void removeBook ( int i )
    {
        newBookList.remove(i);
    }
    
    public BookList getBookList()
    {
        return newBookList;
    }
    
    public String toString()
    {   
        return " Lecture Name: "+name
              +"\n Lecture ID  : "+ID;
    }
    
    public void print()
    {
        System.out.println(toString());
    }
}
