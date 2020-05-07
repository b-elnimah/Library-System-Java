package backgroud;

import java.io.Serializable;

public class Periodical extends Borrowable implements Serializable {
	
	private String issn;
	private String title;
	private int issue;
	private int year;
	
	public Periodical(String callNumber, String issn, String title, int issue, int year) {
		super(callNumber);
		this.issn = issn;
		this.title = title;
		this.issue = issue;
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String getISEBN_Issn() {
		return issn;
	}
	
	
}
