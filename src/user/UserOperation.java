/**
 * Created by ZHU Yuting on 2015/05/07
 */
package user;

import java.util.ArrayList;

public class UserOperation {
    public static ArrayList<User> users = new ArrayList<>();

    public UserOperation() {
    }

    public static boolean login(String name, String password) {
        System.out.println("Finding user: " + name + " with password "
                + password);
        for (User user : users) {
            if (user.getName().equals(name)) {
                if (user.getPassword().equals(password)) {
                    return true;
                } else {
                    System.out.println("wrong password!");
                }
            } else {
                System.out.println("no such user!");
            }
        }
        return false;
    }

    public static void addUser(String username, String password) {
        User newUser = new User(username, password);
        System.out.println("New User:");
        System.out.println("UserName: " + newUser.getName());
        System.out.println("UserPwd: " + newUser.getPassword());
        users.add(newUser);
    }
}
