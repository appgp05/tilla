package com.example.examen;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.examen.services.ServicePantallaPrincipal;

public class MainActivity extends AppCompatActivity {
    private Button btnMostrarPeliculas;
    private Button btnMostrarPeliculaBuscada;
    private Button btnMostrarDetallesPeliculaPorId;

    /////PATRON SINGLETON
    private static MainActivity padre;
    public static MainActivity getInstance(){
        return padre;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // SINGLETON
        this.padre = this;
        // FIN SINGLETON

        ServicePantallaPrincipal service = new ServicePantallaPrincipal(padre);
        btnMostrarPeliculas = findViewById(R.id.popular_button);
        btnMostrarPeliculaBuscada = findViewById(R.id.search_button);
        btnMostrarDetallesPeliculaPorId = findViewById(R.id.details_button);

        btnMostrarPeliculas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service.getPopularMovies();
            }
        });

        btnMostrarPeliculaBuscada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service.getSearchedMovie();
            }
        });

        btnMostrarDetallesPeliculaPorId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                service.getMovieDetailsById();
            }
        });
    }
}