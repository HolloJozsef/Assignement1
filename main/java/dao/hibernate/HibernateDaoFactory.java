package dao.hibernate;

import dao.*;

public class HibernateDaoFactory extends DaoFactory {
    @Override
    public UserDao getUserDao(){
        return new HibernateUserDao();
    }


    @Override
    public AdminDao getAdminDao(){ return new HibernateAdminDao();
    }
}
