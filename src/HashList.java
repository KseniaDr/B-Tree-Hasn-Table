
public class HashList {

	HashListElement start;
	HashListElement end;
	private int size;

	public HashList(){
		start=null;
		end=null;
		size=0;
	}

	/**adds a new string to the list of the message list
	 * @param data the word that we want to add
	 */
	public void add(String data) {
		HashListElement element = new HashListElement(data);   
		if(!contains(element)){//if the element doesn't exists in the list
			if(start == null) {
				start = element;
				end = start;
				size++;
			}
			else {
				end.setNext(element);
				end = element;
				size++;
			}
		}
		else{
			HashListElement temp=start;
			while(temp!=null  && !element.getData().equals(temp.getData()))
				temp=temp.getNext();
			temp.setCounter();
		}
	}

	/**checks if the element already exists in the list 
	 * @param element-the element that we check
	 * @return true if the element exists in the list, false if not
	 */
	public boolean contains(HashListElement element){
		HashListElement temp = start;
		for(int x = 0; x < size; x++){
			if (temp.getData().equals(element.getData()))
				return true;
			temp=temp.getNext();
		}
		return false;
	}
}
