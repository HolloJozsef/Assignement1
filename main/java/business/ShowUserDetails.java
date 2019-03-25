package business;

import dao.DaoFactory;
import dao.UserDao;

public class ShowUserDetails {
    private final DaoFactory daoFactory;
    private int userId;
    public ShowUserDetails(DaoFactory daoFactory,int userId){
        this.daoFactory=daoFactory;
        this.userId=userId;
    }
    public void execute(){
        UserDao userDao=daoFactory.getUserDao();
       int result=daoFactory.getUserDao().verifyNumberOfRequests(userId);
        if(result >=4) {
            System.out.println("Numarul maxim de cas este 3!");
            throw new IllegalArgumentException("Numar prea mare de case!");
        }
        else
            System.out.println("Numarul de case este "+result);
    }

}

/*
UserDao userDao = daoFactory.getUserDao();
        User user=userDao.findUser(1);
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
        if(userDao.verifyNumberOfRequests(3))
            System.out.println("LEGAL");
        else
            System.out.println("NOT LEGAL");
        // System.out.println(user.toString());
        return user;
 */