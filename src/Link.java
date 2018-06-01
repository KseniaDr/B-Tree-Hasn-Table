
public class Link {
	
	private String data;
    private Link next;
 
    /*  Constructor  */
    public Link()
    {
    	next = null;
        data = "";
    }    
    /*  Constructor  */
    public Link(String d,Link n)
    {
        data = d;
        next = n;
    }    
    /*  Function to set link to next Node  */
    public void setNext(Link n)
    {
    	next = n;
    }    
    /*  Function to set data to current Node  */
    public void setData(String d)
    {
        data = d;
    }    
    /*  Function to get link to next node  */
    public Link getNext()
    {
        return next;
    }    
    /*  Function to get data from current Node  */
    public String getData()
    {
        return data;
    }
}
