package com.sad366.compagnie_transports.Methodes;

import com.sad366.compagnie_transports.Tables.Client;
import com.sad366.compagnie_transports.Tables.User;

import java.util.List;

public interface ClientMethode {
    List<Client> getClients();
    Client addClient(Client client);
    Client upateClient(Long id, Client client);
    void deleteClient(Long id);


}
