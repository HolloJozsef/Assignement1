package dao;

import entities.User;

public interface UserDao extends Dao<User> {
    @Override
    void insert(User objectToCreate);
    void delete(User objectToRemove);
    void update(User objectToRemove);
    User findUser(int id);
    int verifyNumberOfRequests(int houseId);


}
