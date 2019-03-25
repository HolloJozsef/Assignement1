package dao.jdbc;

import dao.HouseDao;
import dao.connectionFactory;
import entities.House;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcHouseDao implements HouseDao {

    public void insert(House objectToCreate) {
        try{
            Connection connection = connectionFactory.getConnection();
            PreparedStatement pstmt=connection.prepareStatement("INSERT INTO `house` VALUES (?,?,?)");
            pstmt.setInt(1,objectToCreate.getIdadresa());
            pstmt.setString(2,objectToCreate.getAdresa());
            pstmt.setInt(3,objectToCreate.getIdclient());
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void delete(House objectToDelete) {
        try{
            Connection connection = connectionFactory.getConnection();
            PreparedStatement pstmt=connection.prepareStatement("DELETE FROM `house` VALUES (?,?,?)");
            pstmt.setInt(1,objectToDelete.getIdadresa());
            pstmt.setString(2,objectToDelete.getAdresa());
            pstmt.setInt(3,objectToDelete.getIdclient());
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void update(House houseToUpdate){
        Connection dbConnection = connectionFactory.getConnection();
        PreparedStatement findStatement = null;
        try {
            findStatement = (PreparedStatement) dbConnection.prepareStatement("UPDATE house WHERE idcasa=?");
            findStatement.setInt(1,houseToUpdate.getIdadresa());
            findStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }

}
