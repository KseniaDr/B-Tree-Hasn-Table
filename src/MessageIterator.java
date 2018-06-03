import java.util.Iterator;

public class MessageIterator implements Iterator<Message>{
	private int  position;
	private Message [] msg;
	
	public MessageIterator(Message [] message){
		position=-1;
		msg=message;
				}
	public boolean hasNext() {
		return next() != null; 
	}

	public Message next() {
		position++;
		if(position < msg.length)
			return msg[position];
		else return null;
	}
}

