package dao.hibernate;

import dao.UserDao;
import dao.hibernate.util.HibernateUtil;
import entities.Request;
import entities.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class HibernateUserDao implements UserDao {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session currentSession = sessionFactory.openSession();
    Transaction transaction = currentSession.beginTransaction();
    @Override
    public void insert(User objectToCreate){
        currentSession.merge(objectToCreate);
        transaction.commit();
        currentSession.close();

    }
    public User findUser(int id){
        User user=currentSession.get(User.class,id);
        transaction.commit();
        currentSession.close();
        return user;
    }
    public void update(User objectToUpdate){
        currentSession.update(objectToUpdate);
        transaction.commit();
        currentSession.close();

    }
    public void delete(User user){
        currentSession.delete(user);
        transaction.commit();
        currentSession.close();
    }


    public int verifyNumberOfRequests(int houseId) {
        Session currentSession = sessionFactory.openSession();
        currentSession.createNativeQuery("SELECT COUNT (idcasa) FROM request WHERE idcasa=?").
                setParameter(1, houseId);
        Criteria crit=currentSession.createCriteria(Request.class);
        crit.add(Restrictions.eq("idcasa",houseId));
        List<Request> results=crit.list();
        int res=results.size();
        return res;


    }
}
