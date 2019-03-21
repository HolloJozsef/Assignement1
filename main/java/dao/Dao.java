package dao;

public interface Dao<T> {
    void insert(T objectToInsert);
    void remove(T objectToRemove);
}
