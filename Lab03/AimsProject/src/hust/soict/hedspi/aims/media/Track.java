package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;
import java.time.Duration;

public class Track implements Playable {
    private final String title;
    private final int length;

    // Constructor 
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Play method
    @Override
    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    public String playGUI() throws PlayerException {
        if (this.getLength() > 0) {
            return "Playing track: " + this.getTitle() + "\n" + 
                "Track length: " + formatDuration(this.getLength());
        } else {
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
    }

    public String formatDuration(int durationInSeconds) {
        Duration duration = Duration.ofSeconds(durationInSeconds);
        return String.format("%02d:%02d", duration.toMinutes(), duration.minusMinutes(duration.toMinutes()).getSeconds());
    }

    // Getter method
    public String getTitle() {
        return title;
    }
    
    public int getLength() {
        return length;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {  
            return true;
        }
        if (!(obj instanceof Track)) {
            return false;
        }
        return ((Track)obj).getTitle().equals(this.getTitle()) && ((Track)obj).getLength() == this.getLength();
    }
    
    @Override
    public int hashCode() {
        int result = getTitle().hashCode();
        result = 31 * result + getLength();
        return result;
    }
}
