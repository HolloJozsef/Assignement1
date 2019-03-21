package dao;

import entities.Request;

public interface RequestDao extends Dao<Request> {
    @Override
    void insert (Request requestToInsert);
    @Override
    void remove(Request requestToRemove);
}
