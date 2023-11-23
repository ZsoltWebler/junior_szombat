package aFotokollekcio;

import java.util.List;

import java.util.ArrayList;

public class PhotoCollection {

	private static void addPhoto(Photo photo, List<Photo> photos) {	
		photos.add(photo);
	}
	
	private static void listPhotos(List<Photo> photos) {
	
		for ( Photo photo : photos) {
			  System.out.print(photo.getTitle() + " ");
			  switch (photo.getQuality()) {
			    case NO_STAR: 			
				     break;
			    case ONE_STAR: 
			    	 System.out.print("*");
			         break;
			    case TWO_STAR: 
			    	 System.out.print("**");
		             break;
			    default:
				     break;
			  }
			  System.out.println();
		}
	}
		
	
	private static void starPhoto(String photoTitle,Quality qA, List<Photo> photos ) throws PhotoNotFoundException {
	 	
	  try {
		boolean isNotFound = true;  
		for (Photo photo: photos) {
			if (photo.getTitle() == photoTitle ) {
				photo.setQuality(qA);
				isNotFound = false; // mert megtalalta
			}
		} 
		if (isNotFound) {
			throw new PhotoNotFoundException("In the list, there is no photo with this title: ", photoTitle );	
		}
	  } catch (PhotoNotFoundException e) {
		System.out.println(e.getMessage());
	  }	
	}
	
	private static int numberOfStars(List<Photo> photos) {
		int nrOfStarts = 0;
		
		for (Photo photo: photos) {
			nrOfStarts += photo.getQuality().getCsillag();
		}
		
		return nrOfStarts;
	}

	public static void main(String[] args) {
		
		Photo photo = new Photo("Elso_kep");
		Photo photo1 = new Photo("Masodik_kep", Quality.ONE_STAR);
		Photo photo2 = new Photo("Harmadik_kep", Quality.TWO_STAR);
//		Photo photo3 = new Photo("X_kep", Quality.TWO_STAR);
		
		List<Photo> photos = new ArrayList<>();
		
		addPhoto(photo, photos);
		addPhoto(photo1, photos);
		addPhoto(photo2, photos);
//		addPhoto(photo3, photos);
		listPhotos(photos);
		
		System.out.println();
		photo1.setQuality(Quality.NO_STAR);
		photo2.setQuality(Quality.NO_STAR);
		listPhotos(photos);
		
		System.out.println();
		starPhoto("Elso_kep", Quality.ONE_STAR, photos);
		starPhoto("Masodik_kep", Quality.TWO_STAR, photos);
		starPhoto("X_kep", Quality.TWO_STAR, photos);
		listPhotos(photos);
		
		int nrStars = numberOfStars(photos);
		System.out.println("The number of starts are: " + nrStars);
	}

}
