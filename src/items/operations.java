package items;

import IO.jReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ahmedezzat
 */
public interface operations {

    public static ArrayList<publication> publications = new ArrayList<publication>();
    File file = new File("publications.txt");

    public static publication readPublication(Scanner in) {
        String type = in.nextLine();
        switch (type) {
            case "book":
                return new book(in);
            case "booklet":
                return new booklet(in);
            case "magazine":
                return new magazine(in);
        }
        return null;
    }

    public static void build() {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {

            }
        }
        try {
            Scanner in = new Scanner(file);
            while (in.hasNext()) {
                publications.add(readPublication(in));
            }
        } catch (FileNotFoundException ex) {

        }
    }

    public static void end() {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {

            }
        }
        try {
            PrintWriter out = new PrintWriter(file);
            for (publication p : publications) {
                out.println(p.printInFile());
            }
            out.flush();
            out.close();
        } catch (FileNotFoundException ex) {

        }

    }

    public static void menu() {
        while (true) {
            int x = jReader.showChooseOptions("", "Publication menu",
                    new String[]{"Add new Publication", "delete Publication",
                        "search of Publication", "list of available publications"});
            switch (x) {
                case 0:
                    addPublication();
                    break;
                case 1:
                    deletePublication();
                    break;
                case 2:
                    searchPublication();
                    break;
                case 3:
                    listOfAvailablePublications();
                    break;
                default:
                    return;
            }
        }
    }

    public static void addPublication() {
        String type = jReader.next("type", "Publication information");
        switch (type) {
            case "book":
                publications.add(new book());
                break;
            case "booklet":
                publications.add(new booklet());
                break;
            case "magazine":
                publications.add(new magazine());
                break;
            default:
                jReader.showInvalidInputMessage();
                addPublication();
                break;
        }
    }

    public static void searchPublication() {
        int x = jReader.showChooseOptions("", "Publication menu",
                new String[]{"search by title", "search by serial number"});
        int index;
        switch (x) {
            case 0:
                String title = jReader.next("enter title of Publication", "search");
                index = searchPublication(title);
                if (index == -1) {
                    jReader.showNotFoundMessage("title");
                    return;
                }
                if (publications.get(index).Avaliable()) {
                    jReader.showMessage("this Publication is Available\n" + publications.get(index), "search");
                } else {
                    jReader.showMessage("sorry this Publication is not availablein the present time\n"
                            + publications.get(index), "search");
                }
                break;
            case 1:
                long serialNumber = jReader.nextLong("enter serial number of Publication", "search");
                index = searchPublication(serialNumber);
                if (index == -1) {
                    jReader.showNotFoundMessage("serial number");
                    return;
                }
                if (publications.get(index).Avaliable()) {
                    jReader.showMessage("this Publication is Available\n" + publications.get(index), "search");
                } else {
                    jReader.showMessage("sorry this Publication is not available in the present time\n"
                            + publications.get(index), "search");
                }
                break;
        }
    }

    public static int searchPublication(String title) {
        for (int i = 0; i < publications.size(); i++) {
            if (publications.get(i).getTitle().equals(title)) {
                return i;
            }
        }
        return -1;
    }

    public static int searchPublication(long serialNumber) {
        for (int i = 0; i < publications.size(); i++) {
            if (publications.get(i).getSerialNumber() == serialNumber) {
                return i;
            }
        }
        return -1;
    }

    public static void deletePublication() {
        int x = jReader.showChooseOptions("", "delete Publication menu",
                new String[]{"search by title", "search by serial number"});
        switch (x) {
            case 0:
                String title = jReader.next("enter title of Publication", "delete publication");
                deletePublication(title);
                break;
            case 1:
                long serialNumber = jReader.nextLong("enter serial number of Publication", "delete publication");
                deletePublication(serialNumber);
                break;
            default:
                break;
        }
    }

    public static void deletePublication(String title) {
        int index = searchPublication(title);
        if (index != -1) {
            publications.remove(index);
            jReader.showMessage("This Publication was deleted successfully", "delete Publication");
        } else {
            jReader.showNotFoundMessage("title");
        }
    }

    public static void deletePublication(long serialNumber) {
        int index = searchPublication(serialNumber);
        if (index != -1) {
            publications.remove(index);
            jReader.showMessage("This Publication was deleted successfully", "delete Publication");
        } else {
            jReader.showNotFoundMessage("serial number");
        }
    }

    public static void listOfAvailablePublications() {
        ArrayList<publication> tmp = new ArrayList<>();
        for (publication a : publications) {
            if (a.Avaliable()) {
                tmp.add(a);
            }
        }
        jReader.showListOfItems(tmp);
    }

}
