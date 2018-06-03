
public class Queue {

	private QNode first;
	private QNode last;
	private int size;

	public Queue(){
		first=null;
		last=null;
		size=0;
	}

	/**the function insert a B-Tree node to the queue
	 * @param node the node that we want to insert.
	 */
	public void enqueue(BTreeNode node){
		String data=nodeToString(node);
		QNode oldlast = last;
        last = new QNode(data, node);
        last.setNext(null);
        last.setPrev(oldlast);
        if (isEmpty())
        	first = last;
        else           
        	oldlast.setNext(last);
        size++;
	}

	/**the function removes a node from the queue
	 * @return the node that has been removeds
	 */
	public QNode dequeue(){
        if (isEmpty()) {
        	System.out.println("The queue is empty!");
        	return null;
        }
        QNode node = first;
        first = first.next;
        if(first!=null)
        	first.setPrev(null);
        size--;
        return node;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	/**this function makes a string from all of the keys in the node
	 * @return the string that contains the keys
	 */
	private String nodeToString(BTreeNode node){
		String temp="";
		for(int i=0 ; i < node.getNumKeys() ; i++ ){
			if(i+1==node.getNumKeys())
    			temp=temp+node.getKeys()[i];
    		else
    		temp=temp+node.getKeys()[i]+",";
		}
		return temp;
	}
	
	public QNode getLast(){
		return last;
	}
	
	public QNode getFirst(){
		return first;
	}
	
	public int getSize(){
		return size;
	}
}
