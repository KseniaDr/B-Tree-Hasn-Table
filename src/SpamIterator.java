import java.util.Iterator;

public class SpamIterator implements Iterator<Spam>{
	private int  position;
	private Spam [] spams;

	public SpamIterator(Spam [] spams){
		position=-1;
		this.spams=spams;
	}
	
	/**checke if there is more spams in the array
	 */
	public boolean hasNext() {
		return (position+1) < spams.length; 
	}
	
	/**retuurn the next spam word
	 */
	public Spam next() {
		position++;
		if(position < spams.length)
			return spams[position];
		else return null;
	}

}
