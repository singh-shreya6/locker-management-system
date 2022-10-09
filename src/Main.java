import controllers.LockerController;
import controllers.UserController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LockerController lockerController = new LockerController();
        UserController userController = new UserController();
        Scanner sc = new Scanner(System.in);
        while(true) {
            String line = sc.nextLine();
            String[] commands = line.split(" ");

            switch (commands[0]) {
                case "create":
                    System.out.println("Inside create");
                    lockerController.createLocker(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]), Integer.parseInt(commands[3]));
                    break;
                case "get":
                    System.out.println("Inside get");
                    lockerController.getLocker();
                    break;
                case "request":
                    System.out.println("Inside request");
                    lockerController.request(commands[1], commands[2]);
                    break;
                case "addUser":
                    System.out.println("Inside addUser");
                    userController.addUser(commands[1]);
                    break;
                default:
                    break;
            }
        }
    }
}
