package java_database.controller;

import java_database.model.MovieDao;
import java_database.repository.MovieCategoryRepository;
import java_database.repository.MovieRepository;
import java_database.view.Imdb;

public class ImdbController {

    MovieRepository movieRepository = new MovieRepository();
    MovieCategoryRepository movieCategoryRepository = new MovieCategoryRepository();

    public ImdbController() {

        Imdb imdb = new Imdb(this);

    }


    public void listMovies() {

        movieRepository.getAll().stream().forEach(System.out::println);

        System.out.println("========");

        for(MovieDao movie : movieRepository.getAll()){
            System.out.println(movie);
        }

    }

    public void listCategories() {

        movieCategoryRepository.getAll().stream().forEach(System.out::println);

    }

    public void addMovie(MovieDao movieDao) {
        movieRepository.save(movieDao);
    }

}
