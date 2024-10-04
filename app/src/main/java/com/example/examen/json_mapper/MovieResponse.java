package com.example.examen.json_mapper;

import com.example.examen.json_mapper.Movie;

import java.util.List;

public class MovieResponse {
    // URL: https://api.themoviedb.org/3/movie/popular?api_key=API_KEY
    private List<Movie> results;

    public List<Movie> getResults() {
        return results;
    }
    public void setResults(List<Movie> results) {
        this.results = results;
    }
}