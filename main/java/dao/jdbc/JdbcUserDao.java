package dao.jdbc;

import dao.UserDao;
import dao.connectionFactory;
import entities.House;
import entities.Request;
import entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUserDao implements UserDao {
    @Override
    public void insert(User objectToCreate) {
        try{
            Connection connection = connectionFactory.getConnection();
                PreparedStatement pstmt=connection.prepareStatement("INSERT INTO `client` VALUES (?,?,?)");
                pstmt.setInt(1,objectToCreate.getId());
                pstmt.setString(2,objectToCreate.getEmail());
                pstmt.setString(3,objectToCreate.getPass());
                pstmt.executeUpdate();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
    }
    @Override
    public void remove(User objectToDelete) {
        try{
            Connection connection = connectionFactory.getConnection();
            PreparedStatement pstmt=connection.prepareStatement("DELETE FROM `client` VALUES (?,?,?)");
            pstmt.setInt(1,objectToDelete.getId());
            pstmt.setString(2,objectToDelete.getEmail());
            pstmt.setString(3,objectToDelete.getPass());
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public User findUser(int id){
        User user=new User();
        try {
            Connection connection = connectionFactory.getConnection();
            String strSelect = "select iduser, email, password from client";
            PreparedStatement pstmt=connection.prepareStatement("SELECT * FROM `client` WHERE iduser=VALUE (?)");
            pstmt.setInt(1,id);
            ResultSet rs=pstmt.getResultSet();
            while(rs.next()){
                user=new User(rs.getString(2),rs.getString(3),rs.getInt(1));
                System.out.println(user.toString());

            }
        }
         catch (SQLException ex) {
            ex.printStackTrace();
       }
        return user;
    }
    public void addRequest(Request requestToInsert) {
        Connection dbConnection = connectionFactory.getConnection();
        PreparedStatement findStatement = null;
        try {
            findStatement = (PreparedStatement) dbConnection.prepareStatement("INSERT INTO request VALUES (?,?, ?)");
            findStatement.setInt(1, requestToInsert.getIdcerere());
            findStatement.setInt(2,requestToInsert.getIdcasa());
            findStatement.setString(3,requestToInsert.getRequestType());
            findStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }
    public void addHouse(House house){
        Connection dbConnection = connectionFactory.getConnection();
        PreparedStatement findStatement = null;
        try {
            findStatement = (PreparedStatement) dbConnection.prepareStatement("INSERT INTO house VALUES (?,?, ?)");
            findStatement.setInt(1, house.getIdadresa());
            findStatement.setInt(3,house.getIdclient());
            findStatement.setString(2,house.getAdresa());
            findStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }
    public void removeHouse(House house){
        Connection dbConnection = connectionFactory.getConnection();
        PreparedStatement findStatement = null;
        try {
            findStatement = (PreparedStatement) dbConnection.prepareStatement("DELETE FROM house WHERE idproprietar=?");
            findStatement.setInt(1,house.getIdclient());
            findStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }
    public void removeRequest(Request request){
        Connection dbConnection = connectionFactory.getConnection();
        PreparedStatement findStatement = null;
        try {
            findStatement = (PreparedStatement) dbConnection.prepareStatement("DELETE FROM request WHERE idcasa=?");
            findStatement.setInt(1,request.getIdcasa());
            findStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }
    public int verifyNumberOfRequests(int houseId){
      int result=0;
        try {
            Connection connection = connectionFactory.getConnection();
            String strSelect = "select iduser, email, password from client";
            PreparedStatement pstmt=connection.prepareStatement("SELECT COUNT (idcasa) FROM request WHERE idcasa=?");
            pstmt.setInt(1,houseId);
            ResultSet rs=pstmt.getResultSet();

            if(rs!=null){
                rs.last();
                result=rs.getRow();
                System.out.println(result);

            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}

