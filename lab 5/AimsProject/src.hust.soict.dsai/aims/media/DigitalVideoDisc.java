package hust.soict.dsai.aims.media;
import hust.soict.dsai.aims.exception.PlayerException;
public class DigitalVideoDisc extends Disc implements Playable {
    
    // Constructor 
    public DigitalVideoDisc(String title) {
        super(title);
    }    
    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director, cost);
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }
    
    @Override
    public void play() throws PlayerException{
		if (this.getLength() > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		}
		else {throw new PlayerException("Error: DVD length is non-positive!");}
	}
	
	@Override
    public String toString() {
        return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + " $";
    }

    public boolean isMatch(String title) {
        return this.getTitle().toLowerCase().contains(title.toLowerCase());
    }
}
