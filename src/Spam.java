
public class Spam{

	private String spamWord;
	private double percentageOfSpam;
	
	public Spam(String spamWord,String percentageOfSpam){
		this.spamWord=spamWord;
		try{
			this.percentageOfSpam=Double.parseDouble(percentageOfSpam);//makes a number from the string
		}
		catch(RuntimeException e){
			System.err.println("the percentage must be a number.");
		}
	}

	public String getSpamWord() {
		return spamWord;
	}

	public double getPercentageOfSpam() {
		return percentageOfSpam;
	}
	
	public String toString(){
		return "Spam word : "+ this.spamWord + " , percentage of spam : " +this.percentageOfSpam;
	}

}
