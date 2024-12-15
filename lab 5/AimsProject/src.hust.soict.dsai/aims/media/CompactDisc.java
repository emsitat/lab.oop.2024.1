package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {

    private String artist;
    private List<Track> tracks = new ArrayList<Track>();; 

    public String getArtist() {
        return artist;
    }

    public CompactDisc(String title) {
        super(title);
    }
    public CompactDisc(String title, String category, String artist, float cost) {
        super(title, category, cost);
        this.artist = artist;
    }

    // Add and remove track method
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track: " + track.getTitle() + " has been added to CD!" );
        } else {
            System.out.println("Track already exists in CD.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track: " +track.getTitle() + " has been removed from CD!");
        } else {
            System.out.println("Track does not exist in CD.");
        }
    }
    
    // Get length method
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    
    @Override
    public void play() throws PlayerException{
		if (this.getLength() > 0) {
			System.out.println("Compactdisc: " + getTitle());
			System.out.println("Artist: " + getArtist());
			System.out.println("Length: " + getLength());
			java.util.Iterator iter = tracks.iterator();
			Track nextTrack;
			while (iter.hasNext()) {
				nextTrack = (Track) iter.next();
				try {
					nextTrack.play();
				}
				catch(PlayerException e ) {
					throw e;
					}
			}
		}
		else {
			throw new PlayerException("Error: DVD length is non-positive!");
		}
		
		
		for (Track track : tracks) {
			track.play();
		}
	}
    
    @Override
    public String toString() {
        return this.getId() + " - CD: " + this.getTitle() +"-" + this.getCategory() + "-"+
        		this.getArtist() +"-"+ this.getLength() + "-"
                + this.getCost() + "$";
    }
}
