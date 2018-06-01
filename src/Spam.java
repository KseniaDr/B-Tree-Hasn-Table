
public class Spam {

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
}
