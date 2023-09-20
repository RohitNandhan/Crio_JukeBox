package com.crio.old.jukebox.repositories;

import com.crio.old.jukebox.entites.User;
import com.crio.old.jukebox.exceptions.CustomerAlreadyPresentException;

import java.util.HashMap;
import java.util.Map;

public class UserRepository implements IUserRepository {
  private final Map<String, User> userMap;

    public UserRepository() {
        this.userMap = new HashMap<>();
    }

    @Override
    public User getUserById(String userId) {
        return userMap.get(userId);
    }

    @Override
    public void saveUser(User user) {
        try {
            if (userMap.containsKey(user.getId())) {
                    throw new CustomerAlreadyPresentException("USER EXIST");
            } else {
                userMap.put(user.getId(), user);
            }
        } catch (CustomerAlreadyPresentException e) {
            System.err.println(e);
        }
    }
}
