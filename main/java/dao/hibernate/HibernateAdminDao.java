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
    @Override
    public void insert(Admin objectToInsert){
        Session currentSession=sessionFactory.openSession();
        Transaction transaction=currentSession.beginTransaction();
        currentSession.persist(objectToInsert);
        transaction.commit();
        currentSession.close();
    }
    @Override
    public void remove(Admin objectToRemove){
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.delete(objectToRemove);
        transaction.commit();
        currentSession.close();
    }
    public List<User> showAllUsers(){
        Session currentSession = sessionFactory.openSession();
        return currentSession.createQuery("SELECT  (a) from User  a",User.class).getResultList();

    }
    public void addRequest(Request request){
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.createNativeQuery("INSERT INTO request (idcerere,idcasa,tip) VALUES (?,?,?)")
                .setParameter(1,request.getIdcerere())
                .setParameter(2,request.getIdcasa())
                .setParameter(3,request.getRequestType())
                .executeUpdate();
        transaction.commit();
        currentSession.close();
    }
    public void deleteRequest(Request request){
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.delete(request);
        transaction.commit();
        currentSession.close();
    }
    public List<Request> showAllRequest(){
        Session currentSession=sessionFactory.openSession();
        return  currentSession.createQuery("SELECT (a) from Request a",Request.class).getResultList();
    }
}
