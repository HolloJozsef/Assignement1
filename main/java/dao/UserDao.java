package dao;

import entities.House;
import entities.Request;
import entities.User;

public interface UserDao extends Dao<User> {
    @Override
    void insert(User objectToCreate);
    User findUser(int id);
    void remove(User user);
    void addRequest(Request requestToInsert);
    void addHouse(House house);
    void removeHouse(House house);
    void removeRequest(Request request);
    int verifyNumberOfRequests(int houseId);
}
