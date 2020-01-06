package items;

import IO.jReader;
import java.util.Scanner;

/**
 *
 * @author Ahmedezzat
 */
public abstract class publication {

    private String title, author, publisher;
    private long serialNumber;
    private int numberOfPages, numberOfCopies, numberAvaliable;

    public publication() {
        readInformation();

    }

    public void readInformation() {
        title = jReader.next("title", "Publication information");
        author = jReader.next("author", "Publication information");
        publisher = jReader.next("publisher", "Publication information");
        serialNumber = jReader.nextLong("serial number", "Publication information");
        numberOfPages = jReader.nextInt("number of pages", "Publication information");
        numberOfCopies = jReader.nextInt("number of copies", "Publication information");
        numberAvaliable = numberOfCopies;
    }

    @Override
    public String toString() {
        return title + "\nauthor : " + author + ", publisher : " + publisher + ", serial number : " + serialNumber + ", number of pages: " + numberOfPages + ", number of copies : " + numberOfCopies + ", number of Avaliable copies : " + numberAvaliable;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public int getNumberAvaliable() {
        return numberAvaliable;
    }

    public boolean Avaliable() {
        return numberAvaliable > 0;
    }

    public void borrowed() {
        numberAvaliable--;
    }

    public void returnBorrowed() {
        numberAvaliable++;
    }

    public abstract double getPenalty();

    public abstract long getMaxTime();

}
