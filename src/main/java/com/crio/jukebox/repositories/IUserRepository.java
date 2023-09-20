package com.crio.jukebox.repositories;

import com.crio.jukebox.entites.User;

public interface IUserRepository {
    User getUserById(String userId);
    User saveUser(User user);

    User saveUser(String userName);
}
