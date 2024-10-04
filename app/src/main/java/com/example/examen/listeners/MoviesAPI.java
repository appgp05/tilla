package com.example.examen.listeners;

import com.example.examen.json_mapper.Movie;
import com.example.examen.json_mapper.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MoviesAPI {

    String apiKey = "8fcc6a4b12fc37e238032f61f36b27d8";

    // Obtener las películas populares
    @GET("movie/popular")
    Call<MovieResponse> getPopularMovies(@Query("api_key") String apiKey,
                                         @Query("language") String language,
                                         @Query("page") int page);

    // Buscar películas por título
    @GET("search/movie")
    Call<MovieResponse> getSearchedMovie(@Query("api_key") String apiKey,
                                         @Query("language") String language,
                                         @Query("query") String query,
                                         @Query("page") int page);

    // Obtener detalles de una pelicula
    @GET("movie/{movie_id}")
    Call<Movie> getMovieDetails(@Path("movie_id") int movieId,
                                @Query("api_key") String apiKey,
                                @Query("language") String language);
}

