<h1 align="center">
  Spring Boot jOOQ
</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=Youtube&message=@giulianabezerra&color=8257E5&labelColor=000000" alt="@giulianabezerra" />
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Demo&color=8257E5&labelColor=000000" alt="Demo" />
</p>

Demo apresentada [aqui](https://youtu.be/6av6oUZK_zc) para ilustrar o uso do jOOQ + Spring Boot como framework de persistência de dados.

## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [jOOQ](https://www.jooq.org)
- [Postgres](https://www.postgresql.org)
- [Docker Compose](https://docs.docker.com/compose/)

## Instruções

- Iniciar banco de dados
```
docker-compose up --build --force-recreate --remove-orphans -d
```

- Executar o projeto
- Gerar entidades a partir do banco
```
./mvnw clean generate-sources
```
- Reiniciar a aplicação

Para derrubar o docker após os testes, executar `docker-compose down`.

## API

Para testar, as seguintes chamadas poderão ser feitas:

- POST /users
```
http POST :8080/users username=username password=password email=email
```

- GET /users/{username}
```
http :8080/users/username 
```