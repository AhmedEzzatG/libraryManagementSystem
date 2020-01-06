package items;

/**
 *
 * @author Ahmedezzat
 */
public class booklet extends publication {

    @Override
    public String toString() {
        return "booklet " + super.toString();
    }

    @Override
    public double getPenalty() {
        return 15;
    }

    @Override
    public long getMaxTime() {
        return 4 * 86400000;
    }
}
