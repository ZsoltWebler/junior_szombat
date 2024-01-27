package aFotokollekcio;

public class PhotoNotFoundException extends RuntimeException {

	public PhotoNotFoundException(String msg, String title) {
		super(msg + title);
	
	}

}
