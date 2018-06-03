import java.util.Iterator;

public class Spam implements Iterator<Spam> {

	private String spamWord;
	private String percentageOfSpam;
	
	public Spam(String spamWord,String percentageOfSpam){
		this.setPercentageOfSpam(percentageOfSpam);
		this.setSpamWord(spamWord);
	}

	public String getSpamWord() {
		return spamWord;
	}

	public void setSpamWord(String spamWord) {
		this.spamWord = spamWord;
	}

	public String getPercentageOfSpam() {
		return percentageOfSpam;
	}

	public void setPercentageOfSpam(String percentageOfSpam) {
		this.percentageOfSpam = percentageOfSpam;
	}
	
	public String toString(){
		return "Spam word : "+ this.spamWord + " , percentage of spam : " +this.percentageOfSpam;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Spam next() {
		// TODO Auto-generated method stub
		return null;
	}
}
