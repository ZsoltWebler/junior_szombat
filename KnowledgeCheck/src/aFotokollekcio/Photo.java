package aFotokollekcio;

public class Photo implements Qualified {
	
	private String title;
	private Quality QA;
	
	public Photo(String title) {
		this.title = title;
		this.QA = Quality.NO_STAR;
		
	}

	public Photo(String title, Quality qA) {
		this.title = title;
		this.QA = qA;
	}

	@Override
	public Quality getQuality() {
		return QA;
	}

	@Override
	public void setQuality(Quality qA) {
		this.QA = qA;
		
	}

	public String getTitle() {
		return title;
	}
	
	
	
	

}
