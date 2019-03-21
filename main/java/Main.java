import business.ShowUserDetails;
import dao.DaoFactory;
import dao.hibernate.util.HibernateUtil;
import entities.House;
import entities.User;

import java.io.IOException;

public class Main {
    public static final int USER_ID = 1;
    public static void main(String[] args) throws IOException {
        DaoFactory daoFactory = DaoFactory.getInstance(DaoFactory.Type.HIBERNATE);
        insertInitialData(daoFactory);
        ShowUserDetails transactionScript = new ShowUserDetails(daoFactory, USER_ID);
        User execute = transactionScript.execute();
        if (execute != null) {
            System.out.println("User" + execute.toString());


        }
        System.in.read();
        HibernateUtil.getSessionFactory().close();
    }
    private static void insertInitialData(DaoFactory daoFactory){

        User human=new User();
        human.setEmail("human@gmail.com");
        human.setId(USER_ID);
        human.setPass("12322224");
        House casa=new House("TESTCASAMAIN",human);
        daoFactory.getUserDao().insert(human);
        daoFactory.getHouseDao().insert(casa);
        human.addHouse(casa);
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
