package items;

import java.util.Scanner;

/**
 *
 * @author Ahmedezzat
 */
public class magazine extends publication {

    public magazine() {
    }

    public magazine(Scanner in) {
        super(in);
    }

    @Override
    public String getType() {
        return "magazine";
    }

    @Override
    public double getPenalty() {
        return 10;
    }

    @Override
    public long getMaxTime() {
        return 3;
    }
}
