package dao.hibernate;

import dao.UserDao;
import dao.hibernate.util.HibernateUtil;
import entities.House;
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
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.delete(user);
        transaction.commit();
        currentSession.close();
    }
    @Override
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
    public void addHouse(House house){
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.createNativeQuery("INSERT INTO house (adresa,idproprietar,idadresa) VALUES (?,?,?)")
                .setParameter(1,house.getAdresa())
                .setParameter(2,house.getIdclient())
                .setParameter(3,house.getIdadresa())
                .executeUpdate();
        transaction.commit();
        currentSession.close();
    }
    public void removeHouse(House house){
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.createNativeQuery("REMOVE FROM house (adresa,idproprietar,idadresa) VALUES (?,?,?)")
                .setParameter(1,house.getAdresa())
                .setParameter(2,house.getIdclient())
                .setParameter(3,house.getIdadresa())
                .executeUpdate();
        transaction.commit();
        currentSession.close();
    }
    public void removeRequest(Request request){
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.createNativeQuery("REMOVE FROM request (idcerere,idcasa,tip) VALUES (?,?,?)")
                .setParameter(1,request.getIdcerere())
                .setParameter(2,request.getIdcasa())
                .setParameter(3,request.getRequestType())
                .executeUpdate();
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
