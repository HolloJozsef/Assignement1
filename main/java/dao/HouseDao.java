package dao;

import entities.House;

public interface HouseDao  extends Dao<House>{
    @Override
    void delete(House objectToDelete);

    @Override
    void update(House objectToUpdate);

    @Override
    void insert(House objectToCreate);
}
