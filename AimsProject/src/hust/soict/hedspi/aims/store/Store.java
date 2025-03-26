package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import java.util.LinkedList;
public class Store {
    private LinkedList<DigitalVideoDisc> itemsInStore = new LinkedList<DigitalVideoDisc>();

    private boolean checkDVD(DigitalVideoDisc disc) {
        for (DigitalVideoDisc digitalVideoDisc : itemsInStore) {
            if (digitalVideoDisc.equals(disc)) {
                return true;
            }
        }
        return false;
    }

    public void removeDVD(DigitalVideoDisc disc) {
        if(checkDVD(disc)) {
            itemsInStore.remove(disc);
            System.out.println(disc.getTitle() + " da bi xoa khoi store!");
        } else {
            System.out.println("Khong co " + disc.getTitle() + " trong store!");
        }
    }

    public void addDVD(DigitalVideoDisc disc) {
        if(!checkDVD(disc)) {
            itemsInStore.add(disc);
            System.out.println(disc.getTitle() + " da duoc them vao store!");
        } else {
            System.out.println(disc.getTitle() + " da ton tai trong store!");
        }
    }

    @Override // Dinh nghia lai phuong thuc toString cua lop Object
    public String toString() {
        StringBuilder string = new StringBuilder("****************STORE***************\nDanh sach DVD trong store:\n");
        if(itemsInStore.isEmpty()) {
            string.append("Khong co DVD nao trong store!\n");
        } else {
            for (DigitalVideoDisc dvd : itemsInStore) {
                string.append(dvd.getTitle() + " - " + dvd.getCost() + " $\n");
            }
        }
        string.append("***************************************");
        return string.toString();
    }
}
