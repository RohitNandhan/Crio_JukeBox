package com.crio.old.jukebox.repositories;

import com.crio.old.jukebox.entites.User;

public interface IUserRepository {
    User getUserById(String userId);
    void saveUser(User user);
}
