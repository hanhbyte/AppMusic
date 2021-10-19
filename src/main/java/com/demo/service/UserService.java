package com.demo.service;

import java.util.Optional;
import com.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
  @Autowired
  IUserService userService;
  @Override
  public Iterable<User> findAll() {
    return userService.findAll();
  }

  @Override
  public Optional<User> findById(Long id) {
    return userService.findById(id);
  }

  @Override
  public void save(User user) {
    userService.save(user);
  }
}
