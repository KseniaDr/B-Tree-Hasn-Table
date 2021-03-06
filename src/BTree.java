
import java.io.File;
import java.util.Scanner;

public class BTree {

	private int tVal;
	private int max; // the maximum degree of the node
	private BTreeNode root;// the root of the tree

	public BTree(String t) {
		try{//check if 't' can be cast into an integer
			tVal=Integer.parseInt(t);
			max=this.tVal*2-1;
			root = new BTreeNode(tVal);
			root.setLeaf(true);
		}
		catch(RuntimeException e){
			System.err.println("the input must be a number.");
		}
	}

	/**this function read the friend file and creates a B-Tree.
	 * @param path-the path of the file.
	 */
	public void createFullTree(String path) {
		String friends=openFile(path);
		String [] parts=friends.split(",");//split the string into an array.
		int i=0;
		while(i<parts.length){
			insert(parts[i]);
			i++;
		}	
	}//close  createFullTree

	/**this function is responsible for opening the file.
	 * @param friendsList-the list of friends.
	 */
	private String openFile(String path){
		Scanner read = null;
		try{//try to read from a file
			read = new Scanner(new File(path));
			return readFile(read);
		}
		catch(Exception e){//if the file doesn't exist, print an error message.
			System.out.println("could not find file");
		}
		return "";
	}//close openFile

	/**this function is responsible for making a string from the file.   
	 * @param read- the opened file.
	 * @param friendsList- the list of friends.
	 * @return the String of the file
	 */
	private String readFile(Scanner read){
		String temp="";
		while(read.hasNext()){//while there is elements in the file.
			temp=temp +read.nextLine() + ",";
		}
		return temp;
	}//close readFile

	/**this function is responsible for inserting an object to the B-tree.
	 * @param friend-the couple of friends that we want to insert.
	 */
	public void insert(String friend) {
		if(root.getNumKeys()==max){//if the root is full 
			BTreeNode s=new BTreeNode(tVal, root);//create a new root
			root=s;
			s.setLeaf(false);//s is not  a leaf
			s.setNumKeys(0);
			s.Split(0);//split s.
			s.insertNonFull(friend);
		}
		else{
			root.insertNonFull(friend);
		}
	}//close insert
	
	/**this function responsible for searching the key in the tree, if the key is in the tree will return true
	 * @param key-the key we want to find
	 * @return true if the key is in the tree, false if the key is not in the tree
	 */
	public boolean search(String key){
		int secName = key.indexOf("&")+2; // find the first letter in the second name
		String key2=key.substring(secName) + " & " + key.substring(0, secName-3);
		if(root!=null){
			return root.search(key) || root.search(key2);
		}
		return false;
	}

	/**this function scans the tree and prints the tree nodes horizontally,
	 * by inserting the nodes into a queue and working on one node each time, after printing the node the queue
	 * will dequeue the node from the queue.
	 * @param q-the queue of the nodes.
	 * @return-the horizontally scanned string of the tree.
	 */
	public String BFS(Queue q, String ans){
		while(!q.isEmpty()){//while the queue is not empty
			QNode d=q.dequeue();
			BTreeNode node=d.getNode();
			ans=ans+d.getData();
			if(!node.isLeaf()){
				for(int i=0; i<node.getChildren().length ; i++){
					if(node.getChildren()[i]!=null){
						q.enqueue(node.getChildren()[i]);
						if(node.numOfChildern()-1!=i)
							q.getLast().setData("|");// '|' separation between two nodes that have a common parent.
						q.getLast().setHeight(d.getHeight()+1);//add height to the node
						q.getLast().setFather(node);//add the father of the node
					}
				}
				if(q.getFirst()!=null && q.getFirst().getHeight()!=d.getHeight())//if the height of the nodes changed 
					ans=ans+"#"; // '#' separation between levels of the tree
			}
			if(q.getFirst()!=null && d.getFather()!=null && !q.getFirst().getFather().equals(d.getFather()) && d.getHeight()==q.getFirst().getHeight())//if the father of the node is different 
				ans=ans+"^";// '^' separation between nodes at the same level that do not have a common father
		}
		return ans;
	}

	/**makes a string from the B-Tree by using BFS function.
	 */
	public String toString(){
		Queue q = new Queue();
		q.enqueue(root);
		q.getLast().setHeight(0);
		String ans="";
		ans=BFS(q, ans);
		return ans;
	}//close toString
}