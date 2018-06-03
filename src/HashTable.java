
public class HashTable {

	private HashList[] table;
	private int size;

	public HashTable(int m){
		size=m;
		table= new HashList[m];
	}

	/**this function is responsible to maps keys of a message word 
	 * by the ascii value of the given string.
	 * @param word- the string that we want to map.
	 * @return the index that represent the place of the word in the map
	 */
	private int hashFunction(String word){
		int sum=0;
		for(int i=0; i<word.length();i++)// counting the ascii values of every char in the word
			sum = sum + ((int) word.charAt(i));
		return sum%size;
	}
	
	/**this function is responsible for inserting the words of the message in the hash table
	 * @param word- the word that we want to insert.
	 */
	public void insert(String word){
		table[hashFunction(word)].insert(word);
	}
	
	public int search(String key){
		
	}
}
