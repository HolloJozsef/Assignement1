package dao;

import dao.hibernate.HibernateDaoFactory;
import dao.jdbc.JdbcDaoFactory;
public abstract class DaoFactory {

        private static final DaoFactory HIBERNATE_DAO_FACTORY = new HibernateDaoFactory();
        private static final DaoFactory JDBC_DAO_FACTORY      = new JdbcDaoFactory();

        public enum Type {
            HIBERNATE,
            JDBC
        }

        public DaoFactory() {

        }

        public static DaoFactory getInstance(Type factoryType) {
            switch (factoryType) {
                case HIBERNATE:
                    return HIBERNATE_DAO_FACTORY;
                case JDBC:
                    return JDBC_DAO_FACTORY;
                default:
                    throw new IllegalArgumentException("Invalid factory");
            }
        }

        public abstract UserDao getUserDao();

        public abstract AdminDao getAdminDao();

      public abstract HouseDao getHouseDao();

      public abstract RequestDao getRequestDao();
}
