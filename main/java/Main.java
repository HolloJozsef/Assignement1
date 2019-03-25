import dao.DaoFactory;
import dao.UserDao;
import dao.hibernate.util.HibernateUtil;
import entities.User;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static final int USER_ID = 1;
    public static void main(String[] args) throws IOException {
   
        System.out.println("1.JDBC");
        System.out.println("2.HIBERNATE");
        Scanner in = new Scanner(System.in);
        int myInt = (Integer.parseInt(in.nextLine()));
        DaoFactory daoFactory=null;
        switch (myInt) {
            case 1:
                 daoFactory = DaoFactory.getInstance(DaoFactory.Type.JDBC);
                break;
            case 2:
                 daoFactory = DaoFactory.getInstance(DaoFactory.Type.HIBERNATE);
                break;
        }
        while (myInt != 0) {
            System.out.println("1.User");
            System.out.println("2.Admin");
            myInt = (Integer.parseInt(in.nextLine()));
            switch (myInt) {
                case 1:
                    System.out.println("Choose from:1.Register     2.Login     3.Add House    " +
                            "3.Remove House    4.Add Request        5.Remove Request");
                    int myint2 = (Integer.parseInt(in.nextLine()));
                    switch (myint2) {
                        case 1:
                            System.out.println("Email: ");
                            String email = in.nextLine();
                            System.out.println("Password: ");
                            String pass = in.nextLine();
                            System.out.println("Id: ");
                            int id = (Integer.parseInt(in.nextLine())) ;
                            UserDao userDao = daoFactory.getUserDao();
                            userDao.insert(new User(email, pass, id));
                    }

            }
        }
        System.in.read();
        HibernateUtil.getSessionFactory().close();
    }
    private static void insertInitialData(DaoFactory daoFactory){

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
