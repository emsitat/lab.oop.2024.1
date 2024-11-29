package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import hust.soict.dsai.aims.media.Media;

public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    // Add and remove media from cart
    public void addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full!");
        } else if (itemsOrdered.contains(media)) {
            System.out.println(media.getTitle() + " is already in the cart!");
        } else {
            itemsOrdered.add(media);
            System.out.println(media.getTitle() + " has been added!");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.isEmpty()) {
            System.out.println("Nothing to remove!");
        } else {
            if (itemsOrdered.remove(media)) {
                System.out.println(media.getTitle() + " has been removed from the cart.");
            } else {
                System.out.println("Media is not found in cart!");
            }
        }
    }

    public float totalCost() {
        float totalCost = 0;
        for (Media media : itemsOrdered) {
            totalCost += media.getCost();
        }
        return totalCost;
    }

    // 1. Print Cart Details
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        float totalCost = 0;

        for (int i = 0; i < itemsOrdered.size(); i++) {
            Media media = itemsOrdered.get(i);
            System.out.println((i + 1) + ". " + media.toString());
            totalCost += media.getCost();
        }

        System.out.println("Total cost: " + totalCost + " $");
        System.out.println("***************************************************");
    }

    // 2. Search Media by ID
    public void searchById(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found Media: " + media.toString());
                return;
            }
        }
        System.out.println("No Media with ID " + id + " found.");
    }

    // 3. Search Media by Title
    public void searchByTitle(String title) {
        boolean found = false;

        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                System.out.println("Found Media: " + media.toString());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Media with title \"" + title + "\" found.");
        }
    }
    
    // Sort media in cart
    public void sortMediaByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        for (Media media : itemsOrdered) {
            System.out.println(media.toString());
        }
    }

    public void sortMediaByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        for (Media media : itemsOrdered) {
            System.out.println(media.toString());
        }
    }

    
    //Search to remove method 
    public Media searchToRemove(String title) {
		for (Media media : itemsOrdered) {
			if (media.getTitle().equals(title)) {
				return media;
			}
		}
		return null;
	}
    
    public void empty() {
        if (itemsOrdered.size() == 0) {
            System.out.println("Nothing to remove!");
        } else {
            itemsOrdered.clear();
            System.out.println("Now your current cart will be empty!");
            System.out.println();
        }
    }
}
