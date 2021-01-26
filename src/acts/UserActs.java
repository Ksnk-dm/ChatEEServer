package acts;

import utils.Room;
import utils.User;

import java.util.ArrayList;
import java.util.List;

public class UserActs {
    private static final UserActs users = new UserActs();
    private final List<User> userArray = new ArrayList<User>();
    private final List<User> userOnlineArray = new ArrayList<User>();
    private final RoomActs roomActs = RoomActs.getInstance();

    public static UserActs getInstance() {
        return users;
    }


    private UserActs() {

    }

    private boolean userExists(String login) {
        boolean result = false;
        for (User usr : userArray) {
            if (usr.getLogin().equals(login)) {
                result = true;
                break;
            }
        }
        return result;
    }

    private User getUser(String login, String password) {
        User result = null;
        for (User user : userArray) {
            if (user.getLogin().equals(login) && user.getPass().equals(password)) {
                result = user;
            }
        }
        return result;
    }


    public String allUsers() {
        String allusers = "";
        for (User user : userArray) {
            allusers += "\n" + user.toString() + "\n";
        }
        return allusers;
    }


    private User getUserOnline(String login) {
        User result = null;
        for (User usr : userOnlineArray) {
            if (usr.getLogin().equals(login)) {
                result = usr;
                break;
            }
        }
        return result;
    }

    public synchronized String registration(String login, String password) {
        String result = "";
        if (userExists(login)) {
            result = "UserAlreadyExists";
        } else {
            userArray.add(new User(login, password));
            result = "OK";
        }
        return result;
    }


    public synchronized String login(String login, String password) {
        String result = "";
        User user = getUser(login, password);
        if (user != null) {
            User userOnlione = getUserOnline(login);
            if (userOnlione != null) {
                result = "User online";
            } else {
                user.setStatus("online");
                user.setRoom(roomActs.getRoom("home"));
                userOnlineArray.add(user);
                result = "OK";
            }
        } else {
            result = "wrong password!";
        }
        return result;
    }

    public synchronized String logout(String login) {
        String result = "";
        User user = getUserOnline(login);
        if (user != null) {
            user.setStatus("offline");
            user.setRoom(null);
            userOnlineArray.remove(user);
            result = "OK";
        } else {
            result = "User offline";
        }
        return result;
    }
}





