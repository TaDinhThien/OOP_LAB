package hust.soict.hedspi.aims.cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;   // So luong toi da dia DVD trong gio hang

    // Mang luu cac dia DVD duoc them vao gio hang
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered;     // So luong dia DVD hien co trong gio hang

    // Ham them mot dia DVD vao gio hang
    public int addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("Gio hang da day. Khong the them dia moi!");
            return 0;
        } else {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("Dia DVD " + '"' + disc.getTitle() + '"' + " da duoc them vao!");
            return 1;
        }
    }

    // Ham them nhieu dia DVD vao gio hang
    public int addDigitalVideoDisc(DigitalVideoDisc... dvdArray) {
        int addCount = 0;
        for (DigitalVideoDisc disc : dvdArray) {
            if (qtyOrdered == MAX_NUMBERS_ORDERED) {
                System.out.println("Gio hang da day. Khong the them dia moi!");
                break;
            } else {
                itemsOrdered[qtyOrdered] = disc;
                qtyOrdered++;
                System.out.println("Dia DVD " + '"' + disc.getTitle() + '"' + " da duoc them vao!");
                addCount++;
            }
        }
        return addCount;
    }

    // Ham them 2 dia DVD vao gio hang
    public int addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered + 1 >= MAX_NUMBERS_ORDERED) {
            System.out.println("Gio hang da day. Khong the them dia moi!");
            return 0;
        } else {
            itemsOrdered[qtyOrdered] = dvd1;
            qtyOrdered++;
            System.out.println("Dia DVD " + '"' + dvd1.getTitle() + '"' + " da duoc them vao!");

            itemsOrdered[qtyOrdered] = dvd2;
            qtyOrdered++;
            System.out.println("Dia DVD " + '"' + dvd2.getTitle() + '"' + " da duoc them vao!");
            return 2; // Tra ve so dia DVD da them duoc
        }
    }

    // Ham xoa mot dia DVD ra khoi gio hang
    public int removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (itemsOrdered[0] == null) {
            System.out.println("Gio hang dang trong!");
            return 0;
        }
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("Da xoa dia DVD " + '"' + disc.getTitle() + '"' + " thanh cong!");
                return 1;
            }
        }
        System.out.println("Khong tim thay dia DVD!");
        return 0;
    }

    // Ham tinh tong gia tien cua cac dia DVD trong gio hang
    public float totalCost() {
        float sum = 0.00f;
        for (int i = 0; i < qtyOrdered; i++) {
            sum += itemsOrdered[i].getCost();
        }
        return sum;
    }

    // Ham in danh sach cac dia DVD trong gio hang
    public void print() {
        StringBuilder output = new StringBuilder("********************* GIO HANG **************************\nDanh sach san pham: \n");
        for (int i = 0; i < qtyOrdered; i++) {
            output.append(i + 1).append(". [").append(itemsOrdered[i].getTitle()).append("] - [")
                    .append(itemsOrdered[i].getCategory()).append("] - [")
                    .append(itemsOrdered[i].getDirector()).append("] - [")
                    .append(itemsOrdered[i].getLength()).append("]: ")
                    .append(itemsOrdered[i].getCost()).append(" $\n");
        }
        output.append("Tong tien: ").append(totalCost()).append(" $\n");
        output.append("***************************************************\n");
        System.out.println(output);
    }

    // Ham tim kiem dia DVD theo ID
    public void searchById(int i) {
        if (i > qtyOrdered || i <= 0) {
            System.out.println("Khong tim thay ket qua!");
        } else {
            System.out.println("Ket qua: " + "[" + itemsOrdered[i - 1].getTitle() + "] - ["
                    + itemsOrdered[i - 1].getCategory() + "] - ["
                    + itemsOrdered[i - 1].getDirector() + "] - ["
                    + itemsOrdered[i - 1].getLength() + "]: "
                    + itemsOrdered[i - 1].getCost() + " $");
        }
    }

    // Ham tim kiem dia DVD theo tieu de
    public void searchByTitle(String title) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getTitle().equals(title)) {
                System.out.println("Ket qua: " + "[" + itemsOrdered[i].getTitle() + "] - ["
                        + itemsOrdered[i].getCategory() + "] - ["
                        + itemsOrdered[i].getDirector() + "] - ["
                        + itemsOrdered[i].getLength() + "]: "
                        + itemsOrdered[i].getCost() + " $");
                return;
            }
        }
        System.out.println("Khong tim thay ket qua!");
    }
}
