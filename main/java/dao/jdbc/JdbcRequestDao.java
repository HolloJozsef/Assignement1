package dao.jdbc;

import dao.RequestDao;
import dao.connectionFactory;
import entities.Request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcRequestDao implements RequestDao {
    public void insert(Request requestToInsert) {
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

    public void delete(Request request){
        Connection dbConnection = connectionFactory.getConnection();
        PreparedStatement findStatement = null;
        try {
            findStatement = (PreparedStatement) dbConnection.prepareStatement("DELETE FROM request WHERE idcasa=?");
            findStatement.setInt(1,request.getIdcasa());
            findStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }
    public void update(Request request){
        Connection dbConnection = connectionFactory.getConnection();
        PreparedStatement findStatement = null;
        try {
            findStatement = (PreparedStatement) dbConnection.prepareStatement("UPDATE request WHERE idcasa=?");
            findStatement.setInt(1,request.getIdcasa());
            findStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }
}
