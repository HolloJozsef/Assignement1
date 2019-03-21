package dao;

import entities.House;

public interface HouseDao extends Dao<House>{
    @Override
    void insert (House houseToInsert);
    @Override
    void remove (House houseToRemove);
}
