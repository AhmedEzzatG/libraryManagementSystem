package persons;

import IO.jReader;
import java.util.ArrayList;

/**
 *
 * @author Ahmedezzat
 */
public class user {

    private String email, userName, password;

    ArrayList<borrowed> arr = new ArrayList<borrowed>();

    public user() {
        userName = jReader.next("user name", "user information");
        email = jReader.next("email", "user information");
        password = jReader.next("password", "user information");
    }

    private int searchInBorrowed(int serialNumber) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getItem().getSerialNumber() == serialNumber) {
                return i;
            }
        }
        return -1;
    }

    public int Borrow(int serialNumber) {
        int index = items.operations.searchPublication(serialNumber);
        if (index == -1) {
            return 0;
        }
        if (searchInBorrowed(serialNumber) != -1) {
            return 1;
        }
        if (items.operations.arr.get(index).Avaliable() == false) {
            return 2;
        }
        items.operations.arr.get(index).borrowed();
        arr.add(new borrowed(items.operations.arr.get(index)));
        return 3;
    }

    public boolean returnBorrowed(int serialNumber) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getItem().getSerialNumber() == serialNumber) {
                arr.get(i).getItem().returnBorrowed();
                return true;
            }
        }
        return false;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public boolean login(String password) {
        return this.password.equals(password);
    }
}
