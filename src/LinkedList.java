public class LinkedList
{
	protected Link start;
	protected Link end ;
	public int size ;

	/*  Constructor  */
	public LinkedList(){
		start = null;
		end = null;
		size = 0;
	}
	/*  Function to check if list is empty  */
	public boolean isEmpty(){
		return start == null;
	}
	/*  Function to get size of list  */
	public int getSize(){
		return size;
	}    


	/*  Function to insert an element at position  */
	public void insertAtPos(String val , int pos){
		Link nptr = new Link(val, null);                
		Link ptr = start;
		pos = pos - 1 ;
		for (int i = 1; i < size; i++) 
		{
			if (i == pos) 
			{
				Link tmp = ptr.getNext() ;
				ptr.setNext(nptr);
				nptr.setNext(tmp);
				break;
			}
			ptr = ptr.getNext();
		}
		size++ ;
	}
	/*  Function to delete an element at position  */
	public void deleteAtPos(int pos){        
		if (pos == 1) 
		{
			start = start.getNext();
			size--; 
			return ;
		}
		if (pos == size) 
		{
			Link s = start;
			Link t = start;
			while (s != end)
			{
				t = s;
				s = s.getNext();
			}
			end = t;
			end.setNext(null);
			size --;
			return;
		}
		Link ptr = start;
		pos = pos - 1 ;
		for (int i = 1; i < size - 1; i++) {
			if (i == pos) {
				Link tmp = ptr.getNext();
				tmp = tmp.getNext();
				ptr.setNext(tmp);
				break;
			}
			ptr = ptr.getNext();
		}
		size-- ;
	}    
	/*  Function to display elements  */
	public void display(){
		System.out.print("\nSingly Linked List = ");
		if (size == 0) {
			System.out.print("empty\n");
			return;
		}    
		if (start.getNext() == null) {
			System.out.println(start.getData() );
			return;
		}
		Link ptr = start;
		System.out.print(start.getData()+ "->");
		ptr = start.getNext();
		while (ptr.getNext() != null){
			System.out.print(ptr.getData()+ "->");
			ptr = ptr.getNext();
		}
		System.out.print(ptr.getData()+ "\n");
	}

	public String getAt(int index){
		if (index < 0 || index > this.size) {
			return null;
		}

		if (index == 0) {
			return this.start.getData();
		}

		Link singly = start.getNext();

		for (int i = 1; i < index; i ++) {

			if (singly.getNext() == null) {
				return null;
			}       

			singly = singly.getNext();      
		}
		return singly.getData(); 
	}
	public void insert(String temp) {
		Link nptr = new Link(temp,null);    
		size++ ;    
		if(start == null) {
			start = nptr;
			end = start;
		}
		else {
			end.setNext(nptr);
			end = nptr;

		}

	}
}