package dao.hibernate;

import dao.RequestDao;
import dao.hibernate.util.HibernateUtil;
import entities.Request;
import org.hibernate.SessionFactory;

public class HbernateRequestDao implements RequestDao {
    private SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
    @Override
    public void insert(Request requestToInsert){

    }
    @Override
    public void remove(Request requestToRemove){

    }
}
