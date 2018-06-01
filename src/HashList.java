
public class HashList {

	HashListElement start;
	
	public HashList(){
		start=null;
	}
	
	public void insert(String data){
		HashListElement element = new HashListElement(data);        
		if(start == null) 
			start = element;
		else
			start.setNext(element);
	}
}
