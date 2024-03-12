package br.com.gabrielcardoso.jdbcclient;

import java.util.List;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    
    private final JdbcClient jdbcClient;

    public UserRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<User> findAll() {
        return jdbcClient.sql("SELECT * FROM users")
            .query(User.class)
            .list();
    }

    public User findById(Long id) {
        return jdbcClient
                .sql("SELECT * FROM users where id = :id")
                .param("id", id)
                .query(User.class)
                .single();
    }

    public void save(User user) {
        jdbcClient
            .sql("INSERT INTO users (username, email, password) VALUES (:username, :email, :password)")
            .param("username", user.username())
            .param("email", user.email())
            .param("password", user.password())
            .update();
    }

    public void update(User user) {
        jdbcClient
            .sql("UPDATE users SET username = :username, email = :email, password = :password WHERE id = :id")
            .param("username", user.username())
            .param("email", user.email())
            .param("password", user.password())
            .param("id", user.id())
            .update();
    }


    public void deleteById(Long id) {
        jdbcClient 
            .sql("DELETE FROM users where id = :id") 
            .param("id", id)
            .update();
    }

}


