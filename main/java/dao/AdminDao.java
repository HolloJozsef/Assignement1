package dao;

import entities.Admin;
import entities.Request;
import entities.User;

import java.util.List;

public interface AdminDao extends Dao<Admin>{
    @Override
    void insert(Admin objectToCreate);
    List<User> showAllUsers();
    void addRequest(Request request);
    void deleteRequest(Request request);
     List<Request> showAllRequest();
}
