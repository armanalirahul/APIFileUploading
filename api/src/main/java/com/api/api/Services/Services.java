package com.api.api.Services;

import java.util.List;
import java.util.Optional;

import com.api.api.Repository.Repo;
import com.api.api.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Services {

  @Autowired
  private Repo repo;

  public User addUser(User user) {
    return this.repo.save(user);
  }

  public List<User> getAllUsers() {
    List<User> users = (List<User>) repo.findAll();
    return users;

  }

  public Optional<User> getById(int id) {
    Optional<User> users = repo.findById(id);
    return users;
  }

  public int delete(int id) {
    // User user = list.stream().filter(e -> e.getid() == id).findFirst().get();
    int i = 0;
    repo.deleteById(id);
    i = 1;
    return i;
  }

  public User update(User user, int id) {
    user.setid(id);
   return repo.save(user);
}




}
