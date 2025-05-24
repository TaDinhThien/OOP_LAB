package hust.soict.hedspi.lab02;
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered;

    public int addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full. Can't add more discs");
            return 0;
        } else {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The DVD \"" + disc.getTitle() + "\" has been added!");
            return 1;
        }
    }

    // Overloaded method to add multiple DVDs using an array
    public int addDigitalVideoDisc(DigitalVideoDisc... dvds) {
        int addedCount = 0;
        for (DigitalVideoDisc dvd : dvds) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered] = dvd;
                qtyOrdered++;
                System.out.println("The DVD \"" + dvd.getTitle() + "\" has been added!");
                addedCount++;
            } else {
                System.out.println("The cart is full. Can't add more discs.");
                break;
            }
        }
        return addedCount;
    }

    // Overloaded method to add two DVDs
    public int addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        int addedCount = 0;
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = dvd1;
            qtyOrdered++;
            System.out.println("The DVD \"" + dvd1.getTitle() + "\" has been added!");
            addedCount++;
        }
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = dvd2;
            qtyOrdered++;
            System.out.println("The DVD \"" + dvd2.getTitle() + "\" has been added!");
            addedCount++;
        } else {
            System.out.println("The cart is full. Can't add more discs.");
        }
        return addedCount;
    }

    public int removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == 0) {
            System.out.println("Your cart is empty!");
            return 0;
        }
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("Remove DVD \"" + disc.getTitle() + "\" successfully!");
                return 1;
            }
        }
        System.out.println("No DVD match!");
        return 0;
    }

    public float totalCost() {
        float sum = 0.00f;
        for (int i = 0; i < qtyOrdered; i++) {
            sum += itemsOrdered[i].getCost();
        }
        return sum;
    }
}

