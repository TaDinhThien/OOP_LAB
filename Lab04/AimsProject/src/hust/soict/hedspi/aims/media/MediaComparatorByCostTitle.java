package hust.soict.hedspi.aims.media;
import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media>{
    @Override
    public int compare(Media o1, Media o2){
        int costComparison = Double.compare(o1.getCost(), o2.getCost());
        return costComparison == 0 ? o1.getTitle().compareTo(o2.getTitle()) : costComparison;
    }
}
