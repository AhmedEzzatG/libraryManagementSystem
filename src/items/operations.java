package items;

import IO.jReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ahmedezzat
 */
public interface operations {

    public static ArrayList<publication> arr = new ArrayList<publication>();

    public static int searchPublication(String title) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getTitle().equals(title)) {
                return i;
            }
        }
        return -1;
    }

    public static int searchPublication(int serialNumber) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getSerialNumber() == serialNumber) {
                return i;
            }
        }
        return -1;
    }

    public static void addPublication() {
        String type = jReader.next("type", "Publication information");
        switch (type) {
            case "book":
                arr.add(new book());
                break;
            case "booklet":
                arr.add(new booklet());
                break;
            case "magazine":
                arr.add(new magazine());
                break;
            default:
                jReader.showInvalidInputMessage();
                addPublication();
                break;
        }
    }

    public static void deletePublication(String title) {
        int index = searchPublication(title);
        if (index != -1) {
            arr.remove(index);
            jReader.showMessage("This Publication was deleted successfully", "successful delete");
        } else {
            jReader.showNotFoundMessage("title");
        }
    }

    public static void deletePublication(int serialNumber) {
        int index = searchPublication(serialNumber);
        if (index != -1) {
            arr.remove(index);
            jReader.showMessage("This Publication was deleted successfully", "successful delete");
        } else {
            jReader.showNotFoundMessage("serial number");
        }
    }

    public static void listOfPublications() {
        jReader.showListOfItems(arr);
    }
}
