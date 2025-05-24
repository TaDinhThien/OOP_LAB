package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    // Kiểm tra media đã có trong store chưa
    private boolean checkMedia(Media media) {
        return itemsInStore.contains(media);
    }

    // Thêm media vào store
    public void addMedia(Media media) {
        if (!checkMedia(media)) {
            itemsInStore.add(media);
            System.out.println(media.getTitle() + " has been added to the store!");
        } else {
            System.out.println(media.getTitle() + " already exists in the store!");
        }
    }

    // Xoá media khỏi store
    public void removeMedia(Media media) {
        if (checkMedia(media)) {
            itemsInStore.remove(media);
            System.out.println(media.getTitle() + " has been removed from the store!");
        } else {
            System.out.println("There is no " + media.getTitle() + " in the store!");
        }
    }

    // Tìm media theo tiêu đề
    public Media findMediaByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    // Lấy danh sách media trong store
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    // Hiển thị store theo format đẹp
    public void displayStore() {
        System.out.println("**************** STORE ****************");
        System.out.println("Items in the store:");
        if (itemsInStore.isEmpty()) {
            System.out.println("There is no item in the store!");
        } else {
            int index = 1;
            for (Media media : itemsInStore) {
                System.out.println(index++ + ". " + media.toString());
            }
        }
        System.out.println("***************************************");
    }

    // Hiển thị store dạng chuỗi (hữu ích khi in trực tiếp)
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("**************** STORE ****************\nItems in the store:\n");
        if (itemsInStore.isEmpty()) {
            string.append("There is no item in the store!\n");
        } else {
            for (Media media : itemsInStore) {
                string.append(media.getTitle()).append(" - ").append(media.getCost()).append(" $\n");
            }
        }
        string.append("***************************************");
        return string.toString();
    }

    // Lọc media theo loại (DVD, CD, Book...)
    public ArrayList<Media> getMediaByType(Class<?> mediaType) {
        ArrayList<Media> result = new ArrayList<>();
        for (Media media : itemsInStore) {
            if (mediaType.isInstance(media)) {
                result.add(media);
            }
        }
        return result;
    }
}


