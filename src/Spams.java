import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

public class Spams implements Iterable<Spam> {
	private Spam[] spams;
	private int position;
	
	public Spams(Scanner read,String path){
		spams=new Spam[FindSpamsLength(path)];
		ReadSpamWordsFile(read);
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
	
	private int FindSpamsLength(String path) {
		Scanner read = null;
		try{//try to read from a file
			read = new Scanner(new File(path));
			
			int size=0;
			while(read.hasNext()){//find the length of the messages array
				read.nextLine();
				size++;
			}
			read.close();
			return size;
		}
		catch(Exception e){//if the file doesn't exist, print an error message.
			System.out.println("could not find file 'spam_words.txt'");
			return 0;
		}
	}

	@Override
	public Iterator iterator() {
			return new SpamIterator(spams);
	}
}
