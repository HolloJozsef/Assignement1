package dao.jdbc;

import dao.AdminDao;
import dao.connectionFactory;
import entities.Admin;
import entities.Request;
import entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcAdminDao implements AdminDao {

    @Override
    public void insert(Admin objectToCreate) {
        try{
            Connection connection = connectionFactory.getConnection();
            PreparedStatement pstmt=connection.prepareStatement("INSERT INTO `administrator` VALUES (?,?,?)");
            pstmt.setInt(1,objectToCreate.getIdAdmin());
            pstmt.setString(2,objectToCreate.getEmail());
            pstmt.setString(3,objectToCreate.getPassword());
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void delete(Admin objectToDelete) {
        try{
            Connection connection = connectionFactory.getConnection();
            PreparedStatement pstmt=connection.prepareStatement("DELETE FROM `administrator` VALUES (?,?,?)");
            pstmt.setInt(1,objectToDelete.getIdAdmin());
            pstmt.setString(2,objectToDelete.getEmail());
            pstmt.setString(3,objectToDelete.getPassword());
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void update(Admin userToUpdate){
        Connection dbConnection = connectionFactory.getConnection();
        PreparedStatement findStatement = null;
        try {
            findStatement = (PreparedStatement) dbConnection.prepareStatement("UPDATE administrator WHERE idAdmin=?");
            findStatement.setInt(1,userToUpdate.getIdAdmin());
            findStatement.executeUpdate();
        } catch (SQLException e) {

        }
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
