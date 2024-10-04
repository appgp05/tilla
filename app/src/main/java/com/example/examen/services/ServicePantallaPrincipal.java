package com.example.examen.services;

import android.widget.Toast;

import com.example.examen.MainActivity;
import com.example.examen.json_mapper.Movie;
import com.example.examen.json_mapper.MovieResponse;
import com.example.examen.listeners.MoviesAPI;
import com.example.examen.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServicePantallaPrincipal {

    private MainActivity padre;

    public ServicePantallaPrincipal(MainActivity padre) {
        this.padre = padre;
    }

    public void getPopularMovies() {
        Call<MovieResponse> call = RetrofitClient.getInstance().getPopularMovies(MoviesAPI.apiKey,"es-ES", 1);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    List<Movie> movies = response.body().getResults();
                    // Aquí puedes pasar la lista de películas a un callback para MainActivity
                    for (Movie myMovie : movies) {
                        Toast.makeText(padre, "Movie: " + myMovie.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(padre, "Error en la respuesta", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Toast.makeText(padre, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void getSearchedMovie() {
        Call<MovieResponse> call = RetrofitClient.getInstance().getSearchedMovie(MoviesAPI.apiKey,"es-ES","titanic",1);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    List<Movie> movies = response.body().getResults();
                    // Aquí puedes pasar la lista de películas a un callback para MainActivity
                    for (Movie myMovie : movies) {
                        Toast.makeText(padre, "Movie: " + myMovie.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(padre, "Error en la respuesta", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Toast.makeText(padre, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void getMovieDetailsById() {
        Call<Movie> call = RetrofitClient.getInstance().getMovieDetails(550, MoviesAPI.apiKey, "es-ES");
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Movie myMovie = response.body();
                    Toast.makeText(padre, "Details: " + myMovie.getOverview(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(padre, "Error en la respuesta", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                Toast.makeText(padre, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }


}
