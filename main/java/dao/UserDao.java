package dao;

import entities.User;

public interface UserDao extends Dao<User> {
    @Override
    void insert(User objectToCreate);
    User findUser(int id);
}
