package lecturer;

/**
 *
 * @author R00050862
 */
public class BookList extends ObjectList {
    
    public BookList () {}
    
    public BookList (int listTotal)
    {
        super(listTotal);
        //super.objectList = new Book[listTotal];
    }
    
    public Book getBook(int bookPosition)
    {
        return (Book) super.getObject(bookPosition);
    }
    
    public Book search(int isbnNumber)
    {
        for(int i = 0; i<super.getTotal(); i++)
        {
            if( this.getBook(i).getBookISBN() == isbnNumber )
                {
                    return (Book) this.getBook(i);
                }
        }
        return null;
    }
    
    public boolean removeBook(int isbnNumber)
    {
        boolean valid = false;
                    for(int i = 0; i<super.getTotal(); i++)
                    {
                        if( this.getBook(i).getBookISBN() == isbnNumber )        
                            {
                                super.remove(i);
                                i = super.getTotal();
                                valid = true;
                            }
                    }
        return valid;
    }
    
    public double calculateYearlyBookPayment()
    {
        double total = 0;
        for(int i = 0; i<super.getTotal(); i++)
        {
                    total += this.getBook(i).getBookPrice();       
        }
        
        return total;
    }
}
