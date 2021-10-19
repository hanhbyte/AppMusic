package com.demo.service;

import java.util.Optional;
import com.demo.model.User;

public interface IUserService {
  Iterable<User> findAll();
  Optional<User> findById(Long id);
  void save(User user);
}
