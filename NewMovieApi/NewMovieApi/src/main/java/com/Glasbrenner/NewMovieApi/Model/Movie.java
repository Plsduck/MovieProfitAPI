package com.Glasbrenner.NewMovieApi.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name="Movie")

public class Movie {
    @Id
    @Column(name="id")
    private long id;

    private String title;

    private int budget;

    private long revenue;

    private long profit;
    private int year;
    public Movie(){

    }
    public Movie(long id, String title, int budget, long revenue, long profit, int year) {
        this.id = id;
        this.title = title;
        this.budget = budget;
        this.revenue = revenue;
        this.profit = profit;
        this.year = year;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public long getRevenue() {
        return revenue;
    }

    public void setRevenue(long revenue) {
        this.revenue = revenue;
    }

    public long getProfit() {
        return profit;
    }

    public void setProfit(long profit) {
        this.profit = profit;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}