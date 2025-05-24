package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // public Optional<Client> getClientById(int id) {
    //     return clientRepository.findById(id);
    // }

    // public Client createClient(Client client) {
    //     return clientRepository.save(client);
    // }

    // public Client enregistrerClient(Client client) throws IllegalArgumentException {
    //     // Validation des données côté serveur
    //     if (client.getNom() == null || client.getNom().trim().isEmpty()) {
    //         throw new IllegalArgumentException("Le nom est obligatoire.");
    //     }
    //     if (client.getPrenom() == null || client.getPrenom().trim().isEmpty()) {
    //         throw new IllegalArgumentException("Le prénom est obligatoire.");
    //     }
    //     if (client.getCni() == null || client.getCni().trim().isEmpty()) {
    //         throw new IllegalArgumentException("Le numéro de CNI est obligatoire.");
    //     }
    //     if (clientRepository.existsByNumCni(client.getCni())) {
    //         throw new IllegalArgumentException("Ce numéro de CNI est déjà utilisé.");
    //     }
    //     if (client.getTelephone() == null || client.getTelephone().trim().isEmpty()) {
    //         throw new IllegalArgumentException("Le numéro de téléphone est obligatoire.");
    //     }
    //     if (client.getEmail() == null || client.getEmail().trim().isEmpty()) {
    //         throw new IllegalArgumentException("L'adresse e-mail est obligatoire.");
    //     }
    //     if (!client.getEmail().contains("@")) {
    //         throw new IllegalArgumentException("L'adresse e-mail n'est pas valide.");
    //     }
    //     if (clientRepository.existsByEmail(client.getEmail())) {
    //         throw new IllegalArgumentException("Cette adresse e-mail est déjà utilisée.");
    //     }
    //     if (client.getMdp() == null || client.getMdp().trim().isEmpty()) {
    //         throw new IllegalArgumentException("Le mot de passe est obligatoire.");
    //     }
    //     if (client.getMdp().length() < 5) {
    //         throw new IllegalArgumentException("Le mot de passe doit contenir au moins 5 caractères.");
    //     }

    //     // IMPORTANT: En production, il faut hasher le mot de passe ici avant de sauvegarder !
    //     // String hashedPassword = passwordEncoder.encode(user.getMotdepasse());
    //     // user.setMotdepasse(hashedPassword);

    //     return clientRepository.save(client);
    // }

    // public Client updateClient(Long id, Client client) {
    //     if (clientRepository.existsById(id)) {
    //         client.setIdClient(id);
    //         return clientRepository.save(client);
    //     }
    //     return null; // Gérer l'erreur "Client non trouvé"
    // }

    // public void deleteClient(Long id) {
    //     clientRepository.deleteById(id);
    // }
}
