import business.ShowUserDetails;
import dao.AdminDao;
import dao.DaoFactory;
import dao.UserDao;
import dao.hibernate.util.HibernateUtil;
import entities.House;
import entities.User;
import entities.Request;
import java.io.IOException;
import java.util.List;

public class Main {
    public static final int USER_ID = 1;
    public static void main(String[] args) throws IOException {
        DaoFactory daoFactory = DaoFactory.getInstance(DaoFactory.Type.HIBERNATE);
        insertInitialData(daoFactory);
        ShowUserDetails transactionScript = new ShowUserDetails(daoFactory, 1);
        transactionScript.execute();
        System.in.read();
        HibernateUtil.getSessionFactory().close();
    }
    private static void insertInitialData(DaoFactory daoFactory){

        User human=new User();
        human.setEmail("human@gmail.com");
        human.setId(USER_ID);
        human.setPass("12322224");
        daoFactory.getUserDao().insert(human);
        UserDao userDao = daoFactory.getUserDao();
       // User user=userDao.findUser(1);
        userDao.addRequest(new Request("dinUser",3,777));

        userDao.addHouse(new House("cevaNume",1,5));
        userDao.addRequest(new Request("cerere1",1));
        AdminDao adminDao=daoFactory.getAdminDao();
        List<User> clieti=adminDao.showAllUsers();
        System.out.println(clieti.toString()+"from showAllUsers method");
        adminDao.addRequest(new Request("adeverinta",3,3));
        //   adminDao.deleteRequest(new Request("cerere1",1,1));
        adminDao.addRequest(new Request("adeverinta2",3,78));

        adminDao.addRequest(new Request("adeverinta3",3,213));
        System.out.println(adminDao.showAllRequest().toString());
       // human.addHouse(casa);
    }














        /*
       Connection connection = dao.connectionFactory.getConnection();
        UserDaoImplementation us=new UserDaoImplementation();
        us.getUser(1);
        System.out.println(us.toString());





       HibernateUserDao aaaa=new HibernateUserDao();
        House home=new House("Obs 3");
        User Alec=new User(4,"jdbcTest2","bbb3",null);
        System.out.println(home.toString());
        System.out.println(Alec.toString());
       // Alec.addHouse(home);
       // Alec.addHouse(new House("test"));
       // aaaa.insert(Alec);
       // aaaa.insertHouse(home);
        Alec.addHouse(home);
       System.out.println(Alec.toString());
       // JdbcUserDao aa=new JdbcUserDao();
      // aa.insert(Alec);
*/




}
