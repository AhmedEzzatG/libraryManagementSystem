package persons;



import items.publication;

/**
 *
 * @author Ahmedezzat
 */
public class borrowed {

    private publication item;
    private long timeOfBorrowed;

    public borrowed(publication item) {
        this.item = item;
        timeOfBorrowed = System.currentTimeMillis();
    }

    public boolean overPeriod() {
        return System.currentTimeMillis() - timeOfBorrowed > item.getMaxTime();
    }

    public publication getItem() {
        return item;
    }

    public long getTimeOfBorrowed() {
        return timeOfBorrowed;
    }
}
