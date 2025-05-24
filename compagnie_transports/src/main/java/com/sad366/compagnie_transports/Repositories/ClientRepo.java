package com.sad366.compagnie_transports.Repositories;

import com.sad366.compagnie_transports.Tables.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, Long> {
}
