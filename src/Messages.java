
import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

public class Messages implements Iterable<Message> {

	private Spams spams;
	private Message[] messages; 

	public Messages(){}

/**find the length of the messages file
 * @param path-the path of the file
 * @return the size of the messages array
 */
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
			read.close();
			return size+1;
		}
		catch(Exception e){//if the file doesn't exist, print an error message.
			System.out.println("could not find file 'messages.txt'");
			return 0;
		}
	}

/**the iterator
 */
	public Iterator<Message> iterator() {
		return new MessageIterator(messages);
	}

	/**this function is responsible for opening the file.
	 * @param friendsList-the list of friends.
	 */
	public void generateMessages(String path) {
		Scanner read = null;
		try{//try to read from a file
			read = new Scanner(new File(path));
			read.nextLine();//the first line is a blank
			messages=new Message[FindMessagesLength(path)];
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
		int i=0;
		while(read.hasNext()){ //while there is elements in the file.
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
			nameOfTheDeliver=""; nameOfTheReceiver=""; bodyMessage="";
		}
	}

/**find the spams messages from all of the messages.
 * @param path-the path of the spam file
 * @param btree- the friend tree
 * @return a string of the numbers of the spam messages.
 */
	public String findSpams(String path, BTree btree) {
		Scanner read1 = null;
		try{//try to read from a file
			read1 = new Scanner(new File(path));
			spams= new Spams(read1,path);
			Iterator<Message> itrMsg=iterator();
			return findSpams(btree, itrMsg);
		}
		catch(Exception e){//if the file doesn't exist, print an error message.
			System.out.println("could not find file 'spam_words.txt'");
			return null;
		}		
	}

	public void createHashTables(String string) {
			try{
		int sizeTable=Integer.parseInt(string);
		for(int i=0 ; i < messages.length ; i++)
			messages[i].createHashTable(sizeTable);
			}
			catch(RuntimeException e){
				System.err.println("the input must be a number.");
		}
	}

	/**a function that finds the spam messages and makes a string that contains the index of the message
	 * @param btree-the friend tree
	 * @param itrMsg- the message iterator
	 * @return the string that contains the spam messages indexes.
	 */
	private String findSpams(BTree btree, Iterator<Message> itrMsg){
		int i=0;
		String spamMsg="";
		while(itrMsg.hasNext()){//check all the messages that was sent
			Message m=itrMsg.next();
			String friend= m.getNameOfTheDeliever() + " & " + m.getNameOfTheReciever();
			if(!btree.search(friend)){//if the deliver and the receiver are not friends
				Iterator<Spam> itrSpm=spams.iterator();
				while(itrSpm.hasNext()){//check if there are spam words in the message
					Spam s=itrSpm.next();
					int num=m.getTable().search(s.getSpamWord());//return the number of time that the spam words appears in the message
					double prec=((double)(num*100))/((double)m.getParts().length);//the percent of the spam word in the message
					if(prec > s.getPercentageOfSpam()){
						spamMsg=spamMsg + i + ",";	
						break;
					}
				}//close second while
			}
			i++;
		}//close first while
		return spamMsg.substring(0, spamMsg.length()-1);
	}//close findSpams
}
