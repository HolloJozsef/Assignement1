package dao.jdbc;

import dao.*;

public class JdbcDaoFactory extends DaoFactory {
    @Override
    public UserDao getUserDao(){
        return new JdbcUserDao();
    }

    @Override
    public AdminDao getAdminDao(){return new JdbcAdminDao();}
}
