package hust.soict.hedspi.test.cart.CartTest;

import hust.soict.hedspi.aims.cart.Cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class TestCart {
    public static void main(String[] args) {
        // Tạo Cart mới
        Cart cart = new Cart();

        // Tạo và thêm các DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
            "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
            "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc(
            "Aladin", "Animation", 18.99f);
        cart.addMedia(dvd3);

        // Hiển thị giỏ hàng
        System.out.println("----- CONTENTS OF CART -----");
        cart.print();

        // Test search by ID
        System.out.println("\n-- Test searchById(3) --");
        cart.searchById(3);
        System.out.println("-- Test searchById(4) --");
        cart.searchById(4);

        // Test search by Title
        System.out.println("\n-- Test searchByTitle(\"The Lion King\") --");
        cart.searchByTitle("The Lion King");
        System.out.println("-- Test searchByTitle(\"Alan Walker\") --");
        cart.searchByTitle("Alan Walker");
    }
}
