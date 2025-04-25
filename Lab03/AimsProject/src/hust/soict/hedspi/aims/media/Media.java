package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;
import java.time.Duration;
import java.util.Comparator;

public abstract class Media implements Comparable<Media>, Playable {

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    
    private static int nbMedia = 0;
    private final int id;
    private String title;
    private String category;
    private float cost;

    // Constructor 
    public Media(String title) {
        this.title = title;
		this.id = ++nbMedia;
    }
    public Media(String title, String category) {
        this.title = title;
        this.category = category;
        this.id = ++nbMedia;
    }
    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = ++nbMedia;
    }
    
    // Getter method
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public float getCost() {
        return cost;
    }

    // Setter method
    public void setTitle(String title) {
        this.title = title;
    }
    
    // Check is title match
    public boolean isMatch(String title) {
        return this.getTitle().toLowerCase().contains(title.toLowerCase());
    }

    @Override
    public void play() {
        System.out.println("Playing media");
    }
    
    public String playGUI() throws PlayerException {
        return "Playing media";
    }

    public String formatDuration(int durationInSeconds) {
        Duration duration = Duration.ofSeconds(durationInSeconds);
        return String.format("%02d:%02d", duration.toMinutes(), duration.minusMinutes(duration.toMinutes()).getSeconds());
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Media)) {
            return false;
        }
        return this.getTitle() != null && this.getTitle().equals(((Media)obj).getTitle());
    }
    
    @Override
    public int hashCode() {
        return getTitle() == null ? 0 : getTitle().hashCode();
    }

    @Override
    public String toString() {
        return "Media: " + this.getTitle() +
                " - Category: " + this.getCategory() +
                " - Cost: " + this.getCost() + "$";
    }

    // Answer for the second question
    @Override
    public int compareTo(Media other) {
        int titleComparison = this.getTitle().compareTo(other.getTitle());
        return titleComparison != 0 ? titleComparison : Double.compare(this.getCost(), other.getCost());
    }
}
