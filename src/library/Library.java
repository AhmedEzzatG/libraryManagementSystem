package library;

import IO.jReader;
import java.util.Scanner;
import persons.operations;

/**
 *
 * @author Ahmedezzat
 */
public class Library {

    Scanner in = new Scanner(System.in);

    public static void build() {
        items.operations.build();
        operations.build();
    }

    public static void end() {
        items.operations.end();
        operations.end();
    }

    public static void main(String[] args) {
        build();
        while (true) {
            int choose = jReader.showChooseOptions("Welcome in Assiut library management system", "Welcome",
                    new String[]{"Sing up", "Login"});
            switch (choose) {
                case 0:
                    persons.operations.signUp();
                    break;
                case 1:
                    String email = jReader.next("email", "user informatin");
                    String password = jReader.next("password", "user informatin");
                    if (operations.logIn(email, password) == false) {
                        jReader.showMessage("unsuccessful login", "unsuccessful login , try again");
                        continue;
                    }
                    break;
                default:
                    end();
                    return;
            }
            String[] options;
            if (operations.activeUser instanceof persons.manager) {
                options = new String[]{"publications menu", "personal menu", "manager menu"};
            } else {
                options = new String[]{"publications menu", "personal menu"};

            }
            boolean stayHere = true;
            while (stayHere) {
                choose = jReader.showChooseOptions("Welcome " + operations.activeUser.getUserName(),
                        "Welcome in Assiut library management system", options);
                switch (choose) {
                    case 0:
                        items.operations.menu();
                        break;
                    case 1:
                        operations.personalMenu();
                        break;
                    case 2:
                        operations.managerMenu();
                        break;
                    default:
                        stayHere = false;
                }
            }
        }
    }

}
