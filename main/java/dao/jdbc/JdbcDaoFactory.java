package dao.jdbc;

import dao.DaoFactory;
import dao.HouseDao;
import dao.UserDao;
import dao.hibernate.HibernateHouseDao;

public class JdbcDaoFactory extends DaoFactory {
    @Override
    public UserDao getUserDao(){
        return new JdbcUserDao();
    }
    @Override
    public HouseDao getHouseDao(){ return new HibernateHouseDao();
    }
}
