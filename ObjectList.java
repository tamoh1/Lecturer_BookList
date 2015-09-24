/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lecturer;

import java.util.Arrays;

/**
 *
 * @author R00050862
 */
public abstract class ObjectList {
    
    private int total;
    private Object[] objectList;
    
    public ObjectList () {}
    public ObjectList (int listTotal) 
    {
        total = 0;
        objectList = new Object[listTotal];
    }
    
    public boolean add(Object obj)
    {
        boolean valid = false;
        total++;
        for( int i = 0; i<objectList.length; i++)
        {
            if(  objectList[i] == null )
            {
                objectList[i] = obj;
                i = objectList.length;
                valid = true;
            }
        }
        return valid;
    }
    
    public boolean remove(int i)
    {
        boolean valid = false;
        total--;
        for( int j = i; j<objectList.length-1; j++)
        {
            objectList[j] = objectList[j+1];
            valid = true;
        }
        objectList[objectList.length-1] = null;
        return valid;
    }
    
    public boolean isFull()
    {
        boolean valid = false;
        if(  total == 15)
            {
                valid = true;
            }
        return valid; 
    }
    
    public boolean isEmpty()
    {
        boolean valid = false;
        if(  total == 0)
            {
                valid = true;
            }
        return valid;  
    }
    
    public Object getObject(int i)
    {
        return objectList[i];
    }
    
    public int getTotal()
    {
        return total;
    }
}
