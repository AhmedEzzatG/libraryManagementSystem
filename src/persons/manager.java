package persons;

import IO.jReader;
import items.publication;
import java.util.ArrayList;

/**
 *
 * @author Ahmedezzat
 */
public class manager extends user {

    public static void listOfBorrowedPublications() {
        ArrayList<String> a = new ArrayList<String>();
        for (publication e : items.operations.arr) {
            if (e.getNumberAvaliable() < e.getNumberOfCopies()) {
                
            }
        }
        jReader.showListOfItems(a);
    }

    public void listOfOverPeriodBorrowedPublications() {
        for (user p : library.Library.arr) {
            for (borrowed item : p.arr) {
                if (item.overPeriod()) {
                    //System.out.println(p.getEmail() + ' ' + p.getUserName() + ' ' + item.toString());
                }
            }
        }
    }
}
