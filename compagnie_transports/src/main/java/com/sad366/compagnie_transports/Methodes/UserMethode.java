package com.sad366.compagnie_transports.Methodes;

import com.sad366.compagnie_transports.Tables.User;
import com.sad366.compagnie_transports.Tables.User;

import java.util.List;

public interface UserMethode {
    List<User> getUsers();
    User addUser(User user);
    User upateUser(Long id, User user);
    void deleteUser(Long id);

}

