package br.com.gabrielcardoso.multidatasource;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.init.DataSourceScriptDatabaseInitializer;
import org.springframework.boot.sql.init.DatabaseInitializationMode;
import org.springframework.boot.sql.init.DatabaseInitializationSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.simple.JdbcClient;

@Configuration
public class DataSourceConfig {

        @Bean
        @Primary
        @ConfigurationProperties(prefix = "app.datasource.posts")
        DataSourceProperties postsDatasourceProperties() {
            return new DataSourceProperties();
        }

        @Primary
        @Bean
        DataSource postsDatasSource(DataSourceProperties props) {
            return props.initializeDataSourceBuilder().build();
        }

        @Primary
        @Bean
        JdbcClient postsJdbcClient(DataSource dataSource) {
            return JdbcClient.create(dataSource);
        }

        @Primary
        @Bean
        DataSourceScriptDatabaseInitializer postsDataSourceScriptDatabaseInitializer(DataSource dataSource) {
            var settings = new DatabaseInitializationSettings();
            settings.setSchemaLocations(List.of("classpath:posts-schema.sql"));
            settings.setMode(DatabaseInitializationMode.ALWAYS);
            return new DataSourceScriptDatabaseInitializer(dataSource, settings);
        }

        @Bean
        @ConfigurationProperties(prefix = "app.datasource.comments")
        DataSourceProperties commentsDatasourceProperties() {
            return new DataSourceProperties();
        }

        @Bean
        DataSource commentsDataSource(@Qualifier("commentsDatasourceProperties") DataSourceProperties props) {
            return props.initializeDataSourceBuilder().build();
        }

        @Bean
        JdbcClient commentsJdbcClient(@Qualifier("commentsDataSource") DataSource dataSource) {
            return JdbcClient.create(dataSource);
        }

        @Bean
        DataSourceScriptDatabaseInitializer commentsDataSourceScriptDatabaseInitializer(@Qualifier("commentsDataSource") DataSource dataSource) {
            var settings = new DatabaseInitializationSettings();
            settings.setSchemaLocations(List.of("classpath:comments-schema.sql"));
            settings.setMode(DatabaseInitializationMode.ALWAYS);
            return new DataSourceScriptDatabaseInitializer(dataSource, settings);
        }
}
