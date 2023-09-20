package com.crio.jukebox.repositories;

import com.crio.jukebox.entites.User;
import com.crio.jukebox.exceptions.CustomerAlreadyPresentException;

import java.util.HashMap;
import java.util.Map;

public class UserRepository implements IUserRepository{
  private final Map<String,User> userMap;
  private static int counter=0;

    public UserRepository() {
        this.userMap = new HashMap<>();
    }

    @Override
    public User getUserById(String userId) {
        return userMap.get(userId);
    }

    @Override
    public User saveUser(User user) {
        try {
            if (userMap.containsKey(user.getId())) {
                    throw new CustomerAlreadyPresentException("USER EXIST");
            } else {
                userMap.put(user.getId(), user);
            }
        } catch (CustomerAlreadyPresentException e) {
            System.err.println(e);
        }
       return user;
    }
    @Override
    public User saveUser(String userName) {
          String userId=String.valueOf(++counter);
         return saveUser(new User(userId,userName));
    }

}
