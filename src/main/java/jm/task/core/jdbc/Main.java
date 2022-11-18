package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        UserService u = new UserServiceImpl();
        u.createUsersTable();
        u.saveUser("Alex", "Afanasev", (byte)25);
        u.saveUser("Yulia", "Chlynina", (byte)27);
        u.saveUser("Vladimir", "Vladimirov", (byte)47);
        u.saveUser("Robert", "Stivenson", (byte)34);
        List<User> users = u.getAllUsers();
        users.stream().forEach(user -> System.out.println(user));
        u.cleanUsersTable();
        u.dropUsersTable();
    }
}
