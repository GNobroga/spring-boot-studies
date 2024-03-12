package br.com.giulianabezerra.springbootjooq;

import br.com.giulianabezerra.springbootjooq.public_.tables.records.UsersRecord;

public class UserMapper {
  public static UserDTO toUserDTO(UsersRecord usersRecord) {
    return new UserDTO(
        usersRecord.getUsername(),
        usersRecord.getPassword(),
        usersRecord.getEmail());
  }
}
