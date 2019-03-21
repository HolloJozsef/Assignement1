package dao.hibernate;

import dao.DaoFactory;
import dao.HouseDao;
import dao.UserDao;

public class HibernateDaoFactory extends DaoFactory {
    @Override
    public UserDao getUserDao(){
        return new HibernateUserDao();
    }
    @Override
    public HouseDao getHouseDao(){
        return new HibernateHouseDao();
    }
}
