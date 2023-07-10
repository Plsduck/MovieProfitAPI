package com.Glasbrenner.NewMovieApi.DAO;

import com.Glasbrenner.NewMovieApi.Model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
@Component
public class MovieDAO implements DAO<Movie>{

    @Autowired
    JdbcTemplate template;

    public MovieDAO(){

    }

    public void setTemplate(JdbcTemplate template){
        this.template = template;
    }
    @Override
    public Movie get(long id) throws SQLException {
        String sql = "SELECT * FROM movie WHERE id=?";

        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Movie>(Movie.class));

    }

    @Override
    public List<Movie> getAll() {

        String sql = "SELECT * FROM movie ";
        List<Movie> list = template.query(sql,new BeanPropertyRowMapper<Movie>(Movie.class));

        return list;
    }

    @Override
    public void save(Movie movie) {

        template.update("INSERT INTO movie (id,budget,profit,revenue,title,year) VALUES (?,?,?,?,?,?)",
        movie.getId(),movie.getBudget(),movie.getProfit(),movie.getRevenue(),movie.getTitle(),movie.getYear());

        System.out.println("Saved Successfully");
    }

    @Override
    public void update(Movie Oldmovie, long id) {


        template.update("UPDATE movie set title = ?,budget = ?, profit = ?, revenue = ?, title = ?, year = ? WHERE id = ?",
                Oldmovie.getId(),Oldmovie.getBudget(),Oldmovie.getProfit(),Oldmovie.getRevenue(),Oldmovie.getTitle(),
                Oldmovie.getYear(),id);
        System.out.println("Successfully Updated");
    }

    @Override
    public void delete(Movie movie) {
        template.update("DELETE from movie WHERE id = ?",movie.getId());

        System.out.println("Success!");
    }
}
