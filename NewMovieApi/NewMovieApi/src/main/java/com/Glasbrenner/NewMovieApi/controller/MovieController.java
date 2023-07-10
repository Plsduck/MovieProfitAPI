package com.Glasbrenner.NewMovieApi.controller;

import com.Glasbrenner.NewMovieApi.DAO.MovieDAO;
import com.Glasbrenner.NewMovieApi.Model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {
    @Autowired
    MovieDAO dao;

@Autowired public MovieController(MovieDAO dao){
    this.dao = dao;
}
    @GetMapping("/movie")
    public List<Movie> getAllMovieDetails() {
        return dao.getAll();
    }

    @GetMapping("/movie/{id}")
    public Movie getByID(@PathVariable long id) throws SQLException {
        return dao.get(id);
    }


    @PostMapping("/movie")
    public String postMovieDetails(@RequestBody Movie movie){
        dao.save(movie);
        return "Post Mapping completed";
    }

    @PutMapping("/movie/{id}")
    public String putMovieDetails(@RequestBody Movie movie, @PathVariable long id){
        dao.update(movie,id);
        return "Put Mapping completed";
    }

    @DeleteMapping("/movie")
    public String deleteMovieDetails(@RequestBody Movie movie){

        dao.delete(movie);
        return "Delete Mapping completed";
    }


}
