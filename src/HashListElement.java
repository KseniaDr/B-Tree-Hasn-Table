
public class HashListElement {

	HashListElement next;
	String data;
	
	public HashListElement(String data){
		this.data=data;
	}
	
	public void setNext(HashListElement element){
		next=element;
	}
	
	public HashListElement getNext(){
		return next;
	}
}
