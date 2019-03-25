package dao;

import entities.Admin;
import entities.Request;
import entities.User;

import java.util.List;

public interface AdminDao extends Dao<Admin>{

    List<User> showAllUsers();

     List<Request> showAllRequest();
    @Override
    void delete(Admin objectToDelete);

    @Override
    void update(Admin objectToUpdate);

    @Override
    void insert(Admin objectToCreate);
}
