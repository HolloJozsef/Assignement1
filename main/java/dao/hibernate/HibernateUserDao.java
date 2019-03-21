package dao.hibernate;

import dao.UserDao;
import dao.hibernate.util.HibernateUtil;
import entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateUserDao implements UserDao {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    @Override
    public void insert(User objectToCreate){
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.merge(objectToCreate);
        transaction.commit();
        currentSession.close();
    }
    public User findUser(int id){
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        User user=currentSession.get(User.class,id);
        transaction.commit();
        currentSession.close();
        return user;
    }
    public void remove(User user){

    }

}
