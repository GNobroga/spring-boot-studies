package br.com.giulianabezerra.springbootjooq;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import br.com.giulianabezerra.springbootjooq.public_.tables.Users;
import br.com.giulianabezerra.springbootjooq.public_.tables.records.UsersRecord;

@Repository
public class UserRepositoryImpl implements UserRepository {
  private final DSLContext ctx;

  public UserRepositoryImpl(DSLContext ctx) {
    this.ctx = ctx;
  }

  @Override
  public UsersRecord create(UserDTO user) {
    UsersRecord usersRecord = ctx.newRecord(Users.USERS);
    usersRecord.setUsername(user.username());
    usersRecord.setPassword(user.password());
    usersRecord.setEmail(user.email());
    int stored = usersRecord.store();

    if (stored == 1) {
      return usersRecord;
    } else {
      throw new RuntimeException("User not created");
    }
  }

  @Override
  public UsersRecord findById(String username) {
    return this.ctx
        .selectFrom(Users.USERS)
        .where(Users.USERS.USERNAME.eq(username))
        .fetchOne();
  }
}
