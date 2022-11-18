package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
    private UserDaoHibernateImpl userDaoHyb = new UserDaoHibernateImpl();

    public void createUsersTable() {
        userDaoHyb.createUsersTable();
    }

    public void dropUsersTable() {
        userDaoHyb.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoHyb.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userDaoHyb.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userDaoHyb.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaoHyb.cleanUsersTable();
    }
}
