import java.awt.event.TextEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

public class Messages implements Iterable {

	private Message[] messages;
	private Spam[] spams;

	public Messages(){
		//messages= new Message[FindMessagesLength(String path)];
		//spams= new Spam[FindSpamsLength(String path)];
	}

	private int FindSpamsLength(String path) {
		Scanner read = null;
		try{//try to read from a file
			read = new Scanner(new File(path));
			
			int size=0;
			while(read.hasNext()){//find the length of the messages array
				String temp=read.nextLine();
				size++;
			}
			return size;
		}
		catch(Exception e){//if the file doesn't exist, print an error message.
			System.out.println("could not find file 'spam_words.txt'");
			return 0;
		}
	}
	
	private int FindMessagesLength(String path){
		Scanner read = null;
		try{//try to read from a file
			read = new Scanner(new File(path));
			
			int size=0;
			while(read.hasNext()){//find the length of the messages array
				String temp=read.nextLine();
				if(temp.equals("#"))
					size++;
			}
			return size+1;
		}
		catch(Exception e){//if the file doesn't exist, print an error message.
			System.out.println("could not find file 'messages.txt'");
			return 0;
		}
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	/**this function is responsible for opening the file.
	 * @param friendsList-the list of friends.
	 */
	public void generateMessages(String path) {
		Scanner read = null;
		try{//try to read from a file
			read = new Scanner(new File(path));
			messages= new Message[FindMessagesLength(path)];
			ReadMessagesFile(read);
		}
		catch(Exception e){//if the file doesn't exist, print an error message.
			System.out.println("could not find file 'messages.txt'");
		}
	}

	/**this function is responsible for inserting the friends in a linked list.   
	 * @param read- the opened file.
	 * @param friendsList- the list of friends.
	 */
	private void ReadMessagesFile(Scanner read){
		String nameOfTheDeliver="",nameOfTheReceiver="",bodyMessage="",bodyMessageNext="";
		int indexPoints,i=0,temp=0;
		while(read.hasNext()){ //while there is elements in the file.
			if(temp==0)
				read.nextLine();
			temp++;
			String tempDeliver=read.nextLine();
			nameOfTheDeliver= tempDeliver.substring(tempDeliver.indexOf(":")+1, tempDeliver.length()); //the name of the deliver
			String tempReceiver=read.nextLine();
			nameOfTheReceiver= tempReceiver.substring(tempReceiver.indexOf(":")+1, tempReceiver.length()); //the name of the receiver
			bodyMessage=read.nextLine();
			if(read.hasNext())
				bodyMessageNext = read.nextLine();
			while(read.hasNext() && (!bodyMessageNext.equals("#"))){ // the body of the massage
				bodyMessage=bodyMessage+"\n"+bodyMessageNext;
				bodyMessageNext=read.nextLine();
			}
			this.messages[i]=new Message(nameOfTheDeliver,nameOfTheReceiver,bodyMessage);//insert the message in to the array.
			i++;
			nameOfTheDeliver="";
			nameOfTheReceiver="";
			bodyMessage="";
		}
	}

	public String findSpams(String path, BTree btree) {
		Scanner read = null;
		try{//try to read from a file
			read = new Scanner(new File(path));
			spams= new Spam[FindSpamsLength(path)];
			ReadSpamWordsFile(read);
		}
		catch(Exception e){//if the file doesn't exist, print an error message.
			System.out.println("could not find file 'spam_words.txt'");
		}		
		return null;
	}

	private void ReadSpamWordsFile(Scanner read) {
		String allLine ="", spamWord="",percentageOfSpam="";
		int indexSpace=0,i=0;
		
		while(read.hasNext()){ //while there is elements in the file.
			allLine=read.nextLine();
			indexSpace=allLine.indexOf(" ");
			spamWord=allLine.substring(0,indexSpace);
			percentageOfSpam=allLine.substring(indexSpace+1);
			spams[i]=new Spam(spamWord,percentageOfSpam);//insert the spam word in to the array.
			i++;
			percentageOfSpam="";
			spamWord="";
		}
	}

	public void createHashTables(String string) {
		try{
			int sizeTable=Integer.parseInt(string);
			//for(int i=0 ; i < messages.length ; i++)
				//messages[i].createHashTable(sizeTable);
			
		}
		catch(RuntimeException e){
			System.err.println("the input must be a number.");
		}
	}//close createHashTables
	
}
