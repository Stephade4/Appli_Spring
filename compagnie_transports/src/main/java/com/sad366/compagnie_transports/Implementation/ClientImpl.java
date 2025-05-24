package com.sad366.compagnie_transports.Implementation;


import com.sad366.compagnie_transports.Methodes.ClientMethode;
import com.sad366.compagnie_transports.Repositories.ClientRepo;
import com.sad366.compagnie_transports.Tables.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClientImpl implements ClientMethode {

    private final ClientRepo clientRepo;
    @Override
    public List<Client> getClients() {
        return clientRepo.findAll();
    }

    @Override
    public Client addClient(Client client) {
        return clientRepo.save(client);
    }

    @Override
    public Client upateClient(Long id, Client client) {

        Client existingClient = clientRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client introuvable"));

        existingClient.setNom_prenom_clt(client.getNom_prenom_clt());
        existingClient.setNumCNI_clt(client.getNumCNI_clt());
        existingClient.setEmail_clt(client.getEmail_clt());
        existingClient.setTelephone_clt(client.getTelephone_clt());
        existingClient.setProfession_clt(client.getProfession_clt());
        existingClient.setPassword_clt(client.getPassword_clt());

        return clientRepo.save(existingClient);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepo.deleteById(id);
    }
}
