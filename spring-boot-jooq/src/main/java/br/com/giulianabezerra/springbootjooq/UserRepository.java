package br.com.giulianabezerra.springbootjooq;

import br.com.giulianabezerra.springbootjooq.public_.tables.records.UsersRecord;

public interface UserRepository {
  UsersRecord findById(String username);

  UsersRecord create(UserDTO user);
}
