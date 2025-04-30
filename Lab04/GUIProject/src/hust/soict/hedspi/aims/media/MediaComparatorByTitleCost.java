package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media>{
    @Override
    public int compare(Media o1, Media o2){
        int titleComparison = o1.getTitle().compareTo(o2.getTitle());
        return titleComparison == 0 ? Double.compare(o1.getCost(), o2.getCost()) : titleComparison;
    }
}
