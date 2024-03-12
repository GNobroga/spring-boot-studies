package br.com.gabrielcardoso.jdbc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatasourceConfig {
    
    @Bean
    @ConfigurationProperties("app.datasource.main")
    HikariDataSource hikariDataSource() {
        return DataSourceBuilder
            .create()
            .type(HikariDataSource.class)
            .build(); 
    }

    
    @Bean
    PlatformTransactionManager platformTransactionManager(HikariDataSource hikariDataSource) {
        return new DataSourceTransactionManager(hikariDataSource);
    }

    @Bean
    JdbcTemplate jdbcTemplate(HikariDataSource hikariDataSource) {
        return new JdbcTemplate(hikariDataSource);
    }

    @Bean
    NamedParameterJdbcTemplate namedParameterJdbcTemplate(HikariDataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
 