package web.services;

import web.models.User;

import java.util.List;

public interface UserService {
    List<User> showUsers();

    void addUser(User user);

    User showUser(int id);

    void deleteUser(int id);

    void updateUser(User user);
}
