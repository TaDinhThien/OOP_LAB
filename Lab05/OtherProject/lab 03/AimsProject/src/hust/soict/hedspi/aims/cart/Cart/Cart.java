package hust.soict.hedspi.aims.cart.Cart;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.MediaComparatorByCostTitle;
import hust.soict.hedspi.aims.media.MediaComparatorByTitleCost;

import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full. Can't add more items.");
            return;
        }
        if (itemsOrdered.contains(media)) {
            System.out.println("This media is already in the cart.");
            return;
        }
        itemsOrdered.add(media);
        System.out.println("The media \"" + media.getTitle() + "\" has been added!");
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("Removed media \"" + media.getTitle() + "\" successfully!");
        } else {
            System.out.println("No media match!");
        }
    }

    public float totalCost() {
        float sum = 0.00f;
        for (Media media : itemsOrdered) {
            sum += media.getCost();
        }
        return sum;
    }

    public void print() {
        StringBuilder output = new StringBuilder("*********************CART************************** \nOrdered items: \n");
        int index = 1;
        for (Media media : itemsOrdered) {
            output.append(index++).append(". [")
                  .append(media.getTitle()).append("] - [")
                  .append(media.getCategory()).append("]: ")
                  .append(media.getCost()).append(" $\n");
        }
        output.append("Total: ").append(totalCost()).append(" $\n");
        output.append("***************************************************\n");
        System.out.println(output);
    }

    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Result: [" + media.getTitle() + "] - [" + media.getCategory() + "]: " + media.getCost() + " $\n");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No match found!");
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Result: [" + media.getTitle() + "] - [" + media.getCategory() + "]: " + media.getCost() + " $\n");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No match found!");
        }
    }

    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, new MediaComparatorByTitleCost());
        System.out.println("Cart sorted by title then cost.");
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, new MediaComparatorByCostTitle());
        System.out.println("Cart sorted by cost then title.");
    }

    public void clear() {
        itemsOrdered.clear();
        System.out.println("The cart has been cleared. Order has been placed!");
    }

    public Media searchExactTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public Media findMediaByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
}

