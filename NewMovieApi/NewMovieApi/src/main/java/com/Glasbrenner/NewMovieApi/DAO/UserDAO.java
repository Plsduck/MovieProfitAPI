package com.Glasbrenner.NewMovieApi.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.SQLException;
import java.util.List;

public class UserDAO implements DAO{

    @Autowired
    JdbcTemplate template;

    @Autowired
    PasswordEncoder encoder;
    @Override
    public Object get(long id) throws SQLException {
        return null;
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public void update(Object o, long id) {

    }

    @Override
    public void delete(Object o) {

    }
}
