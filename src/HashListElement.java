
public class HashListElement {

	HashListElement next;
	String data;
	int counter;
	
	public HashListElement(String data){
		this.data=data;
		counter=1;
	}
	
	public void setNext(HashListElement element){
		next=element;
	}
	
	public HashListElement getNext(){
		return next;
	}
	
	public int getConter(){
		return counter;
	}
	
	public void setCounter(){
		counter++;
	}
	
	public String getData(){
		return data;
	}
}
