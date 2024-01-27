package aFotokollekcio;

public enum Quality {
	
	NO_STAR(0),
	ONE_STAR(1),
	TWO_STAR(2);
		
	private int csillag;

	private Quality(int csillag) {
		this.csillag = csillag;
	}

	public int getCsillag() {
		return csillag;
	}  

	
}
