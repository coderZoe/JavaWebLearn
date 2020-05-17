package Servlet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yhs
 * @date 2020/5/6 11:04
 * @description
 */
public class Class23UserDemo {
    private static List<User> userList = new ArrayList<>();
    static {
        User user = new User("tom","123");
        User user1 = new User("mary","123");
        User user2 = new User("kate","123");
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
    }

    public static User getUSer(String username,String password){
        for(User user:userList){
            if(user.getUserName().equals(username)&&user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
}

class   User{
    private String userName;
    private String password;

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
