package lecturer;

/**
 *
 * @author R00050862
 */
public class Book {
    
    private String title;
    private int ISBN;
    private String author;
    private double price;
    
    public Book () {}
    
    public Book (String bookName, int bookCode, String bookAuthor, double bookPrice)
    {
        title = bookName;
        ISBN = bookCode;
        author = bookAuthor;
        price = bookPrice;
    }
    
    public void setBookName( String bookName)
    {
        title = bookName;
    }
    
    public void setBookISBN( int bookCode)
    {
        ISBN = bookCode;
    }
    
    public void setBookAuthor( String bookAuthor)
    {
        author = bookAuthor;
    }
    
    public void setBookPrice( double bookPrice)
    {
        price = bookPrice;
    }
    
    public String getBookName( )
    {
        return title;
    }
    
    public int getBookISBN( )
    {
        return ISBN;
    }
    
    public String getBookAuthor( )
    {
        return author;
    }
    
    public double getBookPrice( )
    {
        return price;
    }
    
    public String toString()
    {
        return " Title  : "+title
              +"\n ISBN   : "+ISBN
              +"\n Author : "+author
              +"\n Price  : €"+price;
    }
    
    public void print()
    {
        System.out.println(toString());
    }
    
}
