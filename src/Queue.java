
public class Queue {

	private QNode first;
	private QNode last;
	private int size;

	public Queue(){
		first=null;
		last=null;
		size=0;
	}

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
}
