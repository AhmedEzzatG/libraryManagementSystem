package items;

/**
 *
 * @author Ahmedezzat
 */
public class magazine extends publication {

    @Override
    public String toString() {
        return "magazine " + super.toString();
    }

    @Override
    public double getPenalty() {
        return 10;
    }

    @Override
    public long getMaxTime() {
        return 3 * 86400000;
    }
}
