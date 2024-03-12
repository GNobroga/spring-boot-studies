package br.com.gabrielcardoso.jdbc.movie;

import java.util.List;
import java.util.Optional;

public interface IMovieDAO {
    List<Movie> selectMovies();
    int insertMovie(Movie movie);
    int deleteMovie(int id);
    Optional<Movie> selectMovieById(int id);
}