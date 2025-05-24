package com.sad366.compagnie_transports.Repositories;

import com.sad366.compagnie_transports.Tables.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
