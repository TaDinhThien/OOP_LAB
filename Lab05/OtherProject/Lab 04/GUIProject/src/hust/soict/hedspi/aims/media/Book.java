package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    private ArrayList<String> authors = new ArrayList<>();

    public Book() {
        super();
    }

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        }
    }
    public Book(String title, String category, float cost) {
        super(0, title, category, cost); // hoặc sinh id ngẫu nhiên nếu cần
    }


    public void removeAuthor(String authorName) {
        authors.remove(authorName);
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }
}
