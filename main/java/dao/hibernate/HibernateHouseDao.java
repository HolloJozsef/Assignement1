package dao.hibernate;

import dao.HouseDao;
import dao.hibernate.util.HibernateUtil;
import entities.House;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateHouseDao implements HouseDao {
    private SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
    @Override
    public void insert(House houseToInsert){
        Session currentSession =sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.persist(houseToInsert);
        transaction.commit();
        currentSession.close();
    }
    @Override
    public void remove(House houseToRemove){
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.delete(houseToRemove);
        transaction.commit();
        currentSession.close();
    }
}
