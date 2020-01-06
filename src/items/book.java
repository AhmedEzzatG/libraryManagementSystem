package items;

/**
 *
 * @author Ahmedezzat
 */
public class book extends publication {

    @Override
    public String toString() {
        return "book " + super.toString();
    }

    @Override
    public double getPenalty() {
        return 10.5;
    }

    @Override
    public long getMaxTime() {
        return 7 * 86400000;
    }

}
