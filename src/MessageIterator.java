import java.util.Iterator;

public class MessageIterator implements Iterator<Message>{
	private int  position;
	private Message [] msg;

	public MessageIterator(Message [] message){
		position=-1;
		msg=message;
	}
	/**checks if the there are more messages
	 */
	public boolean hasNext() {
		return (position+1)<msg.length; 
	}

	/**returns the next message in the array
	 */
	public Message next() {
		position++;
		if(position < msg.length)
			return msg[position];
		else return null;
	}
}

