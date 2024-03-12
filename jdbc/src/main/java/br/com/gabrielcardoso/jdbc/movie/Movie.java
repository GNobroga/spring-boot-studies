package br.com.gabrielcardoso.jdbc.movie;

import java.time.LocalDate;
import java.util.List;

import br.com.gabrielcardoso.jdbc.actor.Actor;

public record Movie(Integer id,
                    String name,
                    List<Actor> actors,
                    LocalDate releaseDate) {
}