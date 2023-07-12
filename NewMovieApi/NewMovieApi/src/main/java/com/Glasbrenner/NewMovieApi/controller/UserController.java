package com.Glasbrenner.NewMovieApi.controller;

import com.Glasbrenner.NewMovieApi.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class UserController {

    @Autowired
    UserDAO dao;

    @Autowired
    public UserController(UserDAO dao){
        this.dao = dao;
    }

    public void newUser(){

    }

    public void getPassword(){

    }
}
