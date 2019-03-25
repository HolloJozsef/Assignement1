package dao;

public interface Dao<T> {
    void insert(T objectToInsert);
    void delete(T objectToRemove);
    void update(T objectToRemove);
}
