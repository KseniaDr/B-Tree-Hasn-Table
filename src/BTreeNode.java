public class BTreeNode {

	private int numKeys; // number of the keys in the current node
	private BTreeNode[] children; // a list that contains the childrens of the node
	private boolean leaf; // check if this node is a leaf
	private String[] keys;// a list that contains the keys of the node
	private int t;//this number determine the max number of keys and the min number of keys

	public BTreeNode(int t, BTreeNode node){
		this.t=t;
		this.children= new BTreeNode[2*t];
		this.keys=new String[2*t-1];
		children[0]=node;//add the node to be the first child in the array.
	}//close constructor

	public BTreeNode(int t){
		numKeys=0;
		this.children= new BTreeNode[2*t];
		this.keys=new String[2*t-1];
		this.t=t;
	}

	/**this function splits the node.
	 * @param childIndex-the index of the child that we want to split
	 */
	public void Split(int childIndex){
		BTreeNode y=this.children[childIndex]; 
		BTreeNode z=new BTreeNode(t);
		z.leaf=y.leaf;
		z.setNumKeys(t-1);//set the numbers of keys in the node.
		copy(y, z, t-1);// copy the keys.
		if(!y.leaf){ //copy y children, from index t to 2t, to z
			for (int i = 0; i < t; i++) {
				z.children[i]=y.children[t+i];
				y.children[t+i]=null;
			}
		}
		y.numKeys=t-1;//set the numbers of the keys in the node.
		updateNode(z, y , childIndex);//update all the nodes
	}//close split

	/**copy the keys from the node that we want to split to the new node.
	 * @param prev-the previous node
	 * @param current- the current node
	 * @param index- the max index 
	 */
	private void copy(BTreeNode  prev, BTreeNode current, int index){
		for (int i = 0 ; i < index ; i++) { //copy the keys from prev, from index t to 2t-1, to current.
			current.keys[i]=prev.keys[t+i];
			prev.keys[t+i]=null;//delete the key from the node.
			prev.numKeys--;
		}
	}//close copy
	
	/*this function is responsible to update the children and the keys in the current node that we split. 
	 * learned in class.
	 */
	private void updateNode(BTreeNode z, BTreeNode y , int childIndex){
		for(int i=this.numKeys ; i> childIndex ; i--)//move the children one step forwards
			this.children[i+1]=this.children[i];
		this.children[childIndex+1]=z;
		for(int i=this.numKeys-1; i> childIndex; i--)
			this.keys[i+1]=this.keys[i];
		if(keys[childIndex]!=null){
			int i;
			for(i= numKeys-1 ; i>= 0 && keys[childIndex].compareTo(keys[i]) < 0 ; i--)
				keys[i+1]=keys[i];
			keys[i+1]=keys[childIndex];
		}
		this.keys[childIndex]=y.keys[t-1];
		y.keys[t-1]=null;
		numKeys++;
	}//close updateNode

/**this function inserts the key in the right node, if the node is full
 * the function will split the node with split function.
 * @param key-the key we want to insert.
 */
	public void insertNonFull(String key){
		int i;
		if(leaf==true){
			for( i= numKeys-1 ; i>= 0 && key.compareTo(keys[i]) < 0 ; i--)//find the right index to insert key
				keys[i+1]=keys[i];
		keys[i+1]=key;
		numKeys++;
		}
		else{//if it's not a leaf
			for( i= numKeys-1 ; i>= 0 && key.compareTo(keys[i]) < 0 ; i--);//find the right index
				i++;
				if(children[i].numKeys==2*t-1){//check if the node is full
					Split(i);//split the node
					if(key.compareTo(keys[i])>0)
						i++;
				}
				children[i].insertNonFull(key);
		}
	}//close insertNonFull
	
	/*returns the number of the children of the node
	 */
	public int numOfChildern(){
		int i=0;
		while(this.children[i]!=null)
			i++;
		return i;
	}
	
	/**search the key in the node, learned in class
	 * @param key- the key that we want to find
	 * @return true if the key exists in the node, false if not
	 */
	public boolean search(String key) {
		int i;
		for (i = 0; i < numKeys && keys[i].compareTo(key) < 0 ; i++);
		if(i <numKeys && keys[i].equals(key))
			return true;
		else if(leaf)
			return false;
		else
			return children[i].search(key);//Recursive search
	}
	
	/**compares two nodes and checks if there equal.
	 * @param node-the node that we compare with the current node. 
	 * @return true if it's the same node, false if not
	 */
	public boolean equals (BTreeNode node){
		return (this.numKeys==node.numKeys && this.leaf==node.leaf && this.children.equals(node.children) && this.keys.equals(node.keys) && this.t==node.t);
	}

	public int getNumKeys() {
		return numKeys;
	}

	public void setNumKeys(int numKeys) {
		this.numKeys = numKeys;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public BTreeNode[] getChildren() {
		return children;
	}

	public void setChildren(BTreeNode[] children) {
		this.children = children;
	}

	public String[] getKeys() {
		return keys;
	}

	public void setKeys(String[] keys) {
		this.keys = keys;
	}

	public boolean leaf(){
		return leaf;
	}

	public int getT() {
		return t;
	}

}