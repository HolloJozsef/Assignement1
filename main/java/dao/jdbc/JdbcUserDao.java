package dao.jdbc;

import dao.UserDao;
import dao.connectionFactory;
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
    public void delete(User objectToDelete) {
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
   public void update(User userToUpdate){
       Connection dbConnection = connectionFactory.getConnection();
       PreparedStatement findStatement = null;
       try {
           findStatement = (PreparedStatement) dbConnection.prepareStatement("UPDATE user WHERE iduser=?");
           findStatement.setInt(1,userToUpdate.getId());
           findStatement.executeUpdate();
       } catch (SQLException e) {

       }
    }

}

