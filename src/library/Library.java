package library;

import IO.jReader;
import items.operations;
import java.util.ArrayList;
import java.util.Scanner;
import persons.manager;
import persons.user;

/**
 *
 * @author Ahmedezzat
 */
public class Library {

    public static ArrayList<user> arr = new ArrayList<user>();
    public static user activeUser;
    Scanner in = new Scanner(System.in);

    public static void signUp() {
        user p = new user();
        arr.add(p);
        jReader.showMessage("", "");
        activeUser = p;
    }

    public static boolean logIn(String email, String password) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getEmail().equals(email)) {
                if (arr.get(i).login(password)) {
                    activeUser = arr.get(i);
                    return true;
                }
                jReader.showMessage("wrong password", "login");
                return false;
            }
        }
        jReader.showNotFoundMessage("email");
        return false;
    }

    public static void build() {

    }

    public static void end() {

    }

    public static void main(String[] args) {
        build();
        while (true) {
            int x = jReader.showChooseOptions("welcome", "Welcome", new String[]{"Sing up", "login"});
            if (x == -1) {
                end();
                return;
            }
            if (x == 0) {
                signUp();
            } else {
                String email = jReader.next("email", "user informatin");
                String password = jReader.next("password", "user informatin");
                if (logIn(email, password) == false) {
                    jReader.showMessage("unsuccessful login", "unsuccessful login , try again");
                    continue;
                }
            }
        }
    }

}
