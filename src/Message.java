
public class Message {

	private String nameOfTheDeliver;
	private String nameOfTheReciever;
	private String textBody;
	private HashTable table;
	
	public Message(String nameOfTheDeliever,String nameOfTheReciever,String textBody){
		this.setNameOfTheDeliever(nameOfTheDeliever);
		this.setNameOfTheReciever(nameOfTheReciever);
		this.setTextBody(textBody);
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
	
	public HashTable createHashTable(int m){
		return table=new HashTable(m);
	}
}
