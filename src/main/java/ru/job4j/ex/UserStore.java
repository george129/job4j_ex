package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User ret = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(login)) {
                ret = users[i];
                break;
            }
        }
        if (ret == null) {
            throw new UserNotFoundException("User not found");
        }
        return ret;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean ret = false;
        if (user.getUsername().length() < 3 || !user.isValid()) {
            throw new UserInvalidException("User is not valid");
        } else {
            ret = true;
        }
        return ret;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        User user;
        try {
            user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
