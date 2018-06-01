
public class HashList {

	HashListElement start;
	HashListElement end;
	private int size;

	public HashList(){
		start=null;
		end=null;
		size=0;
	}


	public void insert(String data) {
		HashListElement element = new HashListElement(data);   
		if(start == null) {
			start = element;
			end = start;
			size++;
		}
		else {
			if(contains(element))
				element.setCounter();
			else{
			end.setNext(element);
			end = element;
			size++;
			}
		}
	}

	public boolean contains(HashListElement element){
		HashListElement temp = start;
		for(int x = 0; x < size; x++){
			if (temp.getData() == element.getData())
				return true;
			temp=temp.getNext();
		}
		return false;
	}
}
