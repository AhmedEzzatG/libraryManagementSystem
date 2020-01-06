package IO;

import java.io.*;
import java.util.StringTokenizer;

/**
 *
 * @author Ahmedezzat
 */
public class reader {

    StringTokenizer st;
    BufferedReader br;

    public reader(InputStream s) {
        br = new BufferedReader(new InputStreamReader(s));
    }

    public reader(File file) {
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (Exception ex) {

        }
    }

    public String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception ex) {
                
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        try {
            return Integer.parseInt(next());
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, "error input type ,please try again", "ERROR", JOptionPane.ERROR_MESSAGE);
            return nextInt();
        }
    }

    public long nextLong() {
        try {
            return Long.parseLong(next());
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, "error input type ,please try again", "ERROR", JOptionPane.ERROR_MESSAGE);
            return nextLong();
        }
    }

    public String nextLine() {
        String rt = "";
        while (st.hasMoreTokens()) {
            rt += st.nextToken();
        }
        if (rt.isEmpty()) {
            try {
                return br.readLine();
            } catch (Exception ex) {

            }
        }
        return rt;
    }

}
