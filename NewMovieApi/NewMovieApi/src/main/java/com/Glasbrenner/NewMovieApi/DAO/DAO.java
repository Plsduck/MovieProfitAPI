package com.Glasbrenner.NewMovieApi.DAO;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    T get(long id) throws SQLException;

    List<T> getAll();

    void save(T t);

    void update(T t, long id);

    void delete(T t);
}
