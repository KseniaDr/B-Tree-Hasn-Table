import java.util.Iterator;

public class SpamIterator implements Iterator<Spam>{
	private int  position;
	private Spam [] spams;

	public SpamIterator(Spam [] spams){
		position=-1;
		this.spams=spams;
	}
	public boolean hasNext() {
		return next() != null; 
	}
	public Spam next() {
		position++;
		if(position < spams.length)
			return spams[position];
		else return null;
	}
}
