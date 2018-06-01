
public class QNode {
	
	private String data;
	private BTreeNode node;
	private BTreeNode father;
	QNode next;
	QNode prev;
	int height;
	
	public QNode(String data, BTreeNode node){
		this.node=node;
		this.data=data;
		this.setFather(null);
		next=null;
		prev=null;
		height=0;
	}
	
	public void setNext(QNode next){
		this.next = next;
	}
	
	public void setPrev(QNode prev){
		this.prev=prev;
	}
	
	public String getData(){
		return data;
	}
	
	public void setData(String value){
		data=data+value;
	}
	
	public BTreeNode getNode(){
		return node;
	}
	
	public int getHeight(){
		return height;
	}
	
	public void setHeight(int h){
		height=h;
	}

	public BTreeNode getFather() {
		return father;
	}

	public void setFather(BTreeNode father) {
		this.father = father;
	}
}
