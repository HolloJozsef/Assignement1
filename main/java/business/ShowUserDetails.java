package business;

import dao.DaoFactory;
import dao.HouseDao;
import dao.UserDao;
import entities.House;
import entities.User;

public class ShowUserDetails {
    private final DaoFactory daoFactory;
    private long userId;
    public ShowUserDetails(DaoFactory daoFactory,int userId){
        this.daoFactory=daoFactory;
        this.userId=userId;
    }
    public User execute(){
        UserDao userDao = daoFactory.getUserDao();
        User user=userDao.findUser(1);

        HouseDao houseDao=daoFactory.getHouseDao();
         houseDao.insert(new House("cevaNume",user));


        System.out.println(user.toString());
        return user;
    }

}
