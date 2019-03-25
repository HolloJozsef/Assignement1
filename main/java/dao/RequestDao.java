package dao;

import entities.Request;

public interface RequestDao extends Dao<Request>{
    @Override
    void delete(Request objectToDelete);

    @Override
    void update(Request objectToUpdate);

    @Override
    void insert(Request objectToCreate);
}
