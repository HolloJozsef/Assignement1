package dao.jdbc;

import dao.AdminDao;
import entities.Admin;
import entities.Request;
import entities.User;

import java.util.ArrayList;
import java.util.List;

public class JdbcAdminDao implements AdminDao {

    public void insert(Admin adminToInsert){

    }
    public void remove(Admin adminToRemove) {

    }
    public List<User> showAllUsers(){

        List<User> client1= new ArrayList<User>() ;
        client1.add(new User());
        return client1;
    }
    public void addRequest(Request request){

    }
    public void deleteRequest(Request request){

    }
    public List<Request> showAllRequest() {
        List<Request> request1=new ArrayList<Request>();
        request1.add(new Request());
        return request1;
    }
}
