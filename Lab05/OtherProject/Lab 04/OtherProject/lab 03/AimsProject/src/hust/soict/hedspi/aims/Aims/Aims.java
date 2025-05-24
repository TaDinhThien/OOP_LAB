package hust.soict.hedspi.aims.Aims;

import hust.soict.hedspi.aims.cart.Cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;
import java.util.Scanner;
import java.util.Collections;

public class Aims {

    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    public static void main(String[] args) {
        // Sample data (for testing)
        store.addMedia(new DigitalVideoDisc(1, "Avengers", "Action", 19.99f));
        store.addMedia(new CompactDisc(2, "CD1", "Music", 10.5f));
        store.addMedia(new Book(3, "Java Programming", "Education", 29.99f));

        int choice;
        do {
            showMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> viewStore();
                case 2 -> updateStore();
                case 3 -> viewCart();
                case 0 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid option! Please try again.");
            }
        } while (choice != 0);
    }

    // Implement viewStore, updateStore, viewCart and other helper methods here

    private static void viewStore() {
        System.out.println(store);
        int choice;
        do {
            storeMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> seeMediaDetails();
                case 2 -> addMediaToCart();
                case 3 -> playMedia();
                case 4 -> viewCart();
                case 0 -> {}
                default -> System.out.println("Invalid option!");
            }
        } while (choice != 0);
    }

    private static void seeMediaDetails() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media == null) {
            System.out.println("Media not found!");
            return;
        }
        System.out.println(media);
        int choice;
        do {
            mediaDetailsMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> cart.addMedia(media);
                case 2 -> {
                    if (media instanceof Playable playable) playable.play();
                    else System.out.println("This media is not playable.");
                }
                case 0 -> {}
                default -> System.out.println("Invalid option!");
            }
        } while (choice != 0);
    }

    private static void addMediaToCart() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media == null) {
            System.out.println("Media not found!");
            return;
        }
        cart.addMedia(media);
    }

    private static void playMedia() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null && media instanceof Playable playable) {
            playable.play();
        } else {
            System.out.println("Media not found or not playable.");
        }
    }

    private static void updateStore() {
        System.out.print("Enter action (add/remove): ");
        String action = scanner.nextLine();
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);

        if (action.equalsIgnoreCase("add")) {
            if (media != null) {
                System.out.println("Media already in store!");
            } else {
                System.out.print("Enter category: ");
                String category = scanner.nextLine();
                System.out.print("Enter cost: ");
                float cost = Float.parseFloat(scanner.nextLine());
                Media newMedia = new DigitalVideoDisc(100 + store.getItemsInStore().size(), title, category, cost);
                store.addMedia(newMedia);
            }
        } else if (action.equalsIgnoreCase("remove")) {
            if (media != null) store.removeMedia(media);
            else System.out.println("Media not found in store.");
        }
    }

    private static void viewCart() {
        cart.print();
        int choice;
        do {
            cartMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> filterCart();
                case 2 -> sortCart();
                case 3 -> removeMediaFromCart();
                case 4 -> playMediaInCart();
                case 5 -> {
                    System.out.println("An order has been created!");
                    cart = new Cart();
                }
                case 0 -> {}
                default -> System.out.println("Invalid option!");
            }
        } while (choice != 0);
    }

    private static void filterCart() {
        System.out.print("Filter by (id/title): ");
        String type = scanner.nextLine();
        if (type.equalsIgnoreCase("id")) {
            System.out.print("Enter id: ");
            int id = Integer.parseInt(scanner.nextLine());
            cart.searchById(id);
        } else if (type.equalsIgnoreCase("title")) {
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            cart.searchByTitle(title);
        } else {
            System.out.println("Invalid filter option.");
        }
    }

    private static void sortCart() {
        System.out.print("Sort by (title/cost): ");
        String type = scanner.nextLine();
        if (type.equalsIgnoreCase("title")) {
            cart.getItemsOrdered().sort(new MediaComparatorByTitleCost());
        } else if (type.equalsIgnoreCase("cost")) {
            cart.getItemsOrdered().sort(new MediaComparatorByCostTitle());
        } else {
            System.out.println("Invalid sort option.");
        }
    }

    private static void removeMediaFromCart() {
        System.out.print("Enter title of media to remove: ");
        String title = scanner.nextLine();
        Media media = cart.findMediaByTitle(title);
        if (media != null) cart.removeMedia(media);
        else System.out.println("Media not found in cart.");
    }

    private static void playMediaInCart() {
        System.out.print("Enter media title to play: ");
        String title = scanner.nextLine();
        Media media = cart.findMediaByTitle(title);
        if (media != null && media instanceof Playable playable) {
            playable.play();
        } else {
            System.out.println("Media not found or not playable.");
        }
    }
}