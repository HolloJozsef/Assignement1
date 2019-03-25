package dao.hibernate;

import dao.AdminDao;
import dao.hibernate.util.HibernateUtil;
import entities.Admin;
import entities.Request;
import entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateAdminDao implements AdminDao {
    private SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
    Session currentSession = sessionFactory.openSession();
    Transaction transaction = currentSession.beginTransaction();
    @Override
    public void insert(Admin objectToInsert){
        currentSession.persist(objectToInsert);
        transaction.commit();
        currentSession.close();
    }
    @Override
    public void delete(Admin objectToRemove){

        currentSession.delete(objectToRemove);
        transaction.commit();
        currentSession.close();
    }
    public void update(Admin objectToUpdate){
        currentSession.update(objectToUpdate);
        transaction.commit();
        currentSession.close();

    }
    public List<User> showAllUsers(){
        Session currentSession = sessionFactory.openSession();
        return currentSession.createQuery("SELECT  (a) from User  a",User.class).getResultList();

    }
    public List<Request> showAllRequest(){
        Session currentSession=sessionFactory.openSession();
        return  currentSession.createQuery("SELECT (a) from Request a",Request.class).getResultList();
    }
}
