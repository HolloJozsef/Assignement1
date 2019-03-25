package dao.hibernate;

import dao.RequestDao;
import dao.hibernate.util.HibernateUtil;
import entities.Request;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateRequestDao implements RequestDao {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session currentSession = sessionFactory.openSession();
    Transaction transaction = currentSession.beginTransaction();
    @Override
    public void insert(Request objectToCreate){
        currentSession.merge(objectToCreate);
        transaction.commit();
        currentSession.close();
    }
    @Override
    public void update(Request objectToUpdate){
        currentSession.update(objectToUpdate);
        transaction.commit();
        currentSession.close();
    }
    public void delete(Request objectToDelete){
        currentSession.delete(objectToDelete);
        transaction.commit();
        currentSession.close();
    }
}
