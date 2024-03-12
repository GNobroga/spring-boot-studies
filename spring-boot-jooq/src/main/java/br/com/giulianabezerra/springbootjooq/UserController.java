package br.com.giulianabezerra.springbootjooq;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
  private UserRepository repository;

  public UserController(UserRepository repository) {
    this.repository = repository;
  }

  @GetMapping("{username}")
  public UserDTO findUserByUsername(@PathVariable("username") String username) {
    return UserMapper.toUserDTO(this.repository.findById(username));
  }

  @PostMapping
  public UserDTO createUser(@RequestBody UserDTO user) {
    return UserMapper.toUserDTO(this.repository.create(user));

  }
}
