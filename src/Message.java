
public class Message {

	private String nameOfTheDeliver;
	private String nameOfTheReciever;
	private String textBody;
	private HashTable table;
	private String [] parts;
	
	public Message(String nameOfTheDeliever,String nameOfTheReciever,String textBody){
		this.setNameOfTheDeliever(nameOfTheDeliever);
		this.setNameOfTheReciever(nameOfTheReciever);
		this.setTextBody(textBody);
		parts=textBody.split(" ");
	}

	public String getNameOfTheDeliever() {
		return nameOfTheDeliver;
	}

	public void setNameOfTheDeliever(String nameOfTheDeliever) {
		this.nameOfTheDeliver = nameOfTheDeliever;
	}

	public String getNameOfTheReciever() {
		return nameOfTheReciever;
	}

	public void setNameOfTheReciever(String nameOfTheReciever) {
		this.nameOfTheReciever = nameOfTheReciever;
	}

	public String getTextBody() {
		return textBody;
	}

	public void setTextBody(String textBody) {
		this.textBody = textBody;
	}
	
	public String toString(){
		return "The name of the deliver : "+this.nameOfTheDeliver+ " , The name of the reciever : " + this.nameOfTheReciever + " ,\nThe body message : " +this.textBody;
	}
	
	/**the function creates a hash table for the message and inserts the body of the message into the table.
	 * @param m-the size of the table.
	 */
	public void createHashTable(int m){
		table=new HashTable(m);
		for(int i=0 ; i < parts.length ; i++){
			table.insert(parts[i]);
		}
	}
	
	
}
