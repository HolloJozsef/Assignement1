package dao.hibernate;

import dao.HouseDao;
import dao.hibernate.util.HibernateUtil;
import entities.House;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateHouseDao implements HouseDao {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session currentSession = sessionFactory.openSession();
    Transaction transaction = currentSession.beginTransaction();
    @Override
    public void insert(House objectToCreate){
        currentSession.merge(objectToCreate);
        transaction.commit();
        currentSession.close();
    }
    @Override
    public void update(House objectToUpdate){
        currentSession.update(objectToUpdate);
        transaction.commit();
        currentSession.close();
    }
    public void delete(House objectToDelete){
        currentSession.delete(objectToDelete);
        transaction.commit();
        currentSession.close();
    }
}
