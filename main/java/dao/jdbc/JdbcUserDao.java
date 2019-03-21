package dao.jdbc;

import dao.UserDao;
import dao.connectionFactory;
import entities.House;
import entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUserDao implements UserDao {
    public void insert(User objectToCreate) {
     //   public User getUser(int id){
        try{
            Connection connection = connectionFactory.getConnection();

              //  Statement stmt = connection.createStatement();
               //  stmt.execute("INSERT INTO `client` VALUES (1,'jdbcTest','bbb')");
                PreparedStatement pstmt=connection.prepareStatement("INSERT INTO `client` VALUES (?,?,?)");
                pstmt.setInt(1,objectToCreate.getId());
                pstmt.setString(2,objectToCreate.getEmail());
                pstmt.setString(3,objectToCreate.getPass());
                pstmt.executeUpdate();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

       //}
    }
    public void insertHouse( House h){

    }

    public void remove(User user) {

    }
    public User findUser(int id){
        User user=new User();
        return user;
    }
}
